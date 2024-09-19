/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : score

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2019-01-04 23:39:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_score
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `score_value` int(11) DEFAULT NULL COMMENT '成绩值',
  `score_type` varchar(255) DEFAULT NULL COMMENT '成绩类别1习题 2测验 3考试',
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='学生成绩表';

-- ----------------------------
-- Records of t_score
-- ----------------------------
INSERT INTO `t_score` VALUES ('3', '50', '1', '201723132');
INSERT INTO `t_score` VALUES ('4', '88', '2', '201723135');
INSERT INTO `t_score` VALUES ('5', '100', '1', '201723131');
INSERT INTO `t_score` VALUES ('6', '100', '3', '201723131');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `student_no` int(11) NOT NULL COMMENT '学号',
  `student_name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `student_sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `stu_pass` varchar(12) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`student_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('201723131', '黄梦歌', '女', '201723131');
INSERT INTO `t_student` VALUES ('201723132', '张三', '男', '201723132');
INSERT INTO `t_student` VALUES ('201723133', '李四', '男', '201723133');
INSERT INTO `t_student` VALUES ('201723134', '王五', '男', '201723134');
INSERT INTO `t_student` VALUES ('201723135', '马六', '女', '201723135');
INSERT INTO `t_student` VALUES ('201723136', 'lisa', '女', '201723136');
INSERT INTO `t_student` VALUES ('201723137', 'arike', '男', '201723137');
INSERT INTO `t_student` VALUES ('201723138', '测试数据', '男', '201723138');
INSERT INTO `t_student` VALUES ('201723139', '李思思', '女', '201723139');
INSERT INTO `t_student` VALUES ('201723142', '袁华', '男', '201723142');
INSERT INTO `t_student` VALUES ('201723143', '袁大头', '男', '201723143');
INSERT INTO `t_student` VALUES ('201723145', '都是', '男', '201723145');
INSERT INTO `t_student` VALUES ('201723147', 'lisi', '男', '201723147');
INSERT INTO `t_student` VALUES ('201723155', '黄三', '男', '201723155');
INSERT INTO `t_student` VALUES ('2017231388', '李达', '男', '2017231388');
INSERT INTO `t_student` VALUES ('2017231888', '大神给回复', '男', '2017231888');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `pass_word` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '123456');
