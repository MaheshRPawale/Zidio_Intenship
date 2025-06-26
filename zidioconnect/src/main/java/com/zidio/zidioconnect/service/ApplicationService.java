package com.zidio.zidioconnect.service;

import java.util.List;

import com.zidio.zidioconnect.dto.ApplicationRequestDto;
import com.zidio.zidioconnect.dto.ApplicationResponseDto;

public interface ApplicationService {

    ApplicationResponseDto apply(ApplicationRequestDto request);

    List<ApplicationResponseDto> getApplicationsByStudent(String studentEmail);

    List<ApplicationResponseDto> getApplicationsByJob(Long jobId);
}