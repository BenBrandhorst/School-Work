--Ben Brandhorst
--11/1/19
--SDEV 350 7980
--Professor Ivan De Los Santos

--Creates output file in location specified
spool "c:\Oracle\BBrandhorstLab2.txt"
Drop TABLE ClassEnrollments;
DROP TABLE Engineers;
DROP TABLE Faculty;
DROP TABLE Classes;

--Creates Engineers table with the requisite PK and columns
CREATE TABLE Engineers
(
EID NUMBER NOT NULL,
Lastname VARCHAR2(50) NOT NULL,
Firstname VARCHAR2(50) NOT NULL,
Email VARCHAR2(254) NOT NULL,
Graddate DATE NOT NULL,
CONSTRAINT Engineers_pk PRIMARY KEY (EID)
);

--Creates Faculty table with the requisite PK and columns
CREATE TABLE Faculty
(
FID NUMBER NOT NULL,
Lastname VARCHAR2(50) NOT NULL,
Firstname VARCHAR2(50) NOT NULL,
Email VARCHAR2(254) NOT NULL,
Hiredate DATE NOT NULL,
CONSTRAINT Faculty_pk PRIMARY KEY (FID)
);

--Creates Classes table with the requisite PK and columns
CREATE TABLE Classes
(
CID NUMBER NOT NULL,
Subject VARCHAR2(50) NOT NULL,
Catalognbr NUMBER NOT NULL,
Title VARCHAR2(50) NOT NULL,
CONSTRAINT Classes_pk PRIMARY KEY (CID)
);

--Creates ClassEnrollments table with the requisite PK and FKs
CREATE TABLE ClassEnrollments
(
EnID NUMBER NOT NULL,
CID NUMBER,
FID NUMBER,
EID NUMBER,
CONSTRAINT ClassEnrollments_pk PRIMARY KEY (EnID),
CONSTRAINT Classes_fk FOREIGN KEY (CID) REFERENCES Classes (CID),
CONSTRAINT Faculty_fk FOREIGN KEY (FID) REFERENCES Faculty (FID),
CONSTRAINT Engineers_fk FOREIGN KEY (EID) REFERENCES Engineers (EID)
);
--Inserts 15 records into Engineers table
INSERT ALL
--Inserts 15 records into Engineers table
INTO Engineers VALUES (1, 'Brandhorst', 'Ben', 'ben.brandhorst@email.com', '1-JUN-2019')
INTO Engineers VALUES (2, 'Jones', 'Jim', 'jim.jones@email.com','1-JUN-2021')
INTO Engineers VALUES (3, 'Lee', 'Bruce', 'bruce.lee@email.com', '1-JUN-2020')
INTO Engineers VALUES (4, 'Paulson', 'Robert', 'robert.paulson@email.com', '1-Dec-2020')
INTO Engineers VALUES (5, 'Stanley', 'Kim', 'kim.stanley@email.com', '1-JUN-2020')
INTO Engineers VALUES (6, 'Lopez', 'George', 'george.lopez@email.com', '1-JUN-2020')
INTO Engineers VALUES (7, 'Doe', 'Jane', 'jane.doe@email.com', '1-JUN-2020')
INTO Engineers VALUES (8, 'Smith', 'Kevin', 'kevin.smith@email.com', '1-JUN-2020')
INTO Engineers VALUES (9, 'Taylor', 'Double', 'double.taylor@email.com', '1-JUN-2020')
INTO Engineers VALUES (10, 'Castillo', 'Juan', 'juan.castillo@email.com', '1-JUN-2020')
INTO Engineers VALUES (11, 'Shrenk', 'Kathy', 'kathy.shrenk@email.com', '1-JUN-2020')
INTO Engineers VALUES (12, 'Marks', 'Marky', 'marky.marks@email.com', '1-JUN-2020')
INTO Engineers VALUES (13, 'Hines', 'Cadedra', 'cadedra.hines@email.com', '1-JUN-2020')
INTO Engineers VALUES (14, 'Datiz', 'Keith', 'keith.datiz@emai.com', '1-JUN-2020')
INTO Engineers VALUES (15, 'Carlson', 'Tom', 'tom.carlson@email.com', '1-JUN-2020')
--Inserts 3 records into Faculty table
INTO Faculty VALUES (1, 'Henderson', 'Oswald', 'oswald.henderson@faculty.com', '1-Jan-1990')
INTO Faculty VALUES (2, 'Johnson', 'Magic', 'magic.johnson@faculty.com', '13-Mar-1982')
INTO Faculty VALUES (3, 'Iver', 'Bon', 'bon.iver@faculty.com', '22-Oct-2001')
--Inserts 3 records into Classes table
INTO Classes VALUES (1, 'SDEV', 350, 'Database Security')
INTO Classes VALUES (2, 'BIOL', 103, 'Into to Biology')
INTO Classes VALUES (3, 'CMIS', 242, 'Intermediate Programming')
--Inserts 15 records int ClassEnrollments table
INTO ClassEnrollments VALUES (1, 1, 1, 15)
INTO ClassEnrollments VALUES (2, 1, 1, 14)
INTO ClassEnrollments VALUES (3, 1, 1, 13)
INTO ClassEnrollments VALUES (4, 1, 1, 12)
INTO ClassEnrollments VALUES (5, 1, 1, 11)
INTO ClassEnrollments VALUES (6, 2, 2, 10)
INTO ClassEnrollments VALUES (7, 2, 2, 9)
INTO ClassEnrollments VALUES (8, 2, 2, 8)
INTO ClassEnrollments VALUES (9, 2, 2, 7)
INTO ClassEnrollments VALUES (10, 2, 2, 6)
INTO ClassEnrollments VALUES (11, 3, 3, 5)
INTO ClassEnrollments VALUES (12, 3, 3, 4)
INTO ClassEnrollments VALUES (13, 3, 3, 3)
INTO ClassEnrollments VALUES (14, 3, 3, 2)
INTO ClassEnrollments VALUES (15, 3, 3, 1)
--INSERT ALL requires a subquery so we use (SELECT * FROM DUAL) to satisfy the requirement
SELECT * FROM DUAL;

