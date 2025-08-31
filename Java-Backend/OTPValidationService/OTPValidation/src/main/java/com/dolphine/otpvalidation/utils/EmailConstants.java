package com.dolphine.otpvalidation.utils;

public class EmailConstants {
	
	public static final String SUBJECT = "Spring Boot OTP Validation";
	
    public static final String WISH = "Hi ";
    
    public static final String BODY_BEFORE_OTP = "Your One-Time Password (OTP) for validation is: ";
    
	public static final String BODY_AFTER_OTP = "Please use this OTP to complete your validation process. This OTP is valid for 10 minutes.\n\n"
												+ "If you did not request this OTP, please ignore this email.\n\n";
	
	public static final String NEW_LINE = "\n\n";
	
	public static final String COMMA = ",";
	
	public static final String SIGNATURE = "Thanks,\nSpring Boot App Team\nCell : 0987654321";
	
	public static final String AT_SYMBOL = "@";

    public static String buildOtpValidationBody(String recipientName, String otp) {
        return EmailConstants.WISH + recipientName + EmailConstants.COMMA +
        		EmailConstants.NEW_LINE + EmailConstants.BODY_BEFORE_OTP + otp +
        		EmailConstants.NEW_LINE + EmailConstants.BODY_AFTER_OTP + EmailConstants.SIGNATURE;
    }

}
