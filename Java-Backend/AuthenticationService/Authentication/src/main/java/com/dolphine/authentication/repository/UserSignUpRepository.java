package com.dolphine.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dolphine.authentication.entity.User;
import com.dolphine.authentication.vo.UserVO;

@Repository
public interface UserSignUpRepository extends JpaRepository<User, Long>{

	@Query("SELECT user FROM User user WHERE user.phoneMail.commonDetailId=:commonDetailId")
	User getUserByCommonInd(Long commonDetailId);
	
}