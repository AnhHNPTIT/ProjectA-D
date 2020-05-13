-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2018 at 07:03 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `boec_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `Id` int(10) NOT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`Id`, `Username`, `Password`) VALUES
(1, 'dangle', 'dangle'),
(2, 'admin', 'admin'),
(5, 'dangdangdang', 'dangdang'),
(6, 'danglelele', 'lelelele'),
(7, 'aaaa', 'aaaa'),
(8, '123', ''),
(9, 'TEST TEST', 'TEST PASS'),
(10, 'TEST TEST', 'TEST PASS'),
(11, 'TEST TEST', 'TEST PASS'),
(12, 'dangtest', 'dangtest'),
(13, 'dangtest', 'dangtest'),
(14, 'test', 'test'),
(15, 'test', 'test'),
(16, 'test', 'test'),
(17, 'test', 'test'),
(18, 'test', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `Id` int(10) NOT NULL,
  `Number` int(10) NOT NULL,
  `District` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `Street` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`Id`, `Number`, `District`, `City`, `Country`, `Street`) VALUES
(1, 513125124, 'hanoi', 'hanoi', 'vietnam', 'khamthien'),
(2, 5123, 'hanoi', 'hanoi', 'vietnam', 'VanChuong'),
(3, 12, '24', '24142', '124124', '41'),
(4, 284028, '840', '840', '84', '40'),
(5, 4, '40', '40', '4141', '408'),
(6, 4, '4', '4', '4', '4'),
(7, 512121, 'aaaaa', 'aaaaa', 'aaaaa', 'aaaaa'),
(8, 122, '5161', '4124', '512', '512'),
(9, 1000, '', '', '', ''),
(10, 1000, '', '', '', ''),
(11, 1000, '', '', '', ''),
(12, 100, 'hd', 'hanoi', 'vietnam', 'pk'),
(13, 21411, 'dangtest', 'dangtest', 'dangtest', 'dangtest'),
(14, 123, 'hadong', 'hanoi', 'vietnam', 'nguyentrai'),
(15, 123, 'hadong', 'hanoi', 'vietnam', 'nguyentrai'),
(16, 123, 'hadong', 'hanoi', 'vietnam', 'nguyentrai'),
(17, 123, 'hadong', 'hanoi', 'vietnam', 'nguyentrai'),
(18, 123, 'hadong', 'hanoi', 'vietnam', 'nguyentrai');

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `Id` int(10) NOT NULL,
  `OrderId` int(10) NOT NULL,
  `EmployeePersonId` int(10) NOT NULL,
  `Sumary` float NOT NULL,
  `Date` date DEFAULT NULL,
  `Note` varchar(255) DEFAULT NULL,
  `OrderShipCompanyCompanyId` int(10) DEFAULT NULL,
  `EmployeeId` int(11) NOT NULL,
  `EmployeePersonId2` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `PublishingYear` date DEFAULT NULL,
  `SKU` int(10) NOT NULL,
  `Size` varchar(255) DEFAULT NULL,
  `PageNumber` int(10) NOT NULL,
  `ItemId` int(10) NOT NULL,
  `Author` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`PublishingYear`, `SKU`, `Size`, `PageNumber`, `ItemId`, `Author`) VALUES
('2018-05-01', 5, 'nho', 1000, 1, 'VU TRONG PHUNG'),
('2018-05-02', 52, 'to', 1000, 2, 'FFFFF');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `Id` int(10) NOT NULL,
  `TotalPrice` float NOT NULL,
  `CustomerPersonId` int(10) NOT NULL,
  `Note` varchar(255) DEFAULT 'waiting'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`Id`, `TotalPrice`, `CustomerPersonId`, `Note`) VALUES
(1, 0, 1, 'ordered'),
(2, 0, 2, 'ordered'),
(3, 0, 2, 'ordered'),
(4, 0, 2, 'ordered'),
(5, 0, 2, 'ordered'),
(6, 0, 2, 'ordered'),
(7, 0, 2, 'ordered'),
(8, 0, 1, 'waiting'),
(9, 0, 2, 'ordered'),
(10, 0, 2, 'ordered'),
(11, 0, 2, 'waiting');

-- --------------------------------------------------------

--
-- Table structure for table `cart_item`
--

CREATE TABLE `cart_item` (
  `quantity` int(20) DEFAULT NULL,
  `ItemId` int(10) NOT NULL,
  `CartId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart_item`
--

INSERT INTO `cart_item` (`quantity`, `ItemId`, `CartId`) VALUES
(1, 1, 1),
(1, 1, 2),
(1, 1, 6),
(1, 1, 7),
(1, 2, 2),
(1, 2, 3),
(1, 2, 4),
(4, 2, 6),
(1, 2, 9),
(1, 2, 10),
(1, 3, 1),
(2, 3, 4),
(1, 3, 6),
(2, 4, 6),
(1, 5, 5),
(5, 6, 2),
(1, 6, 5),
(2, 6, 6),
(1, 6, 11);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `Id` int(10) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Discriminator` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`Id`, `Name`, `Discriminator`) VALUES
(1, 'Sach Van Hoc', ''),
(2, 'Sach Khoa Hoc', ''),
(3, 'Dien dan dung', ''),
(4, 'Dien tu', ''),
(5, 'Quan Bo', ''),
(6, 'Ao thun', '');

