#
# Environment:
#
   C:\eclipse-bluemix
   Java1.8
   WildFly 8


1. Spring Data JPA + MVC :
   1.Server site paging including changeable for ROWS/PAGE
   2.Form Entity Beans Validation in server site


2. Db Cofiguration:
   src/main/resources/application.properties
   database.driverClass=com.mysql.jdbc.Driver
   database.url=jdbc:mysql:///socan2
   database.username=googleapi
   database.password=googleapi

    CREATE USER 'googleapi'@'localhost' IDENTIFIED BY 'googleapi';
    GRANT ALL PRIVILEGES ON *.* TO 'googleapi'@'localhost';

CREATE TABLE general_licensees(
	id INT NOT NULL AUTO_INCREMENT,	
	masked_id INT NOT NULL ,
	NAME VARCHAR(1024) NOT NULL,
	sic VARCHAR(12) NOT NULL,
	full_description VARCHAR(1024) ,
	address VARCHAR(1024) ,
	address2 VARCHAR(1024) ,
	address3 VARCHAR(1024) ,
	city VARCHAR(1024) ,
	state_prov VARCHAR(24) ,
	post_code VARCHAR(10) ,
	country VARCHAR(256) ,	
	PRIMARY KEY ( id)
 );


CREATE TABLE employee(
	id INT NOT NULL AUTO_INCREMENT,	
	name VARCHAR(1024) NOT NULL,
	joining_date	date,
	salary	float,
	ssn VARCHAR(12) NOT NULL,
	age	int(11) ,
	PRIMARY KEY ( id)
 );
