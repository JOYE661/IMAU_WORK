
# 此文件用于部署项目时导入数据库
# 在实际上线时，不应公开此文件，以避免重要信息泄露

# 创建数据库
CREATE DATABASE `php_fun`;

# 选择数据库
USE `php_fun`;

# Session表
CREATE TABLE `fun_session` (
  `id` VARCHAR(255) PRIMARY KEY COMMENT 'SessionID',
  `expires` INT UNSIGNED NOT NULL COMMENT '过期时间',
  `data` BLOB COMMENT '数据'
) DEFAULT CHARSET=utf8;

# 栏目表
CREATE TABLE `fun_category` (
  `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(12) DEFAULT '' NOT NULL COMMENT '栏目名称',
  `cover` VARCHAR(255) DEFAULT '' NOT NULL COMMENT '图片地址',
  `sort` INT DEFAULT 0 NOT NULL COMMENT '显示顺序'
) DEFAULT CHARSET=utf8;

# 内容表
CREATE TABLE `fun_post` (
  `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `cid` INT UNSIGNED DEFAULT 0 NOT NULL COMMENT '栏目id',
  `uid` INT UNSIGNED DEFAULT 0 NOT NULL COMMENT '用户id',
  `type` ENUM('text','video','pic') DEFAULT 'text' NOT NULL COMMENT '内容类型',
  `content` TEXT NOT NULL COMMENT '内容文本',
  `time` INT UNSIGNED DEFAULT 0 NOT NULL COMMENT '发布时间',
  `hits` INT UNSIGNED DEFAULT 0 NOT NULL COMMENT '阅读量',
  `reply` INT UNSIGNED DEFAULT 0 NOT NULL COMMENT '回复量'
) DEFAULT CHARSET=utf8;

# 附件表
CREATE TABLE `fun_attachment` (
  `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `pid` INT UNSIGNED DEFAULT 0 NOT NULL COMMENT '内容id',
  `content` VARCHAR(255) DEFAULT '' NOT NULL COMMENT '附件内容'
) DEFAULT CHARSET=utf8;

# 回复表
CREATE TABLE `fun_reply` (
  `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `pid` INT UNSIGNED DEFAULT 0 NOT NULL COMMENT '内容id',
  `uid` INT UNSIGNED DEFAULT 0 NOT NULL COMMENT '用户id',
  `content` VARCHAR(255) DEFAULT '' NOT NULL COMMENT '回复内容',
  `time` INT UNSIGNED DEFAULT 0 NOT NULL COMMENT '回复时间'
) DEFAULT CHARSET=utf8;

# 用户表
CREATE TABLE `fun_user` (
  `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `group` ENUM('admin','user') DEFAULT 'user' NOT NULL COMMENT '用户组',
  `name` VARCHAR(10) UNIQUE DEFAULT '' NOT NULL COMMENT '用户名',
  `email` VARCHAR(32) DEFAULT '' NOT NULL COMMENT '电子邮箱',
  `password` CHAR(32) DEFAULT '' NOT NULL COMMENT '密码',
  `salt` CHAR(6) DEFAULT '' NOT NULL COMMENT '密码盐',
  `avatar` VARCHAR(255) DEFAULT '' NOT NULL COMMENT '头像地址',
  `time` INT UNSIGNED DEFAULT 0 NOT NULL COMMENT '注册时间'
) DEFAULT CHARSET=utf8;

INSERT INTO `fun_user` (`id`, `group`, `name`, `email`, `password`, `salt`, `time`) VALUES
(1, 'admin', 'admin', 'admin@example.com', MD5(CONCAT(MD5('123456'), 'a9E3iN')), 'a9E3iN', UNIX_TIMESTAMP());

INSERT INTO `fun_category` (`id`, `name`, `cover`, `sort`) VALUES
(1,  'ThinkPHP', '2017-04/24/e3fc47679a3ed4d81eed36271e75c5e4.png', 0),
(2,  'Bootstrap', '2017-04/24/5a7f90ed87454fae60d9a76b3c9974a0.png', 1),
(3,  'Laravel', '2017-04/24/c85b86946fb46120f61bf371b91cde90.png', 2),
(4,  '小道消息', '', 3),
(5,  '嘿科技', '', 4),
(6,  '趣快报', '', 5),
(7,  '歪果趣闻', '', 6),
(9,  '神吐槽', '', 7),
(8,  '涨姿势', '', 8);