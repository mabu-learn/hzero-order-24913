/*
Navicat MySQL Data Transfer

Source Server         : local-mysql
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : hzero_order

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-07-18 20:31:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hodr_company
-- ----------------------------
DROP TABLE IF EXISTS `hodr_company`;
CREATE TABLE `hodr_company` (
  `company_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '表ID，主键，供其他表做外键',
  `company_number` varchar(60) COLLATE utf8mb4_bin NOT NULL COMMENT '公司编号',
  `company_name` varchar(240) COLLATE utf8mb4_bin NOT NULL COMMENT '公司名称',
  `enabled_flag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '启用标识',
  `object_version_number` bigint(20) NOT NULL DEFAULT '1' COMMENT '版本号',
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(20) NOT NULL DEFAULT '-1',
  `last_updated_by` bigint(20) NOT NULL DEFAULT '-1',
  `last_update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `hodr_company_u1` (`company_number`),
  UNIQUE KEY `hodr_company_u2` (`company_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='公司';

-- ----------------------------
-- Records of hodr_company
-- ----------------------------
INSERT INTO `hodr_company` VALUES ('1', 'CO00000001', '上海汉得信息技术股份有限公司', '1', '1', '2019-07-18 11:35:53', '-1', '-1', '2019-07-18 11:35:53');
INSERT INTO `hodr_company` VALUES ('2', 'CO00000002', '北京百度网讯科技有限公司', '1', '1', '2019-07-18 11:48:24', '-1', '-1', '2019-07-18 11:48:24');

-- ----------------------------
-- Table structure for hodr_customer
-- ----------------------------
DROP TABLE IF EXISTS `hodr_customer`;
CREATE TABLE `hodr_customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '表ID，主键，供其他表做外键',
  `customer_number` varchar(60) COLLATE utf8mb4_bin NOT NULL COMMENT '客户编号',
  `customer_name` varchar(240) COLLATE utf8mb4_bin NOT NULL COMMENT '客户名称',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `enabled_flag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '启用标识',
  `object_version_number` bigint(20) NOT NULL DEFAULT '1' COMMENT '版本号',
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(20) NOT NULL DEFAULT '-1',
  `last_updated_by` bigint(20) NOT NULL DEFAULT '-1',
  `last_update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `hodr_customer_u1` (`company_id`,`customer_number`),
  KEY `hodr_customer_n1` (`company_id`,`customer_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='客户';

-- ----------------------------
-- Records of hodr_customer
-- ----------------------------
INSERT INTO `hodr_customer` VALUES ('1', 'CUS00000001', '新希望六和股份有限公司', '1', '1', '1', '2019-07-18 11:50:15', '-1', '-1', '2019-07-18 11:50:15');
INSERT INTO `hodr_customer` VALUES ('2', 'CUS00000002', '四川东方变压器集团有限公司', '1', '1', '1', '2019-07-18 11:50:55', '-1', '-1', '2019-07-18 11:50:55');
INSERT INTO `hodr_customer` VALUES ('3', 'CUS00000003', '北京珠穆朗玛移动通信有限公司', '2', '1', '1', '2019-07-18 11:51:27', '-1', '-1', '2019-07-18 11:51:27');
INSERT INTO `hodr_customer` VALUES ('4', 'CUS00000004', '上海橡果网络技术发展有限公司', '2', '1', '1', '2019-07-18 11:52:01', '-1', '-1', '2019-07-18 11:52:01');

-- ----------------------------
-- Table structure for hodr_item
-- ----------------------------
DROP TABLE IF EXISTS `hodr_item`;
CREATE TABLE `hodr_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '表ID，主键，供其他表做外键',
  `item_code` varchar(60) COLLATE utf8mb4_bin NOT NULL COMMENT '物料编码',
  `item_uom` varchar(60) COLLATE utf8mb4_bin NOT NULL COMMENT '物料单位',
  `item_description` varchar(240) COLLATE utf8mb4_bin NOT NULL COMMENT '物料描述',
  `saleable_flag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '可销售标识',
  `start_active_date` date DEFAULT NULL COMMENT '生效起始时间',
  `end_active_date` date DEFAULT NULL COMMENT '生效结束时间',
  `enabled_flag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '启用标识',
  `object_version_number` bigint(20) NOT NULL DEFAULT '1' COMMENT '版本号',
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(20) NOT NULL DEFAULT '-1',
  `last_updated_by` bigint(20) NOT NULL DEFAULT '-1',
  `last_update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`item_id`),
  UNIQUE KEY `hodr_item_u1` (`item_code`),
  KEY `hodr_item_n1` (`item_description`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='物料';

-- ----------------------------
-- Records of hodr_item
-- ----------------------------
INSERT INTO `hodr_item` VALUES ('1', 'ITEM0000000602', 'EA', 'packing material for HU management', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('2', 'ITEM0000000604', 'PC', 'AUTOVUE INNOVA全自动配血分析系统(强生)22', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('3', 'ITEM0000000607', 'PC', 'TradingGood,ReorderPoint,Reg.Tr.', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('4', 'ITEM0000000611', 'PC', '500不浮动式保护盖', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('5', 'ITEM0000000612', 'PC', '500不浮动式头盖', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('6', 'ITEM0000000623', 'PC', '镍氢电池', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('7', 'ITEM0000000624', 'PC', '金达电机', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('8', 'ITEM0000000625', 'PC', '电阻1206±5%1KΩ', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('9', 'ITEM0000000626', 'PC', '电阻0805±5%10KΩ', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('10', 'ITEM0000000627', 'PC', '电阻1206±5%51Ω', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('11', 'ITEM0000000628', 'PC', '电阻0805±5%100KΩ', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('12', 'ITEM0000000629', 'PC', '电阻0805±5%1KΩ', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('13', 'ITEM0000000630', 'PC', '电阻0805±1%11KΩ', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('14', 'ITEM0000000631', 'PC', '电阻0805±5%220Ω', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('15', 'ITEM0000000632', 'PC', '电阻1210J0.1Ω', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('16', 'ITEM0000000633', 'PC', '电阻0805±5%10Ω', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('17', 'ITEM0000000634', 'PC', '电阻0805±5%470Ω', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('18', 'ITEM0000000635', 'PC', '贴片电容104K/0805', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('19', 'ITEM0000000636', 'PC', '贴片二极管1N5819(DO-214)', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('20', 'ITEM0000000637', 'PC', '贴片二极管1N4148(1206)', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('21', 'ITEM0000000638', 'PC', '500刀架支撑弹片', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('22', 'ITEM0000000639', 'PC', '850上铰链', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('23', 'ITEM0000000640', 'PC', 'Φ1.3x16.5铰链钢销', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('24', 'ITEM0000000641', 'PC', '500下铰链', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('25', 'ITEM0000000642', 'PC', '350铰链扭簧', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('26', 'ITEM0000000643', 'PC', 'Φ1.5x21.1齿轮钢针', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('27', 'ITEM0000000644', 'PC', '350充电插针', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('28', 'ITEM0000000645', 'PC', '355充电接触片', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('29', 'ITEM0000000646', 'PC', '500开关弹片', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('30', 'ITEM0000000647', 'PC', '806插头弹簧', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('31', 'ITEM0000000648', 'PC', '500转轴齿轮', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('32', 'ITEM0000000649', 'PC', '500中心齿轮', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('33', 'ITEM0000000650', 'PC', '500电机齿轮', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('34', 'ITEM0000000651', 'PC', '350活动轴', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('35', 'ITEM0000000652', 'PC', '500内箱', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('36', 'ITEM0000000653', 'PC', '500外箱', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('37', 'ITEM0000000654', 'PC', '500彩盒外套', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('38', 'ITEM0000000655', 'PC', '500彩盒', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('39', 'ITEM0000000656', 'PC', '胶带、打包带', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('40', 'ITEM0000000658', 'PC', '装配机物料', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('41', 'ITEM0000000659', 'PC', '焊接机物料(贴140直38)', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('42', 'ITEM0000000722', 'EA', 'DL06-03-A00 倒缝按钮', '1', '2019-07-01', '2019-08-01', '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('43', 'ITEM0000000723', 'EA', 'DL06-04-A00 照明灯外壳', '1', '2019-07-01', '2019-08-01', '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('44', 'ITEM0000000724', 'EA', 'DL06-05-A00 透明外罩', '1', '2019-07-01', '2019-08-01', '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('45', 'ITEM0000000725', 'EA', 'DL06-06-A00 指示灯贴模', '1', '2019-07-01', '2019-08-01', '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('46', 'ITEM0000000726', 'EA', 'DL06-07-0A0 PCB板', '1', '2019-07-01', '2019-08-01', '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('47', 'ITEM0000000727', 'EA', 'DL01-07-A00 微动开关', '1', '2019-07-01', '2019-08-01', '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('48', 'ITEM0000000728', 'EA', 'DL06-09-A00 微触开关', '1', '2019-07-01', '2019-08-01', '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('49', 'ITEM0000000729', 'EA', 'DL06-10-A00 十字槽盘头螺钉', '1', '2019-07-01', '2019-08-01', '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('50', 'ITEM0000000732', 'EA', 'DL01-14-A00 电源线', '1', '2019-07-01', '2019-08-01', '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('51', 'ITEM0000000733', 'EA', 'DL13-00 倒缝照明灯组件 H7700系列', '1', '2019-07-01', '2019-08-01', '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('52', 'ITEM0000000741', 'EA', '宏威2极单相250W电机', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('53', 'ITEM0000000742', 'EA', '1.2米封边平缝板+脚架', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('54', 'ITEM0000000744', 'EA', 'H7700-7C-3高速平缝机配套件', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('55', 'ITEM0000000745', 'EA', '电脑直驱高速平缝机三自动(经济型，进口旋梭)', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('56', 'ITEM0000000746', 'EA', 'HP-005电控箱', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('57', 'ITEM0000000747', 'EA', '1.2米平缝机板', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('58', 'ITEM0000000748', 'EA', 'H7700-7C-3高速平缝机配套件无板架', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('59', 'ITEM0000000749', 'EA', '板架套件', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('60', 'ITEM0000001715', 'EA', '航天管58*1800', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('61', 'ITEM0000001717', 'EA', '集热器联箱外壳', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('62', 'ITEM0000001718', 'EA', '集热器联箱外壳端盖', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('63', 'ITEM0000001726', 'EA', '自攻丝', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('64', 'ITEM0000001727', 'EA', '溢流管', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('65', 'ITEM0000001730', 'KG', '铜直管8×0.6', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('66', 'ITEM0000001731', 'KG', '铜直管21×1', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('67', 'ITEM0000001736', 'EA', '水箱端头泡沫', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('68', 'ITEM0000001737', 'EA', '水箱包装箱', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('69', 'ITEM0000001743', 'EA', '螺栓/螺母M8×20', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('70', 'ITEM0000001744', 'KG', '聚氨酯黑料', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('71', 'ITEM0000001745', 'KG', '聚氨酯白料', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('72', 'ITEM0000001746', 'EA', '硅橡胶G1/2', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('73', 'ITEM0000001747', 'EA', '硅胶圈φ20', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('74', 'ITEM0000001754', 'KG', '镀锌板φ620×δ0.5', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('75', 'ITEM0000001764', 'KG', '彩板φ475(δ0.37)', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('76', 'ITEM0000001766', 'KG', '不锈钢304/2B 0.5*1219', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('77', 'ITEM0000001767', 'EA', '保热墙Ⅱ2100/45度左后腿毛坯件', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('78', 'ITEM0000001772', 'EA', 'φ58管口装饰圈', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('79', 'ITEM0000001773', 'M2', 'δ0.3/黑玻纤布', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('80', 'ITEM0000001775', 'EA', '60U型管装饰圈垫片', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('81', 'ITEM0000001776', 'EA', '58集热器热管装饰内圈', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('82', 'ITEM0000001777', 'M', '48K黑玻纤布贴面玻璃棉', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('83', 'ITEM0000001778', 'M2', '38K阻燃锡箔纸贴面玻纤棉', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('84', 'ITEM0000001780', 'KG', 'SUS304φ375(δ0.5)', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('85', 'ITEM0000001784', 'EA', '螺丝8*16', '1', null, null, '0', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('86', 'ITEM0000001785', 'EA', '螺丝6*12', '1', null, null, '0', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('87', 'ITEM0000001787', 'KG', '2011保热墙Ⅱ代2100*20管/45度底托', '1', null, null, '0', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('88', 'ITEM0000001788', 'KG', '2011保热墙Ⅱ代2100/45度左前腿', '1', null, null, '0', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('89', 'ITEM0000001789', 'KG', 'SUS304φ420×δ0.5', '1', null, null, '0', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('90', 'ITEM0000001790', 'EA', '硅胶圈（φ88）', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('91', 'ITEM0000001791', 'EA', '火雷管', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('92', 'ITEM0000001792', 'EA', '电雷管', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('93', 'ITEM0000001795', 'EA', '防泄漏球阀', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('94', 'ITEM0000001801', 'M2', '轻木', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('95', 'ITEM0000001810', 'EA', '梁Si40.2/1.5MW', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('96', 'ITEM0000001811', 'EA', '腹板Si40.2/1.5MW', '1', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('97', 'ITEM0000001812', 'EA', '毛坯Si40.2/1.5MW', '0', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('98', 'ITEM0000001813', 'EA', '叶片Si40.2/1.5MW', '0', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('99', 'ITEM0000001834', 'EA', '十字平沉头螺钉M3*14*5', '0', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('100', 'ITEM0000001835', 'EA', '紧定螺钉M3×4', '0', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');
INSERT INTO `hodr_item` VALUES ('101', 'ITEM0000001836', 'EA', '六角螺母', '0', null, null, '1', '1', '2019-07-18 12:11:35', '-1', '-1', '2019-07-18 12:11:35');

-- ----------------------------
-- Table structure for hodr_so_header
-- ----------------------------
DROP TABLE IF EXISTS `hodr_so_header`;
CREATE TABLE `hodr_so_header` (
  `so_header_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '表ID，主键，供其他表做外键',
  `order_number` varchar(60) COLLATE utf8mb4_bin NOT NULL COMMENT '订单编号',
  `company_id` bigint(20) NOT NULL COMMENT '公司ID',
  `order_date` date NOT NULL COMMENT '订单日期',
  `order_status` varchar(30) COLLATE utf8mb4_bin NOT NULL DEFAULT 'NEW',
  `customer_id` bigint(20) NOT NULL,
  `object_version_number` bigint(20) NOT NULL DEFAULT '1',
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(20) NOT NULL DEFAULT '-1',
  `last_updated_by` bigint(20) NOT NULL DEFAULT '-1',
  `last_update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`so_header_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='销售订单头';

-- ----------------------------
-- Records of hodr_so_header
-- ----------------------------
INSERT INTO `hodr_so_header` VALUES ('1', 'SO190718000001', '1', '2019-07-18', 'NEW', '1', '1', '2019-07-18 12:17:21', '-1', '-1', '2019-07-18 12:17:21');
INSERT INTO `hodr_so_header` VALUES ('2', 'SO190718000002', '1', '2019-07-19', 'NEW', '2', '1', '2019-07-18 12:17:21', '-1', '-1', '2019-07-18 12:17:21');
INSERT INTO `hodr_so_header` VALUES ('3', 'SO190718000003', '2', '2019-07-20', 'NEW', '3', '1', '2019-07-18 12:17:21', '-1', '-1', '2019-07-18 12:17:21');
INSERT INTO `hodr_so_header` VALUES ('4', 'SO190718000004', '2', '2019-07-21', 'NEW', '4', '1', '2019-07-18 12:17:21', '-1', '-1', '2019-07-18 12:17:21');

-- ----------------------------
-- Table structure for hodr_so_line
-- ----------------------------
DROP TABLE IF EXISTS `hodr_so_line`;
CREATE TABLE `hodr_so_line` (
  `so_line_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '表ID，主键，供其他表做外键',
  `so_header_id` bigint(20) NOT NULL COMMENT '订单头ID',
  `line_number` int(10) NOT NULL COMMENT '行号',
  `item_id` bigint(20) NOT NULL COMMENT '产品ID',
  `order_quantity` decimal(20,6) NOT NULL COMMENT '数量',
  `order_quantity_uom` varchar(60) COLLATE utf8mb4_bin NOT NULL COMMENT '产品单位',
  `unit_selling_price` decimal(20,10) NOT NULL COMMENT '销售单价',
  `description` varchar(240) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `addition1` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '附加信息1',
  `addition2` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '附加信息2',
  `addition3` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '附加信息3',
  `addition4` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '附加信息4',
  `addition5` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '附加信息5',
  `object_version_number` bigint(20) NOT NULL DEFAULT '1' COMMENT '版本号',
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint(20) NOT NULL DEFAULT '-1',
  `last_updated_by` bigint(20) NOT NULL DEFAULT '-1',
  `last_update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`so_line_id`),
  UNIQUE KEY `hodr_so_line_u1` (`so_header_id`,`line_number`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='销售订单行';

-- ----------------------------
-- Records of hodr_so_line
-- ----------------------------
INSERT INTO `hodr_so_line` VALUES ('1', '1', '1', '50', '4384.680000', 'EA', '6532.9400000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('2', '1', '2', '51', '7491.160000', 'EA', '187.5000000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('3', '1', '3', '52', '7655.570000', 'EA', '1599.5100000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('4', '1', '4', '53', '5271.980000', 'EA', '304.0000000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('5', '1', '5', '54', '8558.570000', 'EA', '2222.9100000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('6', '2', '1', '55', '8410.020000', 'EA', '8870.8700000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('7', '2', '2', '56', '9359.250000', 'EA', '3308.8300000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('8', '2', '3', '57', '6538.860000', 'EA', '9413.8000000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('9', '2', '4', '58', '3067.000000', 'EA', '7338.2700000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('10', '2', '5', '59', '2579.350000', 'EA', '5523.0900000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('11', '3', '1', '60', '6952.890000', 'EA', '7108.7800000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('12', '3', '2', '61', '1173.500000', 'EA', '565.3500000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('13', '3', '3', '62', '96.710000', 'EA', '5137.1300000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('14', '3', '4', '63', '7210.800000', 'EA', '4329.1600000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('15', '3', '5', '64', '1184.140000', 'EA', '693.1400000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('16', '4', '1', '65', '7949.860000', 'KG', '4679.9100000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('17', '4', '2', '66', '2532.990000', 'KG', '7519.0300000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('18', '4', '3', '67', '2408.770000', 'EA', '9088.1100000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('19', '4', '4', '68', '2561.720000', 'EA', '5813.5000000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
INSERT INTO `hodr_so_line` VALUES ('20', '4', '5', '69', '2194.710000', 'EA', '4143.4700000000', null, null, null, null, null, null, '1', '2019-07-18 12:29:00', '-1', '-1', '2019-07-18 12:29:00');
