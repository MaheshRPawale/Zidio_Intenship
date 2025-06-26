package com.zidio.zidioconnect.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zidio.zidioconnect.Entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Optional<Application> findByStudentEmailAndJobId(String studentEmail, Long jobId);

    List<Application> findByStudentEmail(String studentEmail);

    List<Application> findByJobId(Long jobId);
}