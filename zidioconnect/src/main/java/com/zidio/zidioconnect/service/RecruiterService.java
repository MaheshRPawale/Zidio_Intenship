package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.dto.RecruiterRequestDto;

import java.util.List;


public interface RecruiterService {
	RecruiterRequestDto saveRecruiter(RecruiterRequestDto request);
    List<RecruiterRequestDto> getAllRecruiters();
    RecruiterRequestDto getByRecruiterEmail(String recruiterEmail);
}
