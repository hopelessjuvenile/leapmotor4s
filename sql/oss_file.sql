/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027 (8.0.27)
 Source Host           : localhost:3306
 Source Schema         : lm-4s

 Target Server Type    : MySQL
 Target Server Version : 80027 (8.0.27)
 File Encoding         : 65001

 Date: 28/12/2023 13:04:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oss_file
-- ----------------------------
DROP TABLE IF EXISTS `oss_file`;
CREATE TABLE `oss_file`  (
  `file_id` bigint NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件路径',
  `domain` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '域名地址',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `original_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '原始文件名',
  `hash` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件hash值',
  `size` double NULL DEFAULT NULL COMMENT '文件大小',
  `put_time` datetime NULL DEFAULT NULL COMMENT '文件上传时间',
  `content_Type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `direction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '汽车方位',
  `license_plate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '车牌号',
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1739174359353458690 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oss_file
-- ----------------------------
INSERT INTO `oss_file` VALUES (1739122696945012737, '/carimage/20231225/2023-12-25-12-48-12_upper_left.png_1703486454137.png', 'www.baidu.com', 'minio.jpeg', 'minio.jepg', '222', 2, '2023-12-28 01:24:27', 'jepg', 'upleft', '粤ABC123');
INSERT INTO `oss_file` VALUES (1739164588013420546, '/carimage/20231225/2023-12-25-12-48-12_upper_left.png_1703486454137.png', 'www.baidu.com', 'minio.jpeg', 'minio.jepg', '222', 2, '2023-12-28 01:24:25', 'jepg', 'upleft', '粤ABC133');
INSERT INTO `oss_file` VALUES (1739165822963318785, '/carimage/20231225/2023-12-25-12-48-12_upper_left.png_1703486454137.png', 'www.baidu.com', 'minio.jpeg', 'minio.jepg', '222', 2, '2023-12-28 01:24:24', 'jepg', 'upleft', '粤ABC133');
INSERT INTO `oss_file` VALUES (1739174359353458689, '/carimage/20231225/2023-12-25-12-48-12_upper_left.png_1703486454137.png', 'http://172.22.33.209:9000/carimage', '/carimage/20231225/2023-12-25-12-48-12_upper_left.png_1703486454137.png', '2023-12-25-12-48-12_upper_left.png', '1843149746', 277813, '2023-12-25 15:17:22', 'png', '左上角', '粤ABC133');

SET FOREIGN_KEY_CHECKS = 1;
