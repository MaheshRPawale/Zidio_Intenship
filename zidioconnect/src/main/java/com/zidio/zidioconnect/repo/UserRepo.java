package com.zidio.zidioconnect.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zidio.zidioconnect.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	 boolean existsByEmail(String email);
	Optional<User> findByEmail(String email);
   
}
