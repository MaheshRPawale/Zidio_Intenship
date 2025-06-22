package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.StudentProfileDto;
import java.util.Optional;

public interface StudentProfileService {
	
    StudentProfileDto createProfile(StudentProfileDto profileDto);
    
    StudentProfileDto updateProfile(StudentProfileDto profileDto);
    
    Optional<StudentProfileDto> getProfileByUserId(Long userId);
  
    void deleteProfile(Long userId);
}