package com.zidio.zidioconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zidio.zidioconnect.dto.LoginRequest;
import com.zidio.zidioconnect.dto.RegisterRequest;
import com.zidio.zidioconnect.service.UserService_Login_Register;

@RestController

@RequestMapping("/api/auth")
public class UserController_Login_Register {

	@Autowired
	private UserService_Login_Register userservice_Login_Register;
	
	 @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
	        return new ResponseEntity<>(userservice_Login_Register.register(registerRequest), HttpStatus.CREATED);
	    }

	    // Login
	    @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
	        return ResponseEntity.ok(userservice_Login_Register.login(loginRequest)); 
	    }
}
