Use Blog;

insert into `user`(`id`,`username`,`password`,`enabled`)
    values(1,"Micheal Scott", "password", true),
        (2,"Jim Halpert","password",true);

insert into `role`(`id`,`role`)
    values(1,"ROLE_ADMIN"), (2,"ROLE_CONTRIBUTOR");
    
insert into `user_role`(`user_id`,`role_id`)
    values(1,1),(1,2),(2,2);

UPDATE user SET password = '$2a$10$G62zHeKFk2Sc4Xt5PCzyJu8i6nRZy50S3uFmLDPFLPodt3ABhyY/m' WHERE id = 1;
UPDATE user SET password = '$2a$10$G62zHeKFk2Sc4Xt5PCzyJu8i6nRZy50S3uFmLDPFLPodt3ABhyY/m' WHERE id = 2;