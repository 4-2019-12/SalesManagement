/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : sale_db

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-01-05 15:26:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auditrecord`
-- ----------------------------
DROP TABLE IF EXISTS `auditrecord`;
CREATE TABLE `auditrecord` (
  `id` int(11) NOT NULL,
  `suggestion` text,
  `orderId` varchar(10) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `userId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderId` (`orderId`),
  CONSTRAINT `Orders_AuditRecord_FK1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auditrecord
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `describes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '夏季鞋类', '夏季运动鞋、板鞋、布鞋、高跟鞋、篮球鞋');
INSERT INTO `category` VALUES ('2', '夏季下装', '夏季牛仔裤、休闲裤、短裤');
INSERT INTO `category` VALUES ('3', '夏季上装', '夏季外套、短袖、衬衫、背心');
INSERT INTO `category` VALUES ('4', '夏季凉鞋', '夏季凉拖、凉鞋');
INSERT INTO `category` VALUES ('5', '春秋鞋类', '春秋季运动鞋、板鞋、布鞋、高跟鞋、篮球鞋');
INSERT INTO `category` VALUES ('6', '春秋上装', '春秋季大衣、卫衣、外套、毛衣、打底衫');
INSERT INTO `category` VALUES ('7', '春秋下装', '春秋季牛仔裤、休闲裤、毛绒裤、打底裤');
INSERT INTO `category` VALUES ('8', '冬季下装', '冬季加厚牛仔裤、秋裤、休闲裤、打底裤');
INSERT INTO `category` VALUES ('9', '冬季上装', '冬季羽绒服、棉服');
INSERT INTO `category` VALUES ('10', '冬季棉鞋', '冬季棉靴');

-- ----------------------------
-- Table structure for `consignee`
-- ----------------------------
DROP TABLE IF EXISTS `consignee`;
CREATE TABLE `consignee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(10) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consignee
-- ----------------------------
INSERT INTO `consignee` VALUES ('1', '2', '万达王总', '1888666688', '徐州云龙区万达广场', '1');
INSERT INTO `consignee` VALUES ('2', '2', '雷军', '18811930150', ' 湖北省武汉市洪山区九峰一路小米武汉总部大楼', '1');

-- ----------------------------
-- Table structure for `costume`
-- ----------------------------
DROP TABLE IF EXISTS `costume`;
CREATE TABLE `costume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` double(10,2) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `picture` varchar(500) DEFAULT NULL,
  `cost` double(10,2) DEFAULT NULL,
  `describes` varchar(500) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `warehouseId` varchar(10) DEFAULT NULL,
  `discountId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoryId` (`categoryId`),
  KEY `discountId` (`discountId`),
  CONSTRAINT `Category_Costume_FK1` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`),
  CONSTRAINT `Discount_Costume_FK1` FOREIGN KEY (`discountId`) REFERENCES `discount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of costume
-- ----------------------------
INSERT INTO `costume` VALUES ('1', '199.00', '男士亚麻衬衫米白', '/upload/costume_img/img-1.jpg', '100.00', '春季白衬衫男长袖商务免烫加厚衬衣修身西装职业正装', '1', '95', '1', '1');
INSERT INTO `costume` VALUES ('2', '99.00', '女士纯棉背心', '/upload/costume_img/img-2.jpg', '44.00', '夏季女士潮流轻薄透气运动瑜伽背心', '2', '110', '1', '5');
INSERT INTO `costume` VALUES ('3', '149.00', '女士小V领白衬衫', '/upload/costume_img/img-3.jpg', '66.00', '春秋女生白衬衫潮流显瘦', '6', '50', '1', '1');
INSERT INTO `costume` VALUES ('4', '169.00', '男士polo衫', '/upload/costume_img/img-4.jpg', '70.00', '夏季男生显瘦潮流短袖衬衫', '4', '200', '1', '3');

-- ----------------------------
-- Table structure for `discount`
-- ----------------------------
DROP TABLE IF EXISTS `discount`;
CREATE TABLE `discount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discount
-- ----------------------------
INSERT INTO `discount` VALUES ('1', '新品折扣', '0.88');
INSERT INTO `discount` VALUES ('2', '促销折扣', '0.66');
INSERT INTO `discount` VALUES ('3', '会员折扣', '0.98');
INSERT INTO `discount` VALUES ('4', '节日折扣', '0.8');
INSERT INTO `discount` VALUES ('5', '无折扣', '1');

-- ----------------------------
-- Table structure for `feedackinfo`
-- ----------------------------
DROP TABLE IF EXISTS `feedackinfo`;
CREATE TABLE `feedackinfo` (
  `id` int(11) NOT NULL,
  `content` text,
  `orderId` varchar(10) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderId` (`orderId`),
  CONSTRAINT `Orders_FeedackInfo_FK1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedackinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `jurisdiction`
-- ----------------------------
DROP TABLE IF EXISTS `jurisdiction`;
CREATE TABLE `jurisdiction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `function` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jurisdiction
-- ----------------------------
INSERT INTO `jurisdiction` VALUES ('1', '查看商品');
INSERT INTO `jurisdiction` VALUES ('3', '查看订单');
INSERT INTO `jurisdiction` VALUES ('4', '客户管理');
INSERT INTO `jurisdiction` VALUES ('5', '款项管理');
INSERT INTO `jurisdiction` VALUES ('6', '商品管理');
INSERT INTO `jurisdiction` VALUES ('7', '类别管理');
INSERT INTO `jurisdiction` VALUES ('8', '订单审核');
INSERT INTO `jurisdiction` VALUES ('9', '制定售价');
INSERT INTO `jurisdiction` VALUES ('10', '用户管理');
INSERT INTO `jurisdiction` VALUES ('11', '权限管理');

