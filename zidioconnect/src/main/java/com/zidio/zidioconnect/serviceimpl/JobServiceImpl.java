package com.zidio.zidioconnect.serviceimpl;

import com.zidio.zidioconnect.Entity.JobListing;
import com.zidio.zidioconnect.Entity.Recruiter;
import com.zidio.zidioconnect.dto.JobListingDto;

import com.zidio.zidioconnect.exception.ResourceNotFoundException;
import com.zidio.zidioconnect.repo.JobRepository;
import com.zidio.zidioconnect.repo.RecruiterRepository;
import com.zidio.zidioconnect.service.JobService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private RecruiterRepository recruiterProfileRepo;

    @Autowired
    private ModelMapper modelMapper;

	@Override
	public List<JobListingDto> searchByTitle(String title) {
		// TODO Auto-generated method stub
		  return jobRepository.findByTitleContainingIgnoreCase(title)
	                .stream()
	                .map(job -> modelMapper.map(job, JobListingDto.class))
	                .collect(Collectors.toList()); 
	}

	@Override
	public List<JobListingDto> getJobsByRecruiter(Long recruiterId) {
		// TODO Auto-generated method stub
		return jobRepository.findByRecruiterId(recruiterId) // ✅

                .stream()
                .map(job -> modelMapper.map(job, JobListingDto.class))
                .collect(Collectors.toList()); 
	}

	@Override
	public JobListingDto postJob(JobListingDto jobListingDto) {
		// TODO Auto-generated method stub
		Recruiter recruiter = recruiterProfileRepo.findById(jobListingDto.getRecruiterId()) 
                .orElseThrow(() -> new ResourceNotFoundException("Recruiter not found with id " + jobListingDto.getRecruiterId()) );

        JobListing job = new JobListing();

        job.setRecruiter(recruiter);
        job.setTitle(jobListingDto.getTitle()); 
        job.setDescription(jobListingDto.getDescription()); 
        job.setLocation(jobListingDto.getLocation()); 
        job.setType(jobListingDto.getType()); 


        JobListing savedJob = jobRepository.save(job);
        return modelMapper.map(savedJob, JobListingDto.class);
	}

    
    
}
