DROP TABLE CEO;

CREATE TABLE CEO ( 
	CEOID           	varchar(12)		PRIMARY KEY, 
	CEONAME				varchar(20)		NOT NULL,
 	CEOPHONE			varchar(20), 
 	REGISTRATIONNUM		varchar(50),
 	CEOPASSWD			varchar(12)		NOT NULL
);

INSERT INTO CEO VALUES('ceoid', 'ceo', '02-940-9999', '123456789', 'ceopw');
