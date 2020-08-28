/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 8.0.16 : Database - takeaway
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`takeaway` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `takeaway`;

/*Table structure for table `order_detail` */

DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
  `detail_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `product_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '商品单价',
  `product_quantity` int(11) NOT NULL COMMENT '商品数量',
  `product_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品小图',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单详情表';

/*Data for the table `order_detail` */

insert  into `order_detail`(`detail_id`,`order_id`,`product_id`,`product_name`,`product_price`,`product_quantity`,`product_icon`,`create_time`,`update_time`) values 
('05fa355aaa2984a54db121912bb14156','71d77877ee5e0dfce1e5dcff567edc62','1','肉夹馍',16.00,1,'https://s1.st.meishij.net/rs/50/123/6030800/n6030800_152708155351112.jpg','2020-08-24 16:29:09','2020-08-24 16:29:09'),
('0d88983504fdd3ecb00581ea05b7de95','99ed507eff6d328fa5b1a49bf0f9b4dd','1','肉夹馍',16.00,2,'https://s1.st.meishij.net/rs/50/123/6030800/n6030800_152708155351112.jpg','2020-08-24 16:05:20','2020-08-24 16:05:20'),
('104436cd0157f12e5b0cbcbbcd39f39d','de7958c7ccb238acca788edd4476fdd4','1','肉夹馍',16.00,1,'https://s1.st.meishij.net/rs/50/123/6030800/n6030800_152708155351112.jpg','2020-08-24 06:33:36','2020-08-24 06:33:36'),
('205a087e4f74f1b7eb2bce46cf6af636','de7958c7ccb238acca788edd4476fdd4','4','宫保鸡丁',33.00,1,'https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg','2020-08-24 06:33:36','2020-08-24 06:33:36'),
('247180306ace199517717768644419b5','3fa2e1b6ecf1d180ee1cce128571b936','2','皮蛋瘦肉粥',3.50,2,'https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg','2020-08-24 15:58:35','2020-08-24 15:58:35'),
('278a5edc631b85e0861fa55a57feff80','71d77877ee5e0dfce1e5dcff567edc62','10','火锅',666.00,1,'https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg','2020-08-24 16:29:09','2020-08-24 16:29:09'),
('2a1eefa15a345a73d7236bd255b11ad1','5d158def2a925cb80ac0a520066560ad','7','香辣牛肉面',33.50,1,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597809655720&di=122e120a433c55d42563729a404a0fdc&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Ftranslate%2F173%2Fw600h373%2F20180721%2F_Gzq-hfqtahi1090555.jpg','2020-08-26 20:25:12','2020-08-26 20:25:12'),
('47d1dd3c96b9a936a662466621e52451','de7958c7ccb238acca788edd4476fdd4','10','火锅',666.00,1,'https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg','2020-08-24 06:33:36','2020-08-24 06:33:36'),
('521f5f4ff4511d785316504adaac1d76','de7958c7ccb238acca788edd4476fdd4','5','鸡汤米线',33.00,1,'https://s1.st.meishij.net/rs/106/232/3995606/n3995606_152654133043680.jpg','2020-08-24 06:33:36','2020-08-24 06:33:36'),
('5daaf438e0a2d63c51eaee78892fcf53','71d77877ee5e0dfce1e5dcff567edc62','12','鸳鸯火锅',66.00,1,'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1347607405,961608748&fm=26&gp=0.jpg','2020-08-24 16:29:10','2020-08-24 16:29:10'),
('608a2a8b129555c810af69b4140178e0','45c17949254caa0295ba8481af834864','7','香辣牛肉面',33.50,1,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597809655720&di=122e120a433c55d42563729a404a0fdc&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Ftranslate%2F173%2Fw600h373%2F20180721%2F_Gzq-hfqtahi1090555.jpg','2020-08-24 15:06:31','2020-08-24 15:06:31'),
('6c41a113628a2e29efbb1efe0e5f2347','71d77877ee5e0dfce1e5dcff567edc62','5','鸡汤米线',33.00,2,'https://s1.st.meishij.net/rs/106/232/3995606/n3995606_152654133043680.jpg','2020-08-24 16:29:10','2020-08-24 16:29:10'),
('7bffacfd79c56c465679b8d46951dea5','de7958c7ccb238acca788edd4476fdd4','3','羊肉胡卜',33.00,1,'https://s1.st.meishij.net/rs/106/232/3995606/n3995606_152654133043680.jpg','2020-08-24 06:33:36','2020-08-24 06:33:36'),
('810ed7b6eed2c25f9d87ee953a1604d5','45c17949254caa0295ba8481af834864','1','肉夹馍',16.00,2,'https://s1.st.meishij.net/rs/50/123/6030800/n6030800_152708155351112.jpg','2020-08-24 15:06:31','2020-08-24 15:06:31'),
('95ace62ea9affa332617c56b6e8f4896','71d77877ee5e0dfce1e5dcff567edc62','6','油炸鸡翅',66.00,1,'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1337981145,1578667496&fm=26&gp=0.jpg','2020-08-24 16:29:10','2020-08-24 16:29:10'),
('9b04c035657fc5647a61c82668258cf3','bb0122bca6b9318bafdd8a9d0cae5c76','2','皮蛋瘦肉粥',3.50,1,'https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg','2020-08-24 16:13:43','2020-08-24 16:13:43'),
('9e7a61403ca1ac6cba7c32f2f5100d20','0dd5071bfe1bccddf3b4a1b652c8cd11','2','皮蛋瘦肉粥',3.50,3,'https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg','2020-08-24 15:44:48','2020-08-24 15:44:48'),
('9e80e564623db42f76b72eeac5b7768a','71d77877ee5e0dfce1e5dcff567edc62','13','卤肥肠',38.00,1,'http://5b0988e595225.cdn.sohucs.com/images/20171020/6081aca340dd4ec692dcdeeca7f44fe6.jpeg','2020-08-24 16:29:10','2020-08-24 16:29:10'),
('b5675890f5ded939ed8aa61cb83c48ee','de7958c7ccb238acca788edd4476fdd4','2','皮蛋瘦肉粥',3.50,1,'https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg','2020-08-24 06:33:36','2020-08-24 06:33:36'),
('d2a774673b0351548f0a00ad6882258e','71d77877ee5e0dfce1e5dcff567edc62','2','皮蛋瘦肉粥',3.50,1,'https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg','2020-08-24 16:29:09','2020-08-24 16:29:09'),
('d2e8e9764bca8ea17971acba54832ec0','71d77877ee5e0dfce1e5dcff567edc62','4','宫保鸡丁',33.00,1,'https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg','2020-08-24 16:29:09','2020-08-24 16:29:09'),
('d7616eaff0232cae58f7f4d8db2f1668','71d77877ee5e0dfce1e5dcff567edc62','7','香辣牛肉面',33.50,1,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597809655720&di=122e120a433c55d42563729a404a0fdc&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Ftranslate%2F173%2Fw600h373%2F20180721%2F_Gzq-hfqtahi1090555.jpg','2020-08-24 16:29:09','2020-08-24 16:29:09'),
('dd1a470b0d64da924bbea60f79ad99b7','de7958c7ccb238acca788edd4476fdd4','7','香辣牛肉面',33.50,1,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597809655720&di=122e120a433c55d42563729a404a0fdc&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Ftranslate%2F173%2Fw600h373%2F20180721%2F_Gzq-hfqtahi1090555.jpg','2020-08-24 06:33:36','2020-08-24 06:33:36'),
('e1c40fc2272c69ed8dc2ba5f628cfec9','71d77877ee5e0dfce1e5dcff567edc62','3','羊肉胡卜',33.00,1,'https://s1.st.meishij.net/rs/106/232/3995606/n3995606_152654133043680.jpg','2020-08-24 16:29:09','2020-08-24 16:29:09'),
('fc6199426098ec0397a4a66368bb6583','8b0da1990ba5c57cf942df33b974edc1','7','香辣牛肉面',33.50,5,'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597809655720&di=122e120a433c55d42563729a404a0fdc&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Ftranslate%2F173%2Fw600h373%2F20180721%2F_Gzq-hfqtahi1090555.jpg','2020-08-24 06:33:21','2020-08-24 06:33:21');

/*Table structure for table `order_master` */

DROP TABLE IF EXISTS `order_master`;

CREATE TABLE `order_master` (
  `order_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `buyer_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态，默认0新下单',
  `pay_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '支付状态，默认0未支付',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`),
  KEY `idx_buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单表';

