package com.zidio.zidioconnect.service;

import java.util.List;

import com.zidio.zidioconnect.dto.JobListingDto;

public interface JobService {

	 List<JobListingDto> searchByTitle(String title);

	    List<JobListingDto> getJobsByRecruiter(Long recruiterId);

	    JobListingDto postJob(JobListingDto jobListingDto);
}