-- --------------------------------------------------------

--
-- Table structure for table `clothes`
--

CREATE TABLE `clothes` (
  `Material` varchar(255) DEFAULT NULL,
  `Brand` varchar(255) DEFAULT NULL,
  `TypeOfGender` varchar(255) DEFAULT NULL,
  `ItemId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clothes`
--

INSERT INTO `clothes` (`Material`, `Brand`, `TypeOfGender`, `ItemId`) VALUES
('Vai bo', 'HM', 'Both', 5),
('Vai cotton', 'UNIQLO', 'Both', 6);

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `Id` int(10) NOT NULL,
  `AddressId` int(10) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `PhoneNumber` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Intro` varchar(255) DEFAULT NULL,
  `EstablishYear` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`Id`, `AddressId`, `Name`, `PhoneNumber`, `Email`, `Intro`, `EstablishYear`) VALUES
(1, 1, 'NXB Kim Dong', '154215121421', 'hergrgreg@@@@@', 'rehergrgawrg', '2017-11-01'),
(2, 2, 'NXB GIAO DUC', '581419281241', 'hraearherherh@@', 'hrehreherhrehre', '2018-05-03'),
(3, 3, 'Samsung Electronic', '5412414', 'gewwag', '5qwefag', '2018-05-01'),
(4, 5, 'Panasonic', '204810481204', 'blfmlwfmlewm', 'leglaeglak', '2018-05-01'),
(5, 6, 'HM', '513513', 'gegaeg', 'aegaeg', '2018-05-02'),
(6, 10, 'UNIQLO', '5135', '13egawegwg', 'awgaweg', '2018-05-01');

-- --------------------------------------------------------

--
-- Table structure for table `creditcard`
--

CREATE TABLE `creditcard` (
  `Id` int(10) NOT NULL,
  `CustomerPersonId` int(10) NOT NULL,
  `CardNumber` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `ExpireDate` date DEFAULT NULL,
  `CustomerId` int(10) NOT NULL,
  `CustomerPersonId2` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Intro` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `PersonId` int(10) NOT NULL,
  `AccountId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Intro`, `Type`, `PersonId`, `AccountId`) VALUES
