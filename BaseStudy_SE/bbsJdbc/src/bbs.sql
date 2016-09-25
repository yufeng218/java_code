1、会员管理模块
-------------- 用户表的创建 ----------
create table my_user (
	id_ varchar(45) not null,
	loginName_ varchar(128) default null,
	password_ varchar(128) default null,
	eamil_ varchar(128) default null,
	nickname_ varchar(128) default null,
	gender_ varchar(16) default null,
	avatar_ mediumblob,
	signature_ varchar(255) default null,
	registrationTime_ datetime default null,
	lastVisitTime_ datetime default null,
	lastVisitIpAddr_ varchar(50) default null,
	topicCount_ int(11) default null,
	articleCount_ int(11) default null,
	locked_ bit(1) default null,
	autoLoginAuthKey_ varchar(128) default null,
	primary key (id_)
) 	engin=InnoDB default charset=utf8;

-------------- 角色表的创建 ----------
create table my_role(
	id_ varchar(255) not null,
	name_ varchar(64) default null,
	description_ varchar(255) default null,
	defaultForNewUser_ bit(1) default null,
	primary key (id_)
)	engine=InnoDB default charset=utf8;

-------------------------- 用户表和角色表的关联表  --------------------
create table my_user_role (
	userId_ varchar(45) not null,
	roleId_ varchar(255) not null,
	primary key (userId_, roleId_),
	key fk9c95cd553b7c6692 (roleId_),
	key fk9c95cd55e0a72a72 (userId_),
	constraint fk9c95cd553b7c6692 foreign key (userId_) references my_user (id_),
	constraint fk9c95cd55e0a72a72 foreign key (roleId_) references my_role (id_)
)	engine=InnoDB default charset=utf8;

-------------------------- 权限表  --------------------
create table my_systemprivilege (
	id_ varchar(255) not null,
	name_ varchar(255) default null,
	action_ varchar(64) default null,
	resource_ varchar(64) default null,
	primary key (id_)
)	engine=InnoDB default charset=utf8;

-------------------------- 角色表和权限表关联的表  --------------------
create table my_role_systemprivilege (
	roleId_ varchar(255) not null,
	systemPrivilegeId_ varchar(255) not null,
	primary key (roleId_, systemPrivilegeId_),
	key fk70476c853b7c6692 (roleId_),
	key fk70476c8558d7fed6 (systemPrivilegeId_),
	constraint fk70476c853b7c6692 foreign key (roleId_) references my_role (id_),
	constraint fk70476c8558d7fed6 foreign key (systemPrivilegeId_) references my_systemprivilege (id_)
)	engine=InnoDB default charset=utf8;


2、板面管理模块
--------- 父板块 --------
create table my_category (
	id_ varchar(255) not null,
	name_ varchar(255) default null,
	order_ int(11) default null,
	primary key (id_)
)	engine=InnoDB default charset=utf8;

----------- 子版块(二级板块)属于某个父板块 主键关系
create table my_forum(
	id_ varchar(255) not null,
	name_ varchar(255) default null,
	description_ varchar(255) default null,
	order_ int(11) default null,
	categroyId_ varchar(255) default null,
	topicCount_ int(11) default null,
	articleCount_ int(11) default null,
	lastTopicId_ varchar(255) default null,
	lastArticlePostTime_ datetime default null,
	primary key (id_),
	key fk903a938cce73292 (categroyId_),
	constraint fk903a938cce73292 foreign key (categroyId_) references my_category (id_)
)	engine=InnoDB default charset=utf8;


---------- 帖子表 -----------
create table my_topic (
	id_ varchar(255) not null,
	title_ varchar(255) default null,
	content_ text,
	authorId_ varchar(45) default null,
	postTime_ datetime default null,
	ipAddr_ varchar(16) default null,
	deleted_ bit(1) default null,
	type_ varchar(255) default null,
	forumId_ varchar(255) default null,
	replyCount_ int(11) default null,
	lastReplyId_ varchar(255) default null,
	lastArticlePostTime_ datetime default null,
	nextFloor_ int(11) default null,
	primary key (id_),
	key fk90ffd39a5ff9c116 (forumId_),
	key fk6899e4a141601cb290ffd39a (authorId_),
	constraint fk6899e4a141601cb290ffd39a foreign key (authorId_) references my_user (id_),
	constraint fk90ffd39a5ff9c116 foreign key (forumId_) references my_forum (id_)
)	engine=InnoDB default charset=utf8;

------------ 回复表 ---------
create table my_reply(
	id_ varchar(255) not null,
	title_ varchar(255) default null,
	content_ text,
	authorId_ varchar(45) default null,
	postTime_ datetime default null,
	ipAddr_ varchar(50) default null,
	deleted_ bit(1) default null,
	floor_ int(11) default null,
	topicId_ varchar(255) default null,
	primary key (id_),
	key fk90df1955af81e56 (topicId_),
	key fk6899e4a141601cb290df1955 (authorId_),
	constraint fk6899e4a141601cb290df1955 foreign key (authorId_) references my_user (id_),
	constraint fk90df1955af81e56 foreign key (topicId_) references my_topic (id_)
);
















