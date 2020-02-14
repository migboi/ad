-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 14-02-2020 a las 00:03:06
-- Versión del servidor: 8.0.17
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbpruebados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `categoria` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`id`, `nombre`, `precio`, `categoria`) VALUES
(1, 'artículo 1', '1.00', 1),
(2, 'artículo 2', '2.00', 2),
(3, 'artículo 3', '3.00', 3),
(8, 'articulo 4', '30.00', 1),
(9, 'articulo 5', '12.12', 3),
(10, 'articulo 6', '15.20', 2),
(14, 'casi f-91w', '19.99', 2),
(15, 'herramineta jaume', '22.85', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`) VALUES
(1, 'categoría 1'),
(2, 'categoría 2'),
(3, 'categoría 3'),
(6, 'informatica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`) VALUES
(1, 'cliente 1'),
(2, 'cliente 2'),
(3, 'cliente 3'),
(8, 'jaume'),
(5, 'lopez'),
(4, 'miguel'),
(11, 'mireia'),
(6, 'pepe'),
(9, 'ruben');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `fecha` datetime NOT NULL,
  `cliente` bigint(20) UNSIGNED NOT NULL,
  `importe` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `fecha`, `cliente`, `importe`) VALUES
(2, '2020-02-03 10:39:44', 1, '11.00'),
(3, '2020-02-03 10:42:21', 1, '1.00'),
(4, '2020-02-03 10:42:48', 1, '2.00'),
(6, '2020-02-05 11:42:39', 2, '15.00'),
(7, '2020-02-05 11:53:41', 2, '12.00'),
(15, '2020-02-07 09:32:03', 1, '1.00'),
(17, '2020-02-07 09:36:35', 1, '2.00'),
(18, '2020-02-07 09:39:38', 1, '5.00'),
(19, '2020-02-07 09:46:22', 1, '7.00'),
(20, '2020-02-07 09:47:17', 1, '5.00'),
(21, '2020-02-07 09:48:49', 1, '666.00'),
(22, '2020-02-07 09:49:31', 1, '5.00'),
(23, '2020-02-07 09:51:33', 1, '1.00'),
(24, '2020-02-07 09:53:27', 1, '1.00'),
(25, '2020-02-10 08:55:35', 5, '15.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidolinea`
--

CREATE TABLE `pedidolinea` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `pedido` bigint(20) UNSIGNED NOT NULL,
  `articulo` bigint(20) UNSIGNED NOT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `unidades` decimal(10,2) DEFAULT NULL,
  `importe` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pedidolinea`
--

INSERT INTO `pedidolinea` (`id`, `pedido`, `articulo`, `precio`, `unidades`, `importe`) VALUES
(1, 24, 1, '1.00', '1.00', '1.00'),
(2, 25, 3, '3.00', '5.00', '15.00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`),
  ADD KEY `categoria` (`categoria`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `fecha` (`fecha`),
  ADD KEY `cliente` (`cliente`);

--
-- Indices de la tabla `pedidolinea`
--
ALTER TABLE `pedidolinea`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `pedido` (`pedido`),
  ADD KEY `articulo` (`articulo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `pedidolinea`
--
ALTER TABLE `pedidolinea`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD CONSTRAINT `articulo_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`);

--
-- Filtros para la tabla `pedidolinea`
--
ALTER TABLE `pedidolinea`
  ADD CONSTRAINT `pedidolinea_ibfk_1` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `pedidolinea_ibfk_2` FOREIGN KEY (`articulo`) REFERENCES `articulo` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
