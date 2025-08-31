package com.dolphine.authentication.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseVO {
	
private LocalDateTime auditAddTimestamp;
    
    private String auditAddUser;
    
    private LocalDateTime auditTimestamp;
    
    private String auditUser;
}
