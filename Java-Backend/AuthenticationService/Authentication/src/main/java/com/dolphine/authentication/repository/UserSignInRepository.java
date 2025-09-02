package com.dolphine.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dolphine.authentication.entity.SignIn;

@Repository
public interface UserSignInRepository extends JpaRepository<SignIn, Long>{

	@Query("SELECT signIn FROM SignIn signIn WHERE signIn.email=:emailId")
	SignIn findByEmailId(String emailId);
	
}