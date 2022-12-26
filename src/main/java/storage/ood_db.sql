/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.35-log : Database - ood_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ood_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ood_db`;

/*Table structure for table `movie` */

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `title` varchar(40) NOT NULL,
  `running_time` varchar(40) NOT NULL,
  `year` int(4) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `movie` */

insert  into `movie`(`title`,`running_time`,`year`,`id`) values ('qwe','80min',2000,1),('rty','90min',2000,2),('wer','90min',2000,3),('zxc','90min',2000,4);

/*Table structure for table `screen` */

DROP TABLE IF EXISTS `screen`;

CREATE TABLE `screen` (
  `screen_id` int(11) NOT NULL AUTO_INCREMENT,
  `capacity` int(11) NOT NULL,
  PRIMARY KEY (`screen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `screen` */

insert  into `screen`(`screen_id`,`capacity`) values (1,60),(2,80);

/*Table structure for table `screening` */

DROP TABLE IF EXISTS `screening`;

CREATE TABLE `screening` (
  `screening_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(32) NOT NULL,
  `time` varchar(32) NOT NULL,
  `ticket_sold` int(11) DEFAULT NULL,
  `screen_id` int(11) NOT NULL,
  PRIMARY KEY (`screening_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `screening` */

insert  into `screening`(`screening_id`,`date`,`time`,`ticket_sold`,`screen_id`) values (1,'2020-2-30','14:00-15:30',300,2),(2,'2020-1-30','17:00-18:30',200,1),(3,'2020-1-30','17:00-18:30',200,1),(4,'2020-1-30','17:00-18:30',200,1);

/*Table structure for table `ticket` */

DROP TABLE IF EXISTS `ticket`;

CREATE TABLE `ticket` (
  `ticket_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(32) NOT NULL,
  `time` varchar(32) NOT NULL,
  `movie_title` varchar(40) NOT NULL,
  `screen_id` int(11) NOT NULL,
  `seat_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ticket_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `ticket` */

insert  into `ticket`(`ticket_id`,`date`,`time`,`movie_title`,`screen_id`,`seat_id`,`price`,`status`) values (1,'2020-1-30','17:00-18:30','qwe',1,22,30,1),(2,'2020-2-30','16:00-17:30','qwe',1,33,30,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
