-- PROFILE TYPE
INSERT INTO profile_type VALUES(1, now(), now(), 'ADMIN', '', 'ADMIN', NULL, NULL);

-- PROFILE
INSERT INTO profile VALUES (1, now(), now(), 1, 'ADMIN', NULL, NULL, 1);

-- PERMISSION
INSERT INTO permission VALUES (1, now(), now(), true, 'ROLE_USER', null, null);
INSERT INTO permission VALUES (2, now(), now(), true, 'ROLE_PROFILE', null, null);
INSERT INTO permission VALUES (3, now(), now(), true, 'ROLE_ADMIN', null, null);
INSERT INTO permission VALUES (4, now(), now(), true, 'ROLE_PERMISSION', null, null);
INSERT INTO permission VALUES (5, now(), now(), true, 'ROLE_PROFILE_PERMISSION', null, null);
INSERT INTO permission VALUES (6, now(), now(), true, 'ROLE_PROFILE_TYPE', null, null);

INSERT INTO profile_permission VALUES (1, now(), now(), true, true, true, true, null, null, 1, 1);
INSERT INTO profile_permission VALUES (2, now(), now(), true, true, true, true, null, null, 2, 1);
INSERT INTO profile_permission VALUES (3, now(), now(), true, true, true, true, null, null, 3, 1);
INSERT INTO profile_permission VALUES (4, now(), now(), true, true, true, true, null, null, 4, 1);
INSERT INTO profile_permission VALUES (5, now(), now(), true, true, true, true, null, null, 5, 1);
INSERT INTO profile_permission VALUES (6, now(), now(), true, true, true, true, null, null, 6, 1);