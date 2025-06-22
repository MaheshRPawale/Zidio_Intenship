package com.zidio.zidioconnect.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zidio.zidioconnect.Entity.User;
import com.zidio.zidioconnect.config.JWTUtil;
import com.zidio.zidioconnect.dto.LoginRequest;
import com.zidio.zidioconnect.dto.RegisterRequest;
import com.zidio.zidioconnect.exception.ResourceNotFoundException;
import com.zidio.zidioconnect.repo.UserRepo;
import com.zidio.zidioconnect.service.UserService_Login_Register;

@Service
public class UserService_Login_RegisterImpl implements UserService_Login_Register {

	 @Autowired
	    private UserRepo userRepo;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Autowired
	    private ModelMapper modelMapper;

	    @Autowired
	    private JWTUtil jwtUtil;

	
	@Override
	public String register(RegisterRequest registerRequest) {
		// TODO Auto-generated method stub
		 User user = new User();
	        user.setEmail(registerRequest.getEmail()); 
	        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
	        user.setRole(registerRequest.getRole()); 
	        userRepo.save(user);
	        return "Registration successful.";
	}

	@Override
	public String login(LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		 User user = userRepo.findByEmail(loginRequest.getEmail()) 
	                .orElseThrow(() -> new ResourceNotFoundException("User not found."));
	        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()) == false) {
	            throw new RuntimeException("Invalid password.");
	        }
	        // Generate a JWT for the user
	        return jwtUtil.generateToken(user.getEmail()); 
	}

}
