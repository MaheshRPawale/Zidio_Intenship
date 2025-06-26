package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.serviceimpl.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import java.io.IOException;
import java.nio.file.*;
import java.util.Map;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> upload(@RequestParam("file") MultipartFile file) throws IOException {
        String url = fileUploadService.upload(file);
        return ResponseEntity.ok(Map.of("resumeUrl", url));
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> download(@PathVariable String fileName) throws IOException {
        Path path = Paths.get("uploads/resumes").resolve(fileName);
        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}