-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: client
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `doc_number` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `email_opt_in` bit(1) DEFAULT NULL,
  `is_blocked` bit(1) DEFAULT NULL,
  `is_employee` bit(1) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `municipal_inscription` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `push_opt_in` bit(1) DEFAULT NULL,
  `sms_opt_in` bit(1) DEFAULT NULL,
  `state_inscription` varchar(255) DEFAULT NULL,
  `whatsapp_opt_in` bit(1) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsrv16ica2c1csub334bxjjb59` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (3,'Eyke','2024-10-20 20:53:22','07777777777','guilherme@gmail.com',_binary '',_binary '\0',_binary '\0','','2024-10-20 21:43:10','Ponte','Guilherme M','98912343456',_binary '\0',_binary '\0','PE',_binary '','2001-10-18'),(5,'Admin','2024-10-20 21:43:51','77777755555','alexc@gmail.com',_binary '',_binary '\0',_binary '\0','','2024-10-20 21:43:51','Ponte','Alexandre C','98985543552',_binary '\0',_binary '\0','MA',_binary '','2002-02-12'),(6,'Admin','2024-10-20 21:51:38','12311910234','rafavex@gmail.com',_binary '',_binary '\0',_binary '\0','Admin','2024-10-20 21:51:38','Ponte','Rafael Vex','556985566552',_binary '\0',_binary '\0','RJ',_binary '','1997-10-20'),(8,'Admin','2024-10-21 01:08:10','45611910234','píetrobraga@gmail.com',_binary '',_binary '\0',_binary '\0','Admin','2024-10-21 01:08:10','Ponte','Pietro Braga','556985566552',_binary '\0',_binary '\0','RJ',_binary '','1997-10-20'),(9,'Admin','2024-10-21 01:08:31','78911910234','carlosaberto@gmail.com',_binary '',_binary '\0',_binary '\0','Admin','2024-10-21 01:08:31','Ponte','Carlos Alberto','556985566552',_binary '\0',_binary '\0','RJ',_binary '','1997-10-20'),(10,'Admin','2024-10-21 01:08:49','12111910234','rodrigofaro@gmail.com',_binary '',_binary '\0',_binary '\0','Admin','2024-10-21 01:08:49','Ponte','Rodrigo Faro','556985566552',_binary '\0',_binary '\0','RJ',_binary '','1997-10-20'),(11,'Admin','2024-10-21 01:09:03','13111910234','ymt12@gmail.com',_binary '',_binary '\0',_binary '\0','Admin','2024-10-21 01:09:03','Ponte','Yan Matheus','556985566552',_binary '\0',_binary '\0','RJ',_binary '','1997-10-20'),(12,'Admin','2024-10-21 01:09:16','14111910234','lulujose@gmail.com',_binary '',_binary '\0',_binary '\0','Admin','2024-10-21 01:09:16','Ponte','Lucas José','556985566552',_binary '\0',_binary '\0','RJ',_binary '','1997-10-20'),(13,'Admin','2024-10-21 01:09:35','15111910234','gecarlos@gmail.com',_binary '',_binary '\0',_binary '\0','Admin','2024-10-21 01:09:35','Ponte','Genivaldo Carlos','556985566552',_binary '\0',_binary '\0','RJ',_binary '','1997-10-20'),(14,'Admin','2024-10-21 01:15:32','51611910234','sumare@gmail.com',_binary '',_binary '\0',_binary '\0','Admin','2024-10-21 01:15:32','Ponte','Carlos Sumare','556985566552',_binary '\0',_binary '\0','RJ',_binary '','1997-10-20'),(15,'Admin','2024-10-21 01:16:25','99911910234','jvvc13@gmail.com',_binary '',_binary '\0',_binary '\0','Admin','2024-10-21 01:16:25','Ponte','João Carlos','556985566552',_binary '\0',_binary '\0','RJ',_binary '','1997-10-20'),(16,'Admin','2024-10-21 01:24:07','88911910299','daniel13@gmail.com',_binary '',_binary '\0',_binary '\0','Admin','2024-10-21 01:26:14','Ponte','Daniel Abreu','556985566552',_binary '\0',_binary '\0','MA',_binary '','1997-10-20');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-21 13:18:46
