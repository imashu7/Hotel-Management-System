-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydab
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `bookingId` int NOT NULL AUTO_INCREMENT,
  `id` int NOT NULL,
  `UserID` int NOT NULL,
  `custName` varchar(45) NOT NULL,
  `custAge` varchar(45) NOT NULL,
  `custMobNo` bigint NOT NULL,
  `date` varchar(45) NOT NULL,
  `roomQuant` varchar(45) NOT NULL,
  PRIMARY KEY (`bookingId`),
  KEY `id_idx` (`id`),
  KEY `UserID_idx` (`UserID`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `hoteldetails` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UserID` FOREIGN KEY (`UserID`) REFERENCES `login` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (5,18,4,'Rohan','45',8976543256,'2021-05-15','6'),(6,18,5,'Tushar','43',9431656415,'2021-05-16','7'),(7,18,4,'utkarsh','23',8051275643,'2021-05-20','4');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoteldetails`
--

DROP TABLE IF EXISTS `hoteldetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoteldetails` (
  `id` int NOT NULL AUTO_INCREMENT,
  `HotelName` varchar(45) NOT NULL,
  `HotelType` varchar(45) NOT NULL,
  `TotalRooms` varchar(45) NOT NULL,
  `AvailableRooms` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `HotelID_UNIQUE` (`id`),
  UNIQUE KEY `HotelName_UNIQUE` (`HotelName`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoteldetails`
--

LOCK TABLES `hoteldetails` WRITE;
/*!40000 ALTER TABLE `hoteldetails` DISABLE KEYS */;
INSERT INTO `hoteldetails` VALUES (3,'Hotel Taj','7 star','700','120'),(14,'Hotel Leela Palace','5 star','1500','120'),(15,'Hotel palace','3 star','800','200'),(18,'The great palace','7 star','1300','150'),(19,'holly','2 star','200','120');
/*!40000 ALTER TABLE `hoteldetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `UserID` int NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) NOT NULL,
  `PhoneNumber` bigint NOT NULL,
  `EmailID` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `UserName_UNIQUE` (`UserName`),
  UNIQUE KEY `PhoneNumber_UNIQUE` (`PhoneNumber`),
  UNIQUE KEY `EmailID_UNIQUE` (`EmailID`),
  UNIQUE KEY `Password_UNIQUE` (`Password`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'Ashutosh123',8051275533,'2017009782.ashutosh@ug.sharda.ac.in','Ashutosh@123'),(4,'Rahul',9987654432,'rahul@gmail.com','rahul@123'),(5,'Tushar',9431656415,'tushar@gmail.com','tushar@123'),(7,'Raman Thakur',9431656418,'raman@gmail.com','raman@123'),(8,'Rohit',9876543,'rohit@gmail.com','rohit@123'),(11,'Ashutosh Tha',8051275,'Ashutosh12','Ashutosh@1'),(12,'raja',67596523,'Raja123','raja@123'),(13,'jhygfd',7454678,'Ashutosh1','Ashutos');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-14 12:35:31
