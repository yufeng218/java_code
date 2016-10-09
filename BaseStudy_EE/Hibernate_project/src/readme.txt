1、创建数据表
//会员表（用户表）
create table systemMemberTable (
	id int not null auto_increment,
	name varchar(20) default null,
	fullName varchar(20),
	password varchar(20),
	privilege varchar(20),
	primary key (id)
)

//问题类型表
create table questionTypeTable (
	id int(11) not null auto_increment,
	name varchar(20) default null,
	primary key (id)
)

//问题表
create table questionTable (
	id int(11) not null auto_increment,
	createTime varchar(20) default null,
	systemMemberId int(11) default null,
	questionTypeId int(11) default null,
	questionKey varchar(20) default null,
	content varchar(200) default null,
	answerCount int(11) default null,
	primary key (id)
)

//答案表
create table answerTable (
	id int(11) not null auto_increment,
	createTime varchar(20) default null,
	systemMemberId int(11) default null,
	questionId int(11) default null,
	content varchar(200) default null,
	primary key (id)
)

2、映射的实体类

3、Dao




