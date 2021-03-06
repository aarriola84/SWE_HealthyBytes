-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: healthybitesdb
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `ingredientlist`
--

DROP TABLE IF EXISTS `ingredientlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredientlist` (
  `ingr_list_id` int(11) NOT NULL AUTO_INCREMENT,
  `ingr_list` tinytext NOT NULL,
  PRIMARY KEY (`ingr_list_id`),
  UNIQUE KEY `ingr_list_id_UNIQUE` (`ingr_list_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientlist`
--

LOCK TABLES `ingredientlist` WRITE;
/*!40000 ALTER TABLE `ingredientlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingredientlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proteintype`
--

DROP TABLE IF EXISTS `proteintype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proteintype` (
  `proType_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  PRIMARY KEY (`proType_id`),
  UNIQUE KEY `proType_id_UNIQUE` (`proType_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proteintype`
--

LOCK TABLES `proteintype` WRITE;
/*!40000 ALTER TABLE `proteintype` DISABLE KEYS */;
INSERT INTO `proteintype` VALUES (1,'Chicken'),(2,'Beef'),(3,'Fish'),(4,'Lamb'),(5,'Vegan'),(6,'Other');
/*!40000 ALTER TABLE `proteintype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipes` (
  `recipe_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `fave_count` int(11) DEFAULT NULL,
  `rec_img` blob,
  `ownership_id` int(11) NOT NULL,
  `steps_id` int(11) NOT NULL,
  `ingr_list_id` int(11) NOT NULL,
  `protein_id` int(11) NOT NULL,
  PRIMARY KEY (`recipe_id`),
  UNIQUE KEY `recipe_id_UNIQUE` (`recipe_id`),
  KEY `ingr_list_id_idx` (`ingr_list_id`),
  KEY `steps_id_idx` (`steps_id`),
  KEY `rec_steps_id_idx` (`steps_id`),
  KEY `rec_ingr_list_id_idx` (`ingr_list_id`),
  KEY `protein_type_idx` (`protein_id`),
  KEY `ownership_id_idx` (`ownership_id`),
  CONSTRAINT `ownership_id` FOREIGN KEY (`ownership_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `protein_id` FOREIGN KEY (`protein_id`) REFERENCES `proteintype` (`proType_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rec_ingr_list_id` FOREIGN KEY (`ingr_list_id`) REFERENCES `ingredientlist` (`ingr_list_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rec_steps_id` FOREIGN KEY (`steps_id`) REFERENCES `steps` (`step_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `steps`
--

DROP TABLE IF EXISTS `steps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `steps` (
  `step_id` int(11) NOT NULL AUTO_INCREMENT,
  `steps` mediumtext NOT NULL,
  PRIMARY KEY (`step_id`),
  UNIQUE KEY `step_id_UNIQUE` (`step_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `steps`
--

LOCK TABLES `steps` WRITE;
/*!40000 ALTER TABLE `steps` DISABLE KEYS */;
/*!40000 ALTER TABLE `steps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(35) NOT NULL,
  `password` varchar(35) NOT NULL,
  `fName` varchar(15) NOT NULL,
  `lName` varchar(35) NOT NULL,
  `dob` date NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'kaybee@gmail.com','pewpew123','','','0000-00-00'),(2,'dagh123@gmail.com','powpow123','','','0000-00-00');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-24 19:33:30
