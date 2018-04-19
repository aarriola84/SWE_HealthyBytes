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
-- Table structure for table `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredients` (
  `ingr_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `type` varchar(15) DEFAULT NULL,
  `nutrition_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ingr_id`),
  UNIQUE KEY `ingr_id_UNIQUE` (`ingr_id`),
  KEY `nutrition_id_idx` (`nutrition_id`),
  CONSTRAINT `nutrition_id` FOREIGN KEY (`nutrition_id`) REFERENCES `nutrition` (`nutrition_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredients`
--

LOCK TABLES `ingredients` WRITE;
/*!40000 ALTER TABLE `ingredients` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myrecipes`
--

DROP TABLE IF EXISTS `myrecipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `myrecipes` (
  `myrec_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `myrec_img` blob,
  `steps_id` int(11) NOT NULL,
  `ingr_list_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`myrec_id`),
  UNIQUE KEY `myrec_id_UNIQUE` (`myrec_id`),
  KEY `ingr_list_id_idx` (`ingr_list_id`),
  KEY `steps_id_idx` (`steps_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `ingr_list_id` FOREIGN KEY (`ingr_list_id`) REFERENCES `ingredientlist` (`ingr_list_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `steps_id` FOREIGN KEY (`steps_id`) REFERENCES `steps` (`step_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myrecipes`
--

LOCK TABLES `myrecipes` WRITE;
/*!40000 ALTER TABLE `myrecipes` DISABLE KEYS */;
/*!40000 ALTER TABLE `myrecipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nutrition`
--

DROP TABLE IF EXISTS `nutrition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nutrition` (
  `nutrition_id` int(11) NOT NULL AUTO_INCREMENT,
  `calories` smallint(6) DEFAULT NULL,
  `totalFat` smallint(6) DEFAULT NULL,
  `cholesterol` smallint(6) DEFAULT NULL,
  `sodium` smallint(6) DEFAULT NULL,
  `totalCarb` smallint(6) DEFAULT NULL,
  `dietaryFiber` smallint(6) DEFAULT NULL,
  `sugars` smallint(6) DEFAULT NULL,
  `vitaminA` smallint(6) DEFAULT NULL,
  `vitaminB` smallint(6) DEFAULT NULL,
  `vitaminC` smallint(6) DEFAULT NULL,
  `vitaminD` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`nutrition_id`),
  UNIQUE KEY `nutrition_id_UNIQUE` (`nutrition_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nutrition`
--

LOCK TABLES `nutrition` WRITE;
/*!40000 ALTER TABLE `nutrition` DISABLE KEYS */;
/*!40000 ALTER TABLE `nutrition` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proteintype`
--

LOCK TABLES `proteintype` WRITE;
/*!40000 ALTER TABLE `proteintype` DISABLE KEYS */;
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
  `rec_img` blob,
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
  `step1` tinytext NOT NULL,
  `step2` tinytext,
  `step3` tinytext,
  `step4` tinytext,
  `step5` tinytext,
  `step6` tinytext,
  `step7` tinytext,
  `step8` tinytext,
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
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'kaybee@gmail.com','pewpew123'),(2,'dagh123@gmail.com','powpow123');
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

-- Dump completed on 2018-04-19  7:46:52