/*Data for the table `order_master` */

insert  into `order_master`(`order_id`,`buyer_name`,`buyer_phone`,`buyer_address`,`buyer_openid`,`order_amount`,`order_status`,`pay_status`,`create_time`,`update_time`) values 
('0dd5071bfe1bccddf3b4a1b652c8cd11','l','l','l','sdfyc123Werdsfd98712Bdc',10.50,2,0,'2020-08-24 15:44:48','2020-08-24 15:58:01'),
('3fa2e1b6ecf1d180ee1cce128571b936','gn','gh','gf','sdfyc123Werdsfd98712Bdc',7.00,1,1,'2020-08-24 15:58:35','2020-08-24 16:04:27'),
('45c17949254caa0295ba8481af834864','e','e','e','sdfyc123Werdsfd98712Bdc',65.50,2,0,'2020-08-24 15:06:31','2020-08-24 15:27:21'),
('5d158def2a925cb80ac0a520066560ad','k','k','k','sdfyc123Werdsfd98712Bdc',33.50,2,0,'2020-08-26 20:25:12','2020-08-26 20:25:22'),
('71d77877ee5e0dfce1e5dcff567edc62','刘宇帆','123786929','长安校区','sdfyc123Werdsfd98712Bdc',1021.00,0,0,'2020-08-24 16:29:09','2020-08-24 16:29:09'),
('8b0da1990ba5c57cf942df33b974edc1','j','j','j','sdfyc123Werdsfd98712Bdc',167.50,2,0,'2020-08-24 06:33:21','2020-08-24 15:44:25'),
('99ed507eff6d328fa5b1a49bf0f9b4dd','a','a','a','sdfyc123Werdsfd98712Bdc',32.00,0,1,'2020-08-24 16:05:20','2020-08-24 16:09:56'),
('bb0122bca6b9318bafdd8a9d0cae5c76','1','1','1','sdfyc123Werdsfd98712Bdc',3.50,2,1,'2020-08-24 16:13:43','2020-08-24 16:13:58'),
('de7958c7ccb238acca788edd4476fdd4','u','nj','u','sdfyc123Werdsfd98712Bdc',818.00,2,0,'2020-08-24 06:33:36','2020-08-24 15:44:36');

