/* Creates a unique profile using strong verification, allowing 3 concurrent
connections,up to 4 consecutive failed login attempts, a password life of 120
days, and a 1 hour lockout window */
CREATE PROFILE PBenBrandhorst LIMIT
PASSWORD_VERIFY_FUNCTION ora12c_verify_function
SESSIONS_PER_USER 3
FAILED_LOGIN_ATTEMPTS 4
PASSWORD_LIFE_TIME 120
PASSWORD_LOCK_TIME 1/24;

-- Verifies Profile was created correctly
SELECT * from DBA_PROFILES WHERE PROFILE ='PBENBRANDHORST' ORDER BY LIMIT ASC;

/* Creates two users, assigns them to Tablespace Users, with a quota of 30M,
and with expired passwords */
CREATE USER U1BenBrandhorst
IDENTIFIED BY "ExpiredPassword1"
DEFAULT TABLESPACE Users
QUOTA 30M on Users
PROFILE PBenBrandhorst
PASSWORD EXPIRE;

CREATE USER U2BenBrandhorst
IDENTIFIED BY "ExpiredPassword1"
DEFAULT TABLESPACE Users
QUOTA 30M on Users
PROFILE PBenBrandhorst
PASSWORD EXPIRE;

--Creates a role which allows users to connect to the database and create tables
CREATE ROLE RBenBrandhorst;
Grant CREATE SESSION to RBenBrandhorst;
Grant CREATE TABLE to RBenBrandhorst;

-- Creates two tables from the (root/admin) schema named User1Data and User2Data
CREATE TABLE User1Data
(
U1ID NUMBER NOT NULL,
Lastname VARCHAR2(50) NOT NULL,
Firstname VARCHAR2(50) NOT NULL,
Email VARCHAR2(254) NOT NULL,
CONSTRAINT User1Data_pk PRIMARY KEY(U1ID)
)
TABLESPACE Users;

CREATE TABLE User2Data
(
U2ID NUMBER NOT NULL,
Lastname VARCHAR2(50) NOT NULL,
Firstname VARCHAR2(50) NOT NULL,
Email VARCHAR2(254) NOT NULL,
CONSTRAINT User2Data_pk PRIMARY KEY (U2ID)
)
TABLESPACE Users;

-- Inserts three records into User1Data and User2Data respectively
INSERT ALL
INTO User1Data VALUES (1, 'Jones', 'Casey', 'Casey.Jones@email.com')
INTO User1Data VALUES (2, 'Watts', 'Alan', 'Alan.Watts@email.com')
INTO User1Data VALUES (3, 'Ali', 'Muhammed', 'Muhammed.Ali@email.com')
INTO User2Data VALUES (1, 'Bush', 'George', 'George.Bush@email.com')
INTO User2Data VALUES (2, 'Obama', 'Barrack', 'Barrack.Obama@email.com')
INTO User2Data VALUES (3, 'Kennedy', 'John', 'John.Kennedy@email.com')
SELECT * FROM DUAL;

/* Creates a role which allows SELECT and INSERT on User1Data and assigns that
role and the RBenBrandhorst role created earlier to U1BenBrandhorst */
CREATE ROLE InputRole;
GRANT SELECT on User1Data to InputRole;
GRANT INSERT on User1Data to InputRole;
GRANT RBenBrandhorst to U1BenBrandhorst;
GRANT InputRole to U1BenBrandhorst;

/* Creates a role which allows SELECT on User1Data and User2Data and assigns
that role and the RBenBrandhorst role created earlier to U2BenBrandhorst */
CREATE ROLE SelectRole;
GRANT SELECT ON User1Data to SelectRole;
GRANT SELECT ON User2Data to SelectRole;
GRANT RBenBrandhorst to U2BenBrandhorst;
GRANT SelectRole to U2BenBrandhorst;

--Test Plan for U1BenBrandhorst
CONNECT U1BenBrandhorst;
CREATE TABLE U1Example
(
U1EID NUMBER NOT NULL,
Lastname VARCHAR2(50) NOT NULL,
Firstname VARCHAR2(50) NOT NULL,
Email VARCHAR2(254) NOT NULL,
CONSTRAINT U1Example_pk PRIMARY KEY(U1EID)
);
SELECT U1ID FROM BBRANDHORST.User1Data;
INSERT INTO BBRANDHORST.User1Data VALUES (4, 'Smith', 'Adam', 'Adam.Smith@email.com');
SELECT U1ID FROM BBRANDHORST.User2Data;
INSERT INTO BBRANDHORST.User2Data VALUES (4, 'Ruth', 'Babe', 'Babe.Ruth@email.com');
DROP TABLE BBrandhorst.User1Data;
DROP TABLE BBrandhorst.User2Data;

--Test Plan for U2BenBrandhorst
CONNECT U2BenBrandhorst;
CREATE TABLE U2Example
(
U2EID NUMBER NOT NULL,
Lastname VARCHAR2(50) NOT NULL,
Firstname VARCHAR2(50) NOT NULL,
Email VARCHAR2(254) NOT NULL,
CONSTRAINT U2Example_pk PRIMARY KEY(U2EID)
);
SELECT U1ID FROM BBRANDHORST.user1data;
INSERT INTO BBRANDHORST.User1Data VALUES (5, 'Garcia', 'Jerry', 'Jerry.Garcia@email.com');
SELECT U2ID FROM BBRANDHORST.user2data;
INSERT INTO BBRANDHORST.User2Data VALUES (4, 'Ruth', 'Babe', 'Babe.Ruth@email.com');
DROP TABLE BBrandhorst.User1Data;
DROP TABLE BBrandhorst.User1Data;
