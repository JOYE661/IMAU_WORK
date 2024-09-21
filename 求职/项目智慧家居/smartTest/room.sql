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

 Date: 21/09/2024 09:40:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `roomName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `roomIcon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sensorNum` int NULL DEFAULT NULL,
  `temperature` int NULL DEFAULT NULL,
  `humidity` int NULL DEFAULT NULL,
  `brightness` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '卧室', 'https://java-11.obs.cn-north-4.myhuaweicloud.com:443/room/home3.png', 1, 25, 66, 8);
INSERT INTO `room` VALUES (2, '厨房', 'https://java-11.obs.cn-north-4.myhuaweicloud.com:443/room/home2.png', 2, 30, 55, 9);

SET FOREIGN_KEY_CHECKS = 1;
