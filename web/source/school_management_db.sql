/*
 Navicat Premium Data Transfer

 Source Server         : J2EE_Connection
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : school_management_db

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 15/12/2020 21:22:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reason` varchar(255) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `stu_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
BEGIN;
INSERT INTO `bill` VALUES (19, '111', 111, 'reject', 1);
INSERT INTO `bill` VALUES (20, '222', 222, 'agree', 2);
INSERT INTO `bill` VALUES (22, '111', 111, 'agree', 1);
INSERT INTO `bill` VALUES (23, '1111', 1111, 'reject', 1);
INSERT INTO `bill` VALUES (24, '11111', 11111, 'agree', 1);
COMMIT;

-- ----------------------------
-- Table structure for holiday
-- ----------------------------
DROP TABLE IF EXISTS `holiday`;
CREATE TABLE `holiday` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `stu_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of holiday
-- ----------------------------
BEGIN;
INSERT INTO `holiday` VALUES (1, 'practice', '2020-12-09 00:00:00', '2020-12-23 00:00:00', 'reject', 1);
INSERT INTO `holiday` VALUES (2, 'practice', '2020-12-16 00:00:00', '2020-12-30 00:00:00', 'over', 114514);
INSERT INTO `holiday` VALUES (9, 'practice', '2020-12-09 00:00:00', '2020-12-23 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (10, 'practice', '2020-12-01 00:00:00', '2020-12-24 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (11, 'practice', '2020-12-01 00:00:00', '2020-12-30 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (12, 'practice', '2020-12-29 00:00:00', '2020-12-31 00:00:00', 'over', 4);
INSERT INTO `holiday` VALUES (13, 'practice', '2020-12-14 00:00:00', '2020-12-23 00:00:00', 'over', 4);
INSERT INTO `holiday` VALUES (14, 'practice', '2020-12-09 00:00:00', '2020-12-23 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (15, 'holiday', '2020-12-09 00:00:00', '2020-12-31 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (16, 'practice', '2020-12-02 00:00:00', '2020-12-23 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (17, 'practice', '2020-11-30 00:00:00', '2020-12-30 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (18, 'practice', '2020-12-09 00:00:00', '2020-12-17 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (19, 'practice', '2020-12-02 00:00:00', '2020-12-18 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (20, 'practice', '2020-12-01 00:00:00', '2020-12-16 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (21, 'temp', '2020-12-01 00:00:00', '2020-12-17 00:00:00', 'over', 4);
INSERT INTO `holiday` VALUES (22, 'practice', '2020-12-02 00:00:00', '2020-12-17 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (23, 'temp', '2020-12-03 00:00:00', '2020-12-24 00:00:00', 'over', 4);
INSERT INTO `holiday` VALUES (24, 'practice', '2020-12-01 00:00:00', '2020-12-23 00:00:00', 'over', 4);
INSERT INTO `holiday` VALUES (25, 'practice', '2020-12-16 00:00:00', '2020-12-31 00:00:00', 'over', 4);
INSERT INTO `holiday` VALUES (26, 'practice', '2020-12-02 00:00:00', '2020-12-24 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (27, 'practice', '2020-12-02 00:00:00', '2020-12-24 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (28, 'practice', '2020-11-01 00:00:00', '2020-11-03 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (29, 'practice', '2021-01-01 00:00:00', '2021-01-28 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (30, 'practice', '2021-01-28 00:00:00', '2021-01-31 00:00:00', 'reject', 1);
INSERT INTO `holiday` VALUES (31, 'practice', '2020-09-02 00:00:00', '2020-09-30 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (32, 'holiday', '2020-12-01 00:00:00', '2020-12-03 00:00:00', 'reject', 4);
INSERT INTO `holiday` VALUES (33, 'family', '2020-11-13 00:00:00', '2020-11-26 00:00:00', 'over', 3);
INSERT INTO `holiday` VALUES (34, 'practice', '2020-12-01 00:00:00', '2020-12-24 00:00:00', 'reject', 1);
INSERT INTO `holiday` VALUES (35, 'practice', '2021-01-09 00:00:00', '2021-02-26 00:00:00', 'over', 3);
INSERT INTO `holiday` VALUES (36, 'family', '2020-10-09 00:00:00', '2020-10-29 00:00:00', 'over', 2);
INSERT INTO `holiday` VALUES (37, 'temp', '2020-08-01 00:00:00', '2020-08-13 00:00:00', 'reject', 4);
INSERT INTO `holiday` VALUES (38, 'practice', '2020-11-04 00:00:00', '2020-11-13 00:00:00', 'over', 1);
INSERT INTO `holiday` VALUES (39, 'practice', '2020-12-09 00:00:00', '2020-12-17 00:00:00', 'over', 1);
COMMIT;

-- ----------------------------
-- Table structure for sta
-- ----------------------------
DROP TABLE IF EXISTS `sta`;
CREATE TABLE `sta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1717811 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sta
-- ----------------------------
BEGIN;
INSERT INTO `sta` VALUES (1, 'test_teacher', '1');
INSERT INTO `sta` VALUES (1234, '124', '123');
INSERT INTO `sta` VALUES (114514, 'sta1', '1234');
INSERT INTO `sta` VALUES (123123, 'aad', '1231');
INSERT INTO `sta` VALUES (1717810, 'sta2', '1234');
COMMIT;

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19180321 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu
-- ----------------------------
BEGIN;
INSERT INTO `stu` VALUES (1, 'test', '1');
INSERT INTO `stu` VALUES (2, 'test2', '2');
INSERT INTO `stu` VALUES (3, 'stu3', '3');
INSERT INTO `stu` VALUES (4, 'stu4', '4');
INSERT INTO `stu` VALUES (6, 'stu6', '6');
INSERT INTO `stu` VALUES (7, 'stu7', '7');
INSERT INTO `stu` VALUES (12, 'zhangjia_good@126.com', '123');
INSERT INTO `stu` VALUES (123, 'FARO_Z', '123');
INSERT INTO `stu` VALUES (1234, '12sq', '123');
INSERT INTO `stu` VALUES (12345, 'wqwd', 'asd');
INSERT INTO `stu` VALUES (114514, 'kkk', '123');
INSERT INTO `stu` VALUES (1890231, 'dddd', '1233');
INSERT INTO `stu` VALUES (19180319, '张健', '19180319');
INSERT INTO `stu` VALUES (19180320, 'JOJO', '19180320');
COMMIT;

-- ----------------------------
-- Table structure for stu_sta
-- ----------------------------
DROP TABLE IF EXISTS `stu_sta`;
CREATE TABLE `stu_sta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stu_id` int DEFAULT NULL,
  `sta_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of stu_sta
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for stu_sta_bill
-- ----------------------------
DROP TABLE IF EXISTS `stu_sta_bill`;
CREATE TABLE `stu_sta_bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stu_id` int DEFAULT NULL,
  `sta_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of stu_sta_bill
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
