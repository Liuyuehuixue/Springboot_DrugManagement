/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : gem

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 11/03/2020 14:38:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_medicine
-- ----------------------------
DROP TABLE IF EXISTS `tbl_medicine`;
CREATE TABLE `tbl_medicine`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `fordisease` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `factory` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `deleted` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_medicine
-- ----------------------------
INSERT INTO `tbl_medicine` VALUES (1, '青霉胺', '清除体内铜，解毒', '重金属中毒', 'shanghai', 0);
INSERT INTO `tbl_medicine` VALUES (2, '罗红霉素', '抗菌', '鼻窦炎，中耳炎', 'wuhan', 0);
INSERT INTO `tbl_medicine` VALUES (3, '恩替卡韦', '抗乙肝', '乙肝', 'beijing', 0);
INSERT INTO `tbl_medicine` VALUES (4, '利福平', '抗菌', '沙眼，结膜炎', 'zhejiang', 0);
INSERT INTO `tbl_medicine` VALUES (5, '氨茶碱', '止喘', '哮喘', 'changsha', 0);
INSERT INTO `tbl_medicine` VALUES (8, 'aa', 'aa', 'aa', 'aa', 1);

SET FOREIGN_KEY_CHECKS = 1;
