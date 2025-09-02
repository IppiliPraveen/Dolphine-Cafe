package com.dolphine.otpvalidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dolphine.otpvalidation.service.EmailSenderService;
import com.dolphine.otpvalidation.vo.EmailOTPRequestVO;
import com.dolphine.otpvalidation.vo.EmailOTPValidationVO;
import com.dolphine.otpvalidation.vo.OTPVO;

@RestController
@RequestMapping("api/otp/email")
public class EmailOTPController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/send")
    public OTPVO sendMail(@RequestBody EmailOTPRequestVO emailRequest) {
    	
    	OTPVO otpVO = new OTPVO();
    	otpVO = emailSenderService.sendMail(emailRequest.getToMail(), emailRequest.getSubject(), emailRequest.getBody());
    	
    	if(otpVO!=null)
    		return otpVO;
        return null;
    }
    
    @PostMapping("/validate")
    public String validateOTP(@RequestBody EmailOTPValidationVO emailOTPValidationVO) {
    	
    	if(emailSenderService.emailOTPValidate(emailOTPValidationVO)) {
    		return "OTP Validated Successfully";
    	}
        return "OTP is Not Valid. Please Enter Valid OTP";
    }
}
