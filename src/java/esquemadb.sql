-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.25a - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para esquemadb
CREATE DATABASE IF NOT EXISTS `esquemadb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `esquemadb`;

-- Volcando estructura para tabla esquemadb.columna
CREATE TABLE IF NOT EXISTS `columna` (
  `id_columna` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_columna` varchar(30) NOT NULL,
  `data_type` varchar(30) NOT NULL,
  `id_tabla` int(3) NOT NULL,
  PRIMARY KEY (`id_columna`),
  KEY `id_tabla` (`id_tabla`),
  CONSTRAINT `columna_ibfk_1` FOREIGN KEY (`id_tabla`) REFERENCES `tabla` (`id_tabla`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla esquemadb.columna: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `columna` DISABLE KEYS */;
/*!40000 ALTER TABLE `columna` ENABLE KEYS */;

-- Volcando estructura para tabla esquemadb.contextonavegacion
CREATE TABLE IF NOT EXISTS `contextonavegacion` (
  `id_contexto` int(10) NOT NULL AUTO_INCREMENT,
  `link` varchar(30) NOT NULL,
  `id_modelo` int(10) NOT NULL,
  `nombre_contexto` varchar(30) NOT NULL,
  PRIMARY KEY (`id_contexto`),
  KEY `id_modelo` (`id_modelo`),
  CONSTRAINT `contextonavegacion_ibfk_1` FOREIGN KEY (`id_modelo`) REFERENCES `modelonavegacion` (`id_modelo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla esquemadb.contextonavegacion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `contextonavegacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `contextonavegacion` ENABLE KEYS */;

-- Volcando estructura para tabla esquemadb.esquema
CREATE TABLE IF NOT EXISTS `esquema` (
  `id_esquema` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_esquema` varchar(30) NOT NULL,
  PRIMARY KEY (`id_esquema`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla esquemadb.esquema: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `esquema` DISABLE KEYS */;
/*!40000 ALTER TABLE `esquema` ENABLE KEYS */;

-- Volcando estructura para tabla esquemadb.modelonavegacion
CREATE TABLE IF NOT EXISTS `modelonavegacion` (
  `id_modelo` int(10) NOT NULL AUTO_INCREMENT,
  `nombre_modelo` varchar(30) NOT NULL,
  PRIMARY KEY (`id_modelo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla esquemadb.modelonavegacion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `modelonavegacion` DISABLE KEYS */;
INSERT INTO `modelonavegacion` (`id_modelo`, `nombre_modelo`) VALUES
	(1, 'PRIMER_MODELO'),
	(2, 'SEGUNDO_MODELO'),
	(3, 'TERCER_MODELO'),
	(4, 'CUARTO_MODELO');
/*!40000 ALTER TABLE `modelonavegacion` ENABLE KEYS */;

-- Volcando estructura para tabla esquemadb.tabla
CREATE TABLE IF NOT EXISTS `tabla` (
  `id_tabla` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tabla` varchar(30) NOT NULL,
  `id_esquema` int(3) NOT NULL,
  PRIMARY KEY (`id_tabla`),
  KEY `id_esquema` (`id_esquema`),
  CONSTRAINT `tabla_ibfk_1` FOREIGN KEY (`id_esquema`) REFERENCES `esquema` (`id_esquema`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla esquemadb.tabla: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tabla` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla` ENABLE KEYS */;

-- Volcando estructura para tabla esquemadb.unidadabstracta
CREATE TABLE IF NOT EXISTS `unidadabstracta` (
  `id_unidad` int(10) NOT NULL AUTO_INCREMENT,
  `id_contexto` int(10) NOT NULL,
  `id_tabla` int(11) NOT NULL,
  `nombre_unidad` varchar(30) NOT NULL,
  PRIMARY KEY (`id_unidad`),
  KEY `id_contexto` (`id_contexto`),
  KEY `id_tabla` (`id_tabla`),
  CONSTRAINT `unidadabstracta_ibfk_1` FOREIGN KEY (`id_contexto`) REFERENCES `contextonavegacion` (`id_contexto`),
  CONSTRAINT `unidadabstracta_ibfk_2` FOREIGN KEY (`id_tabla`) REFERENCES `tabla` (`id_tabla`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla esquemadb.unidadabstracta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `unidadabstracta` DISABLE KEYS */;
/*!40000 ALTER TABLE `unidadabstracta` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
