create view v_user_role as
select c.username, g.group_name, c.password from customer c, groups g, users_groups ug where c.USER_ID = ug.USER_ID and g.GROUP_ID = ug.GROUP_ID;


INSERT INTO `customer` (`USER_ID`,`CREATIONDATE`,`DATEOFBIRTH`,`GENDER`,`MOBILEPHONE`,`NAME`,`PASSWORD`,`SURNAME`,`USERNAME`,`CITY`,`PROVINCE`,`STREET`,`ZIPCODE`) VALUES (1000,NULL,'1976-06-14',NULL,'615095361','Ruben','21232f297a57a5a743894a0e4a801fc3','Sanchez Sancho','rsanchezs@uoc.edu',NULL,NULL,NULL,NULL);
INSERT INTO `customer` (`USER_ID`,`CREATIONDATE`,`DATEOFBIRTH`,`GENDER`,`MOBILEPHONE`,`NAME`,`PASSWORD`,`SURNAME`,`USERNAME`,`CITY`,`PROVINCE`,`STREET`,`ZIPCODE`) VALUES (1001,NULL,'1974-05-07',NULL,'676208094','Marga','21232f297a57a5a743894a0e4a801fc3','Alfara Filella','assessoramentimatge@hotmail.com',NULL,NULL,NULL,NULL);


INSERT INTO groups (GROUP_ID,DESCRIPTION,GROUP_NAME) VALUES (1000,'Administrators', 'admin');
INSERT INTO groups (GROUP_ID,DESCRIPTION,GROUP_NAME) VALUES (1001,'Customers', 'customer');


INSERT INTO users_groups (GROUP_ID,USER_ID) VALUES (1000,1000);
INSERT INTO users_groups (GROUP_ID,USER_ID) VALUES (1000,1001);
INSERT INTO users_groups (GROUP_ID,USER_ID) VALUES (1001,1001);
