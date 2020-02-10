--liquibase formatted sql

--changeset ferreirarubens:0.0.3-user-1
INSERT INTO access_control.USER
            (id_user,
             is_active,
             dt_insert,
             nr_access_level,
             nr_cpf,
             tp_gender,
             ds_login,
             nm_user,
             ds_password,
             id_profile)
VALUES      ( 1,
              true,
              Now(),
              1,
              '19100000000',
              'MALE',
              'admin@ferreira',
              'Admin Ferreira',
              '$2a$10$BF90GwJft28iS0.y1rDJGuzUyOvUgryLCTBeVuZJ5.BdLOsgMYVmK',
              1 ); 