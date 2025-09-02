package com.dolphine.otpvalidation.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "d_otp_tb")
@NamedQueries({
    @NamedQuery(
        name = "OTP.findLatestValidOtpByEmail",
        query = "SELECT ot FROM OTP ot WHERE ot.email = :email AND ot.expTime >= CURRENT_TIMESTAMP ORDER BY ot.sentTime DESC"
    )
})
public class OTP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "d_otp_sk")
    private Long id;

    @Column(name = "d_otp", nullable = false)
    private String otp;

    @Column(name = "d_e_adr_email", nullable = false)
    private String email;

    @Column(name = "d_otp_beg_time", nullable = false)
    private LocalDateTime sentTime;

    @Column(name = "d_otp_exp_time", nullable = false)
    private LocalDateTime expTime;

    @Column(name = "c_aud_add_ts", nullable = false)
    private LocalDateTime addedAuditTimeStamp;

    @Column(name = "c_aud_ts", nullable = false)
    private LocalDateTime auditTimeStamp;

    @Column(name = "c_aud_add_user", nullable = false)
    private String addedAuditUser;

    @Column(name = "c_aud_user", nullable = false)
    private String auditUser;

    @PrePersist
    public void prePersist() {
        this.sentTime = LocalDateTime.now();
        this.expTime = this.sentTime.plusMinutes(10);
        this.addedAuditTimeStamp = LocalDateTime.now();
        this.auditTimeStamp = this.addedAuditTimeStamp;
        this.addedAuditUser = "Batch Test";
        this.auditUser = this.addedAuditUser;
    }

    @PreUpdate
    public void preUpdate() {
        this.auditTimeStamp = LocalDateTime.now();
        this.auditUser = "Batch Test";
    }
}