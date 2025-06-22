package com.zidio.zidioconnect.serviceimpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.zidioconnect.Entity.StudentProfile;
import com.zidio.zidioconnect.Entity.User;
import com.zidio.zidioconnect.dto.StudentProfileDto;
import com.zidio.zidioconnect.exception.ResourceNotFoundException;
import com.zidio.zidioconnect.repo.StudentProfileRepo;
import com.zidio.zidioconnect.repo.UserRepo;
import com.zidio.zidioconnect.service.StudentProfileService;
@Service
public class StudentProfileServiceImpl implements StudentProfileService{

	@Autowired
    private StudentProfileRepo profileRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentProfileDto createProfile(StudentProfileDto profileDto) {
        User user = userRepo.findById(profileDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + profileDto.getUserId()));

        StudentProfile profile = modelMapper.map(profileDto, StudentProfile.class);
        profile.setUser(user);

        StudentProfile savedProfile = profileRepo.save(profile);
        return modelMapper.map(savedProfile, StudentProfileDto.class);
    }

	@Override
	 public StudentProfileDto updateProfile(StudentProfileDto profileDto) {
        StudentProfile existingProfile = profileRepo.findByStudentId(profileDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found for user id: " + profileDto.getUserId()));

        modelMapper.map(profileDto, existingProfile);
        StudentProfile updatedProfile = profileRepo.save(existingProfile);
        return modelMapper.map(updatedProfile, StudentProfileDto.class);
    }
	@Override
	public Optional<StudentProfileDto> getProfileByUserId(Long userId) {
        return profileRepo.findByStudentId(userId)
                .map(profile -> modelMapper.map(profile, StudentProfileDto.class));
    }

	@Override

	 public void deleteProfile(Long userId) {
        StudentProfile profile = profileRepo.findByStudentId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found for user id: " + userId));
        profileRepo.delete(profile);
    }
   
}
