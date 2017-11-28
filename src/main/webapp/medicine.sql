/*
Navicat MySQL Data Transfer

Source Server         : vicky
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : medicine

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2017-11-21 12:14:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `cgdd`
-- ----------------------------
DROP TABLE IF EXISTS `cgdd`;
CREATE TABLE `cgdd` (
  `DDID` int(10) NOT NULL COMMENT '订单编码',
  `ZGBM` int(10) NOT NULL COMMENT '供应商编码',
  `GYSBM` int(10) NOT NULL,
  `DDRQ` datetime NOT NULL,
  `YPBM` int(10) NOT NULL,
  `YPMC` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '药品名称',
  `SL` int(10) NOT NULL COMMENT '药品数量',
  PRIMARY KEY (`DDID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cgdd
-- ----------------------------

-- ----------------------------
-- Table structure for `ckxx`
-- ----------------------------
DROP TABLE IF EXISTS `ckxx`;
CREATE TABLE `ckxx` (
  `CKID` int(10) NOT NULL AUTO_INCREMENT COMMENT '出库id',
  `YPBM` int(10) NOT NULL COMMENT '药品编码',
  `YPMC` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '药品名称',
  `ZGBM` int(10) NOT NULL COMMENT '职工编码',
  `CKRQ` datetime NOT NULL COMMENT '出库日期',
  `SL` int(10) NOT NULL COMMENT '数量',
  PRIMARY KEY (`CKID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ckxx
-- ----------------------------
INSERT INTO ckxx VALUES ('2', '4', '4', '4', '2017-11-01 19:45:13', '4');

-- ----------------------------
-- Table structure for `gys`
-- ----------------------------
DROP TABLE IF EXISTS `gys`;
CREATE TABLE `gys` (
  `GYSBM` int(10) NOT NULL COMMENT '供应商编码',
  `GYSMC` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '供应商名称',
  `GYSFZR` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '供应商负责人',
  `GYSLXFS` varchar(11) DEFAULT NULL COMMENT '供应商联系方式',
  `GYSDZ` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '供应商地址',
  PRIMARY KEY (`GYSBM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of gys
-- ----------------------------
INSERT INTO gys VALUES ('161108', '111', '1111111', '111', '11');
INSERT INTO gys VALUES ('1305541114', '11', '211', '11', '2222');

-- ----------------------------
-- Table structure for `rkxx`
-- ----------------------------
DROP TABLE IF EXISTS `rkxx`;
CREATE TABLE `rkxx` (
  `RKID` int(10) NOT NULL AUTO_INCREMENT,
  `YPBM` int(10) NOT NULL COMMENT '药品编码',
  `YPMC` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '药品名称',
  `ZGBM` int(10) NOT NULL,
  `RKRQ` datetime NOT NULL,
  `RKL` int(10) NOT NULL COMMENT '数量',
  PRIMARY KEY (`RKID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of rkxx
-- ----------------------------

-- ----------------------------
-- Table structure for `ypkcxx`
-- ----------------------------
DROP TABLE IF EXISTS `ypkcxx`;
CREATE TABLE `ypkcxx` (
  `YPBM` int(10) NOT NULL COMMENT '药品编码',
  `YPMC` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '药品名称',
  `YPJX` int(100) NOT NULL COMMENT '药品供应商名称',
  `YPSL` int(10) NOT NULL COMMENT '药品库存量',
  `YXRQ` datetime DEFAULT NULL COMMENT '有效日期',
  PRIMARY KEY (`YPBM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ypkcxx
-- ----------------------------

-- ----------------------------
-- Table structure for `zgxx`
-- ----------------------------
DROP TABLE IF EXISTS `zgxx`;
CREATE TABLE `zgxx` (
  `ZGBM` int(10) NOT NULL COMMENT '职工编码',
  `ZGMC` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '职工名称',
  `ZGMM` varchar(10) NOT NULL COMMENT '职工密码',
  PRIMARY KEY (`ZGBM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of zgxx
-- ----------------------------
