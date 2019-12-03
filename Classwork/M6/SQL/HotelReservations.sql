-- Stephen Espinal

-- DDL
DROP DATABASE IF EXISTS HotelReservationDB;
CREATE DATABASE HotelReservationDB;
USE HotelReservationDB;

CREATE TABLE Customers(

CustomerId INT PRIMARY KEY AUTO_INCREMENT,
CustomerName VARCHAR(20) NOT NULL,
CustomerAge TINYINT NOT NULL

);

CREATE TABLE Reservations(
ReservationId INT PRIMARY KEY AUTO_INCREMENT,
CustomerId INT NOT NULL,
FOREIGN KEY fk_Customer_CustomerID(CustomerId) REFERENCES Customers(CustomerId) 
);

CREATE TABLE RoomType(

RoomTypeId INT PRIMARY KEY AUTO_INCREMENT,
RoomTypeName VARCHAR(20) NOT NULL

);

CREATE TABLE Rooms(
RoomNumId INT PRIMARY KEY,
RoomTypeId INT NOT NULL,
FOREIGN KEY fk_RoomType_RoomTypeId(RoomTypeId) REFERENCES RoomType(RoomTypeId) 
);

CREATE TABLE RoomRates (

RoomRateID INT PRIMARY KEY AUTO_INCREMENT,
RoomRate DECIMAL(5,2) NOT NULL,
RoomRateDateStarting DATE NOT NULL,
RoomRateDateUntil DATE NOT NULL,

RoomTypeId INT NOT NULL,
FOREIGN KEY fk_RoomType_RoomTypeId(RoomTypeId) REFERENCES RoomType(RoomTypeId)

);

CREATE TABLE RoomReservations(
RoomNumId INT NOT NULL,
ReservationId INT NOT NULL,

RoomReservationsId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,

FOREIGN KEY fk_Rooms_RoomNumId(RoomNumId) REFERENCES Rooms(RoomNumId),
FOREIGN KEY fk_Reservations_ReservationId(ReservationId) REFERENCES Reservations(ReservationId),

DateCheckIn DATE NOT NULL,
DateCheckOut DATE NOT NULL

);

CREATE TABLE Guests(
GuestId INT PRIMARY KEY AUTO_INCREMENT,
GuestName VARCHAR(20) NOT NULL,

RoomReservationsId INT NOT NULL,
FOREIGN KEY fk_RoomReservations_RoomReservationsId(RoomReservationsId)REFERENCES RoomReservations(RoomReservationsId) 
);

CREATE TABLE Amenities(
AmenitiesId INT PRIMARY KEY AUTO_INCREMENT,
AmenitiesName VARCHAR(20) NOT NULL
);

CREATE TABLE RoomAmenities(
RoomTypeId INT NOT NULL,
AmenitiesId INT NOT NULL,

PRIMARY KEY RoomAmenitiesId(RoomTypeId,AmenitiesId),

FOREIGN KEY fk_RoomType_RoomTypeId(RoomTypeId) REFERENCES RoomType(RoomTypeId),
FOREIGN KEY fk_Amenities_AmenitiesId(AmenitiesId) REFERENCES Amenities(AmenitiesId)
);

CREATE TABLE AddOns(
AddOnsId INT PRIMARY KEY AUTO_INCREMENT,
AddOnsName VARCHAR(20) NOT NULL
);

CREATE TABLE AddOnPrices(
AddOnPricesId INT PRIMARY KEY AUTO_INCREMENT,
AddOnPrice DECIMAL(4,2) NOT NULL,
AddOnPriceDateStarting DATE NOT NULL,
AddOnPriceDateUntil DATE NOT NULL,
AddOnsId INT NOT NULL,
FOREIGN KEY fk_AddOns_AddOnsId(AddOnsId) REFERENCES AddOns(AddOnsId)

);

CREATE TABLE RoomReservationAddOns(
RoomReservationsId INT NOT NULL,
AddOnPricesId INT NOT NULL,

PRIMARY KEY RoomReservationAddOnsId(RoomReservationsId,AddOnPricesId),

FOREIGN KEY fk_RoomReservations_RoomReservationsId(RoomReservationsId) REFERENCES RoomReservations(RoomReservationsId),
FOREIGN KEY fk_AddOnPrices_AddOnPricesId(AddOnPricesId) REFERENCES AddOnPrices(AddOnPricesId)

);

CREATE TABLE Promotions(

PromotionsId INT PRIMARY KEY AUTO_INCREMENT,
PromotionName VARCHAR(50) NOT NULL,
PromotionDiscount Decimal(2) NOT NULL,
PromotionDateStarting DATE NOT NULL,
PromotionDateUntil DATE NOT NULL

);

CREATE TABLE RoomReservationPromotions(
RoomReservationsId INT NOT NULL,
PromotionsId INT NOT NULL,

PRIMARY KEY RoomReservationPromotions(RoomReservationsId,PromotionsId),

FOREIGN KEY fk_RoomReservations_RoomReservationsId(RoomReservationsId) REFERENCES RoomReservations(RoomReservationsId),
FOREIGN KEY fk_Promotions_PromotionsId(PromotionsId) REFERENCES Promotions(PromotionsId)

);

