CREATE TABLE Students
(
ID INTEGER NOT NULL,
studentName VARCHAR2(40) NOT NULL,

CONSTRAINT Students_pk PRIMARY KEY(ID)
)

INSERT ALL
INTO Students VALUES (1, 'Adam Smith')
INTO Students VALUES (2, 'Mark McGuire')
INTO Students VALUES (3, 'Jon Snow')
INTO Students VALUES (4, 'Barbara Bush')
SELECT * FROM DUAL;

CREATE USER TS1BenBrandhorst
IDENTIFIED BY "Password!2#"
PROFILE PBenBrandhorst
DEFAULT TABLESPACE Users
QUOTA 20M on Users;
CREATE ROLE Lab4;
Grant CREATE SESSION to Lab4;
Grant SELECT on Students to Lab4;
Grant Lab4 to TS1BenBrandhorst;

CREATE USER TS2BenBrandhorst
IDENTIFIED BY "Password!2#"
PROFILE PBenBrandhorst
DEFAULT TABLESPACE Users
QUOTA 20M on Users;

CREATE ROLE TS2RoleBenBrandhorst;
Grant CREATE SESSION to TS2RoleBenBrandhorst;
Grant SELECT on Students to TS2RoleBenBrandhorst;
Grant INSERT on Students to TS2RoleBenBrandhorst;
Grant TS2RoleBenBrandhorst to TS2BenBrandhorst;
