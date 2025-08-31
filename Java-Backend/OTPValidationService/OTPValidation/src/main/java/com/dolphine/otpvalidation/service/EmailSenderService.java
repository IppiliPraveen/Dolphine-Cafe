package com.dolphine.otpvalidation.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dolphine.otpvalidation.entity.OTP;
import com.dolphine.otpvalidation.repository.EmailOTPValidationRepository;
import com.dolphine.otpvalidation.utils.EmailConstants;
import com.dolphine.otpvalidation.vo.EmailOTPValidationVO;
import com.dolphine.otpvalidation.vo.OTPVO;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired 
	protected EmailOTPValidationRepository emailOTPValidationRepository;
	
	
	public OTPVO sendMail (String toMail, String subject, String body) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		Integer otpNumber = getOtp();
		
		mailMessage.setFrom("ippili.praveen09@gmail.com");
		mailMessage.setTo(toMail);
		
		mailMessage.setSubject(EmailConstants.SUBJECT);

		OTPVO otpVO = new OTPVO();
		OTP otp = new OTP();
		
		try {
			
			otp = this.getActiveOTP(toMail);
			
			if (otp == null) {
				System.out.println("otp == null");
				mailMessage.setText(this.buildOtpValidationBody(
						toMail.substring(0, toMail.indexOf(EmailConstants.AT_SYMBOL)), otpNumber));
				mailSender.send(mailMessage);
				otp = this.save(toMail, otpNumber);
				BeanUtils.copyProperties(otp, otpVO);
			} else {
				System.out.println("otp != null");
				mailMessage.setText(this.buildOtpValidationBody(
						toMail.substring(0, toMail.indexOf(EmailConstants.AT_SYMBOL)), Integer.parseInt(otp.getOtp())));
				mailSender.send(mailMessage);
				emailOTPValidationRepository.save(otp);
				BeanUtils.copyProperties(otp, otpVO);
			}
			return otpVO;
		} catch (MailException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	private OTP getActiveOTP(String toMail) {
		
		OTP otp = new OTP();
		otp.setEmail(toMail);
		otp = emailOTPValidationRepository.findLatestValidOtpByEmail(toMail);
		return otp;
	}

	private OTP save(String toMail, Integer otpNumber) {
		
		OTP otp = new OTP();
		otp.setEmail(toMail);
		otp.setOtp(otpNumber.toString());
		return emailOTPValidationRepository.save(otp);
	}

	private int getOtp() {
		Random random = new Random();
		return 100000 + random.nextInt(900000);
	}
	
	private String buildOtpValidationBody(String recipientName, int otp) {
        return EmailConstants.WISH + recipientName + EmailConstants.COMMA +
        		EmailConstants.NEW_LINE + EmailConstants.BODY_BEFORE_OTP + otp +
        		EmailConstants.NEW_LINE + EmailConstants.BODY_AFTER_OTP + EmailConstants.SIGNATURE;
    }

	public boolean emailOTPValidate(EmailOTPValidationVO emailOTPValidationVO) {
		
		OTP otp = new OTP();
		
		otp = this.getActiveOTP(emailOTPValidationVO.getEmail());
		
		if(otp!=null) {
			if(otp.getOtp().equals(emailOTPValidationVO.getOtp())) {
				otp.setExpTime(LocalDateTime.now());
				emailOTPValidationRepository.save(otp);
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}
		return Boolean.FALSE;
	}

}
