package com.zidio.zidioconnect.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.zidioconnect.Entity.Application;
import com.zidio.zidioconnect.dto.ApplicationRequestDto;
import com.zidio.zidioconnect.dto.ApplicationResponseDto;
import com.zidio.zidioconnect.repo.ApplicationRepository;
import com.zidio.zidioconnect.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

	@Override
	public ApplicationResponseDto apply(ApplicationRequestDto request) {
		// TODO Auto-generated method stub
		Optional<Application> existing = applicationRepository.findByStudentEmailAndJobId(request.getStudentEmail(), request.getJobId());

        if (existing.isPresent()) {
            throw new RuntimeException("Already applied for this job");
        }

        Application application = Application.builder()
                .studentEmail(request.getStudentEmail())
                .jobId(request.getJobId())
                .status("Applied")
                .build();

        Application saved = applicationRepository.save(application);
        return mapToResponse(saved);
	}

	@Override
	public List<ApplicationResponseDto> getApplicationsByStudent(String studentEmail) {
		// TODO Auto-generated method stub
		 return applicationRepository.findByStudentEmail(studentEmail).stream()
	                .map(this::mapToResponse)
	                .collect(Collectors.toList());
	}

	@Override
	public List<ApplicationResponseDto> getApplicationsByJob(Long jobId) {
		// TODO Auto-generated method stub
		 return applicationRepository.findByJobId(jobId).stream()
	                .map(this::mapToResponse)
	                .collect(Collectors.toList());
	}
	
	private ApplicationResponseDto mapToResponse(Application app) {
        return new ApplicationResponseDto(
                app.getId(),
                app.getStudentEmail(),
                app.getJobId(),
                app.getStatus()
        );
}
}
	
	
	
	
	
	