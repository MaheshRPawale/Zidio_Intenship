package com.zidio.zidioconnect.serviceimpl;

import com.zidio.zidioconnect.Entity.Recruiter;
import com.zidio.zidioconnect.Entity.User;
import com.zidio.zidioconnect.dto.RecruiterRequestDto;
import com.zidio.zidioconnect.exception.ResourceNotFoundException;
import com.zidio.zidioconnect.repo.RecruiterRepository;
import com.zidio.zidioconnect.repo.UserRepo;
import com.zidio.zidioconnect.service.RecruiterService;

import org.modelmapper.ModelMapper;
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
    private ModelMapper modelMapper;

	@Override
	public RecruiterRequestDto saveRecruiter(RecruiterRequestDto request) {
		// TODO Auto-generated method stub
		  Recruiter recruiter = modelMapper.map(request, Recruiter.class);
	        Recruiter saved = recruiterRepository.save(recruiter);
	        return modelMapper.map(saved, RecruiterRequestDto.class);
	}

	@Override
	public List<RecruiterRequestDto> getAllRecruiters() {
		// TODO Auto-generated method stub
		  return recruiterRepository.findAll().stream()
				  .map(r -> modelMapper.map(r, RecruiterRequestDto.class))
	                .collect(Collectors.toList());
	}

	@Override
	public RecruiterRequestDto getByRecruiterEmail(String recruiterEmail) {
		// TODO Auto-generated method stub
		 Recruiter recruiter = recruiterRepository.findByRecruiterEmail(recruiterEmail);
	        if (recruiter == null) {
	            throw new ResourceNotFoundException("Recruiter not found with email: " + recruiterEmail);
	        }
	        return modelMapper.map(recruiter, RecruiterRequestDto.class);
	}

	



	}

    


