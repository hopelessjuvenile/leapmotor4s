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

 Date: 28/12/2023 13:05:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_car
-- ----------------------------
DROP TABLE IF EXISTS `sys_car`;
CREATE TABLE `sys_car`  (
  `service_id` bigint NOT NULL AUTO_INCREMENT COMMENT '业务关联id',
  `license_plate` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '车牌号',
  `order_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '保养单号',
  `agent_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经办人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '保养日期',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`service_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1724033765497045000 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_car
-- ----------------------------
INSERT INTO `sys_car` VALUES (1, '粤ABCDE', '123456', '张三', '2023-11-13 23:44:59', NULL);
INSERT INTO `sys_car` VALUES (1724033765497044995, '粤ABC133', '234567', '李四', '2023-11-13 19:58:35', NULL);
INSERT INTO `sys_car` VALUES (1724033765497044996, '粤ABC134', '234567', '李四', '2023-12-25 15:39:59', NULL);
INSERT INTO `sys_car` VALUES (1724033765497044997, '粤ABC135', '234567', '李四', '2023-12-25 15:41:01', NULL);
INSERT INTO `sys_car` VALUES (1724033765497044998, '粤ABC123', '123456（保养号）', '王五（经办人）', '2023-12-26 15:05:28', '备注信息');
INSERT INTO `sys_car` VALUES (1724033765497044999, '粤ABC233', '234567', '李四', '2023-12-28 12:00:49', 'null');

SET FOREIGN_KEY_CHECKS = 1;
