package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.StudentProfileDto;
import com.zidio.zidioconnect.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student-profiles")
public class StudentProfileController {

    @Autowired
    private StudentProfileService profileService;

    @PostMapping
    public ResponseEntity<StudentProfileDto> createProfile(@RequestBody StudentProfileDto profileDto) {
        StudentProfileDto createdProfile = profileService.createProfile(profileDto);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StudentProfileDto> updateProfile(@RequestBody StudentProfileDto profileDto) {
        StudentProfileDto updatedProfile = profileService.updateProfile(profileDto);
        return ResponseEntity.ok(updatedProfile);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<StudentProfileDto> getProfileByUserId(@PathVariable Long userId) {
        return profileService.getProfileByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long userId) {
        profileService.deleteProfile(userId);
        return ResponseEntity.noContent().build();
    }
}