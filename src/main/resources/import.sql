-- PROFILE TYPE
INSERT INTO access_control.profile_type VALUES(1, true, now(), now(), 'ADMIN', '', 'ADMIN', NULL, NULL);

-- PROFILE
INSERT INTO access_control.profile VALUES (1, true, now(), now(), 1, 'ADMIN', NULL, NULL, 1);

-- PERMISSION
INSERT INTO access_control.permission VALUES (1, true, now(), now(), true, 'ROLE_USER', null, null);
INSERT INTO access_control.permission VALUES (2, true, now(), now(), true, 'ROLE_PROFILE', null, null);
INSERT INTO access_control.permission VALUES (3, true, now(), now(), true, 'ROLE_ADMIN', null, null);
INSERT INTO access_control.permission VALUES (4, true, now(), now(), true, 'ROLE_PERMISSION', null, null);
INSERT INTO access_control.permission VALUES (5, true, now(), now(), true, 'ROLE_PROFILE_PERMISSION', null, null);
INSERT INTO access_control.permission VALUES (6, true, now(), now(), true, 'ROLE_PROFILE_TYPE', null, null);

INSERT INTO access_control.profile_permission VALUES (1, true, now(), now(), true, true, true, true, null, null, 1, 1);
INSERT INTO access_control.profile_permission VALUES (2, true, now(), now(), true, true, true, true, null, null, 2, 1);
INSERT INTO access_control.profile_permission VALUES (3, true, now(), now(), true, true, true, true, null, null, 3, 1);
INSERT INTO access_control.profile_permission VALUES (4, true, now(), now(), true, true, true, true, null, null, 4, 1);
INSERT INTO access_control.profile_permission VALUES (5, true, now(), now(), true, true, true, true, null, null, 5, 1);
INSERT INTO access_control.profile_permission VALUES (6, true, now(), now(), true, true, true, true, null, null, 6, 1);