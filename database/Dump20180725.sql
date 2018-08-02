-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: shopfashion
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu18.04.1

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
-- Table structure for table `CHITIETHOADON`
--

DROP TABLE IF EXISTS `CHITIETHOADON`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CHITIETHOADON` (
  `mahoadon` int(11) NOT NULL,
  `soluong` int(11) DEFAULT NULL,
  `giatien` varchar(50) DEFAULT NULL,
  `machitietsanpham` int(11) NOT NULL,
  PRIMARY KEY (`mahoadon`,`machitietsanpham`),
  CONSTRAINT `FK_CHITIETHOADON_HOADON` FOREIGN KEY (`mahoadon`) REFERENCES `HOADON` (`mahoadon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHITIETHOADON`
--

LOCK TABLES `CHITIETHOADON` WRITE;
/*!40000 ALTER TABLE `CHITIETHOADON` DISABLE KEYS */;
INSERT INTO `CHITIETHOADON` VALUES (1,1,'100.000',0),(2,1,'100.000',0);
/*!40000 ALTER TABLE `CHITIETHOADON` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CHITIETKHUYENMAI`
--

DROP TABLE IF EXISTS `CHITIETKHUYENMAI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CHITIETKHUYENMAI` (
  `makhuyenmai` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  PRIMARY KEY (`makhuyenmai`,`masanpham`),
  KEY `FK_CHITIETKHUYENMAI_SANPHAM` (`masanpham`),
  CONSTRAINT `FK_CHITIETKHUYENMAI_SANPHAM` FOREIGN KEY (`masanpham`) REFERENCES `SANPHAM` (`masanpham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHITIETKHUYENMAI`
--

LOCK TABLES `CHITIETKHUYENMAI` WRITE;
/*!40000 ALTER TABLE `CHITIETKHUYENMAI` DISABLE KEYS */;
/*!40000 ALTER TABLE `CHITIETKHUYENMAI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CHITIETSANPHAM`
--

DROP TABLE IF EXISTS `CHITIETSANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CHITIETSANPHAM` (
  `machitietsanpham` int(11) NOT NULL AUTO_INCREMENT,
  `soluong` int(11) DEFAULT NULL,
  `ngaynhap` varchar(50) DEFAULT NULL,
  `masanpham` int(11) DEFAULT NULL,
  `masize` int(11) DEFAULT NULL,
  `mamau` int(11) DEFAULT NULL,
  PRIMARY KEY (`machitietsanpham`),
  KEY `FK_CHITIET_SANPHAM` (`masanpham`),
  KEY `FK_CHITIET_SIZE` (`masize`),
  KEY `FK_CHITIET_MAUSANPHAM` (`mamau`),
  CONSTRAINT `FK_CHITIET_MAUSANPHAM` FOREIGN KEY (`mamau`) REFERENCES `MAUSANPHAM` (`mamau`),
  CONSTRAINT `FK_CHITIET_SANPHAM` FOREIGN KEY (`masanpham`) REFERENCES `SANPHAM` (`masanpham`),
  CONSTRAINT `FK_CHITIET_SIZE` FOREIGN KEY (`masize`) REFERENCES `SIZESANPHAM` (`masize`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHITIETSANPHAM`
--

LOCK TABLES `CHITIETSANPHAM` WRITE;
/*!40000 ALTER TABLE `CHITIETSANPHAM` DISABLE KEYS */;
INSERT INTO `CHITIETSANPHAM` VALUES (2,13,'08-12-2018',3,3,2),(3,12,'13-2-2018',2,1,3);
/*!40000 ALTER TABLE `CHITIETSANPHAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CHUCVU`
--

DROP TABLE IF EXISTS `CHUCVU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CHUCVU` (
  `machucvu` int(11) NOT NULL AUTO_INCREMENT,
  `tenchucvu` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`machucvu`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHUCVU`
--

LOCK TABLES `CHUCVU` WRITE;
/*!40000 ALTER TABLE `CHUCVU` DISABLE KEYS */;
INSERT INTO `CHUCVU` VALUES (1,'nhân viên'),(2,'admin');
/*!40000 ALTER TABLE `CHUCVU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DANHMUCSANPHAM`
--

DROP TABLE IF EXISTS `DANHMUCSANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DANHMUCSANPHAM` (
  `madanhmuc` int(11) NOT NULL AUTO_INCREMENT,
  `tendanhmuc` varchar(30) DEFAULT NULL,
  `hinhdanhmuc` text,
  PRIMARY KEY (`madanhmuc`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DANHMUCSANPHAM`
--

LOCK TABLES `DANHMUCSANPHAM` WRITE;
/*!40000 ALTER TABLE `DANHMUCSANPHAM` DISABLE KEYS */;
INSERT INTO `DANHMUCSANPHAM` VALUES (1,'áo khoác nam',NULL),(2,'áo sơ mi',NULL),(3,'áo phông',NULL),(4,'váy công sở',NULL),(5,'váy ngắn',NULL),(6,'áo khoác',NULL),(7,'quần âu',''),(8,'váy dài',NULL);
/*!40000 ALTER TABLE `DANHMUCSANPHAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HOADON`
--

DROP TABLE IF EXISTS `HOADON`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HOADON` (
  `mahoadon` int(11) NOT NULL AUTO_INCREMENT,
  `tenkhachhang` varchar(50) DEFAULT NULL,
  `sodt` char(12) DEFAULT NULL,
  `diachigiaohang` varchar(50) DEFAULT NULL,
  `tinhtrang` tinyint(4) DEFAULT NULL,
  `ngaylap` varchar(50) DEFAULT NULL,
  `hinhthucgiaohang` varchar(50) DEFAULT NULL,
  `ghichu` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`mahoadon`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HOADON`
--

LOCK TABLES `HOADON` WRITE;
/*!40000 ALTER TABLE `HOADON` DISABLE KEYS */;
INSERT INTO `HOADON` VALUES (1,'Lê Văn Dũng','01649987549','Trần Cung',1,'21-07-2018','tận nhà','Giao hàng ngay'),(2,'Nguyễn Thị Hường','01649987548','Hải Dương',0,'22-07-2018','cửa hàng','Giao hàng ngay');
/*!40000 ALTER TABLE `HOADON` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `KHUYENMAI`
--

DROP TABLE IF EXISTS `KHUYENMAI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `KHUYENMAI` (
  `makhuyenmai` int(11) NOT NULL AUTO_INCREMENT,
  `tenkhuyenmai` varchar(200) DEFAULT NULL,
  `thoigianbatdau` varchar(50) DEFAULT NULL,
  `thoigianketthuc` varchar(50) DEFAULT NULL,
  `mota` text,
  `hinhkhuyenmai` text,
  `giagiam` int(11) DEFAULT NULL,
  PRIMARY KEY (`makhuyenmai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KHUYENMAI`
--

LOCK TABLES `KHUYENMAI` WRITE;
/*!40000 ALTER TABLE `KHUYENMAI` DISABLE KEYS */;
/*!40000 ALTER TABLE `KHUYENMAI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MAUSANPHAM`
--

DROP TABLE IF EXISTS `MAUSANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MAUSANPHAM` (
  `mamau` int(11) NOT NULL AUTO_INCREMENT,
  `tenmau` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mamau`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MAUSANPHAM`
--

LOCK TABLES `MAUSANPHAM` WRITE;
/*!40000 ALTER TABLE `MAUSANPHAM` DISABLE KEYS */;
INSERT INTO `MAUSANPHAM` VALUES (1,'màu vàng'),(2,'màu đen'),(3,'màu hường');
/*!40000 ALTER TABLE `MAUSANPHAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NHANVIEN`
--

DROP TABLE IF EXISTS `NHANVIEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NHANVIEN` (
  `manhanvien` int(11) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(50) DEFAULT NULL,
  `diachi` varchar(50) DEFAULT NULL,
  `gioitinh` bit(1) DEFAULT NULL,
  `cmnd` char(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tendangnhap` varchar(50) DEFAULT NULL,
  `matkhau` varchar(100) DEFAULT NULL,
  `machucvu` int(11) DEFAULT NULL,
  PRIMARY KEY (`manhanvien`),
  KEY `FK_NHANVIEN_CHUCVU` (`machucvu`),
  CONSTRAINT `FK_NHANVIEN_CHUCVU` FOREIGN KEY (`machucvu`) REFERENCES `CHUCVU` (`machucvu`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NHANVIEN`
--

LOCK TABLES `NHANVIEN` WRITE;
/*!40000 ALTER TABLE `NHANVIEN` DISABLE KEYS */;
INSERT INTO `NHANVIEN` VALUES (2,'Lê Văn Dũng','Thanh Hóa','','100','levandung@gmail.c','anhdung','12345',2),(3,'Nguyễn Thị Hường','Hải Dương','\0','101','nguyenthihuong@gmail.c','emhuong','12345',1),(4,'Bùi Vân Anh','Hà Nội','\0','102','buivananh@gmail.com','emvananh','12345',1),(5,'Nguyễn Thị Nhi','Hà Nội','\0','103','nguyenthinhi@gmail.com','emnhi','12345',1),(12,NULL,NULL,'\0',NULL,NULL,NULL,'12345',NULL);
/*!40000 ALTER TABLE `NHANVIEN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SANPHAM`
--

DROP TABLE IF EXISTS `SANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SANPHAM` (
  `masanpham` int(11) NOT NULL AUTO_INCREMENT,
  `tensanpham` varchar(100) DEFAULT NULL,
  `giatien` varchar(50) DEFAULT NULL,
  `mota` text,
  `hinhsanpham` text,
  `madanhmuc` int(11) DEFAULT NULL,
  `gianhcho` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`masanpham`),
  KEY `FK_SANPHAM_DANHMUC` (`madanhmuc`),
  CONSTRAINT `FK_SANPHAM_DANHMUC` FOREIGN KEY (`madanhmuc`) REFERENCES `DANHMUCSANPHAM` (`madanhmuc`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SANPHAM`
--

LOCK TABLES `SANPHAM` WRITE;
/*!40000 ALTER TABLE `SANPHAM` DISABLE KEYS */;
INSERT INTO `SANPHAM` VALUES (1,'váy xòe bánh bèo','210.000','mát mẻ và đẹp dáng','thoitrangnu_1.jpg',3,'nữ'),(2,'váy xòe thời thượng','120.000','mát mẻ và đẹp dáng','thoitrangnu_2.jpg',5,'nữ'),(3,'váy dài quý phái','200.000','mát mẻ và đẹp dáng','thoitrangnu_3.jpg',8,'nữ'),(4,'áo xinh xắn','100.000','mát mẻ và đẹp dáng','thoitrangnu_4.jpg',3,'nữ'),(5,'áo công sở','110.000','mát mẻ và đẹp dáng','thoitrangnu_5.jpg',3,'nữ'),(6,'áo khoác ấm áp','210.000','mát mẻ và đẹp dáng','thoitrangnu_6.jpg',6,'nữ'),(7,'áo khoác quý phái','310.000','mát mẻ và đẹp dáng','thoitrangnu_7.jpg',6,'nữ'),(8,'áo khoác công sở','210.000','mát mẻ và đẹp dáng','thoitrangnu_8.jpg',6,'nữ'),(9,'váy ngắn sành điệu','210.000','mát mẻ và đẹp dáng','thoitrangnu_9.jpg',5,'nữ'),(10,'váy ngắn bánh bèo','150.000','mát mẻ và đẹp dáng','thoitrangnu_10.jpg',5,'nữ'),(11,'váy ngắn mùa hè','210.000','mát mẻ và đẹp dáng','thoitrangnu_11.jpg',5,'nữ'),(12,'áo phông mát mẻ','210.000','mát mẻ và đẹp dáng','thoitrangnu_12.jpg',3,'nữ'),(13,'váy dài bánh bèo','140.000','mát mẻ và đẹp dáng','thoitrangnu_13.png',8,'nữ'),(14,'váy ngắn tươi vui','130.000','mát mẻ và đẹp dáng','thoitrangnu_14.jpg',5,'nữ'),(15,'váy dài sang trọng','310.000','mát mẻ và đẹp dáng','thoitrangnu_15.jpg',8,'nữ'),(16,'váy ngắn công sở','210.000','mát mẻ và đẹp dáng','thoitrangnu_16.jpg',4,'nữ'),(17,'váy liền công sở','260.000','mát mẻ và đẹp dáng','thoitrangnu_17.jpg',4,'nữ'),(18,'quần âu nam năng động','210.000','mát mẻ và đẹp dáng','thoitrangnam_1.jpg',7,'nam'),(19,'quần âu nam lịch sự','240.000','mát mẻ và đẹp dáng','thoitrangnam_2.jpg',7,'nam'),(20,'áo khoác nam ấm áp','290.000','mát mẻ và đẹp dáng','thoitrangnam_3.jpg',1,'nam');
/*!40000 ALTER TABLE `SANPHAM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SIZESANPHAM`
--

DROP TABLE IF EXISTS `SIZESANPHAM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SIZESANPHAM` (
  `masize` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`masize`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SIZESANPHAM`
--

LOCK TABLES `SIZESANPHAM` WRITE;
/*!40000 ALTER TABLE `SIZESANPHAM` DISABLE KEYS */;
INSERT INTO `SIZESANPHAM` VALUES (1,'M'),(2,'L'),(3,'XL');
/*!40000 ALTER TABLE `SIZESANPHAM` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-25 22:20:12
