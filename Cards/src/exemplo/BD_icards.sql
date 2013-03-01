-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.30 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2013-02-26 23:06:57
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for icards
DROP DATABASE IF EXISTS `icards`;
CREATE DATABASE IF NOT EXISTS `icards` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `icards`;


-- Dumping structure for table icards.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `nome` varchar(50) NOT NULL,
  `cpf` int(11) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `senha` varchar(10) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `telefone` int(12) NOT NULL,
  `data` varchar(10) NOT NULL,
  `nacionalidade` varchar(20) NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
