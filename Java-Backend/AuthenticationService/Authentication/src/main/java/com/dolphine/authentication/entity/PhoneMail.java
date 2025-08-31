package com.dolphine.authentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "c_phone_mail_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneMail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_user_cmn_dtl_id")
    private Long commonDetailId;

    @Column(name = "c_phone_num", nullable = false, length = 10)
    private String phoneNumber;

    @Column(name = "c_phone_ext", length = 6)
    private String phoneExtn;

    @Column(name = "c_email_adr", nullable = false, length = 255)
    private String email;

    @Column(name = "c_aud_add_ts", nullable = false)
    private LocalDateTime auditAddTimestamp;

    @Column(name = "c_aud_add_user", nullable = false, length = 60)
    private String auditAddUser;

    @Column(name = "c_aud_ts", nullable = false)
    private LocalDateTime auditTimestamp;

    @Column(name = "c_aud_user", nullable = false, length = 60)
    private String auditUser;

}