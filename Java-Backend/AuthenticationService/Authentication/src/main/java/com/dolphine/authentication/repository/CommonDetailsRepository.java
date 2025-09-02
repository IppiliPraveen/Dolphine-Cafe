package com.dolphine.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dolphine.authentication.entity.PhoneMail;
import com.dolphine.authentication.vo.PhoneMailVO;

@Repository
public interface CommonDetailsRepository extends JpaRepository<PhoneMail, Long>{

	@Query("SELECT cmn FROM PhoneMail cmn WHERE cmn.email=:emailId")
	PhoneMail getByEmailId(String emailId);
	
}