-- ----------------------------
-- Table structure for `orderitems`
-- ----------------------------
DROP TABLE IF EXISTS `orderitems`;
CREATE TABLE `orderitems` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(20) DEFAULT NULL,
  `costumeId` int(10) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderId` (`orderId`),
  KEY `coustumeId` (`costumeId`),
  CONSTRAINT `Orders_OrderItems_FK1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitems
-- ----------------------------
INSERT INTO `orderitems` VALUES ('4', '20200102222153', '1', '100', null);
INSERT INTO `orderitems` VALUES ('5', '20200102222153', '2', '20', null);
INSERT INTO `orderitems` VALUES ('6', '20200102222153', '4', '50', null);
INSERT INTO `orderitems` VALUES ('7', '20200102222153', '1', '100', null);
INSERT INTO `orderitems` VALUES ('8', '202001031715282', '1', '200', '0.88');
INSERT INTO `orderitems` VALUES ('12', '202001031715282', '2', '50', '1');
INSERT INTO `orderitems` VALUES ('13', '202001042229372', '3', '5', null);
INSERT INTO `orderitems` VALUES ('14', '202001042229372', '1', '5', null);

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(20) NOT NULL,
  `orderTime` varchar(50) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `consigneeId` int(10) DEFAULT NULL,
  `confirmTime` varchar(50) DEFAULT NULL,
  `userId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('20200102222153', '', '0', 'nosubmit', null, null, '1');
INSERT INTO `orders` VALUES ('202001031715282', '2020-01-05-12:26:26', '39974', 'noexamine', '1', null, '2');
INSERT INTO `orders` VALUES ('202001042229372', null, null, 'nosubmit', null, null, '2');

-- ----------------------------
-- Table structure for `purchase`
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `id` int(11) NOT NULL,
  `userId` varchar(10) DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchase
-- ----------------------------

-- ----------------------------
-- Table structure for `purchaseitem`
-- ----------------------------
DROP TABLE IF EXISTS `purchaseitem`;
CREATE TABLE `purchaseitem` (
  `id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `costumeId` int(11) DEFAULT NULL,
  `purchaseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `costumeId` (`costumeId`),
  KEY `purchaseId` (`purchaseId`),
  CONSTRAINT `Costume_PurchaseItem_FK1` FOREIGN KEY (`costumeId`) REFERENCES `costume` (`id`),
  CONSTRAINT `Purchase_PurchaseItem_FK1` FOREIGN KEY (`purchaseId`) REFERENCES `purchase` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchaseitem
-- ----------------------------

-- ----------------------------
-- Table structure for `roles`
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', 'sale');
INSERT INTO `roles` VALUES ('2', 'manager');
INSERT INTO `roles` VALUES ('3', 'admin');

-- ----------------------------
-- Table structure for `roles_jurisdiction`
-- ----------------------------
DROP TABLE IF EXISTS `roles_jurisdiction`;
CREATE TABLE `roles_jurisdiction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) DEFAULT NULL,
  `jurisdictionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `jurisdictionId` (`jurisdictionId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `Jurisdiction_Roles_Jurisdiction_FK1` FOREIGN KEY (`jurisdictionId`) REFERENCES `jurisdiction` (`id`),
  CONSTRAINT `Roles_Roles_Jurisdiction_FK1` FOREIGN KEY (`roleId`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_jurisdiction
-- ----------------------------
INSERT INTO `roles_jurisdiction` VALUES ('1', '1', '1');
INSERT INTO `roles_jurisdiction` VALUES ('3', '1', '3');
INSERT INTO `roles_jurisdiction` VALUES ('4', '1', '4');
INSERT INTO `roles_jurisdiction` VALUES ('5', '1', '5');
INSERT INTO `roles_jurisdiction` VALUES ('7', '2', '6');
INSERT INTO `roles_jurisdiction` VALUES ('8', '2', '7');
INSERT INTO `roles_jurisdiction` VALUES ('9', '2', '8');
INSERT INTO `roles_jurisdiction` VALUES ('10', '2', '9');
INSERT INTO `roles_jurisdiction` VALUES ('12', '3', '11');

-- ----------------------------
-- Table structure for `states`
-- ----------------------------
DROP TABLE IF EXISTS `states`;
CREATE TABLE `states` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `des` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of states
-- ----------------------------
INSERT INTO `states` VALUES ('1', 'nosubmit', '未提交');
INSERT INTO `states` VALUES ('2', 'noexamine', '未审核');
INSERT INTO `states` VALUES ('3', 'noconfirm', '未确认');
INSERT INTO `states` VALUES ('4', 'completed', '已完成');
INSERT INTO `states` VALUES ('5', 'nopass', '未通过');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `purchaseId` varchar(10) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `Roles_Users_FK1` FOREIGN KEY (`roleId`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'cheng', '123456', 'chengmiao', '15962957280', null, '2');
INSERT INTO `users` VALUES ('2', 'zhang', '123456', 'zhangxiaoyi', '*****', null, '1');
INSERT INTO `users` VALUES ('3', 'admin', 'admin', 'admin', '*****', null, '3');

-- ----------------------------
-- Table structure for `warehouse`
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `address` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