/*Table structure for table `product_category` */

DROP TABLE IF EXISTS `product_category`;

CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类目名称',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `uqe_category_type` (`category_type`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='类目表';

/*Data for the table `product_category` */

insert  into `product_category`(`category_id`,`category_name`,`category_type`,`create_time`,`update_time`) values 
(1,'热销榜',2,'2020-01-07 17:22:48','2020-01-07 17:22:48'),
(2,'夜宵',3,'2020-01-07 17:26:42','2020-01-14 16:57:36'),
(3,'午餐',10,'2020-01-07 17:37:19','2020-08-28 15:02:22'),
(16,'小吃',11,'2020-01-22 17:34:56','2020-01-22 17:34:56'),
(17,'早餐',1,'2020-01-31 16:50:16','2020-01-31 16:50:16');

/*Table structure for table `product_info` */

DROP TABLE IF EXISTS `product_info`;

CREATE TABLE `product_info` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '商品单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '小图',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `product_status` int(11) NOT NULL COMMENT '商品状态，0正常1下架',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品表';

/*Data for the table `product_info` */

insert  into `product_info`(`product_id`,`product_name`,`product_price`,`product_stock`,`product_description`,`product_icon`,`category_type`,`create_time`,`update_time`,`product_status`) values 
(1,'肉夹馍',111.00,60,'好吃好吃米西米西','https://s1.st.meishij.net/rs/50/123/6030800/n6030800_152708155351112.jpg',2,'2020-01-02 23:45:33','2020-08-28 16:30:31',1),
(2,'皮蛋瘦肉粥',3.50,58,'很好喝的粥','https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg',2,'2020-01-03 07:32:00','2020-08-28 12:06:03',1),
(3,'羊肉胡卜',33.00,64,'美滴很','https://s1.st.meishij.net/rs/106/232/3995606/n3995606_152654133043680.jpg',3,'2020-01-11 06:46:37','2020-08-28 12:06:01',1),
(4,'宫保鸡丁',33.00,90,'好吃好吃','https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg',3,'2020-01-20 23:53:36','2020-08-28 12:06:04',1),
(5,'鸡汤米线',33.00,998,'好吃好喝','https://s1.st.meishij.net/rs/106/232/3995606/n3995606_152654133043680.jpg',3,'2020-01-21 16:15:51','2020-08-28 12:06:04',1),
(6,'油炸鸡翅',66.00,104,'好吃香','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1337981145,1578667496&fm=26&gp=0.jpg',11,'2020-01-22 01:35:17','2020-08-28 12:06:09',1),
(7,'香辣牛肉面',33.50,70,'香辣','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1597809655720&di=122e120a433c55d42563729a404a0fdc&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Ftranslate%2F173%2Fw600h373%2F20180721%2F_Gzq-hfqtahi1090555.jpg',2,'2020-01-18 15:42:40','2020-08-28 12:06:08',1),
(10,'火锅',666.00,659,'啦啦啦','https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg',3,'2020-01-24 13:44:55','2020-08-28 12:06:07',1),
(12,'鸳鸯火锅',66.00,93,'好吃好吃好吃','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1347607405,961608748&fm=26&gp=0.jpg',11,'2020-01-25 17:06:32','2020-08-28 12:06:07',1),
(13,'卤肥肠',38.00,98,'好吃太','http://5b0988e595225.cdn.sohucs.com/images/20171020/6081aca340dd4ec692dcdeeca7f44fe6.jpeg',11,'2020-01-26 01:40:25','2020-08-28 12:06:06',1),
(17,'肉丸胡辣汤',6.00,760,'小碗6块大碗7块','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598268592737&di=74c8b120fc2a2713db077c427a68669a&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170420%2F5a8a6361bffa449c820e83b228183b54_th.jpeg',1,'2020-08-24 16:42:20','2020-08-28 12:06:12',1),
(18,'肉夹馍',16.00,107,'好吃好吃','https://s1.st.meishij.net/rs/50/123/6030800/n6030800_152708155351112.jpg',1,'2020-08-27 09:10:31','2020-08-27 09:10:31',1),
(23,'大汉堡',18.00,89,'美滴很','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598501580148&di=45618e9ae129c2af200bd34c2067fd2a&imgtype=0&src=http%3A%2F%2Fimages.3158.cn%2Fdata%2Fattachment%2Ftougao%2Farticle%2F2014%2F06%2F23%2F8738534bc2469b80402610552be24c22.jpg',10,'2020-08-27 09:25:50','2020-08-28 12:06:12',1),
(24,'肉丸胡辣汤',6.00,760,'小碗6块大碗7块','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598268592737&di=74c8b120fc2a2713db077c427a68669a&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170420%2F5a8a6361bffa449c820e83b228183b54_th.jpeg',1,'2020-08-24 16:42:20','2020-08-28 12:06:18',0),
(26,'大汉堡',18.00,89,'美滴很','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598501580148&di=45618e9ae129c2af200bd34c2067fd2a&imgtype=0&src=http%3A%2F%2Fimages.3158.cn%2Fdata%2Fattachment%2Ftougao%2Farticle%2F2014%2F06%2F23%2F8738534bc2469b80402610552be24c22.jpg',10,'2020-08-27 09:25:50','2020-08-28 12:06:13',1),
(27,'宫保鸡丁',33.00,90,'好吃好吃','https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg',3,'2020-01-20 23:53:36','2020-08-28 12:06:16',1),
(28,'皮蛋瘦肉粥',3.50,58,'很好喝的粥','https://s1.st.meishij.net/rs/105/225/1306355/n1306355_150185137138378.jpg',2,'2020-01-03 07:32:00','2020-08-24 08:29:09',1),
(29,'鸡汤米线',33.00,998,'好吃好喝','https://s1.st.meishij.net/rs/106/232/3995606/n3995606_152654133043680.jpg',3,'2020-01-21 16:15:51','2020-08-28 12:06:15',1),
(31,'肉夹馍摸',11231.00,123123,'123123','123123',3,'2020-08-28 12:08:07','2020-08-28 12:08:07',1),
(32,'111',111.00,1,'1','1',3,'2020-08-28 12:08:39','2020-08-28 12:08:39',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
