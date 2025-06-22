package com.zidio.zidioconnect.repo;

import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zidio.zidioconnect.Entity.JobListing;

public interface JobRepository extends JpaRepository<JobListing , Long> {
	List<JobListing> findByTitleContainingIgnoreCase(String title);
	List<JobListing> findByRecruiterId(Long recruiterId); 

}
