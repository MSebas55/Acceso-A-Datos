-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-01-2024 a las 13:31:25
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hechiceria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `magos`
--

CREATE TABLE `magos` (
  `id` int(11) NOT NULL,
  `alias` varchar(30) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `magos`
--

INSERT INTO `magos` (`id`, `alias`, `nombre`, `telefono`) VALUES
(1, 'Merlín', 'Nombre Cambiado', '666777888'),
(3, 'Gaspar', 'Álvaro', '666888999'),
(4, 'MagoNuevo1', 'Mago Nuevo 1', '6669999991'),
(5, 'MagoNuevo2', 'Mago Nuevo 2', '6669999992'),
(6, 'MagoNuevo3', 'Mago Nuevo 3', '6669999993');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `magos_pocimas`
--

CREATE TABLE `magos_pocimas` (
  `idMago` int(11) NOT NULL,
  `idPocima` int(11) NOT NULL,
  `unidades` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `magos_pocimas`
--

INSERT INTO `magos_pocimas` (`idMago`, `idPocima`, `unidades`) VALUES
(1, 1, 4),
(1, 3, 1),
(3, 1, 8),
(3, 2, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pocimas`
--

CREATE TABLE `pocimas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `coste` decimal(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pocimas`
--

INSERT INTO `pocimas` (`id`, `nombre`, `coste`) VALUES
(1, 'Barcelus', '14.95'),
(2, 'Mick', '11.95'),
(3, 'Negritum', '7.95');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `magos`
--
ALTER TABLE `magos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `alias` (`alias`);

--
-- Indices de la tabla `magos_pocimas`
--
ALTER TABLE `magos_pocimas`
  ADD PRIMARY KEY (`idMago`,`idPocima`),
  ADD KEY `idPocima` (`idPocima`);

--
-- Indices de la tabla `pocimas`
--
ALTER TABLE `pocimas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `magos`
--
ALTER TABLE `magos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `pocimas`
--
ALTER TABLE `pocimas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `magos_pocimas`
--
ALTER TABLE `magos_pocimas`
  ADD CONSTRAINT `magos_pocimas_ibfk_1` FOREIGN KEY (`idMago`) REFERENCES `magos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `magos_pocimas_ibfk_2` FOREIGN KEY (`idPocima`) REFERENCES `pocimas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
