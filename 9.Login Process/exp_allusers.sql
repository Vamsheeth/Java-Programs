-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.26-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.5.0.5276
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for exp
CREATE DATABASE IF NOT EXISTS `exp` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `exp`;

-- Dumping structure for table exp.allusers
CREATE TABLE IF NOT EXISTS `allusers` (
  `fname` varchar(10) DEFAULT NULL,
  `lname` varchar(30) DEFAULT NULL,
  `emailID` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `secretQuestion` varchar(30) DEFAULT NULL,
  `secretAnswer` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table exp.allusers: ~2 rows (approximately)
DELETE FROM `allusers`;
/*!40000 ALTER TABLE `allusers` DISABLE KEYS */;
INSERT INTO `allusers` (`fname`, `lname`, `emailID`, `password`, `dateOfBirth`, `username`, `secretQuestion`, `secretAnswer`) VALUES
	('Vamshi', '1234', 'v@m.c', 'Kennadyv@123', '2017-02-28', 'Vamshi', '1234', '1234');
/*!40000 ALTER TABLE `allusers` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
