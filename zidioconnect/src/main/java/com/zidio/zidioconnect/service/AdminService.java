package com.zidio.zidioconnect.service;

import java.util.List;

import com.zidio.zidioconnect.dto.UserInfoResponseDto;
import com.zidio.zidioconnect.dto.UserStatusUpdateRequestDto;

public interface AdminService {
    UserInfoResponseDto updateUserStatus(UserStatusUpdateRequestDto request);
    List<UserInfoResponseDto> getAllUsers();
    List<UserInfoResponseDto> getUsersByRole(String role);
}