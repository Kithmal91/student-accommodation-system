-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.11-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             8.1.0.4545
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for student-accomodation-db
CREATE DATABASE IF NOT EXISTS `student-accomodation-db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `student-accomodation-db`;


-- Dumping structure for table student-accomodation-db.sas_pm_fee
CREATE TABLE IF NOT EXISTS `sas_pm_fee` (
  `fee_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) NOT NULL DEFAULT '0',
  `property_id` bigint(20) NOT NULL DEFAULT '0',
  `fee` double NOT NULL DEFAULT '0',
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`fee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table student-accomodation-db.sas_pm_fee: ~1 rows (approximately)
DELETE FROM `sas_pm_fee`;
/*!40000 ALTER TABLE `sas_pm_fee` DISABLE KEYS */;
INSERT INTO `sas_pm_fee` (`fee_id`, `user_name`, `property_id`, `fee`, `added_date`) VALUES
	(1, 'TESTOWNR', 2, 100, '2017-01-13 10:38:02');
/*!40000 ALTER TABLE `sas_pm_fee` ENABLE KEYS */;


-- Dumping structure for table student-accomodation-db.sas_pm_notification
CREATE TABLE IF NOT EXISTS `sas_pm_notification` (
  `notification_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) NOT NULL DEFAULT '0',
  `property_id` bigint(20) DEFAULT NULL,
  `property_owner` varchar(10) DEFAULT NULL,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`notification_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table student-accomodation-db.sas_pm_notification: ~2 rows (approximately)
DELETE FROM `sas_pm_notification`;
/*!40000 ALTER TABLE `sas_pm_notification` DISABLE KEYS */;
INSERT INTO `sas_pm_notification` (`notification_id`, `user_name`, `property_id`, `property_owner`, `added_date`) VALUES
	(1, 'TESTUSER', 1, 'admin01', '2017-01-13 10:53:00'),
	(2, 'TESTUSER', 2, 'TESTOWNR', '2017-01-13 10:53:01');
/*!40000 ALTER TABLE `sas_pm_notification` ENABLE KEYS */;


-- Dumping structure for table student-accomodation-db.sas_pm_property
CREATE TABLE IF NOT EXISTS `sas_pm_property` (
  `property_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `property_name` varchar(50) DEFAULT '0',
  `location` varchar(50) DEFAULT '0',
  `property_type` varchar(50) DEFAULT '0',
  `maximum_tenants` varchar(50) DEFAULT '0',
  `amount_rent` double DEFAULT '0',
  `user_name` varchar(10) DEFAULT '0',
  `status` varchar(10) DEFAULT '0',
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table student-accomodation-db.sas_pm_property: ~2 rows (approximately)
DELETE FROM `sas_pm_property`;
/*!40000 ALTER TABLE `sas_pm_property` DISABLE KEYS */;
INSERT INTO `sas_pm_property` (`property_id`, `property_name`, `location`, `property_type`, `maximum_tenants`, `amount_rent`, `user_name`, `status`, `added_date`) VALUES
	(1, 'Villa Sunrise', 'Gampaha', 'Appartment', '10', 25000, 'admin01', 'ACTIVE', '2017-01-11 00:58:38'),
	(2, 'VILLA LBC', 'Long Beach California', 'Apartment', '10', 10000, 'TESTOWNR', 'ACTIVE', '2017-01-13 10:53:30');
/*!40000 ALTER TABLE `sas_pm_property` ENABLE KEYS */;


-- Dumping structure for table student-accomodation-db.sas_um_user
CREATE TABLE IF NOT EXISTS `sas_um_user` (
  `user_name` varchar(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` binary(60) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `mobile_number` varchar(10) DEFAULT NULL,
  `user_type` varchar(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table student-accomodation-db.sas_um_user: ~3 rows (approximately)
DELETE FROM `sas_um_user`;
/*!40000 ALTER TABLE `sas_um_user` DISABLE KEYS */;
INSERT INTO `sas_um_user` (`user_name`, `name`, `password`, `email`, `address`, `mobile_number`, `user_type`, `status`, `added_date`) VALUES
	('admin01', 'admin01', _binary 0x243261243130246D593763625A764A6E45797847396E4E47316D65482E58446E7345674351775461646437776D6A614F6751644E7539727063752F79, 'admin123@test.com', NULL, '11111', 'student', 'ACTIVE', '2017-01-13 10:53:41'),
	('TESTOWNR', 'TESTOWNER', _binary 0x2432612431302471393256354A33426337636D464C5A667464426F484F6D456E727343705935662F564477456D5348752F4E73716970746264597769, 'testowner@gmail.com', NULL, '123456789', 'landowner', 'ACTIVE', '2017-01-13 10:53:42'),
	('TESTUSER', 'Test', _binary 0x24326124313024454F6D346B494C32352E6C744578354372654A36312E786E68464971742F4F56596E37784347787167787255424D6F776E6C4F6A53, 'testuser@gmail.com', NULL, '0777793725', 'student', 'ACTIVE', '2017-01-13 10:53:43'),
	('TESTUSR2', 'TESTUSER2', _binary 0x2432612431302448585378736474526D384B365555675046327856674F776F6D483376304937535458626A77683234444B577A565A4955436A6C7A32, 'testuser2@gmail.com', NULL, '123456789', 'student', 'ACTIVE', '2017-01-13 10:54:40');
/*!40000 ALTER TABLE `sas_um_user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
