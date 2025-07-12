package Pronotion.web_server.controller;

import Pronotion.web_server.dto.UserDto;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    private final AmazonS3 s3Client;

    @Value("${aws.bucketName}")
    private String bucketName;

    public FileUploadController(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());
        PutObjectRequest request = new PutObjectRequest(
                bucketName,
                fileName,
                file.getInputStream(),
                metadata
        );

        s3Client.putObject(request);

        String fileUrl = String.format("https://%s.s3.amazonaws.com/%s", bucketName, fileName);
        return ResponseEntity.ok(fileUrl);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listFiles() {
        ListObjectsV2Result result = s3Client.listObjectsV2(bucketName);
        List<S3ObjectSummary> summaries = result.getObjectSummaries();
        return ResponseEntity.ok(summaries);
    }
}
