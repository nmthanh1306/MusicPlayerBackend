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
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song` (
  `song_id` bigint NOT NULL AUTO_INCREMENT,
  `album_id` varchar(255) DEFAULT NULL,
  `favourite` int DEFAULT NULL,
  `link_song` varchar(255) DEFAULT NULL,
  `playlist_id` varchar(255) DEFAULT NULL,
  `singer` varchar(255) DEFAULT NULL,
  `song_image` varchar(255) DEFAULT NULL,
  `song_name` varchar(255) DEFAULT NULL,
  `type_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` VALUES (1,'1',0,'1,2,5','https://sp22-music-player.000webhostapp.com/Image/Song/mtp500x500.jpg','Lạc Trôi','Sơn Tùng M-TP','https://sp22-music-player.000webhostapp.com/Music/lac-troi.mp3','1'),(2,'0',1,'4,5','https://sp22-music-player.000webhostapp.com/Image/Song/kissing_lessons.jpg','Kissing Lessons','Lucy Dacus','https://sp22-music-player.000webhostapp.com/Music/kissing_lessons.mp3','2'),(3,'0',1,'4,5','https://sp22-music-player.000webhostapp.com/Image/Song/stay.jpg','STAY','The Kid LAROI, Justin Bieber','https://sp22-music-player.000webhostapp.com/Music/stay.mp3','1'),(4,'0',2,'1,2','https://sp22-music-player.000webhostapp.com/Image/Song/nguoi-toi-yeu-lanh-lung-sat-da.jpg','Người Tôi Yêu Lạnh Lùng Sắt Đá','Mr.Siro','https://sp22-music-player.000webhostapp.com/Music/nguoi-toi-yeu-lanh-lung-sat-da.mp3','0'),(5,'1',5,'1','https://sp22-music-player.000webhostapp.com/Image/Song/HayTraoChoAnh-SonTungMTPSnoopDogg.jpg','Hãy Trao Cho Anh','Sơn Tùng M-TP, SnoopDogg','https://sp22-music-player.000webhostapp.com/Music/HayTraoChoAnh-SonTungMTPSnoopDogg.mp3','0'),(6,'1',2,'1,2','https://sp22-music-player.000webhostapp.com/Image/Song/MuonRoiMaSaoCon-SonTungMTP-7011803.jpg','Muộn Rồi Mà Sao Còn','Sơn Tùng M-TP','https://sp22-music-player.000webhostapp.com/Music/MuonRoiMaSaoCon-SonTungMTP-7011803.mp3','0'),(7,'1',0,'0','https://sp22-music-player.000webhostapp.com/Image/Song/AnNutNhoThaGiacMo-SonTungMTP-4009508.jpg','Ấn Nút Nhớ Thả Giấc Mơ','Sơn Tùng M-TP','https://sp22-music-player.000webhostapp.com/Music/AnNutNhoThaGiacMo-SonTungMTP-4009508.mp3','0'),(8,'1',0,'0','https://sp22-music-player.000webhostapp.com/Image/Song/lamnguoiluonyeuem.jpg','Làm Người Luôn Yêu Em','Sơn Tùng M-TP','https://sp22-music-player.000webhostapp.com/Music/LamNguoiLuonYeuEm-M-TP_3sp5y.mp3','0'),(9,'0',5,'1,2','https://sp22-music-player.000webhostapp.com/Image/Song/ngay-dau-tien500x500.jpg','Ngày Đầu Tiên','Đức Phúc','https://sp22-music-player.000webhostapp.com/Music/NgayDauTien-DucPhuc-7129810.mp3','0'),(10,'5',5,'1,2','https://sp22-music-player.000webhostapp.com/Image/Song/Chay-Ve-Khoc-Voi-Anh-ERIK.jpg','Chạy Về Khóc Với Anh','ERIK','https://sp22-music-player.000webhostapp.com/Music/Chay-Ve-Khoc-Voi-Anh-ERIK.mp3','0'),(11,'3',1,'1,3','https://sp22-music-player.000webhostapp.com/Image/Song/binz/bigcitiboiz.jpg','Bigcityboi','Binz, Touliver','https://sp22-music-player.000webhostapp.com/Music/bigcityboiz.mp3','0'),(12,'3',0,'3','https://sp22-music-player.000webhostapp.com/Image/Song/binz/ok.jpg','OK','Binz','https://sp22-music-player.000webhostapp.com/Music/OK.mp3','0'),(13,'3',0,'3','https://sp22-music-player.000webhostapp.com/Image/Song/binz/blackjack.jpg','BlackJack','Soobin, Binz','https://sp22-music-player.000webhostapp.com/Music/blackjack.mp3','0'),(14,'3',2,'3','https://sp22-music-player.000webhostapp.com/Image/Song/binz/Phia-Sau-Em-Kay-Tran-Binz.jpg','Phía Sau Em','Kay Trần, Binz','https://sp22-music-player.000webhostapp.com/Music/Phia-Sau-Em-Kay-Tran-Binz.mp3','0'),(15,'3',1,'3,1','https://sp22-music-player.000webhostapp.com/Image/Song/binz/SOFAR-Binz.jpg','SOFAR','Binz','https://sp22-music-player.000webhostapp.com/Music/SOFAR-Binz.mp3','0'),(16,'3',0,'3','https://sp22-music-player.000webhostapp.com/Image/Song/binz/They-Said-Touliver-Binz.jpg','They Said','Binz','https://sp22-music-player.000webhostapp.com/Music/They-Said-Touliver-Binz.mp3','0'),(17,'3',0,'3','https://sp22-music-player.000webhostapp.com/Image/Song/binz/Krazy-Touliver-Binz-Andree-Evy.jpg','Krazy','Touliver, Binz, Andree, Evy','https://sp22-music-player.000webhostapp.com/Music/Krazy-Touliver-Binz-Andree-Evy.mp3','0');
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-20 21:46:52
