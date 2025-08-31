package com.dolphine.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dolphine.authentication.entity.User;

@Repository
public interface UserSignUpRepository extends JpaRepository<User, Long>{
	
}