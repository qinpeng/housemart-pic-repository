CREATE SCHEMA `repository` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `repository`.`house`( 
   `ID` INT NOT NULL AUTO_INCREMENT , 
   `Name` VARCHAR(128) , 
   `Status` TINYINT , 
   `ResidenceID` INT , 
   `CellID` INT , 
   `PicID` INT , 
   `RoomTypePicID` INT , 
   `Direction` INT , 
   `PropertyArea` DECIMAL , 
   `OccupiedArea` DECIMAL , 
   `BuildTime` DATETIME , 
   `HouseType` VARCHAR(64) , 
   `RoomType` INT , 
   `Decorating` INT , 
   `HasKey` BIT , 
   `HasKeyMemo` TEXT , 
   `ViewHouseType` INT , 
   `Memo` TEXT , 
   `AddTime` DATETIME , 
   `UpdateTime` DATETIME , 
   `Creator` INT , 
   `LastUpdater` INT , 
   PRIMARY KEY (`ID`)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 CREATE TABLE `repository`.`house_pic` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ResidenceID` int(11) DEFAULT NULL,
  `HouseID` int(11) DEFAULT NULL,
  `Type` int(11) DEFAULT NULL,
  `URL` varchar(512) DEFAULT NULL,
  `CloudURL` varchar(512) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  `CrawlStatus` int(11) DEFAULT NULL,  
  `AddTime` datetime DEFAULT NULL,
  `UpdateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `ResidenceID` (`ResidenceID` ASC),
  INDEX `HouseID` (`HouseID` ASC),
  INDEX `Type` (`Type` ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE  TABLE `repository`.`broker` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `HomePage` VARCHAR(512) NULL ,
  `Name` VARCHAR(45) NULL ,
  `Labels` VARCHAR(45) NULL ,
  `Phone` VARCHAR(128) NULL ,
  `Company` VARCHAR(45) NULL ,
  `ServiceBlock` VARCHAR(512) NULL ,
  `ShopName` VARCHAR(45) NULL ,
  `ShopAddress` VARCHAR(512) NULL ,
  `ShopPhone` VARCHAR(45) NULL ,
  `ShopMainArea` VARCHAR(45) NULL ,
  `HouseCount` INT NULL ,
  `Residences` TEXT NULL ,
  `SearchRegion` VARCHAR(45) NULL ,
  `SearchPlate` VARCHAR(45) NULL ,
  `SearchCompany` VARCHAR(45) NULL ,
  `AddTime` DATETIME NULL ,
  `UpdateTime` DATETIME NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


