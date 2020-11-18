/*
 Navicat Premium Data Transfer

 Source Server         : My-JD-mysql
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 114.67.107.180:3306
 Source Schema         : yn-blog

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 18/11/2020 14:29:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章标题',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章描述',
  `text_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容md格式',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容(带有样式）',
  `main_picture` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章头图片',
  `author` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '作者',
  `series_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '系列code',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章类型：1-转载，2-原创',
  `year` int(0) NULL DEFAULT NULL COMMENT '年份',
  `month` int(0) NULL DEFAULT NULL COMMENT '月份',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否删除：0-删除，1-未删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_title`(`title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '博客文章主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yn_blog_classify
-- ----------------------------
DROP TABLE IF EXISTS `yn_blog_classify`;
CREATE TABLE `yn_blog_classify`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `classify_id` bigint(0) NOT NULL COMMENT '分类id',
  `blog_id` bigint(0) NOT NULL COMMENT '文章博客id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '博客与分类关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yn_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `yn_blog_tag`;
CREATE TABLE `yn_blog_tag`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tag_id` bigint(0) NOT NULL COMMENT '分类id',
  `blog_id` bigint(0) NOT NULL COMMENT '文章博客id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '博客与标签关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yn_classify
-- ----------------------------
DROP TABLE IF EXISTS `yn_classify`;
CREATE TABLE `yn_classify`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `classify_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类名称',
  `classify_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yn_document
-- ----------------------------
DROP TABLE IF EXISTS `yn_document`;
CREATE TABLE `yn_document`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文档名称',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '封面',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文档主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yn_document_details
-- ----------------------------
DROP TABLE IF EXISTS `yn_document_details`;
CREATE TABLE `yn_document_details`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `doc_id` bigint(0) NULL DEFAULT NULL COMMENT '文档id',
  `subhead` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '副标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容',
  `txt_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容',
  `level` tinyint(0) NOT NULL COMMENT '层级',
  `parent_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '父级id',
  `is_data` tinyint(0) NULL DEFAULT 1 COMMENT '是否存在数据：0-不存在，1-存在',
  `order_num` tinyint(0) NULL DEFAULT NULL COMMENT '同级排序',
  `is_delete` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除：0-不删除，1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文档明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yn_items
-- ----------------------------
DROP TABLE IF EXISTS `yn_items`;
CREATE TABLE `yn_items`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `item_classfy_id` tinyint(0) NULL DEFAULT NULL COMMENT '项目分类id',
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目名称',
  `item_explain` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目简介',
  `item_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目图标地址',
  `item_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目地址',
  `item_introduce_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目文档地址',
  `item_classfy_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yn_links
-- ----------------------------
DROP TABLE IF EXISTS `yn_links`;
CREATE TABLE `yn_links`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `link_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '链接资源名称',
  `link_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '链接资源地址',
  `link_descption` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '链接资源介绍',
  `is_delelte` tinyint(0) NULL DEFAULT 0 COMMENT '是否删除：0-不删除，1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '友情链接表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yn_main_projects
-- ----------------------------
DROP TABLE IF EXISTS `yn_main_projects`;
CREATE TABLE `yn_main_projects`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `head_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题图',
  `simple_explain` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '首页展示主要涉及方面表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yn_mian
-- ----------------------------
DROP TABLE IF EXISTS `yn_mian`;
CREATE TABLE `yn_mian`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `main_title` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主页介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '首页总体介绍表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yn_read_totall
-- ----------------------------
DROP TABLE IF EXISTS `yn_read_totall`;
CREATE TABLE `yn_read_totall`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `blog_id` bigint(0) NOT NULL COMMENT '文章id',
  `read_nums` bigint(0) NOT NULL DEFAULT 0 COMMENT '阅读次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '统计文章访问量表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yn_series
-- ----------------------------
DROP TABLE IF EXISTS `yn_series`;
CREATE TABLE `yn_series`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `serics_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '系列名称',
  `serics_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '系列编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for yn_tag
-- ----------------------------
DROP TABLE IF EXISTS `yn_tag`;
CREATE TABLE `yn_tag`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tag_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签名称',
  `tag_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标签编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '标签表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
