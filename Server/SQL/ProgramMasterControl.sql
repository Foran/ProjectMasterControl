-- MySQL dump 10.13  Distrib 5.1.63, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ProgramMasterControl
-- ------------------------------------------------------
-- Server version	5.1.63-0ubuntu0.10.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pmc_Comments`
--

DROP TABLE IF EXISTS `pmc_Comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pmc_Comments` (
  `Comment_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `User_ID` bigint(20) unsigned NOT NULL,
  `Comment` longtext NOT NULL,
  PRIMARY KEY (`Comment_ID`),
  KEY `User_ID` (`User_ID`),
  CONSTRAINT `pmc_Comments_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `pmc_Users` (`User_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pmc_Comments`
--

LOCK TABLES `pmc_Comments` WRITE;
/*!40000 ALTER TABLE `pmc_Comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `pmc_Comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pmc_Companies`
--

DROP TABLE IF EXISTS `pmc_Companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pmc_Companies` (
  `Company_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Description` longtext NOT NULL,
  PRIMARY KEY (`Company_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pmc_Companies`
--

LOCK TABLES `pmc_Companies` WRITE;
/*!40000 ALTER TABLE `pmc_Companies` DISABLE KEYS */;
/*!40000 ALTER TABLE `pmc_Companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pmc_Email_Addresses`
--

DROP TABLE IF EXISTS `pmc_Email_Addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pmc_Email_Addresses` (
  `Email_Address_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Email` varchar(255) NOT NULL,
  `Type` enum('Home','Work','Unknown') DEFAULT 'Unknown',
  `Description` longtext NOT NULL,
  `EmailVerified` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`Email_Address_ID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pmc_Email_Addresses`
--

LOCK TABLES `pmc_Email_Addresses` WRITE;
/*!40000 ALTER TABLE `pmc_Email_Addresses` DISABLE KEYS */;
/*!40000 ALTER TABLE `pmc_Email_Addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pmc_People`
--

DROP TABLE IF EXISTS `pmc_People`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pmc_People` (
  `Person_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(255) NOT NULL,
  `Middle_Name` varchar(255) DEFAULT NULL,
  `Last_Name` varchar(255) NOT NULL,
  `Description` longtext NOT NULL,
  PRIMARY KEY (`Person_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pmc_People`
--

LOCK TABLES `pmc_People` WRITE;
/*!40000 ALTER TABLE `pmc_People` DISABLE KEYS */;
/*!40000 ALTER TABLE `pmc_People` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pmc_Phone_Numbers`
--

DROP TABLE IF EXISTS `pmc_Phone_Numbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pmc_Phone_Numbers` (
  `Phone_Number_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Phone` varchar(255) NOT NULL,
  `Type` enum('Home','Work','Mobile','Fax','Unknown') DEFAULT 'Unknown',
  `Description` longtext NOT NULL,
  PRIMARY KEY (`Phone_Number_ID`),
  UNIQUE KEY `Phone` (`Phone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pmc_Phone_Numbers`
--

LOCK TABLES `pmc_Phone_Numbers` WRITE;
/*!40000 ALTER TABLE `pmc_Phone_Numbers` DISABLE KEYS */;
/*!40000 ALTER TABLE `pmc_Phone_Numbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pmc_Projects`
--

DROP TABLE IF EXISTS `pmc_Projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pmc_Projects` (
  `Project_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  PRIMARY KEY (`Project_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pmc_Projects`
--

LOCK TABLES `pmc_Projects` WRITE;
/*!40000 ALTER TABLE `pmc_Projects` DISABLE KEYS */;
/*!40000 ALTER TABLE `pmc_Projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pmc_Requirements`
--

DROP TABLE IF EXISTS `pmc_Requirements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pmc_Requirements` (
  `Requirement_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Parent_ID` bigint(20) unsigned DEFAULT NULL,
  `Project_ID` bigint(20) unsigned NOT NULL,
  `Title` varchar(255) NOT NULL,
  `IsFunctional` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `Type` enum('Business','Technical','Test') NOT NULL,
  `Description` longtext NOT NULL,
  PRIMARY KEY (`Requirement_ID`),
  UNIQUE KEY `Project_ID` (`Project_ID`,`Title`),
  KEY `Parent_ID` (`Parent_ID`),
  CONSTRAINT `pmc_Requirements_ibfk_1` FOREIGN KEY (`Parent_ID`) REFERENCES `pmc_Requirements` (`Requirement_ID`) ON UPDATE CASCADE,
  CONSTRAINT `pmc_Requirements_ibfk_2` FOREIGN KEY (`Project_ID`) REFERENCES `pmc_Projects` (`Project_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pmc_Requirements`
--

LOCK TABLES `pmc_Requirements` WRITE;
/*!40000 ALTER TABLE `pmc_Requirements` DISABLE KEYS */;
/*!40000 ALTER TABLE `pmc_Requirements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pmc_Stories`
--

DROP TABLE IF EXISTS `pmc_Stories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pmc_Stories` (
  `Story_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Project_ID` bigint(20) unsigned NOT NULL,
  `Title` varchar(255) NOT NULL,
  `Description` longtext NOT NULL,
  PRIMARY KEY (`Story_ID`),
  UNIQUE KEY `Project_ID` (`Project_ID`,`Title`),
  CONSTRAINT `pmc_Stories_ibfk_1` FOREIGN KEY (`Project_ID`) REFERENCES `pmc_Projects` (`Project_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pmc_Stories`
--

LOCK TABLES `pmc_Stories` WRITE;
/*!40000 ALTER TABLE `pmc_Stories` DISABLE KEYS */;
/*!40000 ALTER TABLE `pmc_Stories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pmc_Users`
--

DROP TABLE IF EXISTS `pmc_Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pmc_Users` (
  `User_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) DEFAULT NULL,
  `Email_Address_ID` bigint(20) unsigned NOT NULL,
  `Person_ID` bigint(20) unsigned NOT NULL,
  `Project_ID` bigint(20) unsigned NOT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `EmailVerified` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`User_ID`),
  UNIQUE KEY `Email_Address_ID` (`Email_Address_ID`),
  UNIQUE KEY `Person_ID` (`Person_ID`),
  UNIQUE KEY `Username` (`Username`),
  CONSTRAINT `pmc_Users_ibfk_1` FOREIGN KEY (`Email_Address_ID`) REFERENCES `pmc_Email_Addresses` (`Email_Address_ID`) ON UPDATE CASCADE,
  CONSTRAINT `pmc_Users_ibfk_2` FOREIGN KEY (`Person_ID`) REFERENCES `pmc_People` (`Person_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pmc_Users`
--

LOCK TABLES `pmc_Users` WRITE;
/*!40000 ALTER TABLE `pmc_Users` DISABLE KEYS */;
/*!40000 ALTER TABLE `pmc_Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-03 21:24:06
