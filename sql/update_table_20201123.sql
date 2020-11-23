/*
 Navicat Premium Data Transfer

 Date: 23/11/2020 15:03:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yn_items
-- ----------------------------
DROP TABLE IF EXISTS `yn_items`;
CREATE TABLE `yn_items`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `item_classfy_id` tinyint(0) NULL DEFAULT NULL COMMENT '项目分类id',
  `item_classfy_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目分类名称',
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目名称',
  `item_explain` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目简介',
  `item_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目图标地址',
  `item_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目地址',
  `item_introduce_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目文档地址',
  `has_document` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否存在说明文档：0-不存在，1-存在',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yn_items_details
-- ----------------------------
DROP TABLE IF EXISTS `yn_items_details`;
CREATE TABLE `yn_items_details`  (
  `id` bigint(0) NOT NULL COMMENT '主键id',
  `items_id` bigint(0) NOT NULL COMMENT '项目id',
  `items_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '项目标签主题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容',
  `txt_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容',
  `order_num` tinyint(0) NULL DEFAULT NULL COMMENT '同级排序',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_delete` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除：0-不删除，1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '项目文档表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
