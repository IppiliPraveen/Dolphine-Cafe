package com.dolphine.authentication.service;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolphine.authentication.entity.PhoneMail;
import com.dolphine.authentication.entity.SignIn;
import com.dolphine.authentication.entity.User;
import com.dolphine.authentication.repository.CommonDetailsRepository;
import com.dolphine.authentication.repository.UserSignInRepository;
import com.dolphine.authentication.repository.UserSignUpRepository;
import com.dolphine.authentication.vo.LogInVO;
import com.dolphine.authentication.vo.PhoneMailVO;
import com.dolphine.authentication.vo.UserVO;

@Service
public class UserSignUpService {
	
	@Autowired
	UserSignUpRepository userRepo;
	
	@Autowired
	CommonDetailsRepository commonRepo;
	
	@Autowired
	UserSignInRepository signInRepo;
	

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public UserVO signUpUser(UserVO userVo) {
		System.out.println("Start ----> signUpUser Serive");
		User user = new User();
		PhoneMail phone = new PhoneMail();
		SignIn signIn = new SignIn();
		BeanUtils.copyProperties(userVo, user);
		try {
			PhoneMailVO phoneVo = userVo.getPhoneMail();
			if(Objects.nonNull(phoneVo)) {
				BeanUtils.copyProperties(phoneVo, phone);
				phone = commonRepo.save(phone);
			}
			if(Objects.nonNull(phone)) {
				user.setPhoneMail(phone);
				BeanUtils.copyProperties(phoneVo, signIn);
				signIn.setEmail(phone.getEmail());
				String pswd = passwordEncoder.encode(userVo.getPassword());
				signIn.setEmail(phone.getEmail());
				signIn.setPassword(pswd);
				signInRepo.save(signIn);
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

	public boolean signIn(LogInVO logInVo) {
		
		SignIn signIn = signInRepo.findByEmailId(logInVo.getEmailId());
		boolean matches = passwordEncoder.matches(logInVo.getPassword(), signIn.getPassword());
		if(Objects.nonNull(signIn) && matches) {
			return true;
		}
		return false;
	}

}
