-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.14-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para laboratorio_omylab
CREATE DATABASE IF NOT EXISTS `laboratorio_omylab` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `laboratorio_omylab`;

-- Volcando estructura para tabla laboratorio_omylab.analisis
CREATE TABLE IF NOT EXISTS `analisis` (
  `idAnalisis` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `costo` float NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`idAnalisis`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.analisis: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `analisis` DISABLE KEYS */;
INSERT INTO `analisis` (`idAnalisis`, `nombre`, `costo`, `estado`) VALUES
	(1, 'Hemograma', 30, 1),
	(2, 'Hto', 25, 1),
	(3, 'Hb', 15, 1),
	(4, 'V. S. G.', 50, 0),
	(5, 'Recuento de plaquetas', 20, 0),
	(6, 'T. de Coag. T de sangría', 30, 1),
	(7, 'T. de Protombina (TP)', 55, 1),
	(8, 'T. Parcial de Tromboplastina (TPT)', 33, 0),
	(9, 'Fibrinógeno', 15, 1);
/*!40000 ALTER TABLE `analisis` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.analisis_has_producto
CREATE TABLE IF NOT EXISTS `analisis_has_producto` (
  `idAnalisis` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` float DEFAULT NULL,
  PRIMARY KEY (`idAnalisis`,`idProducto`),
  KEY `idProducto` (`idProducto`),
  CONSTRAINT `analisis_has_producto_ibfk_1` FOREIGN KEY (`idAnalisis`) REFERENCES `analisis` (`idAnalisis`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `analisis_has_producto_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.analisis_has_producto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `analisis_has_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `analisis_has_producto` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `nro_documento` varchar(20) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `fech_nacimiento` varchar(15) DEFAULT NULL,
  `sexo` varchar(15) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `celular` varchar(15) NOT NULL,
  `idTipo_documento` int(11) NOT NULL,
  PRIMARY KEY (`nro_documento`),
  KEY `cliente_ibfk_1` (`idTipo_documento`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idTipo_documento`) REFERENCES `tipo_documento` (`idTipo_documento`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.cliente: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`nro_documento`, `nombre`, `apellido`, `fech_nacimiento`, `sexo`, `direccion`, `correo`, `celular`, `idTipo_documento`) VALUES
	('00474996', 'OSCAR CRUZARIO', 'VILLALOBOS MENDOZA', '1950-10-01', 'Masculino', 'AV. CORONEL MENDOZA #1227', NULL, '952847770', 1),
	('1234567', 'ANDREA', 'MAMANI PAZOS', '1995-12-3', 'Femenino', 'Calle Los Nardos #1234', '', '925784512', 5),
	('66004585', 'FERNANDO', 'NUÑEZ ALVAREZ', '1995-06-22', 'Masculino', 'ASOC. LOS CLAVELES #1212', NULL, '915452563', 1),
	('70102563', 'AYDEE', 'MAMANI HUANCA', '1996-5-13', 'Femenino', 'PSJE. JOSE GOMEZ #1310', 'AYDEE@gmail.com', '925413610', 1),
	('71569841', 'ANA MARIA', 'FLORES CONDORI', '1975-05-15', 'Femenino', 'PSJE. JOSE GOMEZ #78', 'anamaria_123@hotmail.com', '915698745', 1),
	('73231431', 'ERICKA ESTHER', 'MARTINEZ YUFRA', '2000-5-11', 'Femenino', 'ASOC. MONTEVERDE #12', 'erickamartinez@hotmail.com', '920257485', 1),
	('73237855', 'ZUGARREY LUZ', 'LEON HUILLCA', '1998-10-15', 'Femenino', '', 'luzl1234@gmail.com', '', 1),
	('89151214', 'MIGUEL ANGEL', 'MARTINEZ VILCA', '1987-12-12', 'Masculino', 'ALFONSO UGARTE I ETAPA MZ C3 LT 14', 'miguel013@gmail.com', '952963010', 1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.doc_compra_venta
CREATE TABLE IF NOT EXISTS `doc_compra_venta` (
  `idDoc_compra_venta` int(11) NOT NULL AUTO_INCREMENT,
  `nro_documento` varchar(45) NOT NULL,
  `razon_social` text DEFAULT NULL,
  `fecha` date NOT NULL,
  `total` float NOT NULL DEFAULT 0,
  `idTipo_documento` int(11) NOT NULL,
  `idOrden` int(11) DEFAULT NULL,
  `Proveedor_nro_documento` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idDoc_compra_venta`),
  UNIQUE KEY `nro_documento` (`nro_documento`),
  KEY `doc_compra_venta_ibfk_1` (`idTipo_documento`),
  KEY `doc_compra_venta_ibfk_2` (`idOrden`),
  KEY `doc_compra_venta_ibfk_3` (`Proveedor_nro_documento`),
  CONSTRAINT `doc_compra_venta_ibfk_1` FOREIGN KEY (`idTipo_documento`) REFERENCES `tipo_documento` (`idTipo_documento`) ON UPDATE CASCADE,
  CONSTRAINT `doc_compra_venta_ibfk_2` FOREIGN KEY (`idOrden`) REFERENCES `orden` (`idOrden`) ON UPDATE CASCADE,
  CONSTRAINT `doc_compra_venta_ibfk_3` FOREIGN KEY (`Proveedor_nro_documento`) REFERENCES `proveedor` (`nro_documento`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.doc_compra_venta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `doc_compra_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `doc_compra_venta` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.doc_compra_venta_has_producto
CREATE TABLE IF NOT EXISTS `doc_compra_venta_has_producto` (
  `idDoc_compra_venta` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `precio_compra` float DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDoc_compra_venta`,`idProducto`),
  KEY `idProducto` (`idProducto`),
  CONSTRAINT `doc_compra_venta_has_producto_ibfk_1` FOREIGN KEY (`idDoc_compra_venta`) REFERENCES `doc_compra_venta` (`idDoc_compra_venta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `doc_compra_venta_has_producto_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.doc_compra_venta_has_producto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `doc_compra_venta_has_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `doc_compra_venta_has_producto` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.empleado
CREATE TABLE IF NOT EXISTS `empleado` (
  `nro_documento` varchar(20) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fech_nacimiento` varchar(15) NOT NULL DEFAULT '',
  `direccion` varchar(45) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `clave` varchar(6) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `idRol` int(11) NOT NULL,
  `idTipo_documento` int(11) NOT NULL,
  PRIMARY KEY (`nro_documento`),
  KEY `empleado_ibfk_2` (`idRol`),
  KEY `empleado_ibfk_3` (`idTipo_documento`),
  CONSTRAINT `empleado_ibfk_2` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON UPDATE CASCADE,
  CONSTRAINT `empleado_ibfk_3` FOREIGN KEY (`idTipo_documento`) REFERENCES `tipo_documento` (`idTipo_documento`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.empleado: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` (`nro_documento`, `nombre`, `apellido`, `fech_nacimiento`, `direccion`, `celular`, `clave`, `estado`, `idRol`, `idTipo_documento`) VALUES
	('71249893', 'BRIAN SEBASTIAN', 'ANCO COPAJA', '2001-03-18', 'MONTERICO ', '936526341', '123456', 1, 1, 1),
	('71256398', 'CRISTHIAN MANUEL', 'FIGUEROA PEREZ', '1975-7-23', 'Alfonso Ugarte Mz C13 Lt 10', '952689891', '123456', 1, 2, 5),
	('71390996', 'MATHIUS ', 'FARFAN', '1999-05-28', NULL, '952659874', '123456', 0, 1, 1),
	('73231431', 'ERICKA ESTHER', 'MARTINEZ YUFRA', '2000-06-06', 'ALFONSO UGARTE I ETAPA MZ B4 LT 23', '920250579', '123456', 1, 2, 1),
	('77054850', 'JEANETTE GREGORIA', 'QUISPE APAZA', '2001-5-12', 'ASOC. JORGE BASADRE #123', '952904012', '123456', 0, 3, 6);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.historial
CREATE TABLE IF NOT EXISTS `historial` (
  `idHistorial` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(50) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `accion` text DEFAULT NULL,
  `nro_documento` varchar(20) NOT NULL,
  PRIMARY KEY (`idHistorial`),
  KEY `historial_ibfk_1` (`nro_documento`),
  CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`nro_documento`) REFERENCES `empleado` (`nro_documento`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.historial: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.marca
CREATE TABLE IF NOT EXISTS `marca` (
  `idMarca` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idMarca`),
  UNIQUE KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.marca: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` (`idMarca`, `descripcion`) VALUES
	(1, 'Marca 1'),
	(2, 'Marca 2'),
	(3, 'Marca 3'),
	(6, 'Marca 5'),
	(4, 'Marca 6');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.muestra
CREATE TABLE IF NOT EXISTS `muestra` (
  `idMuestra` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idMuestra`),
  UNIQUE KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.muestra: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `muestra` DISABLE KEYS */;
INSERT INTO `muestra` (`idMuestra`, `descripcion`) VALUES
	(2, 'Heces'),
	(1, 'Orina'),
	(3, 'Sangre');
/*!40000 ALTER TABLE `muestra` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.orden
CREATE TABLE IF NOT EXISTS `orden` (
  `idOrden` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `estado` varchar(15) NOT NULL,
  `Cliente_nro_documento` varchar(20) NOT NULL,
  `Empleado_nro_documento` varchar(20) NOT NULL,
  PRIMARY KEY (`idOrden`),
  KEY `orden_ibfk_1` (`Cliente_nro_documento`),
  KEY `orden_ibfk_2` (`Empleado_nro_documento`),
  CONSTRAINT `orden_ibfk_1` FOREIGN KEY (`Cliente_nro_documento`) REFERENCES `cliente` (`nro_documento`) ON UPDATE CASCADE,
  CONSTRAINT `orden_ibfk_2` FOREIGN KEY (`Empleado_nro_documento`) REFERENCES `empleado` (`nro_documento`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.orden: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `orden` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.orden_has_analisis
CREATE TABLE IF NOT EXISTS `orden_has_analisis` (
  `idOrden` int(11) NOT NULL,
  `idAnalisis` int(11) NOT NULL,
  `valor_min` float DEFAULT NULL,
  `valor_max` float DEFAULT NULL,
  `resultado` varchar(45) DEFAULT NULL,
  `idMuestra` int(11) NOT NULL,
  PRIMARY KEY (`idOrden`,`idAnalisis`),
  KEY `idAnalisis` (`idAnalisis`),
  KEY `idMuestra` (`idMuestra`),
  CONSTRAINT `orden_has_analisis_ibfk_1` FOREIGN KEY (`idOrden`) REFERENCES `orden` (`idOrden`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orden_has_analisis_ibfk_2` FOREIGN KEY (`idAnalisis`) REFERENCES `analisis` (`idAnalisis`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orden_has_analisis_ibfk_3` FOREIGN KEY (`idMuestra`) REFERENCES `muestra` (`idMuestra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.orden_has_analisis: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `orden_has_analisis` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden_has_analisis` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.permiso
CREATE TABLE IF NOT EXISTS `permiso` (
  `idPermiso` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idPermiso`),
  UNIQUE KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.permiso: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `cantidad` float DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `idMarca` int(11) NOT NULL,
  `idTipo_producto` int(11) NOT NULL,
  `idTipo_medida` int(11) NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `idTipo_medida` (`idTipo_medida`) USING BTREE,
  KEY `producto_ibfk_1` (`idMarca`),
  KEY `producto_ibfk_2` (`idTipo_producto`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`idMarca`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`idTipo_producto`) REFERENCES `tipo_producto` (`idTipo_producto`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_3` FOREIGN KEY (`idTipo_medida`) REFERENCES `tipo_medida` (`idTipo_medida`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.producto: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`idProducto`, `descripcion`, `cantidad`, `stock`, `idMarca`, `idTipo_producto`, `idTipo_medida`) VALUES
	(1, 'Reactivo 1', 30, 3, 2, 2, 1),
	(2, 'Reactivo 2', 15, 2, 3, 2, 1),
	(3, 'Alcohol', 2.5, 1, 1, 1, 2);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.producto_detalle
CREATE TABLE IF NOT EXISTS `producto_detalle` (
  `idProducto_detalle` int(11) NOT NULL,
  `cantidad` float DEFAULT NULL,
  `fech_vencimiento` date DEFAULT NULL,
  `idProducto` int(11) NOT NULL,
  PRIMARY KEY (`idProducto_detalle`),
  KEY `producto_detalle_ibfk_1` (`idProducto`),
  CONSTRAINT `producto_detalle_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.producto_detalle: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `producto_detalle` DISABLE KEYS */;
INSERT INTO `producto_detalle` (`idProducto_detalle`, `cantidad`, `fech_vencimiento`, `idProducto`) VALUES
	(1, 10, '2023-05-28', 1),
	(2, 30, '2023-05-28', 1),
	(3, 30, '2023-05-28', 1),
	(4, 15, '2022-10-10', 2),
	(5, 15, '2022-10-10', 2),
	(6, 2.5, '2025-03-18', 3);
/*!40000 ALTER TABLE `producto_detalle` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.proveedor
CREATE TABLE IF NOT EXISTS `proveedor` (
  `nro_documento` varchar(20) NOT NULL,
  `razon_social` varchar(45) NOT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `celular` varchar(15) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `idTipo_documento` int(11) NOT NULL,
  PRIMARY KEY (`nro_documento`),
  UNIQUE KEY `razon_social` (`razon_social`),
  KEY `proveedor_ibfk_1` (`idTipo_documento`),
  CONSTRAINT `proveedor_ibfk_1` FOREIGN KEY (`idTipo_documento`) REFERENCES `tipo_documento` (`idTipo_documento`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.proveedor: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` (`nro_documento`, `razon_social`, `direccion`, `celular`, `estado`, `idTipo_documento`) VALUES
	('10770548506', 'QUISPE APAZA JEANETTE GREGORIA', 'ASOC. Los Olivos #569', '920250579', 0, 2),
	('2365987415102', 'LOS ALAMOS S. A. C.', 'AV. INDUSTRIAL #458', '920257896', 1, 2),
	('9685743625148', 'ESTELA & CIA', 'AV. BOLOGNESI #123', '936451278', 1, 2);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idRol`),
  UNIQUE KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.rol: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`idRol`, `descripcion`) VALUES
	(1, 'Gerente'),
	(3, 'Practicante'),
	(2, 'Secretaría');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.rol_has_permiso
CREATE TABLE IF NOT EXISTS `rol_has_permiso` (
  `idRol` int(11) NOT NULL,
  `idPermiso` int(11) NOT NULL,
  PRIMARY KEY (`idRol`,`idPermiso`),
  KEY `idPermiso` (`idPermiso`),
  CONSTRAINT `rol_has_permiso_ibfk_1` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rol_has_permiso_ibfk_2` FOREIGN KEY (`idPermiso`) REFERENCES `permiso` (`idPermiso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.rol_has_permiso: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `rol_has_permiso` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol_has_permiso` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.tipo_documento
CREATE TABLE IF NOT EXISTS `tipo_documento` (
  `idTipo_documento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) NOT NULL,
  PRIMARY KEY (`idTipo_documento`),
  UNIQUE KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.tipo_documento: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_documento` DISABLE KEYS */;
INSERT INTO `tipo_documento` (`idTipo_documento`, `descripcion`) VALUES
	(3, 'BOLETA'),
	(6, 'CARNET DE EXTRANJERIA'),
	(1, 'DNI'),
	(4, 'FACTURA'),
	(5, 'PASAPORTE'),
	(2, 'RUC');
/*!40000 ALTER TABLE `tipo_documento` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.tipo_medida
CREATE TABLE IF NOT EXISTS `tipo_medida` (
  `idTipo_medida` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(15) NOT NULL,
  PRIMARY KEY (`idTipo_medida`),
  UNIQUE KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.tipo_medida: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_medida` DISABLE KEYS */;
INSERT INTO `tipo_medida` (`idTipo_medida`, `descripcion`) VALUES
	(3, 'kg'),
	(2, 'l'),
	(4, 'mg'),
	(1, 'ml');
/*!40000 ALTER TABLE `tipo_medida` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.tipo_producto
CREATE TABLE IF NOT EXISTS `tipo_producto` (
  `idTipo_producto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipo_producto`),
  UNIQUE KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.tipo_producto: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_producto` DISABLE KEYS */;
INSERT INTO `tipo_producto` (`idTipo_producto`, `descripcion`) VALUES
	(1, 'Desinfectante'),
	(3, 'Limpieza'),
	(2, 'Reactivo');
/*!40000 ALTER TABLE `tipo_producto` ENABLE KEYS */;

-- Volcando estructura para tabla laboratorio_omylab.valor_referencial
CREATE TABLE IF NOT EXISTS `valor_referencial` (
  `idValor_referencial` int(11) NOT NULL AUTO_INCREMENT,
  `valor_min` float DEFAULT NULL,
  `valor_max` float DEFAULT NULL,
  `sexo` varchar(15) DEFAULT NULL,
  `edad_min` int(11) DEFAULT NULL,
  `edad_max` int(11) DEFAULT NULL,
  `idAnalisis` int(11) NOT NULL,
  PRIMARY KEY (`idValor_referencial`),
  KEY `valor_referencial_ibfk_1` (`idAnalisis`),
  CONSTRAINT `valor_referencial_ibfk_1` FOREIGN KEY (`idAnalisis`) REFERENCES `analisis` (`idAnalisis`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla laboratorio_omylab.valor_referencial: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `valor_referencial` DISABLE KEYS */;
INSERT INTO `valor_referencial` (`idValor_referencial`, `valor_min`, `valor_max`, `sexo`, `edad_min`, `edad_max`, `idAnalisis`) VALUES
	(1, 20, 35, 'Femenino', NULL, NULL, 9),
	(2, 30, 50, 'Masculino', NULL, NULL, 9),
	(3, 45, 65, NULL, NULL, NULL, 8),
	(4, 25, 35, NULL, NULL, NULL, 7),
	(5, 15, 20, NULL, 0, 17, 5),
	(6, 20, 30, NULL, 18, 40, 5),
	(7, 30, 50, NULL, 41, 100, 5);
/*!40000 ALTER TABLE `valor_referencial` ENABLE KEYS */;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Analisis
DELIMITER //
CREATE PROCEDURE `USP_D_Analisis`(
	IN `Pid` INT
)
BEGIN
	DELETE FROM analisis 
	WHERE idAnalisis=Pid;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Analisis_has_Producto
DELIMITER //
CREATE PROCEDURE `USP_D_Analisis_has_Producto`(
	IN `Panalisis` INT,
	IN `Pproducto` INT
)
BEGIN
	DELETE FROM analisis_has_producto 
	WHERE (idAnalisis=Panalisis AND idProducto=Pproducto);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Cliente
DELIMITER //
CREATE PROCEDURE `USP_D_Cliente`(
	IN `Pnro_doc` VARCHAR(20)
)
BEGIN
	DELETE FROM Cliente 
	WHERE (nro_documento=Pnro_doc);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Doc_compra_venta
DELIMITER //
CREATE PROCEDURE `USP_D_Doc_compra_venta`(
	IN `PidDoc` INT
)
BEGIN
	DELETE FROM Doc_compra_venta 
	WHERE (idDoc_compra_venta=PidDoc);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Doc_compra_venta_has_Producto
DELIMITER //
CREATE PROCEDURE `USP_D_Doc_compra_venta_has_Producto`(
	IN `PidDoc` INT
)
BEGIN
	DELETE FROM Doc_compra_venta_has_Producto 
	WHERE (idDoc_compra_venta=Pdoc_cv AND idProducto=Pprod);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Empleado
DELIMITER //
CREATE PROCEDURE `USP_D_Empleado`(
	IN `Pnro_doc` VARCHAR(20)
)
BEGIN
	DELETE FROM Empleado 
	WHERE (nro_documento=Pnro_doc);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Historial
DELIMITER //
CREATE PROCEDURE `USP_D_Historial`(
	IN `Pid` INT
)
BEGIN
	DELETE FROM Historial 
	WHERE idHistorial=Pid;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Marca
DELIMITER //
CREATE PROCEDURE `USP_D_Marca`(
	IN `Pid` INT
)
BEGIN
	DELETE FROM Marca 
	WHERE (idMarca=Pid);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Muestra
DELIMITER //
CREATE PROCEDURE `USP_D_Muestra`(
	IN `Pid` INT
)
BEGIN
	DELETE FROM Muestra 
	WHERE (idMuestra=Pid);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Orden
DELIMITER //
CREATE PROCEDURE `USP_D_Orden`(
	IN `Pid` INT
)
BEGIN
	DELETE FROM Orden 
	WHERE (idOrden=Pid);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Orden_has_Analisis
DELIMITER //
CREATE PROCEDURE `USP_D_Orden_has_Analisis`(
	IN `Porden` INT,
	IN `Panalisis` INT
)
BEGIN
	DELETE FROM orden_has_analisis 
	WHERE (idOrden = PordenAND AND idAnalisis = Panalisis);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Permiso
DELIMITER //
CREATE PROCEDURE `USP_D_Permiso`(
	IN `Ppermiso` INT
)
BEGIN
	DELETE FROM permiso
	WHERE idPermiso=Pid;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Producto
DELIMITER //
CREATE PROCEDURE `USP_D_Producto`(
	IN `Pproducto` INT
)
BEGIN
	DELETE FROM producto
	WHERE idProducto=Pproducto;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Producto_Detalle
DELIMITER //
CREATE PROCEDURE `USP_D_Producto_Detalle`(
	IN `Pproducto` INT
)
BEGIN
	DELETE FROM producto_detalle
	WHERE idProducto_detalle=Pproducto;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Proveedor
DELIMITER //
CREATE PROCEDURE `USP_D_Proveedor`(
	IN `Pnro_docu` VARCHAR(20)
)
BEGIN
	DELETE FROM proveedor
	WHERE nro_documento=Pnro_docu;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Rol
DELIMITER //
CREATE PROCEDURE `USP_D_Rol`(
	IN `Prol` INT
)
BEGIN
	DELETE FROM rol
	WHERE idRol=Prol;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Rol_has_Permiso
DELIMITER //
CREATE PROCEDURE `USP_D_Rol_has_Permiso`(
	IN `Prol` INT,
	IN `Ppermiso` INT
)
BEGIN
	DELETE FROM rol_has_permiso
	WHERE (idRol=Prol AND idPermiso=Ppermiso);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Tipo_Documento
DELIMITER //
CREATE PROCEDURE `USP_D_Tipo_Documento`(
	IN `Ptipo_docu` INT
)
BEGIN
	DELETE FROM tipo_documento
	WHERE idTipo_documento=Ptipo_docu;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Tipo_Medida
DELIMITER //
CREATE PROCEDURE `USP_D_Tipo_Medida`(
	IN `Ptipo_med` INT
)
BEGIN
	DELETE FROM tipo_medida
	WHERE idTipo_medida=Ptipo_med;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Tipo_Producto
DELIMITER //
CREATE PROCEDURE `USP_D_Tipo_Producto`(
	IN `Ptipo_pro` INT
)
BEGIN
	DELETE FROM tipo_producto
	WHERE idTipo_producto=Ptipo_pro;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_D_Valor_referencial
DELIMITER //
CREATE PROCEDURE `USP_D_Valor_referencial`(
	IN `Pvalor_r` INT
)
BEGIN
	DELETE FROM valor_referencial
	WHERE idValor_referencial=Pvalor_r;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Analisis
DELIMITER //
CREATE PROCEDURE `USP_I_Analisis`(
	IN `Pnombre` VARCHAR(45),
	IN `Pcosto` FLOAT,
	IN `Pestado` INT
)
BEGIN
	INSERT INTO analisis (nombre,costo,estado) 
	VALUES(Pnombre,Pcosto,Pestado);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Analisis_has_Producto
DELIMITER //
CREATE PROCEDURE `USP_I_Analisis_has_Producto`(
	IN `Panalisis` INT,
	IN `Pproducto` INT,
	IN `Pcantidad` FLOAT
)
BEGIN
	INSERT INTO Analisis_has_Producto (idAnalisis,idProducto,cantidad) 
	VALUES(Panalisis,Pproducto,Pcantidad);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Cargo
DELIMITER //
CREATE PROCEDURE `USP_I_Cargo`(
	IN `Pdescripcion` VARCHAR(30)
)
BEGIN
	INSERT INTO Cargo (descripcion) 
	VALUES(Pdescripcion);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Cliente
DELIMITER //
CREATE PROCEDURE `USP_I_Cliente`(
	IN `Pnro_doc` VARCHAR(20),
	IN `Pnombre` VARCHAR(45),
	IN `Papellido` VARCHAR(45),
	IN `Pfech_nac` VARCHAR(15),
	IN `Psexo` VARCHAR(15),
	IN `Pdireccion` TEXT,
	IN `Pcorreo` VARCHAR(45),
	IN `Pcelular` VARCHAR(15),
	IN `Ptipo_doc` INT
)
BEGIN
	INSERT INTO Cliente (nro_documento,nombre,apellido,fech_nacimiento,sexo,direccion,correo,celular,idTipo_documento) 
	VALUES(Pnro_doc,Pnombre,Papellido,Pfech_nac,Psexo,Pdireccion,Pcorreo,Pcelular,Ptipo_doc);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Doc_compra_venta
DELIMITER //
CREATE PROCEDURE `USP_I_Doc_compra_venta`(
	IN `Pnro_doc` VARCHAR(45),
	IN `Prazon_social` TEXT,
	IN `Pfecha` DATE,
	IN `Ptotal` FLOAT,
	IN `Ptipo_doc` INT,
	IN `Porden` INT,
	IN `Pprove_nro_doc` INT
)
BEGIN
	INSERT INTO Doc_compra_venta (nro_documento,razon_social,fecha,total,idTipo_documento,idOrden,Proveedor_nro_documento) 
	VALUES(Pnro_doc,Prazon_social,Pfecha,Ptotal,Ptipo_doc,Porden,Pprove_nro_doc);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Doc_compra_venta_has_Producto
DELIMITER //
CREATE PROCEDURE `USP_I_Doc_compra_venta_has_Producto`(
	IN `Pdoc_cv` INT,
	IN `Pprod` INT,
	IN `Pprecio` FLOAT,
	IN `Pcantidad` INT
)
BEGIN
	INSERT INTO Doc_compra_venta_has_Producto (idDoc_compra_venta,idProducto,precio_compra,cantidad) 
	VALUES(Pdoc_cv,Pprod,Pprecio,Pcantidad);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Empleado
DELIMITER //
CREATE PROCEDURE `USP_I_Empleado`(
	IN `Pnro_doc` VARCHAR(20),
	IN `Pnombre` VARCHAR(45),
	IN `Papellido` VARCHAR(45),
	IN `Pfech_nac` VARCHAR(15),
	IN `Pdireccion` TEXT,
	IN `Pcelular` VARCHAR(15),
	IN `Pclave` VARCHAR(6),
	IN `Pestado` INT,
	IN `Prol` INT,
	IN `Ptipo_doc` INT
)
BEGIN
	INSERT INTO Empleado (nro_documento,nombre,apellido,fech_nacimiento,direccion,celular,clave,estado,idRol,idTipo_documento) 
	VALUES(Pnro_doc,Pnombre,Papellido,Pfech_nac,Pdireccion,Pcelular,Pclave,Pestado,Prol,Ptipo_doc);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Historial
DELIMITER //
CREATE PROCEDURE `USP_I_Historial`(
	IN `Pfecha` VARCHAR(50),
	IN `Ptipo` VARCHAR(45),
	IN `Paccion` TEXT,
	IN `Pnro_doc` VARCHAR(20)
)
BEGIN
	INSERT INTO Historial (fecha,tipo,accion,nro_documento) 
	VALUES(Pfecha,Ptipo,Paccion,Pnro_doc);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Marca
DELIMITER //
CREATE PROCEDURE `USP_I_Marca`(
	IN `Pdescripcion` VARCHAR(45)
)
BEGIN
	INSERT INTO Marca (descripcion) 
	VALUES(Pdescripcion);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Muestra
DELIMITER //
CREATE PROCEDURE `USP_I_Muestra`(
	IN `Pdescripcion` VARCHAR(45)
)
BEGIN
	INSERT INTO Muestra (descripcion) 
	VALUES(Pdescripcion);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Orden
DELIMITER //
CREATE PROCEDURE `USP_I_Orden`(
	IN `Pfecha` DATETIME,
	IN `Pestado` VARCHAR(15),
	IN `Pcliente` VARCHAR(20),
	IN `Pempleado` VARCHAR(20)
)
BEGIN
	INSERT INTO Orden (fecha,estado,Cliente_nro_documento,Empleado_nro_documento) 
	VALUES(Pfecha,Pestado,Pcliente,Pempleado);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Orden_has_Analisis
DELIMITER //
CREATE PROCEDURE `USP_I_Orden_has_Analisis`(
	IN `Porden` INT,
	IN `Panalisis` INT,
	IN `Pvalor_min` FLOAT,
	IN `Pvalor_max` FLOAT,
	IN `Presul` VARCHAR(45),
	IN `Pmuestra` INT
)
BEGIN
	INSERT INTO orden_has_analisis (idOrden,idAnalisis,valor_min,valor_max,resultado,idMuestra)
	VALUES (Porden,Panalisis,Pvalor_min,Pvalor_max,Presul,Pmuestra);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Permiso
DELIMITER //
CREATE PROCEDURE `USP_I_Permiso`(
	IN `Pdescripcion` VARCHAR(45)
)
BEGIN
	INSERT INTO permiso (descripcion)
	VALUES (Pdescripcion);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Producto
DELIMITER //
CREATE PROCEDURE `USP_I_Producto`(
	IN `Pdescripcion` VARCHAR(45),
	IN `Pcant` FLOAT,
	IN `Pstock` INT,
	IN `Pmarca` INT,
	IN `Ptipo_pro` INT,
	IN `Ptipo_med` INT
)
BEGIN
	INSERT INTO producto (descripcion,cantidad,stock,idMarca,idTipo_producto,idTipo_medida)
	VALUES (Pdescripcion,Pcant,Pstock,Pmarca,Ptipo_pro,Ptipo_med);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Producto_Detalle
DELIMITER //
CREATE PROCEDURE `USP_I_Producto_Detalle`(
	IN `Pcant` FLOAT,
	IN `Pfecha` DATE,
	IN `Pproducto` INT
)
BEGIN
	INSERT INTO producto_detalle (cantidad,fech_vencimiento,idProducto)
	VALUES(Pcant,Pfecha,Pproducto);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Proveedor
DELIMITER //
CREATE PROCEDURE `USP_I_Proveedor`(
	IN `Pnro_docu` VARCHAR(20),
	IN `Prazon_so` VARCHAR(45),
	IN `Pdireccion` VARCHAR(45),
	IN `Pcelular` VARCHAR(15),
	IN `Pestado` TINYINT,
	IN `Ptipo_docu` INT
)
BEGIN
	INSERT INTO proveedor (nro_documento,razon_social,direccion,celular,estado,idTipo_documento)
	VALUES (Pnro_docu,Prazon_so,Pdireccion,Pcelular,Pestado,Ptipo_docu);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Rol
DELIMITER //
CREATE PROCEDURE `USP_I_Rol`(
	IN `Pdescripcion` VARCHAR(45)
)
BEGIN
	INSERT INTO rol (descripcion)
	VALUES (Pdescripcion);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Rol_has_Permiso
DELIMITER //
CREATE PROCEDURE `USP_I_Rol_has_Permiso`(
	IN `Prol` INT,
	IN `Ppermiso` INT
)
BEGIN
	INSERT INTO rol_has_permiso(idRol,idPermiso)
	VALUES (Prol,Ppermiso);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Tipo_Documento
DELIMITER //
CREATE PROCEDURE `USP_I_Tipo_Documento`(
	IN `Pdescripcion` VARCHAR(30)
)
BEGIN
	INSERT INTO tipo_documento (descripcion)
	VALUES(Pdescripcion);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Tipo_Medida
DELIMITER //
CREATE PROCEDURE `USP_I_Tipo_Medida`(
	IN `Pdescripcion` VARCHAR(15)
)
BEGIN
	INSERT INTO tipo_medida (descripcion)
	VALUES(Pdescripcion);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Tipo_Producto
DELIMITER //
CREATE PROCEDURE `USP_I_Tipo_Producto`(
	IN `Pdescripcion` VARCHAR(45)
)
BEGIN
	INSERT INTO tipo_producto (descripcion)
	VALUES (Pdescripcion);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_I_Valor_referencial
DELIMITER //
CREATE PROCEDURE `USP_I_Valor_referencial`(
	IN `Pvalor_min` FLOAT,
	IN `Pvalor_max` FLOAT,
	IN `Psexo` VARCHAR(15),
	IN `Pedad_min` INT,
	IN `Pedad_max` INT,
	IN `PidAnalisis` INT
)
BEGIN
	INSERT INTO valor_referencial (valor_min,valor_max,sexo,edad_min,edad_max,idAnalisis) 
	VALUES(Pvalor_min,Pvalor_max,Psexo,Pedad_min,Pedad_max,PidAnalisis);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Analisis
DELIMITER //
CREATE PROCEDURE `USP_S_Analisis`()
BEGIN
	SELECT * FROM analisis;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Analisis_has_Producto
DELIMITER //
CREATE PROCEDURE `USP_S_Analisis_has_Producto`()
BEGIN
	SELECT * FROM Analisis_has_Producto;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Cargo
DELIMITER //
CREATE PROCEDURE `USP_S_Cargo`()
BEGIN
	SELECT * FROM Cargo;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Cliente
DELIMITER //
CREATE PROCEDURE `USP_S_Cliente`()
BEGIN
	SELECT * FROM Cliente;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Doc_compra_venta
DELIMITER //
CREATE PROCEDURE `USP_S_Doc_compra_venta`()
BEGIN
	SELECT * FROM Doc_compra_venta;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Doc_compra_venta_has_Producto
DELIMITER //
CREATE PROCEDURE `USP_S_Doc_compra_venta_has_Producto`()
BEGIN
	SELECT * FROM Doc_compra_venta_has_Producto;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Empleado
DELIMITER //
CREATE PROCEDURE `USP_S_Empleado`()
BEGIN
	SELECT * FROM Empleado;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Historial
DELIMITER //
CREATE PROCEDURE `USP_S_Historial`()
BEGIN
	SELECT * FROM Historial;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Marca
DELIMITER //
CREATE PROCEDURE `USP_S_Marca`()
BEGIN
	SELECT * FROM Marca;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Muestra
DELIMITER //
CREATE PROCEDURE `USP_S_Muestra`()
BEGIN
	SELECT * FROM Muestra;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Orden
DELIMITER //
CREATE PROCEDURE `USP_S_Orden`()
BEGIN
	SELECT * FROM Orden;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Orden_has_Analisis
DELIMITER //
CREATE PROCEDURE `USP_S_Orden_has_Analisis`()
BEGIN
	SELECT * FROM orden_has_analisis;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Permiso
DELIMITER //
CREATE PROCEDURE `USP_S_Permiso`()
BEGIN
	SELECT * FROM permiso;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Producto
DELIMITER //
CREATE PROCEDURE `USP_S_Producto`()
BEGIN
	SELECT * FROM producto;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Producto_Detalle
DELIMITER //
CREATE PROCEDURE `USP_S_Producto_Detalle`()
BEGIN
	SELECT * FROM producto_detalle;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Proveedor
DELIMITER //
CREATE PROCEDURE `USP_S_Proveedor`()
BEGIN
	SELECT * FROM proveedor;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Rol
DELIMITER //
CREATE PROCEDURE `USP_S_Rol`()
BEGIN
	SELECT * FROM rol;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Rol_has_Permiso
DELIMITER //
CREATE PROCEDURE `USP_S_Rol_has_Permiso`()
BEGIN
	SELECT * FROM rol_has_permiso;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Tipo_Documento
DELIMITER //
CREATE PROCEDURE `USP_S_Tipo_Documento`()
BEGIN
	SELECT * FROM tipo_documento;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Tipo_Medida
DELIMITER //
CREATE PROCEDURE `USP_S_Tipo_Medida`()
BEGIN
	SELECT * FROM tipo_medida;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Tipo_Producto
DELIMITER //
CREATE PROCEDURE `USP_S_Tipo_Producto`()
BEGIN
	SELECT * FROM tipo_producto;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_S_Valor_referencial
DELIMITER //
CREATE PROCEDURE `USP_S_Valor_referencial`()
BEGIN
	SELECT * FROM valor_referencial;
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Analisis
DELIMITER //
CREATE PROCEDURE `USP_U_Analisis`(
	IN `Pid` INT,
	IN `Pnombre` VARCHAR(45),
	IN `Pcosto` FLOAT,
	IN `Pestado` INT
)
BEGIN
	UPDATE analisis
	SET
	   nombre=Pnombre,
	   costo=Pcosto,
	   estado=Pestado
	WHERE (idAnalisis=Pid);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Analisis_has_Producto
DELIMITER //
CREATE PROCEDURE `USP_U_Analisis_has_Producto`(
	IN `Panalisis` INT,
	IN `Pproducto` INT,
	IN `Pcantidad` FLOAT
)
BEGIN
	UPDATE Analisis_has_Producto
	SET
	   cantidad=Pcantidad
	WHERE (idAnalisis=Panalisis AND idProducto=Pproducto);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Cargo
DELIMITER //
CREATE PROCEDURE `USP_U_Cargo`(
	IN `Pid` INT,
	IN `Pdescripcion` VARCHAR(30)
)
BEGIN
	UPDATE Cargo
	SET
	   descripcion=Pdescripcion
	WHERE (idCargo=Pid);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Cliente
DELIMITER //
CREATE PROCEDURE `USP_U_Cliente`(
	IN `Pnro_doc` VARCHAR(20),
	IN `Pnombre` VARCHAR(45),
	IN `Papellido` VARCHAR(45),
	IN `Pfech_nac` VARCHAR(15),
	IN `Psexo` VARCHAR(15),
	IN `Pdireccion` TEXT,
	IN `Pcorreo` VARCHAR(45),
	IN `Pcelular` VARCHAR(15),
	IN `Ptipo_doc` INT
)
BEGIN
	UPDATE Cliente
	SET
	   nombre=Pnombre,
	   apellido=Papellido,
	   fech_nacimiento=Pfech_nac,
	   sexo=Psexo,
	   direccion=Pdireccion,
	   correo=Pcorreo,
	   celular=Pcelular,
	   idTipo_documento=Ptipo_doc
	WHERE (nro_documento=Pnro_doc);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Doc_compra_venta
DELIMITER //
CREATE PROCEDURE `USP_U_Doc_compra_venta`(
	IN `PidDoc` INT,
	IN `Pnro_doc` VARCHAR(45),
	IN `Prazon_social` TEXT,
	IN `Pfecha` DATE,
	IN `Ptotal` FLOAT,
	IN `Ptipo_doc` INT,
	IN `Porden` INT,
	IN `Pprove_nro_doc` INT
)
BEGIN
	UPDATE Doc_compra_venta
	SET
	   nro_documento=Pnro_doc,
	   razon_social=Prazon_social,
	   fecha=Pfecha,
	   total=Ptotal,
	   idTipo_documento=Ptipo_doc,
	   idOrden=Porden,
	   Proveedor_nro_documento=Pprove_nro_doc
	WHERE (idDoc_compra_venta=PidDoc);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Doc_compra_venta_has_Producto
DELIMITER //
CREATE PROCEDURE `USP_U_Doc_compra_venta_has_Producto`(
	IN `Pdoc_cv` INT,
	IN `Pprod` INT,
	IN `Pprecio` FLOAT,
	IN `Pcantidad` INT
)
BEGIN
	UPDATE Doc_compra_venta_has_Producto
	SET
	   
	   precio_compra=Pprecio,
	   cantidad=Pcantidad
	WHERE (idDoc_compra_venta=Pdoc_cv AND idProducto=Pprod);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Empleado
DELIMITER //
CREATE PROCEDURE `USP_U_Empleado`(
	IN `Pnro_doc` VARCHAR(20),
	IN `Pnombre` VARCHAR(45),
	IN `Papellido` VARCHAR(45),
	IN `Pfech_nac` VARCHAR(15),
	IN `Pdireccion` TEXT,
	IN `Pcelular` VARCHAR(15),
	IN `Pclave` VARCHAR(6),
	IN `Pestado` INT,
	IN `Prol` INT,
	IN `Ptipo_doc` INT
)
BEGIN
	UPDATE Empleado
	SET
	   nombre=Pnombre,
	   apellido=Papellido,
	   fech_nacimiento=Pfech_nac,
	   direccion=Pdireccion,
	   celular=Pcelular,
	   clave=Pclave,
	   estado=Pestado,
	   idRol=Prol,
	   idTipo_documento=Ptipo_doc
	WHERE (nro_documento=Pnro_doc);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Historial
DELIMITER //
CREATE PROCEDURE `USP_U_Historial`(
	IN `Pid` INT,
	IN `Pfecha` VARCHAR(50),
	IN `Ptipo` VARCHAR(45),
	IN `Paccion` TEXT,
	IN `Pnro_doc` VARCHAR(20)
)
BEGIN
	UPDATE Historial
	SET
	   fecha=Pfecha,
	   tipo=Ptipo,
	   accion=Paccion,
	   nro_documento=Pnro_doc
	WHERE (idHistorial=Pid);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Marca
DELIMITER //
CREATE PROCEDURE `USP_U_Marca`(
	IN `Pid` INT,
	IN `Pdescripcion` VARCHAR(45)
)
BEGIN
	UPDATE Marca
	SET
	   descripcion=Pdescripcion
	WHERE (idMarca=Pid);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Muestra
DELIMITER //
CREATE PROCEDURE `USP_U_Muestra`(
	IN `Pid` INT,
	IN `Pdescripcion` VARCHAR(45)
)
BEGIN
	UPDATE Muestra
	SET
	   descripcion=Pdescripcion
	WHERE (idMuestra=Pid);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Orden
DELIMITER //
CREATE PROCEDURE `USP_U_Orden`(
	IN `Pid` INT,
	IN `Pfecha` DATETIME,
	IN `Pestado` VARCHAR(15),
	IN `Pcliente` VARCHAR(20),
	IN `Pempleado` VARCHAR(20)
)
BEGIN
	UPDATE Orden
	SET
	   fecha=Pfecha,
	   estado=Pestado,
	   Cliente_nro_documento=Pcliente,
	   Empleado_nro_documento=Pempleado
	WHERE (idOrden=Pid);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Orden_has_Analisis
DELIMITER //
CREATE PROCEDURE `USP_U_Orden_has_Analisis`(
	IN `Porden` INT,
	IN `Panalisis` INT,
	IN `Pvalor_min` FLOAT,
	IN `Pvalor_max` FLOAT,
	IN `Presul` VARCHAR(45),
	IN `Pmuestra` INT
)
BEGIN
	UPDATE orden_has_analisis
	SET
		valor_min=Pvalor_min,
		valor_max=Pvalor_max,
		resultado=Presul,
		idMuestra=Pmuestra
	WHERE (idOrden=Porden AND idAnalisis=Panalisis);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Permiso
DELIMITER //
CREATE PROCEDURE `USP_U_Permiso`(
	IN `Ppermiso` INT,
	IN `Pdescripcion` VARCHAR(45)
)
BEGIN
	UPDATE permiso
	SET
		descripcion=Pdescripcion
	WHERE(idPermiso=Ppermiso);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Producto
DELIMITER //
CREATE PROCEDURE `USP_U_Producto`(
	IN `Pproducto` INT,
	IN `Pdescripcion` VARCHAR(45),
	IN `Pcant` FLOAT,
	IN `Pstock` INT,
	IN `Pmarca` INT,
	IN `Ptipo_pro` INT,
	IN `Ptipo_med` INT
)
BEGIN
	UPDATE producto
	SET
		descripcion=Pdescripcion,
		cantidad=Pcant,
		stock=Pstock,
		idMarca=Pmarca,
		idTipo_producto=Ptipo_pro,
		idTipo_medida=Ptipo_med
	WHERE(idProducto=Pproducto);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Producto_Detalle
DELIMITER //
CREATE PROCEDURE `USP_U_Producto_Detalle`(
	IN `Pprod_detalle` INT,
	IN `Pcant` FLOAT,
	IN `Pfecha` DATE,
	IN `Pproducto` INT
)
BEGIN
	UPDATE producto_detalle
	SET 
		
		cantidad=Pcant,
		fech_vencimiento=Pfecha,
		idProducto=Pproducto
		WHERE(idProducto_detalle=Pprod_detalle);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Proveedor
DELIMITER //
CREATE PROCEDURE `USP_U_Proveedor`(
	IN `Pnro_docu` VARCHAR(20),
	IN `Prazon_so` VARCHAR(45),
	IN `Pdireccion` VARCHAR(45),
	IN `Pcelular` VARCHAR(15),
	IN `Pestado` TINYINT,
	IN `Ptipo_docu` INT
)
BEGIN
	UPDATE proveedor
	SET
		razon_social=Prazon_so,
		direccion=Pdireccion,
		celular=Pcelular,
		estado=Pestado,
		idTipo_documento=Ptipo_docu
	WHERE (nro_documento=Pnro_docu);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Rol
DELIMITER //
CREATE PROCEDURE `USP_U_Rol`(
	IN `Prol` INT,
	IN `Pdescripcion` VARCHAR(45)
)
BEGIN
	UPDATE rol
	SET
		descripcion=Pdescripcion
	WHERE(idRol=Prol);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Tipo_Documento
DELIMITER //
CREATE PROCEDURE `USP_U_Tipo_Documento`(
	IN `Ptipo_docu` INT,
	IN `Pdescripcion` VARCHAR(30)
)
BEGIN
	UPDATE tipo_documento
	SET
		descripcion=Pdescripcion
	WHERE(idTipo_documento=Ptipo_docu);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Tipo_Medida
DELIMITER //
CREATE PROCEDURE `USP_U_Tipo_Medida`(
	IN `Ptipo_med` INT,
	IN `Pdescripcion` VARCHAR(15)
)
BEGIN
	UPDATE tipo_medida
	SET
		descripcion=Pdescripcion
	WHERE(idTipo_Medida=Ptipo_med);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Tipo_Producto
DELIMITER //
CREATE PROCEDURE `USP_U_Tipo_Producto`(
	IN `Ptipo_pro` INT,
	IN `Pdescripcion` VARCHAR(45)
)
BEGIN
	UPDATE tipo_producto
	SET
		descripcion=Pdescripcion
	WHERE(idTipo_producto=Ptipo_pro);
END//
DELIMITER ;

-- Volcando estructura para procedimiento laboratorio_omylab.USP_U_Valor_referencial
DELIMITER //
CREATE PROCEDURE `USP_U_Valor_referencial`(
	IN `Pvalor_min` FLOAT,
	IN `Pvalor_max` FLOAT,
	IN `Psexo` VARCHAR(15),
	IN `Pedad_min` INT,
	IN `Pedad_max` INT,
	IN `PidAnalisis` INT,
	IN `PidValor_r` INT
)
BEGIN
	UPDATE valor_referencial
	SET
	   valor_min=Pvalor_min,
	   valor_max=Pvalor_max,
	   sexo=Psexo,
	   edad_min=Pedad_min,
	   edad_max=Pedad_max,
	   idAnalisis=PidAnalisis
	WHERE (idValor_referencial=PidValor_r);
END//
DELIMITER ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