--Selects all records from each table and shows them in descending order by PK
SELECT * FROM Engineers ORDER BY EID DESC;
SELECT * FROM Faculty ORDER BY FID DESC;
SELECT * FROM Classes ORDER BY CID DESC;
SELECT * FROM ClassEnrollments ORDER BY EnID DESC;

--Updates Faculty Lastname to Friendship
UPDATE Faculty SET Lastname = 'Friendship' WHERE FID = 1;
--Updates Engineer Firstname to Amadeus
UPDATE Engineers SET Firstname = 'Amadeus' WHERE EID = 13;
--Updates Classes Subject to IOT Cyber
UPDATE Classes SET Subject = 'IOT Cyber' WHERE CID = 2;

--Deletes ClassEnrollments record with lowest EnID
DELETE FROM ClassEnrollments WHERE EnID = (SELECT MIN(EnID) FROM ClassEnrollments);

--Creates view for all course enrollments which displays the information specified in the Lab instructions
CREATE OR REPLACE VIEW Lab2View AS
SELECT Engineers.Lastname as EngineerLName,
       Engineers.Firstname,
       Faculty.Lastname as FacultyLName,
       Faculty.Email,
       Classes.Subject,
       Classes.Title
  FROM ClassEnrollments
RIGHT OUTER JOIN Engineers ON (Engineers.EID = ClassEnrollments.EID)
RIGHT OUTER JOIN Faculty ON (Faculty.FID = ClassEnrollments.FID)
RIGHT OUTER JOIN Classes ON (Classes.CID = ClassEnrollments.CID);
SELECT * FROM Lab2View;

--Turns off spooling to stop saving output to text file
spool off
