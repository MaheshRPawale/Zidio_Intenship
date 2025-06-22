package com.zidio.zidioconnect.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.zidioconnect.Entity.StudentProfile;

import java.util.Optional;

@Repository
public interface StudentProfileRepo extends JpaRepository<StudentProfile, Long> {
    Optional<StudentProfile> findByStudentId(Long studentId);
    boolean existsByStudentId(Long studentId);
}
