package com.zidio.zidioconnect.serviceimpl;

import com.zidio.zidioconnect.Entity.Recruiter;
import com.zidio.zidioconnect.Entity.User;
import com.zidio.zidioconnect.dto.RecruiterRequestDto;
import com.zidio.zidioconnect.exception.ResourceNotFoundException;
import com.zidio.zidioconnect.repo.RecruiterRepository;
import com.zidio.zidioconnect.repo.UserRepo;
import com.zidio.zidioconnect.service.RecruiterService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecruiterProfileServiceImpl  implements RecruiterService {


    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private UserRepo userRepo;

	@Override
	public RecruiterRequestDto saveRecruiter(RecruiterRequestDto request) {
		// TODO Auto-generated method stub

		User user = userRepo.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + request.getUserId()));

        Recruiter recruiter = new Recruiter();
        recruiter.setUser(user);
        recruiter.setCompanyName(request.getCompanyName());
        recruiter.setRecruiterEmail(request.getRecruiterEmail());
        recruiter.setRecruiterName(request.getRecruiterName());
        recruiter.setDesignation(request.getDesignation());

        Recruiter saved = recruiterRepository.save(recruiter);

        RecruiterRequestDto response = new RecruiterRequestDto();
        response.setUserId(saved.getUser().getId());
        response.setCompanyName(saved.getCompanyName());
        response.setRecruiterEmail(saved.getRecruiterEmail());
        response.setRecruiterName(saved.getRecruiterName());
        response.setDesignation(saved.getDesignation());
        return response;
	}

	@Override
	public List<RecruiterRequestDto> getAllRecruiters() {
		// TODO Auto-generated method stub
		  return recruiterRepository.findAll().stream().map(recruiter -> {
	            RecruiterRequestDto dto = new RecruiterRequestDto();
	            dto.setUserId(recruiter.getUser().getId());
	            dto.setCompanyName(recruiter.getCompanyName());
	            dto.setRecruiterName(recruiter.getRecruiterName());
	            dto.setRecruiterEmail(recruiter.getRecruiterEmail());
	            dto.setDesignation(recruiter.getDesignation());
	            return dto;
	        }).collect(Collectors.toList());	}

	@Override
	public RecruiterRequestDto getByRecruiterEmail(String recruiterEmail) {
		// TODO Auto-generated method stub
		 Recruiter recruiter = recruiterRepository.findByRecruiterEmail(recruiterEmail);
	        if (recruiter == null) {
	            throw new ResourceNotFoundException("Recruiter not found with email: " + recruiterEmail);
	        }
	        RecruiterRequestDto dto = new RecruiterRequestDto();
	        dto.setUserId(recruiter.getUser().getId());
	        dto.setCompanyName(recruiter.getCompanyName());
	        dto.setRecruiterName(recruiter.getRecruiterName());
	        dto.setRecruiterEmail(recruiter.getRecruiterEmail());
	        dto.setDesignation(recruiter.getDesignation());
	        return dto;
	}



	}

    


