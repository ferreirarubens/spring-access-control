--liquibase formatted sql

--changeset ferreirarubens:0.0.2-profile-type-1
INSERT INTO access_control.profile_type VALUES(1, true, now(), now(), 'ADMIN', '', 'ADMIN', NULL, NULL);

--changeset ferreirarubens:0.0.2-profile-1
INSERT INTO access_control.profile VALUES (1, true, now(), now(), 1, 'ADMIN', NULL, NULL, 1);

--changeset ferreirarubens:0.0.2-permission-1
INSERT INTO access_control.permission VALUES (1, true, now(), now(), true, 'ROLE_USER', null, null);
--changeset ferreirarubens:0.0.2-permission-2
INSERT INTO access_control.permission VALUES (2, true, now(), now(), true, 'ROLE_PROFILE', null, null);
--changeset ferreirarubens:0.0.2-permission-3
INSERT INTO access_control.permission VALUES (3, true, now(), now(), true, 'ROLE_ADMIN', null, null);
--changeset ferreirarubens:0.0.2-permission-4
INSERT INTO access_control.permission VALUES (4, true, now(), now(), true, 'ROLE_PERMISSION', null, null);
--changeset ferreirarubens:0.0.2-permission-5
INSERT INTO access_control.permission VALUES (5, true, now(), now(), true, 'ROLE_PROFILE_PERMISSION', null, null);
--changeset ferreirarubens:0.0.2-permission-6
INSERT INTO access_control.permission VALUES (6, true, now(), now(), true, 'ROLE_PROFILE_TYPE', null, null);

--changeset ferreirarubens:0.0.2-profile-permission-1
INSERT INTO access_control.profile_permission VALUES (1, true, now(), now(), true, true, true, true, null, null, 1, 1);
--changeset ferreirarubens:0.0.2-profile-permission-2
INSERT INTO access_control.profile_permission VALUES (2, true, now(), now(), true, true, true, true, null, null, 2, 1);
--changeset ferreirarubens:0.0.2-profile-permission-3
INSERT INTO access_control.profile_permission VALUES (3, true, now(), now(), true, true, true, true, null, null, 3, 1);
--changeset ferreirarubens:0.0.2-profile-permission-4
INSERT INTO access_control.profile_permission VALUES (4, true, now(), now(), true, true, true, true, null, null, 4, 1);
--changeset ferreirarubens:0.0.2-profile-permission-5
INSERT INTO access_control.profile_permission VALUES (5, true, now(), now(), true, true, true, true, null, null, 5, 1);
--changeset ferreirarubens:0.0.2-profile-permission-6
INSERT INTO access_control.profile_permission VALUES (6, true, now(), now(), true, true, true, true, null, null, 6, 1);