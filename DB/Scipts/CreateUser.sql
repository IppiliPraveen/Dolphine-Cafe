

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
drop table d_user_dtl_tb;
CREATE TABLE d_user_dtl_tb (
    d_user_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
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
    c_aud_user VARCHAR(60) NOT NULL
);

CREATE TABLE c_phone_mail_tb (
    c_user_cmn_dtl_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    c_phone_ext VARCHAR(6),
    c_phone_num VARCHAR(10) NOT NULL,
    c_email_adr VARCHAR(255) NOT NULL,
    c_aud_add_ts TIMESTAMP NOT NULL,
    c_aud_add_user VARCHAR(60) NOT NULL,
    c_aud_ts TIMESTAMP NOT NULL,
    c_aud_user VARCHAR(60) NOT NULL
);

select * from d_otp_tb;

select * from d_user_dtl_tb dudt;

select * from c_phone_mail_tb cpmt;
 rollback;


CREATE SEQUENCE d_otp_sk_seq
    START WITH 10000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE d_otp_tb ALTER COLUMN d_otp_sk ADD GENERATED ALWAYS AS IDENTITY;

ALTER TABLE d_otp_tb ALTER COLUMN d_otp_sk DROP IDENTITY;
ALTER TABLE d_otp_tb ALTER COLUMN d_otp_sk SET DEFAULT nextval('d_otp_sk_seq');


-- Step 1: Remove the default value from d_otp_sk
ALTER TABLE d_otp_tb ALTER COLUMN d_otp_sk DROP DEFAULT;
ALTER TABLE d_otp_tb ALTER COLUMN d_otp_sk DROP IDENTITY;


-- Step 2: Drop the existing sequence link (if needed)
-- Only needed if d_otp_sk was previously tied to a sequence manually
-- ALTER TABLE d_otp_tb ALTER COLUMN d_otp_sk DROP IDENTITY; -- if identity was used

-- Step 3: Convert d_otp_sk to an identity column
ALTER TABLE d_otp_tb ALTER COLUMN d_otp_sk ADD GENERATED ALWAYS AS IDENTITY;

-- Step 4: Set audit columns to NOT NULL
ALTER TABLE d_otp_tb ALTER COLUMN c_aud_add_ts SET NOT NULL;
ALTER TABLE d_otp_tb ALTER COLUMN c_aud_ts SET NOT NULL;
ALTER TABLE d_otp_tb ALTER COLUMN c_aud_add_user SET NOT NULL;
ALTER TABLE d_otp_tb ALTER COLUMN c_aud_user SET NOT NULL;
