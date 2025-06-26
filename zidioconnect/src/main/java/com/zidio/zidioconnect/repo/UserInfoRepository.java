package com.zidio.zidioconnect.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zidio.zidioconnect.Entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email);
    List<UserInfo> findByRole(String role);
}