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
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresses` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `address_type` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `complement` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `neighborhood` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `sap_client_id` varchar(255) DEFAULT NULL,
  `sap_sync_msg` varchar(255) DEFAULT NULL,
  `sap_sync_status` enum('ERROR','PENDING','SUCCESS') DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `client_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrf3c1s9gxxx0wubkv5maokv9y` (`client_id`),
  CONSTRAINT `FKrf3c1s9gxxx0wubkv5maokv9y` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',NULL),(2,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',6),(3,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',NULL),(4,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',8),(5,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',NULL),(6,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',9),(7,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',NULL),(8,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',10),(9,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',NULL),(10,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',11),(11,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',NULL),(12,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',12),(13,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',NULL),(14,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',13),(15,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',NULL),(16,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',14),(17,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',NULL),(18,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',15),(19,_binary '','123 Main St','Home','New York','Apt 4','Admin','','Manhattan','101','SAP001','Synced successfully','SUCCESS','NY','10001',NULL),(23,_binary '','999 Main St','Home','New York','Apt 9','Admin','','Manhattan','999','SAP001','Synced successfully','SUCCESS','NY','10001',16);
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
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
