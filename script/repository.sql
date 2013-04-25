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
  `AddTime` datetime DEFAULT NULL,
  `UpdateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;