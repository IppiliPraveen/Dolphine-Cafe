package com.dolphine.otpvalidation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dolphine.otpvalidation.entity.OTP;

@Repository
public interface EmailOTPValidationRepository extends JpaRepository<OTP, Long>{

	@Query(name = "OTP.findLatestValidOtpByEmail")
	OTP findLatestValidOtpByEmail(@Param("email") String email);
	
}
