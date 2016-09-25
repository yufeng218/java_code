
---- questions ��ṹ -----
create table questions(
id int primary key,
title varchar(250),
options varchar(500),
answer varchar(500),
score int(2),
qlevel int(2)
);

---- users��ṹ -------
create table users(
id int(4) primary key,
name varchar(10),
passwd varchar(10),
email varchar(50)
);
