-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 12, 2019 at 09:22 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `user_portal`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `id` int(50) NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `birthDate` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `age` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`id`, `firstName`, `lastName`, `address`, `phone`, `email`, `birthDate`, `pass`, `age`) VALUES
(9, 'Zahirul', 'Hoque', 'Feni', '01815009474', 'fcizhair@gmail.com', '1996-08-21', 'Njg4NTc0', 23),
(10, 'Omar', 'Faruk', 'Feni', '01912345678', 'faruk@gmail.com', '1997-11-21', 'MTIzNDU2', 21),
(11, 'Ziaul', 'Hoque', 'Feni', '01831721467', 'ziaul@gmail.com', '1999-12-31', 'NjU0MzIx', 19),
(12, 'Ayatullah', 'Siddque', 'Bogura', '01723456798', 'ayatullah@gamil.com', '1994-11-03', 'YXlhdHVsbGFo', 25),
(13, 'Sayirah Akter', 'Eva', 'Feni', '01821456789', 'eva@gmail.com', '2007-12-11', 'ZXZhMTIz', 11),
(14, 'Arafat', 'Hosain', 'Feni', '01824321095', 'arafat@gmail.com', '2003-11-10', 'YXJhZmF0', 16);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
