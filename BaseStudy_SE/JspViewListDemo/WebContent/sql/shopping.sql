-- 数据库创建
-- create database shopping;

SET FOREIGN_KEY_CHECKS=0;

-- ------------------------------
-- Table structure for items
-- ------------------------------
DROP TABLE IF EXISTS items;
CREATE TABLE items (
	id int(15) NOT NULL auto_increment,
	name varchar(50) default NULL,
	city varchar(50) default NULL,
	price int(15) default NULL,
	number int(15) default NULL,
	picture varchar(500) default NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ---------------------------------------
-- Records of items
-- ---------------------------------------
INSERT INTO items VALUES (1, "沃特篮球鞋", "佛山", 180, 500, "woTe02.jpg");
INSERT INTO items VALUES (2, "安踏运动鞋", "福州", 120, 800, "anTa02.jpg");
INSERT INTO items VALUES (3, "耐克运动鞋", "广州", 500, 1000, "naiKe02.jpg");
INSERT INTO items VALUES (4, "阿迪达斯T恤", "上海", 388, 600, "anTa02.jpg");
INSERT INTO items VALUES (5, "李宁文化衫", "广州", 180, 900, "lining02.jpg");
INSERT INTO items VALUES (6, "小米3", "北京", 1999, 3000, "xiaomi02.jpg");
INSERT INTO items VALUES (7, "小米2S", "北京", 1299, 1000, "mi2S02.jpg");
INSERT INTO items VALUES (8, "thinkpad笔记本", "北京", 6999, 500, "think02.jpg");
INSERT INTO items VALUES (9, "dell笔记本", "北京", 3999, 500, "dell02.jpg");
INSERT INTO items VALUES (10, "ipad5", "北京", 5999, 500, "ipad02.jpg");







