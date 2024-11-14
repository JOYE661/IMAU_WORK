/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 21/09/2024 09:40:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isAdmin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangsan', '111111', '1');
INSERT INTO `user` VALUES (2, '张三', '111111', '2');
INSERT INTO `user` VALUES (3, 'lisi', '999999', '5');
INSERT INTO `user` VALUES (4, 'aaa', '111', NULL);
INSERT INTO `user` VALUES (5, 'lklklk', '141414', '0');
INSERT INTO `user` VALUES (6, 'lilili', '141414', '1');
INSERT INTO `user` VALUES (7, 'lilili', '141414', '1');
INSERT INTO `user` VALUES (8, 'ljljlj', '222222', NULL);
INSERT INTO `user` VALUES (9, 'oooooo', '999999', NULL);

SET FOREIGN_KEY_CHECKS = 1;
