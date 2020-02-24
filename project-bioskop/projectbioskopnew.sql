-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 21, 2019 at 04:15 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projectbioskop`
--

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `id` int(11) NOT NULL,
  `nama` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`id`, `nama`) VALUES
(1, 'Joker'),
(2, 'Boker');

-- --------------------------------------------------------

--
-- Table structure for table `jam_tayang`
--

CREATE TABLE `jam_tayang` (
  `id` int(11) NOT NULL,
  `kuota` int(11) DEFAULT NULL,
  `film_id` int(11) NOT NULL,
  `studio_id` int(11) NOT NULL,
  `times_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `jam_tayang`
--

INSERT INTO `jam_tayang` (`id`, `kuota`, `film_id`, `studio_id`, `times_id`) VALUES
(1, 10, 1, 1, 2),
(2, 10, 1, 2, 3),
(3, 10, 2, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `studio`
--

CREATE TABLE `studio` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `studio`
--

INSERT INTO `studio` (`id`, `nama`) VALUES
(1, 'Studio 1'),
(2, 'Studio 2');

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `id` int(11) NOT NULL,
  `nama` varchar(45) DEFAULT NULL,
  `harga` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tiket`
--

INSERT INTO `tiket` (`id`, `nama`, `harga`) VALUES
(1, 'Weekdays', 30000),
(2, 'Weekend', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `times`
--

CREATE TABLE `times` (
  `id` int(11) NOT NULL,
  `tayang` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `times`
--

INSERT INTO `times` (`id`, `tayang`) VALUES
(1, '08:00:00'),
(2, '12:00:00'),
(3, '18:00:00'),
(4, '20:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `jumlah_tiket` int(11) DEFAULT NULL,
  `harga_total` int(15) DEFAULT NULL,
  `tanggal` date NOT NULL,
  `jam_tayang_id` int(11) NOT NULL,
  `tiket_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id`, `jumlah_tiket`, `harga_total`, `tanggal`, `jam_tayang_id`, `tiket_id`) VALUES
(1, 2, NULL, '2019-10-10', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jam_tayang`
--
ALTER TABLE `jam_tayang`
  ADD PRIMARY KEY (`id`,`film_id`,`studio_id`,`times_id`),
  ADD KEY `fk_jam_tayang_film1_idx` (`film_id`),
  ADD KEY `fk_jam_tayang_studio1_idx` (`studio_id`),
  ADD KEY `fk_jam_tayang_times1_idx` (`times_id`);

--
-- Indexes for table `studio`
--
ALTER TABLE `studio`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `times`
--
ALTER TABLE `times`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`,`jam_tayang_id`,`tiket_id`),
  ADD KEY `fk_transaksi_jam_tayang1_idx` (`jam_tayang_id`),
  ADD KEY `fk_transaksi_tiket1_idx` (`tiket_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jam_tayang`
--
ALTER TABLE `jam_tayang`
  ADD CONSTRAINT `fk_jam_tayang_film1` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_jam_tayang_studio1` FOREIGN KEY (`studio_id`) REFERENCES `studio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_jam_tayang_times1` FOREIGN KEY (`times_id`) REFERENCES `times` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `fk_transaksi_jam_tayang1` FOREIGN KEY (`jam_tayang_id`) REFERENCES `jam_tayang` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_transaksi_tiket1` FOREIGN KEY (`tiket_id`) REFERENCES `tiket` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
