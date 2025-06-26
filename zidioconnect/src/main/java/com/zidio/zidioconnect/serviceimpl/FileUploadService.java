package com.zidio.zidioconnect.serviceimpl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class FileUploadService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String upload(MultipartFile file) throws IOException {
        Path path = Paths.get(uploadDir);

        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path targetPath = path.resolve(fileName);

        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

        return "/files/" + fileName;
    }
}