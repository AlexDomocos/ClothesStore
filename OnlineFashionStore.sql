/*
SQLyog Community v9.30 
MySQL - 5.6.25-log : Database - fashionstore
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fashionstore` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `fashionstore`;

/*Table structure for table `f_bookclothes` */

DROP TABLE IF EXISTS `f_bookclothes`;

CREATE TABLE `f_bookclothes` (
  `ID` bigint(20) NOT NULL,
  `clothesId` bigint(20) DEFAULT NULL,
  `clothesName` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  `emailId` varchar(225) DEFAULT NULL,
  `mobileNo` varchar(225) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `pinCode` varchar(225) DEFAULT NULL,
  `landMark` varchar(225) DEFAULT NULL,
  `address` varchar(225) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `finalPrice` bigint(20) DEFAULT NULL,
  `clothesSize` varchar(225) DEFAULT NULL,
  `createdBy` varchar(225) DEFAULT NULL,
  `modifiedBy` varchar(225) DEFAULT NULL,
  `createdDatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modifiedDatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `f_bookclothes` */

/*Table structure for table `f_cart` */

DROP TABLE IF EXISTS `f_cart`;

CREATE TABLE `f_cart` (
  `ID` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `clothesId` bigint(20) DEFAULT NULL,
  `createdBy` varchar(225) DEFAULT NULL,
  `modifiedBy` varchar(225) DEFAULT NULL,
  `createdDatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modifiedDatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`),
  KEY `FK_f_cart` (`clothesId`),
  CONSTRAINT `FK_f_cart` FOREIGN KEY (`clothesId`) REFERENCES `f_clothes` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `f_cart` */

/*Table structure for table `f_category` */

DROP TABLE IF EXISTS `f_category`;

CREATE TABLE `f_category` (
  `ID` bigint(20) NOT NULL,
  `Name` varchar(225) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `image` varchar(225) DEFAULT NULL,
  `createdBy` varchar(225) DEFAULT NULL,
  `modifiedBy` varchar(225) DEFAULT NULL,
  `createdDatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modifiedDatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `f_category` */

/*Table structure for table `f_clothes` */

DROP TABLE IF EXISTS `f_clothes`;

CREATE TABLE `f_clothes` (
  `ID` bigint(20) NOT NULL,
  `categoryId` bigint(20) DEFAULT NULL,
  `CategoryName` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `description` varchar(755) DEFAULT NULL,
  `image` varchar(225) DEFAULT NULL,
  `createdBy` varchar(225) DEFAULT NULL,
  `modifiedBy` varchar(225) DEFAULT NULL,
  `createdDatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modifiedDatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`),
  KEY `FK_f_clothes` (`categoryId`),
  CONSTRAINT `FK_f_clothes` FOREIGN KEY (`categoryId`) REFERENCES `f_category` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `f_clothes` */

/*Table structure for table `f_user` */

DROP TABLE IF EXISTS `f_user`;

CREATE TABLE `f_user` (
  `ID` bigint(20) NOT NULL,
  `firstName` varchar(225) DEFAULT NULL,
  `lastName` varchar(225) DEFAULT NULL,
  `login` varchar(225) DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `mobileNo` varchar(225) DEFAULT NULL,
  `roleId` bigint(20) DEFAULT NULL,
  `gender` varchar(225) DEFAULT NULL,
  `createdBy` varchar(225) DEFAULT NULL,
  `modifiedBy` varchar(225) DEFAULT NULL,
  `createdDatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modifiedDatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `f_user` */

insert  into `f_user`(`ID`,`firstName`,`lastName`,`login`,`password`,`dob`,`mobileNo`,`roleId`,`gender`,`createdBy`,`modifiedBy`,`createdDatetime`,`modifiedDatetime`) values (1,'Hariom','Mukati','Admin@gmail.com','Admin@123','1997-10-06','9165415598',1,'Male','root','root','2019-07-08 10:18:24','2019-07-07 13:23:17'),(2,'User','Last User','User@gmail.com','User@123','1998-10-06','9852654155',2,'Male','root','root','2019-07-10 09:49:23','2019-07-10 09:49:23');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
