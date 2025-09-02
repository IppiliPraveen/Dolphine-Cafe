
-- Drop and create c_phone_mail_tb
DROP TABLE IF EXISTS c_phone_mail_tb;
CREATE TABLE c_phone_mail_tb (
    c_user_cmn_dtl_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    c_phone_ext VARCHAR(6),
    c_phone_num VARCHAR(10) NOT NULL,
    c_email_adr VARCHAR(255) UNIQUE,
    c_aud_add_ts TIMESTAMP NOT NULL,
    c_aud_add_user VARCHAR(60) NOT NULL,
    c_aud_ts TIMESTAMP NOT NULL,
    c_aud_user VARCHAR(60) NOT NULL
) AUTO_INCREMENT = 100001;

-- Drop and create d_user_dtl_tb
DROP TABLE IF EXISTS d_user_dtl_tb;
CREATE TABLE d_user_dtl_tb (
    d_user_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    d_user_first_nam VARCHAR(60) NOT NULL,
    d_user_last_nam VARCHAR(60) NOT NULL,
    d_user_project_nam VARCHAR(120) NOT NULL,
    c_user_cmn_dtl_id BIGINT NOT NULL,
    d_user_role VARCHAR(255) NOT NULL,
    d_user_dep VARCHAR(255),
    d_user_status BOOLEAN NOT NULL,
    c_aud_add_ts TIMESTAMP NOT NULL,
    c_aud_add_user VARCHAR(60) NOT NULL,
    c_aud_ts TIMESTAMP NOT NULL,
    c_aud_user VARCHAR(60) NOT NULL,
    CONSTRAINT fk_cmn_dtl_id FOREIGN KEY (c_user_cmn_dtl_id)
        REFERENCES c_phone_mail_tb(c_user_cmn_dtl_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) AUTO_INCREMENT = 200001;

-- Drop and create d_login_tb
DROP TABLE IF EXISTS d_login_tb;
CREATE TABLE d_login_tb (
    d_log_sk BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    c_email_adr VARCHAR(255) NOT NULL,
    d_log_pwd VARCHAR(120) NOT NULL,
    c_aud_add_ts TIMESTAMP NOT NULL,
    c_aud_add_user VARCHAR(60) NOT NULL,
    c_aud_ts TIMESTAMP NOT NULL,
    c_aud_user VARCHAR(60) NOT NULL,
    CONSTRAINT fk_email FOREIGN KEY (c_email_adr)
        REFERENCES c_phone_mail_tb(c_email_adr)
        ON UPDATE CASCADE
        ON DELETE CASCADE
