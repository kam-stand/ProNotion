package com.spring.config.middleware;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring.service.CustomeUserDetailService;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    CustomeUserDetailService userDetailService;

    @Override
    protected void doFilterInternal(@SuppressWarnings("null") @NonNull HttpServletRequest request,
            @SuppressWarnings("null") @NonNull HttpServletResponse response,
            @SuppressWarnings("null") @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        String token = getJwtFromRequest(request);
        if (token != null && jwtGenerator.validateToken(token)) {
            String username = jwtGenerator.getUsernameFromToken(token);
            logger.debug("username is:" + username);

            UserDetails userDetails = userDetailService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null,
                    userDetails.getAuthorities());

            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        logger.debug("Invalid JWT token: " + token);
        logger.debug("JWT token is missing");

        filterChain.doFilter(request, response);
    }

    public String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