CREATE TABLE Billing (
BillingId INT PRIMARY KEY AUTO_INCREMENT,
Total DECIMAL(10,2),
BillingPriceDateStarting DATE NOT NULL,
BillingPriceDateUntil DATE NOT NULL,
ReservationId INT NOT NULL,
PromotionsId INT NOT NULL,


FOREIGN KEY fk_Reservations_ReservationId(ReservationId) REFERENCES Reservations(ReservationId),
FOREIGN KEY fk_Promotions_PromotionsId(PromotionsId) REFERENCES Promotions(PromotionsId)

);

CREATE TABLE BillingDetails (
BillingDetailsId INT PRIMARY KEY AUTO_INCREMENT,
Total DECIMAL(10,2),
Details VARCHAR(100),
BillingDetailsDate Date NOT NULL,

BillingId INT NOT NULL,
FOREIGN KEY fk_Billing_BillingId(BillingId) REFERENCES Billing(BillingId)

);

-- DML
INSERT INTO Customers (CustomerName,CustomerAge) VALUES 
	('Stephen','27'),
	('John','27'),
    ('Dana',25),
	('Felicia',25);

DELETE FROM Customers
WHERE CustomerId = 4;

INSERT INTO Addons (AddOnsName) VALUES 
	('Room Service'),
	('Movies'),
    ('Extra Towels');
    
UPDATE Customers SET
	CustomerName = 'Ana'
WHERE CustomerId = 2;

INSERT INTO Addons (AddOnsName) VALUES 
	('Room Service'),
	('Movies'),
    ('Extra Towels');

INSERT INTO AddonPrices (AddOnPrice,AddOnPriceDateStarting,AddOnPriceDateUntil,AddOnsId) VALUES 
	('99.00','2019-02-05','2019-12-31',1),
	('50.00','2019-02-05','2019-12-31',2),
	('70.00','2019-02-05','2019-12-31',2);
    
INSERT INTO Amenities (AmenitiesName) VALUES 
	('Fridge'),
	('Spa Bath');
    
INSERT INTO Promotions (PromotionName,PromotionDiscount,PromotionDateStarting,PromotionDateUntil) VALUES 
	('No Promotion', 1,'2019-02-05','2100-12-31'),
	('Summer Savings', 1,'2019-05-05','2019-09-30');  
    
INSERT INTO RoomType (RoomTypeName) VALUES 
	('Single'),
	('Double'),
    ('King Size');

INSERT INTO Rooms (RoomNumId,RoomTypeId) VALUES 
	(101,1),
	(102,2),
    (103,1);

INSERT INTO RoomAmenities (RoomTypeId,AmenitiesId) VALUES 
	(1,1),
	(1,2),
    (2,1);

INSERT INTO RoomRates (RoomRate,RoomRateDateStarting,RoomRateDateUntil,RoomTypeId) VALUES 
	(120.00,'2019-02-05','2050-12-31',1),
	(100.00,'2019-05-05','2020-09-30',2);  
    
INSERT INTO Reservations (CustomerId) VALUES 
	('1'),
	('2'),
    ('3');
    
INSERT INTO RoomRates (RoomRate,RoomRateDateStarting,RoomRateDateUntil,RoomTypeId) VALUES 
	(120.00,'2019-02-05','2050-12-31',1),
	(100.00,'2019-05-05','2020-09-30',2);  
    
INSERT INTO RoomReservations (RoomNumId,ReservationId,DateCheckIn,DateCheckOut) VALUES 
	(101,1,'2019-09-05','2019-09-08'),
	(103,3,'2019-09-05','2019-09-08'),
	(102,2,'2019-09-020','2019-09-30');
    
INSERT INTO RoomReservationAddOns (RoomReservationsId,AddOnPricesId) VALUES 
	(1,1),
	(1,3);
    
INSERT INTO RoomReservationPromotions (RoomReservationsId,PromotionsId) VALUES 
	(1,1),
	(1,2);
    
INSERT INTO Guests (GuestName,RoomReservationsId) VALUES 
	('Amanda',1),
	('Jerry',2);
    
SELECT *
FROM Customers;

SELECT *
FROM Customers
INNER JOIN Reservations ON Customers.CustomerId = Reservations.CustomerId
WHERE Customers.CustomerId = 1;

SELECT 
Customers.CustomerName
FROM Customers
INNER JOIN Reservations ON Customers.CustomerId = Reservations.CustomerId
INNER JOIN RoomReservations ON Reservations.ReservationId = RoomReservations.ReservationId
INNER JOIN Rooms ON RoomReservations.RoomNumId = Rooms.RoomNumId
INNER JOIN RoomType ON Rooms.RoomTypeId = RoomType.RoomTypeId
WHERE RoomType.RoomTypeName = 'Single';

