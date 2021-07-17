-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Temps de generació: 17-07-2021 a les 16:35:27
-- Versió del servidor: 10.4.18-MariaDB
-- Versió de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `botiga`
--

-- --------------------------------------------------------

--
-- Estructura de la taula `botiga`
--

CREATE TABLE `botiga` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `capacitat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de la taula `quadres`
--

CREATE TABLE `quadres` (
  `id` int(11) NOT NULL,
  `id_botiga` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `preu` double NOT NULL,
  `data_entrada` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `botiga`
--
ALTER TABLE `botiga`
  ADD PRIMARY KEY (`id`);

--
-- Índexs per a la taula `quadres`
--
ALTER TABLE `quadres`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_botiga` (`id_botiga`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `quadres`
--
ALTER TABLE `quadres`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restriccions per a les taules bolcades
--

--
-- Restriccions per a la taula `quadres`
--
ALTER TABLE `quadres`
  ADD CONSTRAINT `quadres_ibfk_1` FOREIGN KEY (`id_botiga`) REFERENCES `botiga` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
