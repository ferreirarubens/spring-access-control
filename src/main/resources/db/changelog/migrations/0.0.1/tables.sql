--liquibase formatted sql

--changeset ferreirarubens:0.0.1-profile-type-1
CREATE TABLE access_control.profile_type
(
    id_profile_type bigint NOT NULL,
    is_active boolean,
    dt_insert timestamp without time zone,
    dt_update timestamp without time zone,
    tp_category character varying(50) COLLATE pg_catalog."default" NOT NULL,
    ds_profile_type character varying(1000) COLLATE pg_catalog."default",
    nm_profile_type character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    id_user_insert bigint,
    id_user_update bigint,
    CONSTRAINT profile_type_pkey PRIMARY KEY (id_profile_type)
);

--changeset ferreirarubens:0.0.1-profile-1
CREATE TABLE access_control.profile
(
    id_profile bigint NOT NULL,
    is_active boolean,
    dt_insert timestamp without time zone,
    dt_update timestamp without time zone,
    nr_hierarchy integer NOT NULL,
    nm_profile character varying(30) COLLATE pg_catalog."default" NOT NULL,
    id_user_insert bigint,
    id_user_update bigint,
    id_profile_type bigint NOT NULL,
    CONSTRAINT profile_pkey PRIMARY KEY (id_profile),
    CONSTRAINT profile_type_fk FOREIGN KEY (id_profile_type)
        REFERENCES access_control.profile_type (id_profile_type) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

--changeset ferreirarubens:0.0.1-permission-1
CREATE TABLE access_control.permission
(
    id_permission bigint NOT NULL,
    is_active boolean,
    dt_insert timestamp without time zone,
    dt_update timestamp without time zone,
    is_crud boolean,
    nm_permission character varying(50) COLLATE pg_catalog."default" NOT NULL,
    id_user_insert bigint,
    id_user_update bigint,
    CONSTRAINT permission_pkey PRIMARY KEY (id_permission)
);

--changeset ferreirarubens:0.0.1-profile-permission-1
CREATE TABLE access_control.profile_permission
(
    id_profile_permission bigint NOT NULL,
    is_active boolean,
    dt_insert timestamp without time zone,
    dt_update timestamp without time zone,
    ck_create boolean,
    ck_delete boolean,
    ck_read boolean,
    ck_update boolean,
    id_user_insert bigint,
    id_user_update bigint,
    id_permission bigint NOT NULL,
    id_profile bigint,
    CONSTRAINT profile_permission_pkey PRIMARY KEY (id_profile_permission),
    CONSTRAINT profile_permission_uk UNIQUE (id_profile, id_permission)
);


--changeset ferreirarubens:0.0.1-user-1
CREATE TABLE access_control."user"
(
    id_user bigint NOT NULL,
    is_active boolean,
    dt_insert timestamp without time zone,
    dt_update timestamp without time zone,
    nr_access_level integer,
    nr_cpf character varying(14) COLLATE pg_catalog."default" NOT NULL,
    tp_gender character varying(255) COLLATE pg_catalog."default" NOT NULL,
    ds_login character varying(50) COLLATE pg_catalog."default" NOT NULL,
    nm_user character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    ds_password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    id_user_insert bigint,
    id_user_update bigint,
    id_profile bigint NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id_user),
    CONSTRAINT profile_fk FOREIGN KEY (id_profile)
        REFERENCES access_control.profile (id_profile) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_insert_fk FOREIGN KEY (id_user_insert)
        REFERENCES access_control."user" (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_update_fk FOREIGN KEY (id_user_update)
        REFERENCES access_control."user" (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);