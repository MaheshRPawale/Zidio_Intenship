package com.zidio.zidioconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zidio.zidioconnect.dto.EmailRequestDto;
import com.zidio.zidioconnect.serviceimpl.EmailServiceImpl;

@RestController
@RequestMapping("/api/notifications")
public class EmailController {

    @Autowired
    private EmailServiceImpl emailServiceimpl;

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody EmailRequestDto request) {
        return ResponseEntity.ok(emailServiceimpl.sendEmail(request));
    }
}