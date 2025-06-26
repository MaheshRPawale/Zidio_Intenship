package com.zidio.zidioconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zidio.zidioconnect.dto.UserInfoResponseDto;
import com.zidio.zidioconnect.dto.UserStatusUpdateRequestDto;
import com.zidio.zidioconnect.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PutMapping("/user/status")
    public ResponseEntity<UserInfoResponseDto> updateUserStatus(@RequestBody UserStatusUpdateRequestDto request) {
        return ResponseEntity.ok(adminService.updateUserStatus(request));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserInfoResponseDto>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/users/{role}")
    public ResponseEntity<List<UserInfoResponseDto>> getUserByRole(@PathVariable String role) {
        return ResponseEntity.ok(adminService.getUsersByRole(role));
    }
}