package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.LoginRequest;
import com.zidio.zidioconnect.dto.RegisterRequest;

public interface UserService_Login_Register {
    String register(RegisterRequest registerRequest);
    String login(LoginRequest loginRequest);
}

