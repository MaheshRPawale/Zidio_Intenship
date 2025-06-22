package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.JobListingDto;
import com.zidio.zidioconnect.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobListingController {

    @Autowired
    private JobService jobService;

    @GetMapping("/search")
    public ResponseEntity<List<JobListingDto>> searchJobs(@RequestParam String title) {
        List<JobListingDto> jobs = jobService.searchByTitle(title);
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/recruiter/{recruiterId}")
    public ResponseEntity<List<JobListingDto>> getJobsByRecruiter(@PathVariable Long recruiterId) {
        List<JobListingDto> jobs = jobService.getJobsByRecruiter(recruiterId);
        return ResponseEntity.ok(jobs);
    }

    @PostMapping
    public ResponseEntity<JobListingDto> createJob(@RequestBody JobListingDto jobListingDto) {
        JobListingDto createdJob = jobService.postJob(jobListingDto);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }
}
