-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 26, 2016 at 02:12 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `laundry`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_transaksi`
--

CREATE TABLE IF NOT EXISTS `data_transaksi` (
  `no_nota` varchar(10) NOT NULL,
  `berat` float NOT NULL,
  `kategori` varchar(100) NOT NULL,
  `jumlah` int(100) NOT NULL,
  `total_bayar` int(20) NOT NULL,
  PRIMARY KEY (`no_nota`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_transaksi`
--

INSERT INTO `data_transaksi` (`no_nota`, `berat`, `kategori`, `jumlah`, `total_bayar`) VALUES
('T-011', 1, 'Bad Cover 1 Rp.15000\n', 1, 22000),
('T-012', 4, '', 0, 28000),
('T-013', 3, 'Bad Cover 2 Rp.30000\n', 2, 51000),
('T-014', 3, 'selimut besar 1 Rp.25000\nBoneka 2 Rp.80000\n', 3, 126000),
('T-015', 2, 'Bad Cover 1 Rp.15000\n', 1, 25500),
('T-016', 2.2, 'Boneka 1 Rp.40000\n', 1, 55400);

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE IF NOT EXISTS `kategori` (
  `kategori` varchar(15) NOT NULL,
  `tarif` int(10) NOT NULL,
  PRIMARY KEY (`kategori`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`kategori`, `tarif`) VALUES
('Bad Cover', 15000),
('Boneka', 40000),
('selimut besar', 25000),
('Selimut kecil', 10000),
('selimut sedang', 20000);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE IF NOT EXISTS `pelanggan` (
  `no_pelanggan` varchar(6) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `no_hp` varchar(12) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`no_pelanggan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`no_pelanggan`, `nama`, `no_hp`, `alamat`, `tanggal`) VALUES
('P-001', 'bery', '085678657866', 'citra batam', '2016-04-20'),
('P-002', 'febry', '08976985634', 'citra batam', '2016-04-20'),
('P-003', 'yogsal', '08756423467', 'tiban', '2016-05-04'),
('P-004', 'liberty', '08764356', 'ruko air mas', '2016-06-09'),
('P-005', 'firchan', '08765456', 'batam', '2016-06-09'),
('P-006', 'wahyu', '08574628475', 'citra batam', '2016-06-24'),
('P-007', 'putra', '0856832475', 'batam', '2016-06-24'),
('P-008', 'ichan', '081276678998', 'bengkong', '2016-06-26');

-- --------------------------------------------------------

--
-- Table structure for table `tahun`
--

CREATE TABLE IF NOT EXISTS `tahun` (
  `tahun` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tahun`
--

INSERT INTO `tahun` (`tahun`) VALUES
(2015),
(2016),
(2017),
(2018),
(2019),
(2020),
(2021),
(2022),
(2023),
(2024),
(2025),
(2026),
(2027),
(2028),
(2029),
(2030);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `no_nota` varchar(10) NOT NULL,
  `no_pelanggan` varchar(6) NOT NULL,
  `tgl_masuk` date NOT NULL,
  `tgl_selesai` date NOT NULL,
  `status` varchar(20) NOT NULL,
  `status_bayar` varchar(20) NOT NULL,
  `tgl_bayar` date DEFAULT NULL,
  PRIMARY KEY (`no_nota`,`no_pelanggan`),
  KEY `no_pelanggan` (`no_pelanggan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`no_nota`, `no_pelanggan`, `tgl_masuk`, `tgl_selesai`, `status`, `status_bayar`, `tgl_bayar`) VALUES
('T-011', 'P-003', '2016-05-04', '2016-05-07', 'Sudah Diambil', 'Lunas', '2016-05-07'),
('T-012', 'P-004', '2016-06-09', '2016-06-10', 'Sudah Diambil', 'Lunas', '2016-06-10'),
('T-013', 'P-005', '2016-06-09', '2016-06-11', 'Sudah Diambil', 'Lunas', '2016-06-09'),
('T-014', 'P-006', '2016-06-24', '2016-06-30', 'Belum Diambil', 'Lunas', '2016-06-24'),
('T-015', 'P-008', '2016-06-26', '2016-06-29', 'Belum Diambil', 'Lunas', '2016-06-26'),
('T-016', 'P-008', '2016-06-26', '2016-06-30', 'Belum Diambil', 'Lunas', '2016-06-26');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `hak_akses` varchar(6) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`hak_akses`, `username`, `password`) VALUES
('user', 'karyawan', '12345'),
('admin', 'pemilik', '12345');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_transaksi`
--
ALTER TABLE `data_transaksi`
  ADD CONSTRAINT `data_transaksi_ibfk_1` FOREIGN KEY (`no_nota`) REFERENCES `transaksi` (`no_nota`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`no_pelanggan`) REFERENCES `pelanggan` (`no_pelanggan`) ON DELETE CASCADE ON UPDATE CASCADE;
