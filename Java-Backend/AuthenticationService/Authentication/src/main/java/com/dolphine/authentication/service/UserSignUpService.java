package com.dolphine.authentication.service;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolphine.authentication.entity.PhoneMail;
import com.dolphine.authentication.entity.User;
import com.dolphine.authentication.repository.CommonDetailsRepository;
import com.dolphine.authentication.repository.UserSignUpRepository;
import com.dolphine.authentication.vo.PhoneMailVO;
import com.dolphine.authentication.vo.UserVO;

@Service
public class UserSignUpService {
	
	@Autowired
	UserSignUpRepository userRepo;
	
	@Autowired
	CommonDetailsRepository commonRepo;
	
	public UserVO signUpUser(UserVO userVo) {
		System.out.println("Start ----> signUpUser Serive");
		User user = new User();
		PhoneMail phone = new PhoneMail();
		BeanUtils.copyProperties(userVo, user);
		try {
			PhoneMailVO phoneVo = userVo.getPhoneMail();
			if(Objects.nonNull(phoneVo)) {
				BeanUtils.copyProperties(phoneVo, phone);
				phone = commonRepo.save(phone);
			}
			if(Objects.nonNull(phone)) {
				user.setPhoneMail(phone);
				userRepo.save(user);
			}
			System.out.println("End Success ----> signUpUser Serive");
			return userVo;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("End Fail ----> signUpUser Serive");
			return null;
		}
	}

}
