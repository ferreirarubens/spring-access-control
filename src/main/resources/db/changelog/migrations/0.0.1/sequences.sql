--liquibase formatted sql

--changeset ferreirarubens:0.0.1-seq-1
CREATE SEQUENCE access_control.permission_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

--changeset ferreirarubens:0.0.1-seq-2
CREATE SEQUENCE access_control.profile_permission_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

--changeset ferreirarubens:0.0.1-seq-3	
CREATE SEQUENCE access_control.profile_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
--changeset ferreirarubens:0.0.1-seq-4
CREATE SEQUENCE access_control.profile_type_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
--changeset ferreirarubens:0.0.1-seq-5
CREATE SEQUENCE access_control.user_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;