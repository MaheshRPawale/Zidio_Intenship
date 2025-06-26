package com.zidio.zidioconnect.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.zidioconnect.Entity.UserInfo;
import com.zidio.zidioconnect.dto.UserInfoResponseDto;
import com.zidio.zidioconnect.dto.UserStatusUpdateRequestDto;
import com.zidio.zidioconnect.exception.ResourceNotFoundException;
import com.zidio.zidioconnect.repo.UserInfoRepository;
import com.zidio.zidioconnect.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserInfoRepository userInfoRepository;

	@Override
	public UserInfoResponseDto updateUserStatus(UserStatusUpdateRequestDto request) {
		// TODO Auto-generated method stub
		 UserInfo user = userInfoRepository.findByEmail(request.getEmail())
	                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

		 user.setActive(request.isActive());

	        UserInfo saved = userInfoRepository.save(user);
	        return toResponse(saved);
	}

	@Override
	public List<UserInfoResponseDto> getAllUsers() {
		// TODO Auto-generated method stub
		 return userInfoRepository.findAll().stream()
	                .map(this::toResponse)
	                .collect(Collectors.toList());
	}

	@Override
	public List<UserInfoResponseDto> getUsersByRole(String role) {
		// TODO Auto-generated method stub
		   return userInfoRepository.findByRole(role.toUpperCase()).stream()
	                .map(this::toResponse)
	                .collect(Collectors.toList());
	}

	
	private UserInfoResponseDto toResponse(UserInfo user) {
        return new UserInfoResponseDto(user.getEmail(), user.getRole(), user.isActive());
    }
	
}
