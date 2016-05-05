-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: emprestimo
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agencia`
--

DROP TABLE IF EXISTS `agencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agencia` (
  `cod_agencia` int(11) NOT NULL AUTO_INCREMENT,
  `dependencia` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `prefixo` int(11) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod_agencia`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agencia`
--

LOCK TABLES `agencia` WRITE;
/*!40000 ALTER TABLE `agencia` DISABLE KEYS */;
INSERT INTO `agencia` VALUES (2,'01','agencia 02',2,'MT'),(3,'02','agencia 03',3,'MT'),(4,'03','agencia 04',4,'MT'),(5,'01','agencia 1',1,'MT');
/*!40000 ALTER TABLE `agencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emprestimo`
--

DROP TABLE IF EXISTS `emprestimo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emprestimo` (
  `idEmprestimo` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` varchar(255) DEFAULT NULL,
  `contrapartida` double DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `itens_financiar` varchar(255) DEFAULT NULL,
  `valor_financiamento` double DEFAULT NULL,
  `agencia_cod_agencia` int(11) DEFAULT NULL,
  `fase_idfases` int(11) DEFAULT NULL,
  `porte_idporte` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEmprestimo`),
  KEY `FK_emprestimo_agencia_cod_agencia` (`agencia_cod_agencia`),
  KEY `FK_emprestimo_porte_idporte` (`porte_idporte`),
  KEY `FK_emprestimo_fase_idfases` (`fase_idfases`),
  CONSTRAINT `FK_emprestimo_agencia_cod_agencia` FOREIGN KEY (`agencia_cod_agencia`) REFERENCES `agencia` (`cod_agencia`),
  CONSTRAINT `FK_emprestimo_fase_idfases` FOREIGN KEY (`fase_idfases`) REFERENCES `fase` (`idfases`),
  CONSTRAINT `FK_emprestimo_porte_idporte` FOREIGN KEY (`porte_idporte`) REFERENCES `porte` (`idporte`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emprestimo`
--

LOCK TABLES `emprestimo` WRITE;
/*!40000 ALTER TABLE `emprestimo` DISABLE KEYS */;
INSERT INTO `emprestimo` VALUES (1,'Maria José',NULL,'777.777.777-77','2016-05-16','Máquina de Lavar',2222,3,4,2),(2,'José Maria',NULL,'444.444.444-44','2016-05-09','Máquina de Café',6000,3,2,3);
/*!40000 ALTER TABLE `emprestimo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fase`
--

DROP TABLE IF EXISTS `fase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fase` (
  `idfases` int(11) NOT NULL AUTO_INCREMENT,
  `valor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idfases`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fase`
--

LOCK TABLES `fase` WRITE;
/*!40000 ALTER TABLE `fase` DISABLE KEYS */;
INSERT INTO `fase` VALUES (2,'Aprovado'),(3,'Não Aprovado'),(4,'Em Análise');
/*!40000 ALTER TABLE `fase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `navegacao`
--

DROP TABLE IF EXISTS `navegacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `navegacao` (
  `idnavegacao` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `pagina` varchar(255) DEFAULT NULL,
  `usuario_idusuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idnavegacao`),
  KEY `FK_navegacao_usuario_idusuario` (`usuario_idusuario`),
  CONSTRAINT `FK_navegacao_usuario_idusuario` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `navegacao`
--

LOCK TABLES `navegacao` WRITE;
/*!40000 ALTER TABLE `navegacao` DISABLE KEYS */;
INSERT INTO `navegacao` VALUES (1,'2016-05-05 17:24:23','/gestor-emprestimo-master/index.xhtml',3),(2,'2016-05-05 17:24:26','/gestor-emprestimo-master/index.xhtml',3),(3,'2016-05-05 17:25:01','/gestor-emprestimo-master/index.xhtml',3),(4,'2016-05-05 17:25:04','/gestor-emprestimo-master/index.xhtml',3),(5,'2016-05-05 17:25:56','/gestor-emprestimo-master/index.xhtml',3),(6,'2016-05-05 17:26:08','/gestor-emprestimo-master/index.xhtml',3),(7,'2016-05-05 17:26:09','/gestor-emprestimo-master/index.xhtml',3),(8,'2016-05-05 17:26:13','/gestor-emprestimo-master/index.xhtml',3),(9,'2016-05-05 17:26:20','/gestor-emprestimo-master/index.xhtml',3),(10,'2016-05-05 17:26:47','/gestor-emprestimo-master/index.xhtml',3),(11,'2016-05-05 17:26:50','/gestor-emprestimo-master/index.xhtml',3),(12,'2016-05-05 17:27:17','/gestor-emprestimo-master/index.xhtml',3),(13,'2016-05-05 17:27:20','/gestor-emprestimo-master/navegacao/index.xhtml',3),(14,'2016-05-05 17:27:21','/gestor-emprestimo-master/registro/index.xhtml',3),(15,'2016-05-05 17:27:25','/gestor-emprestimo-master/index.xhtml',3);
/*!40000 ALTER TABLE `navegacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `porte`
--

DROP TABLE IF EXISTS `porte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `porte` (
  `idporte` int(11) NOT NULL AUTO_INCREMENT,
  `valor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idporte`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `porte`
--

LOCK TABLES `porte` WRITE;
/*!40000 ALTER TABLE `porte` DISABLE KEYS */;
INSERT INTO `porte` VALUES (2,'Médio'),(3,'Grande'),(4,'Pequeno');
/*!40000 ALTER TABLE `porte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro`
--

DROP TABLE IF EXISTS `registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro` (
  `idregistro` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `operacao` varchar(255) DEFAULT NULL,
  `emprestimo_idemprestimo` int(11) DEFAULT NULL,
  `usuario_idusuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idregistro`),
  KEY `FK_registro_usuario_idusuario` (`usuario_idusuario`),
  KEY `FK_registro_emprestimo_idemprestimo` (`emprestimo_idemprestimo`),
  CONSTRAINT `FK_registro_emprestimo_idemprestimo` FOREIGN KEY (`emprestimo_idemprestimo`) REFERENCES `emprestimo` (`idEmprestimo`),
  CONSTRAINT `FK_registro_usuario_idusuario` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro`
--

LOCK TABLES `registro` WRITE;
/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `apelido` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `matricula` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `tipo_usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'Usuario','user','userteste','Usuario','user','COMUM'),(3,'Admin','admin','teste','Administrador','admin','ADMIN');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-05 17:28:07
