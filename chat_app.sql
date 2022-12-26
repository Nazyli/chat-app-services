/*
 Navicat Premium Data Transfer

 Source Server         : Local MYSQL DB
 Source Server Type    : MySQL
 Source Server Version : 100418
 Source Host           : 127.0.0.1:3306
 Source Schema         : chat_app

 Target Server Type    : MySQL
 Target Server Version : 100418
 File Encoding         : 65001

 Date: 14/12/2022 20:32:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat_message
-- ----------------------------
DROP TABLE IF EXISTS `chat_message`;
CREATE TABLE `chat_message` (
  `id` varchar(255) NOT NULL,
  `chat_id` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `recipient_id` varchar(255) DEFAULT NULL,
  `sender_id` varchar(255) DEFAULT NULL,
  `status` enum('RECEIVED','DELIVERED') DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of chat_message
-- ----------------------------
BEGIN;
INSERT INTO `chat_message` VALUES ('02b5faa5-70e6-4929-a50c-5d29b71f9968', 'db4dd08b-4002-4bee-8124-55db53e6250b_ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'lagi apa', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED', '2022-04-15 02:36:51.000000');
INSERT INTO `chat_message` VALUES ('21a4ac8d-7fe2-4512-9cc7-5557946a10c1', 'db4dd08b-4002-4bee-8124-55db53e6250b_ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'lembur', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'DELIVERED', '2022-04-15 02:36:57.000000');
INSERT INTO `chat_message` VALUES ('24eb5e96-746d-4a1b-aed3-8c5d00691f38', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'yoii', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED', '2022-04-15 04:23:01.000000');
INSERT INTO `chat_message` VALUES ('34c1e6c1-1095-46c7-a9f4-ebdb1c9ead1e', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'testtt', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED', '2022-04-15 04:16:09.000000');
INSERT INTO `chat_message` VALUES ('3bd92c0f-1bf5-4db1-be84-11712c06ad1f', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'nah kan', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED', '2022-04-15 14:22:59.000000');
INSERT INTO `chat_message` VALUES ('4f855001-1830-4a2f-adcc-dbd8ae0f2706', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'terus ngapain lagi', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED', '2022-04-14 19:52:20.000000');
INSERT INTO `chat_message` VALUES ('56a9d3b5-9c02-4fa7-b46a-56151f72e711', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'Hhhhhh', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED', '2022-04-15 04:23:13.000000');
INSERT INTO `chat_message` VALUES ('623d313c-42d8-4557-aa2b-881c6235a387', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'Hehe', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED', '2022-04-15 14:23:38.000000');
INSERT INTO `chat_message` VALUES ('6aa0a2b0-6854-4efd-bbbe-e2af5783bf09', 'db4dd08b-4002-4bee-8124-55db53e6250b_ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'iya', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'DELIVERED', '2022-04-15 02:36:32.000000');
INSERT INTO `chat_message` VALUES ('7509b54b-107e-458a-b552-e6c1dd05d08d', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'berhasil', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED', '2022-04-15 14:05:39.000000');
INSERT INTO `chat_message` VALUES ('764e307b-3634-46d5-97b1-59ff22e04533', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'makan ini', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED', '2022-04-14 19:51:56.000000');
INSERT INTO `chat_message` VALUES ('7bb10dba-9905-4c69-9e12-018d76934812', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'iya dek', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED', '2022-04-14 19:51:18.000000');
INSERT INTO `chat_message` VALUES ('843483a3-4738-4846-9bc6-aa1c4a489af7', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'test', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED', '2022-04-14 19:31:21.000000');
INSERT INTO `chat_message` VALUES ('92b3de20-880e-4ca8-bc66-81c59b1925aa', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'halo', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED', '2022-04-15 14:05:33.000000');
INSERT INTO `chat_message` VALUES ('976a86cb-3b33-4b82-8b48-77900a80940d', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'lagi apa', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED', '2022-04-14 19:51:40.000000');
INSERT INTO `chat_message` VALUES ('a929f8da-fcdd-405a-8e0b-1d7a79509230', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'mas', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED', '2022-04-14 19:38:59.000000');
INSERT INTO `chat_message` VALUES ('b072bf5c-cd11-44cb-bf7f-6725a48291dc', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'Hhkh', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED', '2022-04-15 04:20:18.000000');
INSERT INTO `chat_message` VALUES ('b29589de-6dd8-4676-a2f5-8d29497cc388', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'Test', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED', '2022-04-15 04:20:12.000000');
INSERT INTO `chat_message` VALUES ('b44e4214-8552-4438-8ca6-cb94a25a4ebd', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'Hehe', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED', '2022-04-15 04:16:18.000000');
INSERT INTO `chat_message` VALUES ('b8c9c97a-d1a0-45b1-acb4-9bed215c63cb', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'Hei', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED', '2022-04-15 04:16:54.000000');
INSERT INTO `chat_message` VALUES ('c1e1ecd4-dded-4859-8091-921affc47fe3', 'db4dd08b-4002-4bee-8124-55db53e6250b_ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'ciptanto', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED', '2022-04-15 02:36:15.000000');
INSERT INTO `chat_message` VALUES ('c65c5d0d-2ccb-4d67-bd12-de20cb687eab', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'yeee', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED', '2022-04-15 14:22:51.000000');
INSERT INTO `chat_message` VALUES ('d0cd9446-79f3-431f-9c08-8974776b832e', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'ya gak tau', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED', '2022-04-14 19:52:26.000000');
INSERT INTO `chat_message` VALUES ('d4383da2-3dc1-4c16-8d75-12fab06901c3', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'Mantapp', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED', '2022-04-15 04:22:50.000000');
INSERT INTO `chat_message` VALUES ('f83d131b-1673-4242-9645-2e1bc5e738d4', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'Tet', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED', '2022-04-15 04:20:15.000000');
COMMIT;

-- ----------------------------
-- Table structure for chat_room
-- ----------------------------
DROP TABLE IF EXISTS `chat_room`;
CREATE TABLE `chat_room` (
  `chat_room_id` varchar(255) NOT NULL,
  `chat_id` varchar(255) DEFAULT NULL,
  `recipient_id` varchar(255) DEFAULT NULL,
  `sender_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`chat_room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of chat_room
-- ----------------------------
BEGIN;
INSERT INTO `chat_room` VALUES ('131b7afe-bc84-47f3-bc2f-df1444800c5a', 'db4dd08b-4002-4bee-8124-55db53e6250b_ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'db4dd08b-4002-4bee-8124-55db53e6250b');
INSERT INTO `chat_room` VALUES ('2', 'hao0000', 'hal', 'hai');
INSERT INTO `chat_room` VALUES ('2d13ea02-07a9-4693-9b03-83c31b468dda', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2');
INSERT INTO `chat_room` VALUES ('4de8752c-a854-4313-b2d1-5800e332bc7a', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2');
INSERT INTO `chat_room` VALUES ('a6b230ef-5b85-474b-9ae0-da8550279c45', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2');
INSERT INTO `chat_room` VALUES ('f0abeb7e-6086-4cf7-90a6-fdcec64fc413', 'db4dd08b-4002-4bee-8124-55db53e6250b_ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2');
INSERT INTO `chat_room` VALUES ('f853510c-1875-47fd-b5b7-bf3ace86a683', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2_db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b');
COMMIT;

-- ----------------------------
-- Table structure for master_chat_room
-- ----------------------------
DROP TABLE IF EXISTS `master_chat_room`;
CREATE TABLE `master_chat_room` (
  `room_id` varchar(255) NOT NULL,
  `chat_room_id` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `recipient_id` varchar(255) DEFAULT NULL,
  `sender_id` varchar(255) DEFAULT NULL,
  `modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of master_chat_room
-- ----------------------------
BEGIN;
INSERT INTO `master_chat_room` VALUES ('19281ae2-5b92-4f40-82b8-ed41dcac4c19', '60c8631b-d1d8-447f-b3d1-348554cfab61_1650016910469', '2022-04-15 17:01:50.000000', b'0', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', NULL);
INSERT INTO `master_chat_room` VALUES ('5e308c71-73fa-45c4-b99c-b4ba5ca991ba', '60c8631b-d1d8-447f-b3d1-348554cfab61_1650016910469', '2022-04-15 17:01:50.000000', b'0', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'db4dd08b-4002-4bee-8124-55db53e6250b', NULL);
INSERT INTO `master_chat_room` VALUES ('80cd4f79-91c7-4b11-b812-e1978f1cb23f', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', '2022-04-15 15:03:07.000000', b'0', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', NULL);
INSERT INTO `master_chat_room` VALUES ('903f0a0b-1bbc-48db-a005-0d49f090f4f1', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', '2022-04-15 15:03:07.000000', b'0', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', NULL);
COMMIT;

-- ----------------------------
-- Table structure for master_user
-- ----------------------------
DROP TABLE IF EXISTS `master_user`;
CREATE TABLE `master_user` (
  `user_id` varchar(255) NOT NULL,
  `active` bit(1) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `picture_url` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of master_user
-- ----------------------------
BEGIN;
INSERT INTO `master_user` VALUES ('cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', b'1', '2022-04-12 19:38:29', 'nazyli@gmail.com', NULL, '$2a$10$VKUOSpUOLh9o30ON4md.meuwC4sYhUWmFC.mdyqizm1gyp0D0MnZm', 'https://chatscope.io/storybook/react/static/media/patrik.d89db575.svg', 'USER', 'Nazyli');
INSERT INTO `master_user` VALUES ('db4dd08b-4002-4bee-8124-55db53e6250b', b'1', '2022-04-12 19:37:36', 'evry@gmail.con', NULL, '$2a$10$ZxWvBNsuDITtTVhI8/fcT.wHGx91u4Rms4QrrJV1Vz1qCIiexYeba', 'https://chatscope.io/storybook/react/static/media/joe.641da105.svg', 'USER', 'Evry');
INSERT INTO `master_user` VALUES ('ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', b'1', '2022-04-12 19:39:06', 'ciptanto@gmail.com', NULL, '$2a$10$rWVwglIPXhPVSc2yyxstnu9KvXzclZK8BunQRs8H.IzaKjQSywXfi', 'https://chatscope.io/storybook/react/static/media/zoe.e31a4ff8.svg', 'USER', 'Ciptanto');
COMMIT;

-- ----------------------------
-- Table structure for trans_chat_message
-- ----------------------------
DROP TABLE IF EXISTS `trans_chat_message`;
CREATE TABLE `trans_chat_message` (
  `trans_message_id` varchar(255) NOT NULL,
  `chat_room_id` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `recipient_id` varchar(255) DEFAULT NULL,
  `sender_id` varchar(255) DEFAULT NULL,
  `status` enum('RECEIVED','DELIVERED') DEFAULT NULL,
  PRIMARY KEY (`trans_message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of trans_chat_message
-- ----------------------------
BEGIN;
INSERT INTO `trans_chat_message` VALUES ('00ad99e0-aa3a-4bc1-83bc-dec8c8259811', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'N', '2022-04-16 08:19:45.000000', b'0', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('2655a093-d82f-4c91-b1e4-bf4921610162', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'Haloo', '2022-04-15 21:58:36.000000', b'0', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('2c0002aa-9a2b-47eb-89b5-878742436fa6', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'test', '2022-04-16 08:17:19.000000', b'0', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('4b1a7627-8748-4ed3-a0cb-ef115d2d9d5d', '60c8631b-d1d8-447f-b3d1-348554cfab61_1650016910469', 'trrrr', '2022-04-15 18:32:50.000000', b'0', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('5f58a5ad-f510-4e06-9b1d-0beced100eca', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'Testtt', '2022-04-15 21:59:21.000000', b'0', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('61064deb-5631-429e-b4b9-902b7256ead0', '60c8631b-d1d8-447f-b3d1-348554cfab61_1650016910469', 'tess', '2022-04-15 21:56:54.000000', b'0', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'RECEIVED');
INSERT INTO `trans_chat_message` VALUES ('61564b4f-fbc0-4c7f-9dd7-a8048393e26e', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'y', '2022-04-16 08:19:39.000000', b'0', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('6f312fdb-c0bb-4b40-9554-2858189ed455', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'Yeee', '2022-04-15 21:58:33.000000', b'0', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('748d40f4-7783-4afc-8793-42acf7b03ed2', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'Test', '2022-04-16 08:18:39.000000', b'0', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('7e98a3b0-d720-4bbe-80e1-c504542ff9f9', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'h', '2022-04-16 08:19:34.000000', b'0', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('8b4f2039-a145-4478-ae18-cabac3f52041', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'Testt', '2022-04-15 21:58:44.000000', b'0', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('9b856148-61f7-43fe-9846-e62ab0c1ab58', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'yoi', '2022-04-15 21:58:30.000000', b'0', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('a3868bfc-7500-4b75-b5a1-a145f32c02e6', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'Y', '2022-04-16 08:21:30.000000', b'0', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('b59e0ff7-5865-4d11-8462-65d27c32f489', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'Test', '2022-04-15 21:58:22.000000', b'0', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('bd353f35-0e5b-448d-884e-e9ff0bac5198', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'Raga', '2022-04-15 21:59:09.000000', b'0', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('c2a5093a-07e1-433d-b6f7-4c020aab0490', '60c8631b-d1d8-447f-b3d1-348554cfab61_1650016910469', 'yo', '2022-04-16 08:17:58.000000', b'0', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'RECEIVED');
INSERT INTO `trans_chat_message` VALUES ('c576aa07-c527-4570-9428-30def440b974', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'Test', '2022-04-15 21:58:39.000000', b'0', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('eb016ee8-4d90-4839-b9cd-f5b92fd46320', '165a8c57-a942-44c8-bf46-8a66f6005ad8_1650009787115', 'yo', '2022-04-16 08:18:58.000000', b'0', 'cd62ca59-4f55-4ebe-8fc4-f442309d3ed2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED');
INSERT INTO `trans_chat_message` VALUES ('f187c377-3f1b-4243-8128-a19fda31af34', '60c8631b-d1d8-447f-b3d1-348554cfab61_1650016910469', 't', '2022-04-15 18:32:48.000000', b'0', 'ff1b8e35-4dcd-46ce-8ab1-e0774207cfa2', 'db4dd08b-4002-4bee-8124-55db53e6250b', 'DELIVERED');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
