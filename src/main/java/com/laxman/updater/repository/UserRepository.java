package com.laxman.updater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laxman.updater.model.AppUser;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<AppUser, Long> {
	
	 AppUser findByEmail(String email);
}