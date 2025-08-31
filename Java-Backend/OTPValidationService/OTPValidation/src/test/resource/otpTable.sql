CREATE TABLE dolphin_dev.d_otp_tb (
    d_otp_sk BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    d_otp VARCHAR(255) NOT NULL,
    d_e_adr_email VARCHAR(255) NOT NULL,
    d_otp_beg_time TIMESTAMP NOT NULL,
    d_otp_exp_time TIMESTAMP NOT NULL,
    c_aud_add_ts TIMESTAMP NOT NULL,
    c_aud_ts TIMESTAMP NOT NULL,
    c_aud_add_user VARCHAR(250) NOT NULL,
    c_aud_user VARCHAR(250) NOT NULL
);