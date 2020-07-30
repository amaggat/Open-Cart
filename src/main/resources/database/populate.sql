/* Brand */
# INSERT INTO brand VALUES ('1', 'Laptop', 'Expensive');
# INSERT INTO brand VALUES ('2', 'Smartphone', 'Expensive');
# INSERT INTO brand VALUES ('3', 'Car', 'Expensive');
# INSERT INTO brand VALUES ('4', 'Wine', 'Expensive');
# INSERT INTO brand VALUES ('5', 'Diamond', 'Expensive');
# INSERT INTO brand VALUES ('6', 'Gold', 'Expensive');
# INSERT INTO brand VALUES ('7', 'Villa', 'Expensive');
# INSERT INTO brand VALUES ('8', 'Apartment', 'Expensive');
# INSERT INTO brand VALUES ('9', 'Planet', 'Expensive');
# INSERT INTO brand VALUES ('10', 'Crush', 'Expensive');

/* Product */

-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: opencart
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Smartphone','This brand is so expensive'),(2,'Laptop','This brand is so expensive'),(3,'Camera','This brand is so expensive'),(4,'You','This brand is non-valuable');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,'2020-10-30 08:57:52',1);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cart-product`
--

LOCK TABLES `cart-product` WRITE;
/*!40000 ALTER TABLE `cart-product` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart-product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Electronic Device','This category is so expensive\r\n'),(2,'The Fool','This category is so cheap');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category-product`
--

LOCK TABLES `category-product` WRITE;
/*!40000 ALTER TABLE `category-product` DISABLE KEYS */;
/*!40000 ALTER TABLE `category-product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Thanh','Dat','thanhdat.vnu@gmail.com','0943883280','dbuser1','$2a$10$nFt.7l8RnXWUmjfHGTaLqOEsI23fTatzHI8/FTUlNVeQ9mIQyl2/.','Mai Dich','Cau Giay','Ha Noi','Viet Nam');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer-role`
--

LOCK TABLES `customer-role` WRITE;
/*!40000 ALTER TABLE `customer-role` DISABLE KEYS */;
INSERT INTO `customer-role` VALUES (1,1,1);
/*!40000 ALTER TABLE `customer-role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'2020-08-24','2020-08-30','2020-10-30','On Arrival',1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES (1,15,2,'Mam tom kham lam');
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,1,'Rẻ lắm','iPhone 6s cộng',1,'2020-07-27','2020-07-30',3),(3,1,'Đắt lắm','iPhone 8 pờ lớt',5,'2020-07-27','2020-07-30',11),(5,1,'Đắt lắm','Mercedes Maybach S650',5,'2020-07-27','2020-07-30',123),(6,1,'Chùi đ*t','Lá Chuối',5,'2020-07-27','2020-07-30',12),(8,1,'Chưa ăn','Cháo Lòng',5,'2020-07-27','2020-07-30',12),(9,1,'Kinh lắm','Tiết Canh',5,'2020-07-27','2020-07-30',123),(10,1,'Cute','Mèo',5,'2020-07-27','2020-07-30',1),(11,1,'Cute','Sen Đá',5,'2020-07-27','2020-07-30',1),(12,1,'Chán ','Phở',5,'2020-07-27','2020-07-30',123),(13,1,'Ngon','Cây chuối',5,'2020-07-27','2020-07-30',1),(14,1,'Ngon lắm','Lá Ngón',5,'2020-07-27','2020-07-30',2),(15,1,'Riềng mẻ mắm tôm','Chó',2,'2020-06-30','2020-07-30',412),(16,1,'Riềng mẻ mắm tôm','Chó',3,'2020-07-06','2020-08-01',1234),(17,3,'Mắm Tôm','Bún Đậu',3,'2020-07-03','2020-07-19',123),(18,3,'Mắm Tôm','Thành Đạt',9,'2020-06-15','2020-07-24',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `wishlist-product`
--

LOCK TABLES `wishlist-product` WRITE;
/*!40000 ALTER TABLE `wishlist-product` DISABLE KEYS */;
/*!40000 ALTER TABLE `wishlist-product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-30 22:48:29

