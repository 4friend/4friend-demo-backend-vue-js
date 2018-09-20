/*Table structure for table `product_lines` */

DROP TABLE IF EXISTS `product_line`;

CREATE TABLE `product_line` (
  `product_line` varchar(50) NOT NULL,
  `text_description` varchar(4000) DEFAULT NULL,
  `html_description` mediumtext,
  `image` mediumblob,
  PRIMARY KEY (`product_line`)
) ;


/*Table structure for table `products` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_code` varchar(15) NOT NULL,
  `product_name` varchar(70) NOT NULL,
  `product_line` varchar(50) NOT NULL,
  `product_scale` varchar(10) NOT NULL,
  `product_vendor` varchar(50) NOT NULL,
  `product_description` text NOT NULL,
  `quantity_in_stock` INT(6) NOT NULL,
  `buy_price` decimal(10,2) NOT NULL,
  `msrp` decimal(10,2) NOT NULL,
  PRIMARY KEY (`product_code`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`product_line`) REFERENCES `product_line` (`product_line`)
);

CREATE TABLE `product_review` (
  `id` bigint AUTO_INCREMENT,
  `reviewer_email` varchar(50) NOT NULL,
  `reviewer_name` varchar(50) NOT NULL,
  `message` varchar(4000) NOT NULL,
  `rating` INT(6) NOT NULL,
  PRIMARY KEY (`id`)
) ;