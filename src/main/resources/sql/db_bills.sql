/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : db_bills

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 21/12/2019 22:06:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bills
-- ----------------------------
DROP TABLE IF EXISTS `bills`;
CREATE TABLE `bills`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '账单id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账单标题',
  `billtime` datetime(0) NULL DEFAULT NULL COMMENT '记账时间',
  `typeid` int(11) NULL DEFAULT NULL COMMENT '账单类别',
  `price` double(65, 2) NULL DEFAULT NULL COMMENT '账单金额',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账单说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bills
-- ----------------------------
INSERT INTO `bills` VALUES (1, '小明借我的钱去喝酒', '2019-08-09 11:29:29', 3, 200.00, '111');
INSERT INTO `bills` VALUES (2, '21231', '2019-08-09 04:25:21', 4, 22.00, '22');
INSERT INTO `bills` VALUES (3, '222', '2019-09-03 16:00:00', 1, 222.00, '222');
INSERT INTO `bills` VALUES (4, '11', '2019-12-21 21:20:27', 1, 11.00, '11');
INSERT INTO `bills` VALUES (5, '11', '2019-12-21 21:20:42', 1, 11.00, '11');
INSERT INTO `bills` VALUES (6, '22', '2019-12-21 21:21:40', 1, 22.00, '22');
INSERT INTO `bills` VALUES (7, '222', '2019-12-21 21:21:45', 1, 22.00, '22');
INSERT INTO `bills` VALUES (8, '22', '2019-12-21 21:21:49', 1, 22.00, '22');
INSERT INTO `bills` VALUES (9, '22', '2019-12-21 21:21:53', 1, 22.00, '22');
INSERT INTO `bills` VALUES (10, '22', '2019-12-21 21:21:57', 1, 22.00, '22');
INSERT INTO `bills` VALUES (11, '22', '2019-12-21 21:22:01', 1, 22.00, '22');
INSERT INTO `bills` VALUES (12, '22', '2019-12-21 21:22:06', 1, 22.00, '222');

-- ----------------------------
-- Table structure for billtype
-- ----------------------------
DROP TABLE IF EXISTS `billtype`;
CREATE TABLE `billtype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of billtype
-- ----------------------------
INSERT INTO `billtype` VALUES (1, '支出');
INSERT INTO `billtype` VALUES (2, '收入');
INSERT INTO `billtype` VALUES (3, '借出');
INSERT INTO `billtype` VALUES (4, '借入');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `loginname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆名称',
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '小明', '1', '1', '男');
INSERT INTO `user` VALUES (2, '管理员', 'admin', '1', '女');

SET FOREIGN_KEY_CHECKS = 1;
