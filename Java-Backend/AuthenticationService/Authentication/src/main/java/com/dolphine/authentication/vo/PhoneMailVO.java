package com.dolphine.authentication.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class PhoneMailVO extends BaseVO{
	
	private Long commonDetailId;
	
	private String phoneNumber;
	
	private String phoneExtn;
	
	private String email;

}
