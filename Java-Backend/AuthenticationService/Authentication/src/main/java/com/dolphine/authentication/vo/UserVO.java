package com.dolphine.authentication.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ippili Praveen
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=false)
public class UserVO extends BaseVO{

    private Long userId;
    
    private String firstName;
    
    private String lastName;
    
    private String projectName;
    
    private Long commonDetailId;
    
    private String userRole;
    
    private String userDepartment;
    
    private String userStatus;
    
    private PhoneMailVO phoneMail;
    
    private String password;
    
}