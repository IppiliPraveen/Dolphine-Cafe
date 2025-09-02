package com.dolphine.authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "d_login_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "d_log_sk")
    private Long id;

    @Column(name = "c_email_adr", nullable = false, length = 255)
    private String email;

    @Column(name = "d_log_pwd", nullable = false, length = 120)
    private String password;

    @Column(name = "c_aud_add_ts", nullable = false)
    private LocalDateTime auditAddTimestamp;

    @Column(name = "c_aud_add_user", nullable = false, length = 60)
    private String auditAddUser;

    @Column(name = "c_aud_ts", nullable = false)
    private LocalDateTime auditTimestamp;

    @Column(name = "c_aud_user", nullable = false, length = 60)
    private String auditUser;
}
