-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: id18532788_music_player
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `music_theme`
--

DROP TABLE IF EXISTS `music_theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `music_theme` (
  `theme_id` bigint NOT NULL AUTO_INCREMENT,
  `theme_image` varchar(255) DEFAULT NULL,
  `theme_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`theme_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music_theme`
--

LOCK TABLES `music_theme` WRITE;
/*!40000 ALTER TABLE `music_theme` DISABLE KEYS */;
INSERT INTO `music_theme` VALUES (1,'Tình Yêu','https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/chu-de-tinh-yeu.jpg'),(2,'Indie','https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/chu-de-indie.jpg'),(3,'Chill','https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/theme-chill-lofi-mFace.jpg'),(4,'Nhạc Việt','https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/theme-nhac-Viet.png'),(5,'Acoustic','https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/theme-accoustic.jpg'),(6,'EDM','https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/theme-EDM.jpg'),(7,'Nhạc Âu Mỹ','https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/theme-US-UK.jpg');
/*!40000 ALTER TABLE `music_theme` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-20 21:46:53
