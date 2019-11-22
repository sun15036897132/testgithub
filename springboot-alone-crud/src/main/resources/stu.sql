/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50545
Source Host           : localhost:3306
Source Database       : students

Target Server Type    : MYSQL
Target Server Version : 50545
File Encoding         : 65001

Date: 2019-11-15 17:50:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(10) NOT NULL DEFAULT '张三',
  `sage` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=1013 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES ('123', '夏侯13456', '0');
INSERT INTO `stu` VALUES ('1001', '夏侯惇', '100');
INSERT INTO `stu` VALUES ('1002', '关于', '25');
INSERT INTO `stu` VALUES ('1003', '张飞', '78');
INSERT INTO `stu` VALUES ('1004', '诸葛亮', '92');
INSERT INTO `stu` VALUES ('1005', '大乔', '18');
INSERT INTO `stu` VALUES ('1006', 'xiaoqiao', '18');
INSERT INTO `stu` VALUES ('1007', '貂蝉', '19');
INSERT INTO `stu` VALUES ('1008', '孙尚香', '21');
INSERT INTO `stu` VALUES ('1009', '周瑜', '87');
INSERT INTO `stu` VALUES ('1010', '甄姬', '21');
INSERT INTO `stu` VALUES ('1011', '曹操', '50');