('dangle introv', 'vip', 1, 1),
('hohoho intro', 'vip', 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `customer_notification`
--

CREATE TABLE `customer_notification` (
  `NotificationId` int(10) NOT NULL,
  `CustomerPersonId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `customer_voucher`
--

CREATE TABLE `customer_voucher` (
  `VoucherId` int(10) NOT NULL,
  `CustomerPersonId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `Id` int(10) NOT NULL,
  `Size` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Location` varchar(255) DEFAULT NULL,
  `Intro` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `electronics`
--

CREATE TABLE `electronics` (
  `Technology` varchar(255) DEFAULT NULL,
  `Power` varchar(255) DEFAULT NULL,
  `Color` varchar(255) DEFAULT NULL,
  `Size` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `ItemId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `electronics`
--

INSERT INTO `electronics` (`Technology`, `Power`, `Color`, `Size`, `Type`, `ItemId`) VALUES
('Dien tu', '500W', 'den', 'to', 'dien tu', 3),
('Dien tu', '5000W', 'do', 'bt', 'dien tu', 4);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Position` varchar(255) DEFAULT NULL,
  `Salary` float NOT NULL,
  `PersonId` int(10) NOT NULL,
  `AccountId` int(10) NOT NULL,
  `DepartmentId` int(10) NOT NULL,
  `RankId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `fullname`
--

CREATE TABLE `fullname` (
  `Id` int(10) NOT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `fullname`
--

INSERT INTO `fullname` (`Id`, `FirstName`, `LastName`) VALUES
(1, 'dang', 'le'),
(2, 'adminname', 'adminlastname'),
(3, '123', '123'),
(4, 'danghai', 'lele'),
(5, 'danghai', 'lelelele'),
(6, 'lelele', 'lelele'),
(7, 'aaaa', 'aaa'),
(8, '123', '12345'),
(9, 'TEST NAME', 'TEST LAST NAME'),
(10, 'TEST NAME', 'TEST LAST NAME'),
(11, 'TEST NAME', 'TEST LAST NAME'),
(12, 'yenyen', 'nguyen'),
(13, 'dangtest', 'dangtest'),
(14, 'yoyoyo', 'YOYOYO'),
(15, 'yoyoyo', 'YOYOYO'),
(16, 'yoyoyo', 'YOYOYO'),
(17, 'yoyoyo', 'YOYOYO'),
(18, 'yoyoyo', 'YOYOYO');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `Id` int(10) NOT NULL,
  `CompanyId` int(10) NOT NULL,
  `CategoryId` int(10) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Price` float NOT NULL,
  `Intro` varchar(255) DEFAULT NULL,
  `Quantity` bigint(20) NOT NULL,
  `ProductDate` date DEFAULT NULL,
  `ImageURI` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`Id`, `CompanyId`, `CategoryId`, `Name`, `Price`, `Intro`, `Quantity`, `ProductDate`, `ImageURI`) VALUES
(1, 2, 1, 'TIeng Viet 1', 100000, 'intro', 100, '2018-05-02', NULL),
(2, 1, 2, 'Truyen Trinh Tham', 500000, 'Trinh Tham', 10, '2018-05-01', NULL),
(3, 3, 3, 'Tivi samsung', 5000000, 'tivi to', 100, '2018-05-01', NULL),
(4, 4, 4, 'Lo vi song', 100000, 'lo vi song', 100, '2018-05-01', NULL),
(5, 5, 5, 'Quan bo xin', 100000, 'quan bo xin', 100, '2018-05-01', NULL),
(6, 6, 6, 'Ao thun do', 500000, 'mau do', 1000, '2018-05-03', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `item_order`
--

CREATE TABLE `item_order` (
  `Id` int(10) NOT NULL,
  `CartId` int(10) NOT NULL,
  `OrderTime` varchar(255) DEFAULT NULL,
  `ShippingFee` float NOT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `PalcedOn` date DEFAULT NULL,
  `PaymentType` varchar(255) DEFAULT NULL,
  `Note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item_order`
--

INSERT INTO `item_order` (`Id`, `CartId`, `OrderTime`, `ShippingFee`, `Status`, `PalcedOn`, `PaymentType`, `Note`) VALUES
(3, 2, 'now', 200.5, 'dilivering', '3895-05-04', 'CARD', 'ordering'),
(4, 3, 'now', 200.5, 'dilivering', '3895-05-04', 'CARD', 'ordering'),
(5, 4, 'now', 200.5, 'dilivering', '3895-05-04', 'CARD', 'ordering'),
(6, 5, 'now', 200.5, 'dilivering', '3895-05-04', 'CARD', 'ordering'),
(7, 6, 'now', 200.5, 'delivering', '3895-05-04', 'CARD', 'ordering'),
(8, 1, 'now', 200.5, 'delivering', '3895-05-04', 'CARD', 'ordering'),
(9, 7, '2018-05-07T11:10:53.836', 200.5, 'delivering', '3918-06-17', NULL, 'ordering'),
(10, 9, '2018-05-07T11:12:09.848', 200.5, 'delivering', '3918-06-17', NULL, 'ordering'),
(11, 10, '2018-05-07T11:17:20.997', 200.5, 'delivering', '3918-06-17', 'Cash', 'ordering');

-- --------------------------------------------------------

--
-- Table structure for table `item_promotions`
--

CREATE TABLE `item_promotions` (
  `ItemId` int(10) NOT NULL,
  `PromotionsId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `Id` int(10) NOT NULL,
  `Content` varchar(255) DEFAULT NULL,
  `Time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `order_shipcompany`
--

CREATE TABLE `order_shipcompany` (
  `OrderId` int(10) NOT NULL,
  `ShipCompanyCompanyId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `Id` int(10) NOT NULL,
  `FullNameId` int(10) NOT NULL,
  `AddressId` int(10) NOT NULL,
  `Dob` date DEFAULT NULL,
  `PhoneNumber` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `ImageURI` varchar(255) DEFAULT NULL,
  `IdentifyNumber` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`Id`, `FullNameId`, `AddressId`, `Dob`, `PhoneNumber`, `Email`, `Gender`, `ImageURI`, `IdentifyNumber`) VALUES
(1, 1, 1, '2018-05-01', '51124151', 'egawegaweg', 'nam', NULL, '512421213'),
(2, 2, 2, '2018-05-18', '512412312', 'tewgawegwag', 'nu', NULL, '5141231');

-- --------------------------------------------------------

--
-- Table structure for table `promotions`
--

CREATE TABLE `promotions` (
  `Id` int(10) NOT NULL,
  `Discount` varchar(255) NOT NULL,
  `FromDiscount` date DEFAULT NULL,
  `EndDiscount` date DEFAULT NULL,
  `PriceAfterDiscount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rank`
--

CREATE TABLE `rank` (
  `Id` int(10) NOT NULL,
  `RankName` varchar(255) DEFAULT NULL,
  `Note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shipcompany`
--

CREATE TABLE `shipcompany` (
  `DeliverType` varchar(255) DEFAULT NULL,
  `CompanyId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `shippinginfo`
--

CREATE TABLE `shippinginfo` (
  `Id` int(10) NOT NULL,
  `ItemId` int(10) NOT NULL,
  `Weight` float NOT NULL,
  `ParceSize` float NOT NULL,
  `Fee` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `voucher`
--

CREATE TABLE `voucher` (
  `Id` int(10) NOT NULL,
  `CouponValue` int(10) NOT NULL,
  `LimitedValue` bigint(20) NOT NULL,
  `quantity` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKBill394877` (`EmployeePersonId2`),
  ADD KEY `FKBill70033` (`OrderId`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ItemId`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKCart405693` (`CustomerPersonId`);

--
-- Indexes for table `cart_item`
--
ALTER TABLE `cart_item`
  ADD PRIMARY KEY (`ItemId`,`CartId`),
  ADD KEY `FKCart_Item904249` (`CartId`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `clothes`
--
ALTER TABLE `clothes`
  ADD PRIMARY KEY (`ItemId`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKCompany646510` (`AddressId`);

--
-- Indexes for table `creditcard`
--
ALTER TABLE `creditcard`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKCreditCard410960` (`CustomerPersonId2`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`PersonId`),
  ADD KEY `FKCustomer95429` (`AccountId`);

--
-- Indexes for table `customer_notification`
--
ALTER TABLE `customer_notification`
  ADD PRIMARY KEY (`NotificationId`,`CustomerPersonId`),
  ADD KEY `FKCustomer_N424414` (`CustomerPersonId`);

--
-- Indexes for table `customer_voucher`
--
ALTER TABLE `customer_voucher`
  ADD PRIMARY KEY (`VoucherId`,`CustomerPersonId`),
  ADD KEY `FKCustomer_V292545` (`CustomerPersonId`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `electronics`
--
ALTER TABLE `electronics`
  ADD PRIMARY KEY (`ItemId`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`PersonId`),
  ADD KEY `FKEmployee758069` (`RankId`),
  ADD KEY `FKEmployee702433` (`DepartmentId`),
  ADD KEY `FKEmployee390432` (`AccountId`);

--
-- Indexes for table `fullname`
--
ALTER TABLE `fullname`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKItem525138` (`CategoryId`),
  ADD KEY `FKItem389531` (`CompanyId`);

--
-- Indexes for table `item_order`
--
ALTER TABLE `item_order`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKOrder795661` (`CartId`);

--
-- Indexes for table `item_promotions`
--
ALTER TABLE `item_promotions`
  ADD PRIMARY KEY (`ItemId`,`PromotionsId`),
  ADD KEY `FKItem_Promo888149` (`PromotionsId`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `order_shipcompany`
--
ALTER TABLE `order_shipcompany`
  ADD PRIMARY KEY (`OrderId`,`ShipCompanyCompanyId`),
  ADD KEY `FKOrder_Ship137659` (`ShipCompanyCompanyId`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `IdentifyNumber` (`IdentifyNumber`),
  ADD KEY `FKPerson626850` (`AddressId`),
  ADD KEY `FKPerson905968` (`FullNameId`);

--
-- Indexes for table `promotions`
--
ALTER TABLE `promotions`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `rank`
--
ALTER TABLE `rank`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `shipcompany`
--
ALTER TABLE `shipcompany`
  ADD PRIMARY KEY (`CompanyId`);

--
-- Indexes for table `shippinginfo`
--
ALTER TABLE `shippinginfo`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKShippingIn12136` (`ItemId`);

--
-- Indexes for table `voucher`
--
ALTER TABLE `voucher`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `creditcard`
--
ALTER TABLE `creditcard`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `fullname`
--
ALTER TABLE `fullname`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `item_order`
--
ALTER TABLE `item_order`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `promotions`
--
ALTER TABLE `promotions`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `rank`
--
ALTER TABLE `rank`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `shippinginfo`
--
ALTER TABLE `shippinginfo`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `voucher`
--
ALTER TABLE `voucher`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `FKBill394877` FOREIGN KEY (`EmployeePersonId2`) REFERENCES `employee` (`PersonId`),
  ADD CONSTRAINT `FKBill70033` FOREIGN KEY (`OrderId`) REFERENCES `item_order` (`Id`);

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FKBook428677` FOREIGN KEY (`ItemId`) REFERENCES `item` (`Id`);

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `FKCart405693` FOREIGN KEY (`CustomerPersonId`) REFERENCES `customer` (`PersonId`);

--
-- Constraints for table `cart_item`
--
ALTER TABLE `cart_item`
  ADD CONSTRAINT `FKCart_Item220329` FOREIGN KEY (`ItemId`) REFERENCES `item` (`Id`),
  ADD CONSTRAINT `FKCart_Item904249` FOREIGN KEY (`CartId`) REFERENCES `cart` (`Id`);

--
-- Constraints for table `clothes`
--
ALTER TABLE `clothes`
  ADD CONSTRAINT `FKClothes719994` FOREIGN KEY (`ItemId`) REFERENCES `item` (`Id`);

--
-- Constraints for table `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `FKCompany646510` FOREIGN KEY (`AddressId`) REFERENCES `address` (`Id`);

--
-- Constraints for table `creditcard`
--
ALTER TABLE `creditcard`
  ADD CONSTRAINT `FKCreditCard410960` FOREIGN KEY (`CustomerPersonId2`) REFERENCES `customer` (`PersonId`);

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FKCustomer220795` FOREIGN KEY (`PersonId`) REFERENCES `person` (`Id`),
  ADD CONSTRAINT `FKCustomer95429` FOREIGN KEY (`AccountId`) REFERENCES `account` (`Id`);

--
-- Constraints for table `customer_notification`
--
ALTER TABLE `customer_notification`
  ADD CONSTRAINT `FKCustomer_N424414` FOREIGN KEY (`CustomerPersonId`) REFERENCES `customer` (`PersonId`),
  ADD CONSTRAINT `FKCustomer_N65243` FOREIGN KEY (`NotificationId`) REFERENCES `notification` (`Id`);

--
-- Constraints for table `customer_voucher`
--
ALTER TABLE `customer_voucher`
  ADD CONSTRAINT `FKCustomer_V187514` FOREIGN KEY (`VoucherId`) REFERENCES `voucher` (`Id`),
  ADD CONSTRAINT `FKCustomer_V292545` FOREIGN KEY (`CustomerPersonId`) REFERENCES `customer` (`PersonId`);

--
-- Constraints for table `electronics`
--
ALTER TABLE `electronics`
  ADD CONSTRAINT `FKElectronic367310` FOREIGN KEY (`ItemId`) REFERENCES `item` (`Id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FKEmployee390432` FOREIGN KEY (`AccountId`) REFERENCES `account` (`Id`),
  ADD CONSTRAINT `FKEmployee702433` FOREIGN KEY (`DepartmentId`) REFERENCES `department` (`Id`),
  ADD CONSTRAINT `FKEmployee758069` FOREIGN KEY (`RankId`) REFERENCES `rank` (`Id`),
  ADD CONSTRAINT `FKEmployee925791` FOREIGN KEY (`PersonId`) REFERENCES `person` (`Id`);

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `FKItem389531` FOREIGN KEY (`CompanyId`) REFERENCES `company` (`Id`),
  ADD CONSTRAINT `FKItem525138` FOREIGN KEY (`CategoryId`) REFERENCES `category` (`Id`);

--
-- Constraints for table `item_order`
--
ALTER TABLE `item_order`
  ADD CONSTRAINT `FKOrder795661` FOREIGN KEY (`CartId`) REFERENCES `cart` (`Id`);

--
-- Constraints for table `item_promotions`
--
ALTER TABLE `item_promotions`
  ADD CONSTRAINT `FKItem_Promo417604` FOREIGN KEY (`ItemId`) REFERENCES `item` (`Id`),
  ADD CONSTRAINT `FKItem_Promo888149` FOREIGN KEY (`PromotionsId`) REFERENCES `promotions` (`Id`);

--
-- Constraints for table `order_shipcompany`
--
ALTER TABLE `order_shipcompany`
  ADD CONSTRAINT `FKOrder_Ship137659` FOREIGN KEY (`ShipCompanyCompanyId`) REFERENCES `shipcompany` (`CompanyId`),
  ADD CONSTRAINT `FKOrder_Ship791981` FOREIGN KEY (`OrderId`) REFERENCES `item_order` (`Id`);

--
-- Constraints for table `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `FKPerson626850` FOREIGN KEY (`AddressId`) REFERENCES `address` (`Id`),
  ADD CONSTRAINT `FKPerson905968` FOREIGN KEY (`FullNameId`) REFERENCES `fullname` (`Id`);

--
-- Constraints for table `shipcompany`
--
ALTER TABLE `shipcompany`
  ADD CONSTRAINT `FKShipCompan888867` FOREIGN KEY (`CompanyId`) REFERENCES `company` (`Id`);

--
-- Constraints for table `shippinginfo`
--
ALTER TABLE `shippinginfo`
  ADD CONSTRAINT `FKShippingIn12136` FOREIGN KEY (`ItemId`) REFERENCES `item` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
