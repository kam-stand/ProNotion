package Pronotion.web_server.controller;

import Pronotion.web_server.service.GoogleAuthTokenService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
public class GoogleOAuthController {

    @Value("${google.client.id}")
    private String clientId;

    @Value("${google.client.secret}")
    private String clientSecret;

    @Value("${google.redirect.uri}")
    private String redirectUri;

    @Value("${google.scope}")
    private String scope;

    @Value("${google.auth.uri}")
    private String authUri;

    @Value("${google.token.uri}")
    private String tokenUri;

    private final GoogleAuthTokenService googleAuthTokenService;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public GoogleOAuthController(GoogleAuthTokenService googleAuthTokenService) {
        this.googleAuthTokenService = googleAuthTokenService;
    }

    /**
     * Step 1: Redirect user to Google OAuth Consent Screen
     */
    @GetMapping("api/auth/google")
    public ResponseEntity<?> googleLogin() {
        try {
            String encodedScope = URLEncoder.encode(scope, StandardCharsets.UTF_8);
            String encodedRedirectUri = URLEncoder.encode(redirectUri, StandardCharsets.UTF_8);

            String url = authUri
                    + "?response_type=code"
                    + "&client_id=" + clientId
                    + "&redirect_uri=" + encodedRedirectUri
                    + "&scope=" + encodedScope
                    + "&access_type=offline"
                    + "&prompt=consent";

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(url));
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating redirect URI: " + e.getMessage());
        }
    }

    /**
     * Step 2: Google redirects back with an authorization code
     */
    @GetMapping("/oauth2callback")
    public void oauth2callback(
            @RequestParam("code") String code,
            HttpServletResponse response
    ) throws IOException {
        try {
            // Exchange code for tokens
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
            form.add("code", code);
            form.add("client_id", clientId);
            form.add("client_secret", clientSecret);
            form.add("redirect_uri", redirectUri);
            form.add("grant_type", "authorization_code");

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(form, headers);
            ResponseEntity<String> tokenResponse = restTemplate.postForEntity(tokenUri, request, String.class);

            JsonNode tokenJson = objectMapper.readTree(tokenResponse.getBody());
            String accessToken = tokenJson.get("access_token").asText();
            String refreshToken = tokenJson.has("refresh_token") ? tokenJson.get("refresh_token").asText() : null;

            // Get user info from Google
            HttpHeaders userInfoHeaders = new HttpHeaders();
            userInfoHeaders.setBearerAuth(accessToken);
            HttpEntity<Void> userInfoRequest = new HttpEntity<>(userInfoHeaders);

            ResponseEntity<String> userInfoResponse = restTemplate.exchange(
                    "https://www.googleapis.com/oauth2/v2/userinfo",
                    HttpMethod.GET,
                    userInfoRequest,
                    String.class
            );

            JsonNode userInfo = objectMapper.readTree(userInfoResponse.getBody());
            String email = userInfo.get("email").asText();
            String name = userInfo.get("name").asText();

            // Save tokens in database
            googleAuthTokenService.saveOrUpdate(email, name, accessToken, refreshToken);

            // ✅ Redirect to home page in frontend
            response.sendRedirect("http://localhost:5173/home");

        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "OAuth failed: " + e.getMessage());
        }
    }

    @GetMapping("/google/files")
    public ResponseEntity<?> googleFiles(@RequestParam String email) {
        String accessToken = googleAuthTokenService.getAccessToken(email);

        String url = "https://www.googleapis.com/drive/v3/files?pageSize=20&fields=files(id,name,mimeType)";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return ResponseEntity.ok(response.getBody());
        } catch (HttpClientErrorException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body("Error retrieving files: " + ex.getResponseBodyAsString());
        }
    }

    @GetMapping("/google/folders")
    public ResponseEntity<?> googleFolders(@RequestParam String email) {
        String accessToken = googleAuthTokenService.getAccessToken(email);

        String url = "https://www.googleapis.com/drive/v3/files"
                + "?q=mimeType='application/vnd.google-apps.folder'"
                + "&pageSize=20"
                + "&fields=files(id,name,mimeType)";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return ResponseEntity.ok(response.getBody());
        } catch (HttpClientErrorException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body("Error retrieving folders: " + ex.getResponseBodyAsString());
        }
    }
}
