package com.dolphine.authentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "d_user_dtl_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "d_user_id")
    private Long userId;

    @Column(name = "d_user_first_nam", nullable = false, length = 60)
    private String firstName;

    @Column(name = "d_user_last_nam", nullable = false, length = 60)
    private String lastName;

    @Column(name = "d_user_project_nam", nullable = false, length = 120)
    private String projectName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "c_user_cmn_dtl_id", referencedColumnName = "c_user_cmn_dtl_id", nullable = false)
    private PhoneMail phoneMail;

    @Column(name = "d_user_role", nullable = false)
    private String userRole;
    
    @Column(name = "d_user_dep")
    private String userDepartment;
    
    @Column(name = "d_user_status", nullable = false)
    private boolean userStatus;

    @Column(name = "c_aud_add_ts", nullable = false)
    private LocalDateTime auditAddTimestamp;

    @Column(name = "c_aud_add_user", nullable = false, length = 60)
    private String auditAddUser;

    @Column(name = "c_aud_ts", nullable = false)
    private LocalDateTime auditTimestamp;

    @Column(name = "c_aud_user", nullable = false, length = 60)
    private String auditUser;

}
