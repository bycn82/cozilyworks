/*
MySQL Data Transfer
Source Host: localhost
Source Database: db_account
Target Host: localhost
Target Database: db_account
Date: 2007-7-14 14:10:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tbl_account
-- ----------------------------
DROP TABLE IF EXISTS `tbl_account`;
CREATE TABLE `tbl_account` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `cozid` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `createdat` datetime default NULL,
  `updatedat` datetime default NULL,
  `registedip` varchar(45) default NULL,
  `question` varchar(45) NOT NULL,
  `answer` varchar(45) NOT NULL,
  `roles` int(10) unsigned NOT NULL default '0' COMMENT '0,normal user 1,editor 2 ,admin',
  `country` varchar(45) default NULL,
  `city` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `tbl_account` VALUES ('1', 'Cozid-1', 'using', '123456', 'cozly@qq.com', '2007-01-01 00:00:00', null, '127.0.0.1', '', '', '0', null, null);
INSERT INTO `tbl_account` VALUES ('5', 'Cozid-2', 'cozly', '123456', 'cozly@hotmail.com', '2007-01-14 03:05:16', null, '127.0.0.1', '', '', '0', null, null);
INSERT INTO `tbl_account` VALUES ('6', 'Cozid-3', 'yahoo', '123456', 'yahoo@yahoo.com', '2007-01-14 13:22:53', null, '127.0.0.1', '', '', '0', null, null);
INSERT INTO `tbl_account` VALUES ('7', 'Cozid-4', 'eslynn', '123456', 'eslynn@shu.com', '2007-03-16 01:00:17', null, '127.0.0.1', '', '', '0', null, null);
INSERT INTO `tbl_account` VALUES ('8', 'Cozid-5', 'susan', '123456', 'woshifanfan@gmail.com', '2007-03-16 01:04:13', null, '127.0.0.1', '', '', '0', null, null);
INSERT INTO `tbl_account` VALUES ('9', 'Cozid-6', 'lina', '123456', 'lina@hao.com', '2007-03-16 01:05:33', null, '127.0.0.1', '213', '545', '0', null, null);
