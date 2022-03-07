-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 04, 2022 at 10:20 AM
-- Server version: 10.5.12-MariaDB
-- PHP Version: 7.3.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id18532788_music_player`
--
DROP DATABASE IF EXISTS `id18532788_music_player`;
CREATE DATABASE IF NOT EXISTS `id18532788_music_player` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id18532788_music_player`;

-- --------------------------------------------------------

--
-- Table structure for table `advertisement`
--
-- Creation: Mar 03, 2022 at 02:31 PM
--

DROP TABLE IF EXISTS `advertisement`;
CREATE TABLE `advertisement` (
  `advertisement_id` bigint NOT NULL,
  `song_id` bigint(255) COLLATE utf8_unicode_ci NOT NULL,
  `advertisement_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `advertisement_content` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `advertisement`
--

INSERT INTO `advertisement` (`advertisement_id`, `song_id`, `advertisement_image`, `advertisement_content`) VALUES
(1, 4, 'https://sp22-music-player.000webhostapp.com/Image/Advertisement/ads-nguoi-toi-yeu-lanh-lung.jpg', 'Giai điệu mang đậm chất của Mr.Siro'),
(2, 9, 'https://sp22-music-player.000webhostapp.com/Image/Advertisement/ads-ngay-dau-tien-duc-phuc-700.jpg', 'Cùng với giọng ca của Đức Phúc và giai điệu lãng mạn'),
(3, 10, 'https://sp22-music-player.000webhostapp.com/Image/Advertisement/ads-chay-ve-khoc-voi-anh.jpg', '');

-- --------------------------------------------------------

--
-- Table structure for table `album`
--
-- Creation: Mar 03, 2022 at 02:31 PM
--

DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `album_id` bigint NOT NULL,
  `album_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `album_singer` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `album_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `album`
--

INSERT INTO `album` (`album_id`, `album_name`, `album_singer`, `album_image`) VALUES
(1, 'Những bài hát hay của Sơn Tùng M-TP', 'Sơn Tùng M-TP', 'https://sp22-music-player.000webhostapp.com/Image/Album/album-son-tung.jpg'),
(2, 'Nghe Gì Cùng Amee ?', 'AMEE', 'https://sp22-music-player.000webhostapp.com/Image/Album/album-AMEE.jpg'),
(3, 'Những bài hát hay nhất của Binz', 'Binz', 'https://sp22-music-player.000webhostapp.com/Image/Album/album-binz.jpg'),
(4, 'Hát cùng Chi Pu', 'Chi Pu', 'https://sp22-music-player.000webhostapp.com/Image/Album/album-Chipu.jpg'),
(5, 'Những bài hát hay nhất của ERIK', 'ERIK', 'https://sp22-music-player.000webhostapp.com/Image/Album/album-erik.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `music_theme`
--
-- Creation: Mar 03, 2022 at 02:31 PM
--

DROP TABLE IF EXISTS `music_theme`;
CREATE TABLE `music_theme` (
  `theme_id` bigint NOT NULL,
  `theme_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `theme_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `music_theme`
--

INSERT INTO `music_theme` (`theme_id`, `theme_name`, `theme_image`) VALUES
(1, 'Tình Yêu', 'https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/chu-de-tinh-yeu.jpg'),
(2, 'Indie', 'https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/chu-de-indie.jpg'),
(3, 'Chill', 'https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/theme-chill-lofi-mFace.jpg'),
(4, 'Nhạc Việt', 'https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/theme-nhac-Viet.png'),
(5, 'Acoustic', 'https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/theme-accoustic.jpg'),
(6, 'EDM', 'https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/theme-EDM.jpg'),
(7, 'Nhạc Âu Mỹ', 'https://sp22-music-player.000webhostapp.com/Image/Music%20Theme/theme-US-UK.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `playlist`
--
-- Creation: Mar 03, 2022 at 02:31 PM
--

DROP TABLE IF EXISTS `playlist`;
CREATE TABLE `playlist` (
  `playlist_id` bigint NOT NULL,
  `playlist_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `playlist_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `playlist_icon` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `playlist`
--

INSERT INTO `playlist` (`playlist_id`, `playlist_name`, `playlist_image`, `playlist_icon`) VALUES
(1, 'Top 100 Nhạc V-Pop', 'https://sp22-music-player.000webhostapp.com/Image/Playlist/playlist-background-Vpop.jpg', 'https://sp22-music-player.000webhostapp.com/Image/Playlist/top100-vpop.jpg'),
(2, 'Top 100 Bài Nhạc Trẻ Hay Nhất', 'https://sp22-music-player.000webhostapp.com/Image/Playlist/playplist-nhac-tre.jpg', 'https://sp22-music-player.000webhostapp.com/Image/Playlist/playlist-top100nhacviet.jpg'),
(3, 'Top 100 nhạc Rap Việt Nam', 'https://sp22-music-player.000webhostapp.com/Image/Playlist/playlist%20-background-Rap-tai-Viet-Nam.jpg', 'https://sp22-music-player.000webhostapp.com/Image/Playlist/top-icon-rap.jpg'),
(4, 'Top 100 Nhạc Âu Mỹ', 'https://sp22-music-player.000webhostapp.com/Image/Playlist/hot-us-uk.jpg', 'https://sp22-music-player.000webhostapp.com/Image/Playlist/top100-pop-au-my.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `song`
--
-- Creation: Mar 03, 2022 at 02:31 PM
--

DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `song_id` bigint NOT NULL,
  `album_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `playlist_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `song_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `song_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `singer` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `link_song` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `favourite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `song`
--

INSERT INTO `song` (`song_id`, `album_id`, `type_id`, `playlist_id`, `song_image`, `song_name`, `singer`, `link_song`, `favourite`) VALUES
(1, '1', '0', '1,2', 'https://sp22-music-player.000webhostapp.com/Image/Song/mtp500x500.jpg', 'Lạc Trôi', 'Sơn Tùng M-TP', 'https://sp22-music-player.000webhostapp.com/Music/lac-troi.mp3', 0),
(2, '0', '1', '4', 'https://sp22-music-player.000webhostapp.com/Image/Song/kissing_lessons.jpg', 'Kissing Lessons', 'Lucy Dacus', 'https://sp22-music-player.000webhostapp.com/Music/kissing_lessons.mp3', 0),
(3, '0', '1', '4', 'https://sp22-music-player.000webhostapp.com/Image/Song/stay.jpg', 'STAY', 'The Kid LAROI, Justin Bieber', 'https://sp22-music-player.000webhostapp.com/Music/stay.mp3', 0),
(4, '0', '2,5', '1,2', 'https://sp22-music-player.000webhostapp.com/Image/Song/nguoi-toi-yeu-lanh-lung-sat-da.jpg', 'Người Tôi Yêu Lạnh Lùng Sắt Đá', 'Mr.Siro', 'https://sp22-music-player.000webhostapp.com/Music/nguoi-toi-yeu-lanh-lung-sat-da.mp3', 0),
(5, '1', '5', '1', 'https://sp22-music-player.000webhostapp.com/Image/Song/HayTraoChoAnh-SonTungMTPSnoopDogg.jpg', 'Hãy Trao Cho Anh', 'Sơn Tùng M-TP, SnoopDogg', 'https://sp22-music-player.000webhostapp.com/Music/HayTraoChoAnh-SonTungMTPSnoopDogg.mp3', 0),
(6, '1', '2,5', '1,2', 'https://sp22-music-player.000webhostapp.com/Image/Song/MuonRoiMaSaoCon-SonTungMTP-7011803.jpg', 'Muộn Rồi Mà Sao Còn', 'Sơn Tùng M-TP', 'https://sp22-music-player.000webhostapp.com/Music/MuonRoiMaSaoCon-SonTungMTP-7011803.mp3', 0),
(7, '1', '0', '0', 'https://sp22-music-player.000webhostapp.com/Image/Song/AnNutNhoThaGiacMo-SonTungMTP-4009508.jpg', 'Ấn Nút Nhớ Thả Giấc Mơ', 'Sơn Tùng M-TP', 'https://sp22-music-player.000webhostapp.com/Music/AnNutNhoThaGiacMo-SonTungMTP-4009508.mp3', 0),
(8, '1', '0', '0', 'https://sp22-music-player.000webhostapp.com/Image/Song/lamnguoiluonyeuem.jpg', 'Làm Người Luôn Yêu Em', 'Sơn Tùng M-TP', 'https://sp22-music-player.000webhostapp.com/Music/LamNguoiLuonYeuEm-M-TP_3sp5y.mp3', 0),
(9, '0', '5', '1,2', 'https://sp22-music-player.000webhostapp.com/Image/Song/ngay-dau-tien500x500.jpg', 'Ngày Đầu Tiên', 'Đức Phúc', 'https://sp22-music-player.000webhostapp.com/Music/NgayDauTien-DucPhuc-7129810.mp3', 0),
(10, '5', '5', '1,2', 'https://sp22-music-player.000webhostapp.com/Image/Song/Chay-Ve-Khoc-Voi-Anh-ERIK.jpg', 'Chạy Về Khóc Với Anh', 'ERIK', 'https://sp22-music-player.000webhostapp.com/Music/Chay-Ve-Khoc-Voi-Anh-ERIK.mp3', 0),
(11, '3', '1,6', '1,3', 'https://sp22-music-player.000webhostapp.com/Image/Song/binz/bigcitiboiz.jpg', 'Bigcityboi', 'Binz, Touliver', 'https://sp22-music-player.000webhostapp.com/Music/bigcityboiz.mp3', 0),
(12, '3', '0', '3', 'https://sp22-music-player.000webhostapp.com/Image/Song/binz/ok.jpg', 'OK', 'Binz', 'https://sp22-music-player.000webhostapp.com/Music/OK.mp3', 0),
(13, '3', '0', '3', 'https://sp22-music-player.000webhostapp.com/Image/Song/binz/blackjack.jpg', 'BlackJack', 'Soobin, Binz', 'https://sp22-music-player.000webhostapp.com/Music/blackjack.mp3', 0),
(14, '3', '2,6', '3', 'https://sp22-music-player.000webhostapp.com/Image/Song/binz/Phia-Sau-Em-Kay-Tran-Binz.jpg', 'Phía Sau Em', 'Kay Trần, Binz', 'https://sp22-music-player.000webhostapp.com/Music/Phia-Sau-Em-Kay-Tran-Binz.mp3', 0),
(15, '3', '1', '3,1', 'https://sp22-music-player.000webhostapp.com/Image/Song/binz/SOFAR-Binz.jpg', 'SOFAR', 'Binz', 'https://sp22-music-player.000webhostapp.com/Music/SOFAR-Binz.mp3', 0),
(16, '3', '0', '3', 'https://sp22-music-player.000webhostapp.com/Image/Song/binz/They-Said-Touliver-Binz.jpg', 'They Said', 'Binz', 'https://sp22-music-player.000webhostapp.com/Music/They-Said-Touliver-Binz.mp3', 0),
(17, '3', '0', '3', 'https://sp22-music-player.000webhostapp.com/Image/Song/binz/Krazy-Touliver-Binz-Andree-Evy.jpg', 'Krazy', 'Touliver, Binz, Andree, Evy', 'https://sp22-music-player.000webhostapp.com/Music/Krazy-Touliver-Binz-Andree-Evy.mp3', 0);

-- --------------------------------------------------------

--
-- Table structure for table `type`
--
-- Creation: Mar 03, 2022 at 02:31 PM
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `type_id` bigint NOT NULL,
  `theme_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`type_id`, `theme_id`, `type_name`, `type_image`) VALUES
(1, '2', 'Indie Rock&Road Trip', 'https://sp22-music-player.000webhostapp.com/Image/Type/type-indie-rock-road-trip.jpg'),
(2, '2', 'Indie Việt', 'https://sp22-music-player.000webhostapp.com/Image/Type/type-indie-viet.jpg'),
(3, '2', 'Indie Pop', 'https://sp22-music-player.000webhostapp.com/Image/Type/type-indie-pop.jpg'),
(4, '2', 'Sad Indie', 'https://sp22-music-player.000webhostapp.com/Image/Type/type-indie-sad.jpg'),
(5, '1', 'V-Pop Tình yêu', 'https://sp22-music-player.000webhostapp.com/Image/Type/type-love-v-pop.jpg'),
(6, '1', 'Rap Việt Về Tình Yêu', 'https://sp22-music-player.000webhostapp.com/Image/Type/type-love-rap-viet-hay.jpg'),
(7, '1', 'Bolero Tình Yêu', 'https://sp22-music-player.000webhostapp.com/Image/Type/type-love-bolero.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advertisement`
--
ALTER TABLE `advertisement`
  ADD PRIMARY KEY (`advertisement_id`);

--
-- Indexes for table `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`album_id`);

--
-- Indexes for table `music_theme`
--
ALTER TABLE `music_theme`
  ADD PRIMARY KEY (`theme_id`);

--
-- Indexes for table `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`playlist_id`);

--
-- Indexes for table `song`
--
ALTER TABLE `song`
  ADD PRIMARY KEY (`song_id`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `advertisement`
--
ALTER TABLE `advertisement`
  MODIFY `advertisement_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `album`
--
ALTER TABLE `album`
  MODIFY `album_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `music_theme`
--
ALTER TABLE `music_theme`
  MODIFY `theme_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `playlist`
--
ALTER TABLE `playlist`
  MODIFY `playlist_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `song`
--
ALTER TABLE `song`
  MODIFY `song_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
