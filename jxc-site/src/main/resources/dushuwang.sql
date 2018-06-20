/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.6.30-log : Database - dushuwang
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dushuwang` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dushuwang`;

/*Table structure for table `attachment` */

DROP TABLE IF EXISTS `attachment`;

CREATE TABLE `attachment` (
  `ID` int(15) NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `FILE_NAME` varchar(100) DEFAULT NULL COMMENT '文件名',
  `FILE_PATH` varchar(256) DEFAULT NULL COMMENT '文件路径',
  `FILE_TYPE` char(1) DEFAULT NULL COMMENT '文件类型（1，笔记 2：课件）',
  `TITLE` varchar(30) DEFAULT NULL COMMENT '标题',
  `DOWNLOAD_NUM` int(10) DEFAULT NULL COMMENT '下载次数',
  `description` varchar(2000) DEFAULT NULL COMMENT '描述',
  `CREATE_USER_ID` int(12) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `icon_path` varchar(50) DEFAULT NULL COMMENT '图像路径',
  PRIMARY KEY (`ID`),
  KEY `IDX_ATTCH_CDATE` (`CREATE_DATE`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Table structure for table `attachment_image` */

DROP TABLE IF EXISTS `attachment_image`;

CREATE TABLE `attachment_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `attachment_id` int(11) DEFAULT NULL COMMENT '附件ID',
  `url` varchar(50) DEFAULT NULL COMMENT '路径',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`),
  KEY `IDX_ATTIMAGE_ATTACHMENT_ID` (`attachment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL COMMENT 'topicID或者资源id',
  `type` varchar(1) NOT NULL COMMENT '回答类型  1：topic  2：file',
  `content` varchar(2000) NOT NULL COMMENT '内容',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `comment_status` varchar(1) NOT NULL COMMENT '1:正常回答  2：匿名回答',
  `status` varchar(1) NOT NULL COMMENT '1:正常  2：已删除',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `stamp_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '盖章最多类型 0-无',
  PRIMARY KEY (`id`),
  KEY `IDX_COMMENT_CDATE` (`create_date`),
  KEY `IDX_COMMENT_PARENT_ID` (`parent_id`),
  KEY `IDX_COMMENT_STATUS` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

/*Table structure for table `data_dic` */

DROP TABLE IF EXISTS `data_dic`;

CREATE TABLE `data_dic` (
  `ID` int(11) NOT NULL COMMENT 'id',
  `TYPE` varchar(10) DEFAULT NULL COMMENT '类型',
  `CODE` varchar(8) DEFAULT NULL COMMENT '代码',
  `NAME` varchar(20) DEFAULT NULL COMMENT '名称',
  `DESC` varchar(50) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `number` int(4) NOT NULL COMMENT '学生数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Table structure for table `department_mapping` */

DROP TABLE IF EXISTS `department_mapping`;

CREATE TABLE `department_mapping` (
  `department_id` int(11) NOT NULL COMMENT '院系ID',
  `profession_id` int(11) NOT NULL COMMENT '专业ID',
  PRIMARY KEY (`department_id`,`profession_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `fans` */

DROP TABLE IF EXISTS `fans`;

CREATE TABLE `fans` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USER_ID` int(11) DEFAULT NULL COMMENT '用户ID',
  `FANS_USER_ID` int(11) DEFAULT NULL COMMENT '粉丝ID',
  `STATUS` char(1) DEFAULT NULL COMMENT '状态(1:关注 2：取消关注)',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`),
  KEY `IDX_FANS_CDATE` (`CREATE_DATE`),
  KEY `IDX_FANS_USER_ID` (`USER_ID`),
  KEY `IDX_FANS_FUSER_ID` (`FANS_USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Table structure for table `follow` */

DROP TABLE IF EXISTS `follow`;

CREATE TABLE `follow` (
  `subject_id` int(11) NOT NULL COMMENT '对象（话题或者附件）id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `type` varchar(1) NOT NULL COMMENT '类型  1：topic  2：file',
  PRIMARY KEY (`subject_id`,`user_id`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `type` tinyint(1) NOT NULL COMMENT '消息类型  1:关注 2:赞 3:回复 4:@ 5:匿名回复',
  `send_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '发送人',
  `send_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '发送实体类型：0-user，1：topic 2：file 3：comment  4：reply',
  `send_id` int(11) NOT NULL COMMENT '实体id',
  `des_type` tinyint(1) NOT NULL COMMENT '目标类型: 0 : user 1：topic 2：file 3：comment  4：reply',
  `des_id` int(11) NOT NULL COMMENT '目标id',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态  0：未读  1：已读',
  `is_anonym` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否匿名： 0-正常，1-匿名',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `IDX_MESSAGE_CREATEDATE` (`create_time`),
  KEY `user_type_status` (`user_id`,`type`,`status`) USING BTREE,
  KEY `send_type_id` (`send_type`,`send_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Table structure for table `profession` */

DROP TABLE IF EXISTS `profession`;

CREATE TABLE `profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) DEFAULT NULL COMMENT '专业名称',
  `number` int(11) DEFAULT '0' COMMENT '学生数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=250 DEFAULT CHARSET=utf8;

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(15) NOT NULL COMMENT 'comment ID',
  `replyto_id` int(11) DEFAULT NULL COMMENT '父回复ID',
  `content` varchar(2000) NOT NULL COMMENT '回复内容',
  `user_id` int(11) NOT NULL COMMENT '回复用户',
  `reply_status` varchar(1) NOT NULL COMMENT '1:正常回复  2：匿名回复',
  `status` varchar(1) NOT NULL DEFAULT '1' COMMENT '1:正常  2：已删除',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `IDS_REPLY_CDATE` (`create_date`),
  KEY `IDS_REPLY_COMMENT_ID` (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

/*Table structure for table `thumbup` */

DROP TABLE IF EXISTS `thumbup`;

CREATE TABLE `thumbup` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `subject_id` int(11) DEFAULT NULL COMMENT '点赞条目ID',
  `sub_type` varchar(1) DEFAULT NULL COMMENT '点赞条目类型 （1：topic  2：file  3：comment 4：reply',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `type` varchar(1) DEFAULT NULL COMMENT '类型  1：赞  2：踩',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `IDS_THUMBUP_SUBJECT_TYPE` (`subject_id`,`sub_type`)
) ENGINE=InnoDB AUTO_INCREMENT=174 DEFAULT CHARSET=utf8;

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `ID` int(15) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(30) DEFAULT NULL COMMENT '标题',
  `CREATE_USER_ID` int(12) DEFAULT NULL COMMENT '创建用户id',
  `CONTENT` varchar(2000) DEFAULT NULL COMMENT '讨论内容',
  `STATUS` varchar(1) DEFAULT NULL COMMENT '讨论状态',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `department_id` int(11) DEFAULT NULL COMMENT '系ID',
  `profession_id` int(11) DEFAULT NULL COMMENT '专业ID',
  `icon_path` varchar(50) DEFAULT NULL COMMENT '图像路径',
  PRIMARY KEY (`ID`),
  KEY `IDX_TOPIC_CDATE` (`CREATE_DATE`),
  KEY `IDX_TOPIC_DEPARTMENT_ID` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Table structure for table `topic_lable` */

DROP TABLE IF EXISTS `topic_lable`;

CREATE TABLE `topic_lable` (
  `ID` int(15) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Table structure for table `topic_lable_mapping` */

DROP TABLE IF EXISTS `topic_lable_mapping`;

CREATE TABLE `topic_lable_mapping` (
  `TOPIC_ID` int(11) NOT NULL,
  `LABLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`TOPIC_ID`,`LABLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `user_activity` */

DROP TABLE IF EXISTS `user_activity`;

CREATE TABLE `user_activity` (
  `ID` int(15) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USER_ID` int(12) DEFAULT NULL COMMENT '用户id',
  `subject_TYPE` char(1) DEFAULT NULL COMMENT '动态类型（1：topic  2：file  3：reply）',
  `subject_ID` int(15) DEFAULT NULL COMMENT '动态id',
  `subject_TITLE` varchar(30) DEFAULT NULL COMMENT '动态标题',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`),
  KEY `IDX_USER_CDATE` (`CREATE_DATE`),
  KEY `IDX_USER_ACTIVITY_USER_ID` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `card_no` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `ticket` varchar(50) DEFAULT NULL COMMENT '票据',
  `name` varchar(30) DEFAULT NULL COMMENT '真实姓名',
  `nick_name` varchar(36) DEFAULT NULL COMMENT '昵称',
  `school_name` varchar(50) DEFAULT NULL COMMENT '学校名称',
  `depart_id` int(15) DEFAULT NULL COMMENT '院系',
  `profession_id` int(15) DEFAULT NULL COMMENT '专业',
  `classes` varchar(20) DEFAULT NULL COMMENT '班级',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `student_no` varchar(18) DEFAULT NULL COMMENT '学号',
  `signature` varchar(20) DEFAULT NULL COMMENT '签名',
  `icon_path` varchar(50) DEFAULT NULL COMMENT '图像路径',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `passwd` varchar(64) DEFAULT '111111' COMMENT '密码',
  PRIMARY KEY (`id`),
  KEY `IDX_USER_DEPARTMENT` (`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=209 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
