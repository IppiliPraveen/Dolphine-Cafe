package com.dolphine.authentication.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInVO implements Serializable{

	private static final long serialVersionUID = 7150592991309860329L;

	private String emailId;
	
	private String password;

}
