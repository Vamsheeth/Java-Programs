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


-- Dumping database structure for student
CREATE DATABASE IF NOT EXISTS `student` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `student`;

-- Dumping structure for table student.student
CREATE TABLE IF NOT EXISTS `student` (
  `FirstName` varchar(50) NOT NULL,
  `MiddleName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) NOT NULL,
  `Date` int(2) NOT NULL,
  `Month` int(15) NOT NULL,
  `Year` int(5) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `City` varchar(50) NOT NULL,
  `State` varchar(50) NOT NULL,
  `PinCode` int(6) NOT NULL,
  `AdharNumber` varchar(12) NOT NULL,
  `EmailId` varchar(100) NOT NULL,
  `StudentMobileNumber` varchar(10) NOT NULL,
  `FatherMobileNumber` varchar(10) NOT NULL,
  `MotherMobileNumber` varchar(10) NOT NULL,
  `Major` varchar(50) NOT NULL,
  `Minor` varchar(100) NOT NULL,
  PRIMARY KEY (`AdharNumber`),
  UNIQUE KEY `AdharNumber` (`AdharNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table student.student: ~3 rows (approximately)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`FirstName`, `MiddleName`, `LastName`, `Date`, `Month`, `Year`, `Address`, `City`, `State`, `PinCode`, `AdharNumber`, `EmailId`, `StudentMobileNumber`, `FatherMobileNumber`, `MotherMobileNumber`, `Major`, `Minor`) VALUES
	('firsttest', ' m', 'm', 1, 1, 2011, 'n', 'n', 'n', 555555, '777777777777', 'hh@b', '2222222222', '3333333333', '6666666666', 'Physics', 'Chemistry Maths '),
	('Sathvik', '', 'Kampati', 7, 12, 1997, 'NIIT UNIVERSITY', 'ALWAR', 'RAJASTHAN', 301705, '888888888888', 'sathvik.kampati@gmail.com', '9001694292', '9848572199', '9069019099', 'Chemistry', 'Chemistry English '),
	('rev', 'afas', 'ggw', 1, 5, 2017, 'dsfds', 'sgd', 'sdg', 987765, '98765432108', 'sdfhgas@gmail.com', '4444444444', '9876432456', '7776756575', 'Maths', 'Physics Chemistry ');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
