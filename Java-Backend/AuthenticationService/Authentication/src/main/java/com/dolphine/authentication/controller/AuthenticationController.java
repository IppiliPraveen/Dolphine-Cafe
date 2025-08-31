package com.dolphine.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dolphine.authentication.service.UserSignUpService;
import com.dolphine.authentication.vo.UserVO;

@RestController
@RequestMapping("dolphine/user")
public class AuthenticationController {


	@Autowired
	UserSignUpService userSignUpService;
	
	@PostMapping("/signup")
	public UserVO signUp(@RequestBody UserVO userVo) {
		System.out.println("----------->signUp");
		return userSignUpService.signUpUser(userVo);
	}
}
