package com.dolphine.authentication.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dolphine.authentication.service.UserSignUpService;
import com.dolphine.authentication.vo.LogInVO;
import com.dolphine.authentication.vo.UserVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
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
	
	@PostMapping("/signin")
	public Map<Object, Object> signIn(@RequestBody LogInVO logInVo) {
		System.out.println("----------->signin");
		ObjectMapper mapper = new ObjectMapper();
		
		Map<Object, Object> resp = userSignUpService.signIn(logInVo);
		try {
			String res=mapper.writer().withDefaultPrettyPrinter().writeValueAsString(resp);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}
	
}
