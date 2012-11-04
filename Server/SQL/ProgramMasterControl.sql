CREATE DATABASE  IF NOT EXISTS ProgramMasterControl;
USE ProgramMasterControl;

DROP TABLE IF EXISTS pmc_Companies;
CREATE TABLE pmc_Companies (
  Company_ID BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  Name VARCHAR(255) NOT NULL,
  Description LONGTEXT NOT NULL,
  PRIMARY KEY (Company_ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS pmc_People;
CREATE TABLE pmc_People (
  Person_ID BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  First_Name VARCHAR(255) NOT NULL,
  Middle_Name VARCHAR(255) DEFAULT NULL,
  Last_Name VARCHAR(255) NOT NULL,
  Description LONGTEXT NOT NULL,
  PRIMARY KEY (Person_ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS pmc_Email_Addresses;
CREATE TABLE pmc_Email_Addresses (
  Email_Address_ID BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  Email VARCHAR(255) NOT NULL,
  `Type` ENUM('Home', 'Work', 'Unknown') DEFAULT 'Unknown',
  Description LONGTEXT NOT NULL,
  EmailVerified TINYINT(1) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY (Email_Address_ID),
  UNIQUE KEY Email (Email)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS pmc_Phone_Numbers;
CREATE TABLE pmc_Phone_Numbers (
  Phone_Number_ID BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  Phone VARCHAR(255) NOT NULL,
  `Type` ENUM('Home', 'Work', 'Mobile', 'Fax', 'Unknown') DEFAULT 'Unknown',
  Description LONGTEXT NOT NULL,
  PRIMARY KEY (Phone_Number_ID),
  UNIQUE KEY Phone (Phone)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS pmc_Projects;
CREATE TABLE pmc_Projects (
  Project_ID BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  Title VARCHAR(255) NOT NULL,
  PRIMARY KEY (Project_ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS pmc_Stories;
CREATE TABLE pmc_Stories (
  Story_ID BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  Project_ID BIGINT(20) UNSIGNED NOT NULL,
  Title VARCHAR(255) NOT NULL,
  Description LONGTEXT NOT NULL,
  PRIMARY KEY (Story_ID),
  UNIQUE KEY Project_ID (Project_ID, Title),
  CONSTRAINT pmc_Stories_ibfk_1 FOREIGN KEY (Project_ID) REFERENCES pmc_Projects (Project_ID) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS pmc_Users;
CREATE TABLE pmc_Users (
  User_ID BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  Username VARCHAR(255) DEFAULT NULL,
  Email_Address_ID BIGINT(20) UNSIGNED NOT NULL,
  Project_ID BIGINT(20) UNSIGNED NOT NULL,
  Password VARCHAR(255) DEFAULT NULL,
  EmailVerified TINYINT(1) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY (User_ID),
  UNIQUE KEY Email_Address_ID (Email_Address_ID),
  UNIQUE KEY Person_ID (Person_ID),
  UNIQUE KEY Username (Username),
  CONSTRAINT pmc_Users_ibfk_1 FOREIGN KEY (Email_Address_ID) REFERENCES pmc_Email_Addresses (Email_Address_ID) ON UPDATE CASCADE,
  CONSTRAINT pmc_Users_ibfk_2 FOREIGN KEY (Person_ID) REFERENCES pmc_People (Person_ID) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS pmc_Comments;
CREATE TABLE `pmc_Comments` (
  Comment_ID BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  User_ID BIGINT(20) UNSIGNED NOT NULL,
  Comment LONGTEXT NOT NULL,
  PRIMARY KEY (Comment_ID),
  KEY User_ID (User_ID),
  CONSTRAINT pmc_Comments_ibfk_1 FOREIGN KEY (User_ID) REFERENCES pmc_Users (User_ID) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS pmc_Requirements;
CREATE TABLE pmc_Requirements (
  Requirement_ID BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  Parent_ID BIGINT(20) UNSIGNED DEFAULT NULL,
  Project_ID BIGINT(20) UNSIGNED NOT NULL,
  Title VARCHAR(255) NOT NULL,
  IsFunctional TINYINT(1) UNSIGNED NOT NULL DEFAULT '1',
  Type ENUM('Business', 'Technical', 'Test') NOT NULL,
  Description LONGTEXT NOT NULL,
  PRIMARY KEY (Requirement_ID),
  UNIQUE KEY Project_ID (Project_ID, Title),
  KEY Parent_ID (Parent_ID),
  CONSTRAINT pmc_Requirements_ibfk_1 FOREIGN KEY (Parent_ID) REFERENCES pmc_Requirements (Requirement_ID) ON UPDATE CASCADE,
  CONSTRAINT pmc_Requirements_ibfk_2 FOREIGN KEY (Project_ID) REFERENCES pmc_Projects (Project_ID) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
