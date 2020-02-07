--liquibase formatted sql

--changeset ferreirarubens:0.0.1-profile-type-2
ALTER TABLE access_control.profile_type
    ADD CONSTRAINT user_insert_fk FOREIGN KEY (id_user_insert)
        REFERENCES access_control."user" (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    ADD CONSTRAINT user_update_fk FOREIGN KEY (id_user_update)
        REFERENCES access_control."user" (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;

--changeset ferreirarubens:0.0.1-profile-2
ALTER TABLE access_control.profile
    ADD CONSTRAINT user_insert_fk FOREIGN KEY (id_user_insert)
        REFERENCES access_control."user" (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    ADD CONSTRAINT user_update_fk FOREIGN KEY (id_user_update)
        REFERENCES access_control."user" (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;

--changeset ferreirarubens:0.0.1-permission-2
ALTER TABLE access_control.permission
    ADD CONSTRAINT user_insert_fk FOREIGN KEY (id_user_insert)
        REFERENCES access_control."user" (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    ADD CONSTRAINT user_update_fk FOREIGN KEY (id_user_update)
        REFERENCES access_control."user" (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;

--changeset ferreirarubens:0.0.1-profile-permission-2
ALTER TABLE access_control.profile_permission
    ADD CONSTRAINT permission_fk FOREIGN KEY (id_permission)
        REFERENCES access_control.permission (id_permission) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    ADD CONSTRAINT profile_fk FOREIGN KEY (id_profile)
        REFERENCES access_control.profile (id_profile) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    ADD CONSTRAINT user_insert_fk FOREIGN KEY (id_user_insert)
        REFERENCES access_control."user" (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    ADD CONSTRAINT user_update_fk FOREIGN KEY (id_user_update)
        REFERENCES access_control."user" (id_user) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;