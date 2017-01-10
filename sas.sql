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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table student-accomodation-db.sas_pm_fee: ~0 rows (approximately)
DELETE FROM `sas_pm_fee`;
/*!40000 ALTER TABLE `sas_pm_fee` DISABLE KEYS */;
/*!40000 ALTER TABLE `sas_pm_fee` ENABLE KEYS */;


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
  `added_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table student-accomodation-db.sas_pm_property: ~0 rows (approximately)
DELETE FROM `sas_pm_property`;
/*!40000 ALTER TABLE `sas_pm_property` DISABLE KEYS */;
/*!40000 ALTER TABLE `sas_pm_property` ENABLE KEYS */;


-- Dumping structure for table student-accomodation-db.sas_um_user
CREATE TABLE IF NOT EXISTS `sas_um_user` (
  `user_name` varchar(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` binary(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `mobile_number` varchar(10) DEFAULT NULL,
  `user_type` varchar(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `added_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table student-accomodation-db.sas_um_user: ~1 rows (approximately)
DELETE FROM `sas_um_user`;
/*!40000 ALTER TABLE `sas_um_user` DISABLE KEYS */;
INSERT INTO `sas_um_user` (`user_name`, `name`, `password`, `email`, `address`, `mobile_number`, `user_type`, `status`, `added_date`) VALUES
	('Lahiru', 'Lahiru', _binary 0x3132333435000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 'lahiru@gmail.com', NULL, '0777776030', 'Student', 'ACTIVE', '2017-01-10 11:44:49');
/*!40000 ALTER TABLE `sas_um_user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
