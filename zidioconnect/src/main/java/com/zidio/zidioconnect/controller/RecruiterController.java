package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.RecruiterRequestDto;
import com.zidio.zidioconnect.service.RecruiterService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController {


	 @Autowired
	    private RecruiterService recruiterService;

	 @PostMapping("/register")
	    public ResponseEntity<RecruiterRequestDto> register(@RequestBody RecruiterRequestDto request) {
	        return ResponseEntity.ok(recruiterService.saveRecruiter(request));
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<RecruiterRequestDto>> getAll() {
	        return ResponseEntity.ok(recruiterService.getAllRecruiters());
	    }

	    @GetMapping("/{email}")
	    public ResponseEntity<RecruiterRequestDto> getByEmail(@PathVariable String email) {
	        return ResponseEntity.ok(recruiterService.getByRecruiterEmail(email));
	    }
}
