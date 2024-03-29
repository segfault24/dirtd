USE eve;

DROP USER IF EXISTS 'dirt'@'localhost';
-- DROP USER IF EXISTS 'dirt'@'DOMAINNAME';
CREATE USER 'dirt'@'localhost' IDENTIFIED BY 'DIRTDBPW';
-- CREATE USER 'dirt'@'DOMAINNAME' IDENTIFIED BY 'DIRTDBPW';
GRANT ALL ON eve.* TO 'dirt'@'localhost';
-- GRANT ALL ON eve.* TO 'dirt'@'DOMAINNAME';
FLUSH PRIVILEGES;

-- -----------------------------------------------------------------------------

-- default admin
-- username: admin
-- password: dirtadmin
INSERT INTO `dirtUser` (
	`username`, `name`, `hash`, `dateCreated`, `lastLogin`, `admin`, `disabled`
) VALUES (
	'admin',
	'Admin',
	'$2y$10$dmQhr32z5mibYp5FLI8gNuNtpkhhX/7j.oyWcwRZ57a85jbgSxcdC',
	NOW(),
	NOW(),
	TRUE,
	FALSE
);

INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("domain","DOMAINNAME");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("adminemail","webmaster@DOMAINNAME");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("scraperkeyid","1");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("scrapercorpid","1018389948");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("ssoclientid","APPCLIENTID");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("ssosecretkey","APPSECRETKEY");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("marketorders.regions","10000002,10000043");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("marketorders.period","20");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("marketorders.maxage","120");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("markethistory.regions","10000002");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("markethistory.period","1440");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("wallet.period","60");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("charactermarket.period","30");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("corpcontracts.period","5");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("publiccontracts.period","60");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("publicstructures.period","2880");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("insuranceprices.period","240");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("typeinfo.period","10080");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("characterdata.period","15");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("characterdata.expires","60");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("mer.period","720");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("unknownids.period","120");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("marketpublic","false");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("maintenancemode","false");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("useragent","DIRT/0.1 (webmaster@DOMAINNAME)");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("ssoscope","esi-wallet.read_character_wallet.v1 esi-universe.read_structures.v1 esi-assets.read_assets.v1 esi-ui.open_window.v1");
INSERT INTO `property` (`propertyName`,`propertyValue`) VALUES ("ssoscope2","esi-markets.structure_markets.v1 esi-markets.read_character_orders.v1 esi-contracts.read_character_contracts.v1 esi-contracts.read_corporation_contracts.v1");
