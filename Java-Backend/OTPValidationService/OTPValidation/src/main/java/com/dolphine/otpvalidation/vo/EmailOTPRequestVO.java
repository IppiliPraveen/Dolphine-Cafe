package com.dolphine.otpvalidation.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailOTPRequestVO {
	
	private String toMail;
	
    private String subject;
    
    private String body;

}
