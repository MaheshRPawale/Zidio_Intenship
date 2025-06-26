package com.zidio.zidioconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zidio.zidioconnect.dto.ApplicationRequestDto;
import com.zidio.zidioconnect.dto.ApplicationResponseDto;
import com.zidio.zidioconnect.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<ApplicationResponseDto> apply(@RequestBody ApplicationRequestDto request) {
        return ResponseEntity.ok(applicationService.apply(request));
    }

    @GetMapping("/student/{email}")
    public ResponseEntity<List<ApplicationResponseDto>> getByStudentEmail(@PathVariable String email) {
        return ResponseEntity.ok(applicationService.getApplicationsByStudent(email));
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationResponseDto>> getByJobId(@PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.getApplicationsByJob(jobId));
    }

}
