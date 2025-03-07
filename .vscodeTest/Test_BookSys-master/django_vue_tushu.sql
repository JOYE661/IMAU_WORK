/*
 Navicat Premium Data Transfer

 Source Server         : 本地drf+vue
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : django_vue_tushu

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 26/03/2024 21:16:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_group
-- ----------------------------
DROP TABLE IF EXISTS `auth_group`;
CREATE TABLE `auth_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for auth_group_permissions
-- ----------------------------
DROP TABLE IF EXISTS `auth_group_permissions`;
CREATE TABLE `auth_group_permissions`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_group_permissions_group_id_permission_id_0cd325b0_uniq`(`group_id`, `permission_id`) USING BTREE,
  INDEX `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm`(`permission_id`) USING BTREE,
  CONSTRAINT `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `auth_group_permissions_group_id_b120cbf9_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for auth_permission
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content_type_id` int(11) NOT NULL,
  `codename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_permission_content_type_id_codename_01ab375a_uniq`(`content_type_id`, `codename`) USING BTREE,
  CONSTRAINT `auth_permission_content_type_id_2f476e4b_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_permission
-- ----------------------------
INSERT INTO `auth_permission` VALUES (1, 'Can add log entry', 1, 'add_logentry');
INSERT INTO `auth_permission` VALUES (2, 'Can change log entry', 1, 'change_logentry');
INSERT INTO `auth_permission` VALUES (3, 'Can delete log entry', 1, 'delete_logentry');
INSERT INTO `auth_permission` VALUES (4, 'Can view log entry', 1, 'view_logentry');
INSERT INTO `auth_permission` VALUES (5, 'Can add permission', 2, 'add_permission');
INSERT INTO `auth_permission` VALUES (6, 'Can change permission', 2, 'change_permission');
INSERT INTO `auth_permission` VALUES (7, 'Can delete permission', 2, 'delete_permission');
INSERT INTO `auth_permission` VALUES (8, 'Can view permission', 2, 'view_permission');
INSERT INTO `auth_permission` VALUES (9, 'Can add group', 3, 'add_group');
INSERT INTO `auth_permission` VALUES (10, 'Can change group', 3, 'change_group');
INSERT INTO `auth_permission` VALUES (11, 'Can delete group', 3, 'delete_group');
INSERT INTO `auth_permission` VALUES (12, 'Can view group', 3, 'view_group');
INSERT INTO `auth_permission` VALUES (13, 'Can add user', 4, 'add_user');
INSERT INTO `auth_permission` VALUES (14, 'Can change user', 4, 'change_user');
INSERT INTO `auth_permission` VALUES (15, 'Can delete user', 4, 'delete_user');
INSERT INTO `auth_permission` VALUES (16, 'Can view user', 4, 'view_user');
INSERT INTO `auth_permission` VALUES (17, 'Can add content type', 5, 'add_contenttype');
INSERT INTO `auth_permission` VALUES (18, 'Can change content type', 5, 'change_contenttype');
INSERT INTO `auth_permission` VALUES (19, 'Can delete content type', 5, 'delete_contenttype');
INSERT INTO `auth_permission` VALUES (20, 'Can view content type', 5, 'view_contenttype');
INSERT INTO `auth_permission` VALUES (21, 'Can add session', 6, 'add_session');
INSERT INTO `auth_permission` VALUES (22, 'Can change session', 6, 'change_session');
INSERT INTO `auth_permission` VALUES (23, 'Can delete session', 6, 'delete_session');
INSERT INTO `auth_permission` VALUES (24, 'Can view session', 6, 'view_session');
INSERT INTO `auth_permission` VALUES (25, 'Can add author', 7, 'add_author');
INSERT INTO `auth_permission` VALUES (26, 'Can change author', 7, 'change_author');
INSERT INTO `auth_permission` VALUES (27, 'Can delete author', 7, 'delete_author');
INSERT INTO `auth_permission` VALUES (28, 'Can view author', 7, 'view_author');
INSERT INTO `auth_permission` VALUES (29, 'Can add publish', 8, 'add_publish');
INSERT INTO `auth_permission` VALUES (30, 'Can change publish', 8, 'change_publish');
INSERT INTO `auth_permission` VALUES (31, 'Can delete publish', 8, 'delete_publish');
INSERT INTO `auth_permission` VALUES (32, 'Can view publish', 8, 'view_publish');
INSERT INTO `auth_permission` VALUES (33, 'Can add book', 9, 'add_book');
INSERT INTO `auth_permission` VALUES (34, 'Can change book', 9, 'change_book');
INSERT INTO `auth_permission` VALUES (35, 'Can delete book', 9, 'delete_book');
INSERT INTO `auth_permission` VALUES (36, 'Can view book', 9, 'view_book');

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_login` datetime(6) NULL DEFAULT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `first_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for auth_user_groups
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_groups`;
CREATE TABLE `auth_user_groups`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_user_groups_user_id_group_id_94350c0c_uniq`(`user_id`, `group_id`) USING BTREE,
  INDEX `auth_user_groups_group_id_97559544_fk_auth_group_id`(`group_id`) USING BTREE,
  CONSTRAINT `auth_user_groups_group_id_97559544_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `auth_user_groups_user_id_6a12ed8b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for auth_user_user_permissions
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_user_permissions`;
CREATE TABLE `auth_user_user_permissions`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_user_user_permissions_user_id_permission_id_14a6b632_uniq`(`user_id`, `permission_id`) USING BTREE,
  INDEX `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm`(`permission_id`) USING BTREE,
  CONSTRAINT `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `auth_user_user_permissions_user_id_a95ead1b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for book_author
-- ----------------------------
DROP TABLE IF EXISTS `book_author`;
CREATE TABLE `book_author`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_author
-- ----------------------------
INSERT INTO `book_author` VALUES (1, 'A', 19);
INSERT INTO `book_author` VALUES (2, 'B', 20);
INSERT INTO `book_author` VALUES (3, 'C', 22);
INSERT INTO `book_author` VALUES (4, 'D', 30);
INSERT INTO `book_author` VALUES (5, 'A', 19);
INSERT INTO `book_author` VALUES (6, 'A', 19);

-- ----------------------------
-- Table structure for book_book
-- ----------------------------
DROP TABLE IF EXISTS `book_book`;
CREATE TABLE `book_book`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` int(11) NOT NULL,
  `pub_date` date NOT NULL,
  `bread` int(11) NOT NULL,
  `bcomment` int(11) NOT NULL,
  `publish_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `book_book_publish_id_dc55dce5_fk_book_publish_id`(`publish_id`) USING BTREE,
  CONSTRAINT `book_book_publish_id_dc55dce5_fk_book_publish_id` FOREIGN KEY (`publish_id`) REFERENCES `book_publish` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_book
-- ----------------------------
INSERT INTO `book_book` VALUES (4, '童年3', 13, '2024-02-14', 200, 300, 2);
INSERT INTO `book_book` VALUES (5, '童年1', 1, '2024-02-06', 1, 1, 1);
INSERT INTO `book_book` VALUES (6, '童年1', 1, '2024-02-06', 1, 1, 1);
INSERT INTO `book_book` VALUES (7, 'dsfsdaf', 12, '2024-02-06', 66, 88, 3);
INSERT INTO `book_book` VALUES (8, '高尔基-童年', 12, '2024-02-06', 66, 88, 3);
INSERT INTO `book_book` VALUES (9, '高尔基-在人间', 12, '2024-02-06', 66, 88, 3);
INSERT INTO `book_book` VALUES (12, '高尔基-我的大学2', 12, '2024-02-06', 66, 88, 3);
INSERT INTO `book_book` VALUES (13, '我的大学', 30, '2024-02-06', 33, 33, 3);
INSERT INTO `book_book` VALUES (14, '我的大学', 66, '2024-02-06', 33, 33, 3);
INSERT INTO `book_book` VALUES (15, '我的大学', 67, '2024-02-06', 33, 33, 3);
INSERT INTO `book_book` VALUES (16, '我的大学', 30, '2024-02-06', 33, 33, 3);
INSERT INTO `book_book` VALUES (17, '我的大学', 66, '2024-02-06', 33, 33, 3);
INSERT INTO `book_book` VALUES (18, '我的大学', 30, '2024-02-06', 33, 33, 3);
INSERT INTO `book_book` VALUES (19, '我的大学', 30, '2024-02-06', 33, 33, 3);
INSERT INTO `book_book` VALUES (20, '我的大学', 30, '2024-02-06', 33, 33, 3);
INSERT INTO `book_book` VALUES (21, '童年3', 13, '2024-02-14', 200, 300, 2);
INSERT INTO `book_book` VALUES (22, '童年3', 13, '2024-02-14', 200, 300, 2);
INSERT INTO `book_book` VALUES (23, '童年3', 13, '2024-02-14', 200, 300, 2);
INSERT INTO `book_book` VALUES (24, '童年3', 13, '2024-02-14', 200, 300, 2);
INSERT INTO `book_book` VALUES (25, '童年3', 13, '2024-02-14', 200, 300, 1);
INSERT INTO `book_book` VALUES (26, '童年3', 13, '2024-02-14', 200, 300, 1);
INSERT INTO `book_book` VALUES (27, '童年3', 13, '2024-02-14', 200, 300, 1);
INSERT INTO `book_book` VALUES (28, '图书上架1', 13, '2024-02-14', 200, 300, 1);

-- ----------------------------
-- Table structure for book_book_authors
-- ----------------------------
DROP TABLE IF EXISTS `book_book_authors`;
CREATE TABLE `book_book_authors`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_id` bigint(20) NOT NULL,
  `author_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `book_book_authors_book_id_author_id_652071c2_uniq`(`book_id`, `author_id`) USING BTREE,
  INDEX `book_book_authors_author_id_dc6a47c1_fk_book_author_id`(`author_id`) USING BTREE,
  CONSTRAINT `book_book_authors_author_id_dc6a47c1_fk_book_author_id` FOREIGN KEY (`author_id`) REFERENCES `book_author` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `book_book_authors_book_id_2a4a45bb_fk_book_book_id` FOREIGN KEY (`book_id`) REFERENCES `book_book` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 89 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_book_authors
-- ----------------------------
INSERT INTO `book_book_authors` VALUES (72, 4, 2);
INSERT INTO `book_book_authors` VALUES (73, 4, 3);
INSERT INTO `book_book_authors` VALUES (8, 5, 1);
INSERT INTO `book_book_authors` VALUES (9, 5, 2);
INSERT INTO `book_book_authors` VALUES (10, 6, 1);
INSERT INTO `book_book_authors` VALUES (11, 6, 2);
INSERT INTO `book_book_authors` VALUES (12, 7, 3);
INSERT INTO `book_book_authors` VALUES (13, 7, 4);
INSERT INTO `book_book_authors` VALUES (14, 8, 3);
INSERT INTO `book_book_authors` VALUES (15, 8, 4);
INSERT INTO `book_book_authors` VALUES (16, 9, 3);
INSERT INTO `book_book_authors` VALUES (17, 9, 4);
INSERT INTO `book_book_authors` VALUES (22, 12, 3);
INSERT INTO `book_book_authors` VALUES (23, 12, 4);
INSERT INTO `book_book_authors` VALUES (24, 13, 1);
INSERT INTO `book_book_authors` VALUES (25, 13, 2);
INSERT INTO `book_book_authors` VALUES (26, 13, 3);
INSERT INTO `book_book_authors` VALUES (27, 13, 4);
INSERT INTO `book_book_authors` VALUES (28, 13, 5);
INSERT INTO `book_book_authors` VALUES (29, 13, 6);
INSERT INTO `book_book_authors` VALUES (30, 14, 1);
INSERT INTO `book_book_authors` VALUES (31, 14, 2);
INSERT INTO `book_book_authors` VALUES (32, 14, 3);
INSERT INTO `book_book_authors` VALUES (33, 14, 4);
INSERT INTO `book_book_authors` VALUES (34, 14, 5);
INSERT INTO `book_book_authors` VALUES (35, 14, 6);
INSERT INTO `book_book_authors` VALUES (36, 15, 1);
INSERT INTO `book_book_authors` VALUES (37, 15, 2);
INSERT INTO `book_book_authors` VALUES (38, 15, 3);
INSERT INTO `book_book_authors` VALUES (39, 15, 4);
INSERT INTO `book_book_authors` VALUES (40, 15, 5);
INSERT INTO `book_book_authors` VALUES (41, 15, 6);
INSERT INTO `book_book_authors` VALUES (42, 16, 1);
INSERT INTO `book_book_authors` VALUES (43, 16, 2);
INSERT INTO `book_book_authors` VALUES (44, 16, 3);
INSERT INTO `book_book_authors` VALUES (45, 16, 4);
INSERT INTO `book_book_authors` VALUES (46, 16, 5);
INSERT INTO `book_book_authors` VALUES (47, 16, 6);
INSERT INTO `book_book_authors` VALUES (48, 17, 1);
INSERT INTO `book_book_authors` VALUES (49, 17, 2);
INSERT INTO `book_book_authors` VALUES (50, 17, 3);
INSERT INTO `book_book_authors` VALUES (51, 17, 4);
INSERT INTO `book_book_authors` VALUES (52, 17, 5);
INSERT INTO `book_book_authors` VALUES (53, 17, 6);
INSERT INTO `book_book_authors` VALUES (54, 18, 1);
INSERT INTO `book_book_authors` VALUES (55, 18, 2);
INSERT INTO `book_book_authors` VALUES (56, 18, 3);
INSERT INTO `book_book_authors` VALUES (57, 18, 4);
INSERT INTO `book_book_authors` VALUES (58, 18, 5);
INSERT INTO `book_book_authors` VALUES (59, 18, 6);
INSERT INTO `book_book_authors` VALUES (60, 19, 1);
INSERT INTO `book_book_authors` VALUES (61, 19, 2);
INSERT INTO `book_book_authors` VALUES (62, 19, 3);
INSERT INTO `book_book_authors` VALUES (63, 19, 4);
INSERT INTO `book_book_authors` VALUES (64, 19, 5);
INSERT INTO `book_book_authors` VALUES (65, 19, 6);
INSERT INTO `book_book_authors` VALUES (66, 20, 1);
INSERT INTO `book_book_authors` VALUES (67, 20, 2);
INSERT INTO `book_book_authors` VALUES (68, 20, 3);
INSERT INTO `book_book_authors` VALUES (69, 20, 4);
INSERT INTO `book_book_authors` VALUES (70, 20, 5);
INSERT INTO `book_book_authors` VALUES (71, 20, 6);
INSERT INTO `book_book_authors` VALUES (74, 21, 2);
INSERT INTO `book_book_authors` VALUES (75, 21, 3);
INSERT INTO `book_book_authors` VALUES (76, 22, 2);
INSERT INTO `book_book_authors` VALUES (77, 22, 3);
INSERT INTO `book_book_authors` VALUES (78, 23, 2);
INSERT INTO `book_book_authors` VALUES (79, 23, 3);
INSERT INTO `book_book_authors` VALUES (80, 24, 2);
INSERT INTO `book_book_authors` VALUES (81, 24, 3);
INSERT INTO `book_book_authors` VALUES (82, 25, 1);
INSERT INTO `book_book_authors` VALUES (83, 25, 2);
INSERT INTO `book_book_authors` VALUES (84, 26, 1);
INSERT INTO `book_book_authors` VALUES (85, 26, 2);
INSERT INTO `book_book_authors` VALUES (86, 27, 1);
INSERT INTO `book_book_authors` VALUES (87, 27, 2);
INSERT INTO `book_book_authors` VALUES (88, 28, 1);
INSERT INTO `book_book_authors` VALUES (89, 28, 2);

-- ----------------------------
-- Table structure for book_publish
-- ----------------------------
DROP TABLE IF EXISTS `book_publish`;
CREATE TABLE `book_publish`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_publish
-- ----------------------------
INSERT INTO `book_publish` VALUES (1, '北京出版社', 'bj@qq.com');
INSERT INTO `book_publish` VALUES (2, '南京出版社', 'nj@qq.com');
INSERT INTO `book_publish` VALUES (3, '上海出版社', 'sh@qq.com');
INSERT INTO `book_publish` VALUES (4, '北京出版社', 'bj@qq.com');
INSERT INTO `book_publish` VALUES (5, '北京出版社', 'bj@qq.com');
INSERT INTO `book_publish` VALUES (6, '北京出版社', 'bj@qq.com');

-- ----------------------------
-- Table structure for django_admin_log
-- ----------------------------
DROP TABLE IF EXISTS `django_admin_log`;
CREATE TABLE `django_admin_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action_time` datetime(6) NOT NULL,
  `object_id` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `object_repr` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `action_flag` smallint(5) UNSIGNED NOT NULL,
  `change_message` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content_type_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `django_admin_log_content_type_id_c4bce8eb_fk_django_co`(`content_type_id`) USING BTREE,
  INDEX `django_admin_log_user_id_c564eba6_fk_auth_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `django_admin_log_content_type_id_c4bce8eb_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `django_admin_log_user_id_c564eba6_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for django_content_type
-- ----------------------------
DROP TABLE IF EXISTS `django_content_type`;
CREATE TABLE `django_content_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `model` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `django_content_type_app_label_model_76bd3d3b_uniq`(`app_label`, `model`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of django_content_type
-- ----------------------------
INSERT INTO `django_content_type` VALUES (1, 'admin', 'logentry');
INSERT INTO `django_content_type` VALUES (3, 'auth', 'group');
INSERT INTO `django_content_type` VALUES (2, 'auth', 'permission');
INSERT INTO `django_content_type` VALUES (4, 'auth', 'user');
INSERT INTO `django_content_type` VALUES (7, 'book', 'author');
INSERT INTO `django_content_type` VALUES (9, 'book', 'book');
INSERT INTO `django_content_type` VALUES (8, 'book', 'publish');
INSERT INTO `django_content_type` VALUES (5, 'contenttypes', 'contenttype');
INSERT INTO `django_content_type` VALUES (6, 'sessions', 'session');

-- ----------------------------
-- Table structure for django_migrations
-- ----------------------------
DROP TABLE IF EXISTS `django_migrations`;
CREATE TABLE `django_migrations`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `app` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `applied` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of django_migrations
-- ----------------------------
INSERT INTO `django_migrations` VALUES (1, 'contenttypes', '0001_initial', '2024-02-06 05:23:48.949140');
INSERT INTO `django_migrations` VALUES (2, 'auth', '0001_initial', '2024-02-06 05:23:49.674999');
INSERT INTO `django_migrations` VALUES (3, 'admin', '0001_initial', '2024-02-06 05:23:49.897168');
INSERT INTO `django_migrations` VALUES (4, 'admin', '0002_logentry_remove_auto_add', '2024-02-06 05:23:49.905166');
INSERT INTO `django_migrations` VALUES (5, 'admin', '0003_logentry_add_action_flag_choices', '2024-02-06 05:23:49.913163');
INSERT INTO `django_migrations` VALUES (6, 'contenttypes', '0002_remove_content_type_name', '2024-02-06 05:23:50.058116');
INSERT INTO `django_migrations` VALUES (7, 'auth', '0002_alter_permission_name_max_length', '2024-02-06 05:23:50.142110');
INSERT INTO `django_migrations` VALUES (8, 'auth', '0003_alter_user_email_max_length', '2024-02-06 05:23:50.272089');
INSERT INTO `django_migrations` VALUES (9, 'auth', '0004_alter_user_username_opts', '2024-02-06 05:23:50.281086');
INSERT INTO `django_migrations` VALUES (10, 'auth', '0005_alter_user_last_login_null', '2024-02-06 05:23:50.346088');
INSERT INTO `django_migrations` VALUES (11, 'auth', '0006_require_contenttypes_0002', '2024-02-06 05:23:50.349087');
INSERT INTO `django_migrations` VALUES (12, 'auth', '0007_alter_validators_add_error_messages', '2024-02-06 05:23:50.357098');
INSERT INTO `django_migrations` VALUES (13, 'auth', '0008_alter_user_username_max_length', '2024-02-06 05:23:50.435091');
INSERT INTO `django_migrations` VALUES (14, 'auth', '0009_alter_user_last_name_max_length', '2024-02-06 05:23:50.513072');
INSERT INTO `django_migrations` VALUES (15, 'auth', '0010_alter_group_name_max_length', '2024-02-06 05:23:50.587048');
INSERT INTO `django_migrations` VALUES (16, 'auth', '0011_update_proxy_permissions', '2024-02-06 05:23:50.597076');
INSERT INTO `django_migrations` VALUES (17, 'auth', '0012_alter_user_first_name_max_length', '2024-02-06 05:23:50.666046');
INSERT INTO `django_migrations` VALUES (18, 'book', '0001_initial', '2024-02-06 05:23:50.973120');
INSERT INTO `django_migrations` VALUES (19, 'sessions', '0001_initial', '2024-02-06 05:23:51.020103');

-- ----------------------------
-- Table structure for django_session
-- ----------------------------
DROP TABLE IF EXISTS `django_session`;
CREATE TABLE `django_session`  (
  `session_key` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `session_data` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `expire_date` datetime(6) NOT NULL,
  PRIMARY KEY (`session_key`) USING BTREE,
  INDEX `django_session_expire_date_a5c62663`(`expire_date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
