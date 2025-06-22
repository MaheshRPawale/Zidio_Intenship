package com.zidio.zidioconnect.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.zidio.zidioconnect.Entity.Recruiter;



public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    Recruiter findByRecruiterEmail(String recruiterEmail);
}
