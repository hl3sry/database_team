CREATE TABLE MENU (
	menuCode NUMBER(4) PRIMARY KEY,
	menu varchar2(4000) NOT NULL,
	price NUMBER(5) NOT NULL,
	menuImage varchar2(4000) NULL,
	menuDescription varchar2(4000) NULL,
	cafeCode NUMBER(4) REFERENCES CAFE(cafeCode)
);
CREATE TABLE ORDER (
	orderCode NUMBER(4) PRIMARY KEY,
	orderDate Date NOT NULL,
	orderCheck NUMBER(1) NOT NULL,
	pickDate Date NOT NULL
	clientId NUMBER(4) REFERENCES CLIENT(clientId)
);
CREATE SEQUENCE menuCode_seq START WITH 2001 MAXVALUE 3000;
CREATE SEQUENCE orderCode_seq START WITH 3001 MAXVALUE 4000;
