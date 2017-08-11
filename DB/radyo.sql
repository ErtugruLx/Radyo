-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Anamakine: localhost
-- Üretim Zamanı: 11 Ağu 2017, 11:06:52
-- Sunucu sürümü: 5.7.19-0ubuntu0.16.04.1
-- PHP Sürümü: 7.0.18-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `radyo`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `radyo`
--

CREATE TABLE `radyo` (
  `radyoid` int(11) NOT NULL,
  `radyoisim` varchar(100) NOT NULL,
  `radyourl` varchar(400) NOT NULL,
  `radyofotograf` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `radyo`
--

INSERT INTO `radyo` (`radyoid`, `radyoisim`, `radyourl`, `radyofotograf`) VALUES
(1, 'Best FM', 'http://46.20.7.125/listen.pls', 'http://www.bestfm.com.tr/Content/img/bestfm-logo.png'),
(2, 'Joy Turk', 'http://provisioning.streamtheworld.com/pls/JOY_TURKAAC.pls', 'https://mediacdns.karnaval.com/media/station_media/4/logos/logo_web_female.png?v=240717060325');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `radyo`
--
ALTER TABLE `radyo`
  ADD PRIMARY KEY (`radyoid`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `radyo`
--
ALTER TABLE `radyo`
  MODIFY `radyoid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
