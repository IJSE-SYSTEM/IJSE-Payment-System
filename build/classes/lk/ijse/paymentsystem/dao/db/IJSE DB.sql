/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  midda
 * Created: Aug 26, 2017
 */

DROP DATABASE IF EXISTS ijse;

CREATE DATABASE ijse;

USE ijse;

CREATE TABLE course(
    code VARCHAR(10),                       /*code as in CMJD, GDSE*/
    name VARCHAR(255),
    CONSTRAINT PRIMARY KEY (code)
);

CREATE TABLE course_details(
    courseID VARCHAR(10),
    code VARCHAR(10),
    no_of_semesters INT(2),
    course_fee DECIMAL(8,2),
    dscnt2PlusSem DECIMAL(3,2),
    dscnt2Sem DECIMAL(3,2),
    dscnt1Sem DECIMAL(3,2),
    dateModified DATE,  
    CONSTRAINT PRIMARY KEY (courseID),
    CONSTRAINT FOREIGN KEY (code) REFERENCES course(code)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE semester_details(
    code VARCHAR(10),
    semester INT(2),
    module_info VARCHAR(255),
    certification_level VARCHAR(500),
    CONSTRAINT FOREIGN KEY (code) REFERENCES course(code)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PRIMARY KEY (code,semester)
);

CREATE TABLE batch(
    batchID VARCHAR(10),
    courseID VARCHAR(10),
    batchNo INT(3),
    startDate DATE,
    branch VARCHAR(20),
    CONSTRAINT FOREIGN KEY (courseID) REFERENCES course_details(courseID)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PRIMARY KEY (batchID),
    CONSTRAINT UNIQUE KEY (courseID,batchNo)
);


CREATE TABLE student(
    sid VARCHAR(10) NOT NULL,
    snameInitials VARCHAR(255) NOT NULL,
    sname VARCHAR(350) NOT NULL,
    address_1 VARCHAR(255) NOT NULL,
    address_2 VARCHAR(255) NOT NULL,
    address_3 VARCHAR(255) NOT NULL,
    tele_home VARCHAR(11),
    tele_mobi VARCHAR(11),
    email VARCHAR(255),
    dob DATE NOT NULL,
    gender BINARY NOT NULL,
    nic VARCHAR(13),
    regFee DECIMAL(8,2),
    school VARCHAR(255),
    grade VARCHAR(50),
    university VARCHAR(255),
    CONSTRAINT PRIMARY KEY (sid)
);

/* 
*stu_guradian, stu_pro_qualification and stu_other_info are weak
*dependent on student table
*/

CREATE TABLE stu_guardian(
    sid VARCHAR(10) NOT NULL,
    gname VARCHAR(350) NOT NULL,
    tele_1 VARCHAR(15) NOT NULL,
    tele_2 VARCHAR(15),
    email VARCHAR(255),
    designation VARCHAR(255),
    work_place VARCHAR(500),
    address_1 VARCHAR(255) NOT NULL,
    address_2 VARCHAR(255) NOT NULL,
    address_3 VARCHAR(255) NOT NULL,
    CONSTRAINT FOREIGN KEY (sid) REFERENCES student(sid)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PRIMARY KEY (sid)
);

CREATE TABLE stu_pro_qualification(
    sid VARCHAR(10) NOT NULL,
    qualification VARCHAR(255),
    awarding_institute VARCHAR(255),
    date_of_award DATE,
    specialization VARCHAR(500),
    CONSTRAINT FOREIGN KEY (sid) REFERENCES student(sid)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PRIMARY KEY (sid)
);

CREATE TABLE stu_other_info(
    sid VARCHAR(10) NOT NULL,
    data_entry_by VARCHAR(100) NOT NULL,
    iq_test INT(3),
    comments VARCHAR(1000),
    birthCertificate BOOLEAN,
    photos BOOLEAN,
    nic BOOLEAN,
    academicCertificates BOOLEAN,
    sportsCertificates BOOLEAN,
    professionalCertificates BOOLEAN,
    CONSTRAINT FOREIGN KEY (sid) REFERENCES student(sid)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PRIMARY KEY (sid)
);


CREATE TABLE registration(
    regID VARCHAR(15) NOT NULL,
    sid VARCHAR(10) NOT NULL,
    batchID VARCHAR(10) NOT NULL,
    registration_date DATE,
    bcs binary,
    transferred_to_batch VARCHAR(15),
    new_reg_id VARCHAR(10),
    CONSTRAINT FOREIGN KEY (sid) REFERENCES student(sid) 
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (batchID) REFERENCES batch(batchID)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (transferred_to_batch) REFERENCES batch(batchID)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (new_reg_id) REFERENCES registration(regID)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PRIMARY KEY (regID)
);

CREATE TABLE payment(
    payID VARCHAR(10) NOT NULL,
    regID VARCHAR(15) NOT NULL,
    semester INT(2) NOT NULL,               /*This is 0 for full payment*/
    sem_half INT(1) NOT NULL,               /*This is 0 for a full semester pay*/
#     nextPayID VARCHAR(10),                  /*This is used one the payment ranges for more than 1 semesters and not a full payment. Example payment for 2 semsters*/
    pay_date DATE,
    amount DECIMAL(8,2) NOT NULL,
    discount DECIMAL(8,2),
    amount_recieved DECIMAL(8,2) NOT NULL,
    CONSTRAINT FOREIGN KEY (regID) REFERENCES registration(regID)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PRIMARY KEY (payID,semester,sem_half),
    CONSTRAINT UNIQUE KEY (regID,semester,sem_half)
);

INSERT INTO course VALUES('CMJD','Comprehensive Master Java Developer');
INSERT INTO course VALUES('GDSE','Graduate Deploma In Software Engineering');
INSERT INTO course VALUES('ABSD','Advanced Business Solution Developer');
INSERT INTO course VALUES('AHAD','Advanced Hybrid Application Developer');

-- INSERT INTO course_details VALUES('C001','CMJD',1,60000.00,0.2,0,0,'2017-09-03');
INSERT INTO course_details VALUES('C001','GDSE',4,280000.00,0.3,0.2,0.1,'2017-09-19');
-- INSERT INTO course_details VALUES('C003','ABSD',1,60000.00,0.2,0,0,'2017-09-03');
-- INSERT INTO course_details VALUES('C004','AHAD',1,60000.00,0.2,0,0,'2017-09-03');

-- INSERT INTO batch VALUES('GDSE41','C002',41,'2016-09-20','Panadura');
-- INSERT INTO batch VALUES('CMJD67','C001',67,'2017-04-05','Panadura');
INSERT INTO batch VALUES('GDSE45','C001',45,'2017-09-19','Panadura');
-- INSERT INTO batch VALUES('GDSE37','C002',37,'2016-09-22','Panadura');

-- SQL stored Procedures


DROP PROCEDURE IF EXISTS add_student;

DELIMITER --
CREATE PROCEDURE add_student(IN nameWithInitial VARCHAR(255), IN sname VARCHAR(350), IN addressLine1 VARCHAR(255), IN addressLine2 VARCHAR(255), IN addressLine3 VARCHAR(255), IN tel_home INT(11), IN tel_mobile INT(11), IN email VARCHAR(255), IN dob DATE, IN gender BOOLEAN, IN nic VARCHAR(13), IN regFee DECIMAL(8,2), IN school VARCHAR(255), IN university VARCHAR(255), IN join_date DATE, IN iq_test INT(3))
  BEGIN
    DECLARE student_id VARCHAR(10);
    DECLARE current_year VARCHAR(4);
    DECLARE id INT;
    DECLARE id_year VARCHAR(4);
    SELECT sid from student ORDER BY sid DESC LIMIT 1 INTO student_id;
    SELECT YEAR(curdate()) INTO current_year;
    SET id_year = SUBSTR(student_id,1,4);
    IF student_id IS NULL THEN
      SET student_id = concat(current_year,"001");   
    ELSE
      IF (id_year =current_year) THEN 
        SELECT CAST(SUBSTR(student_id,5) AS UNSIGNED)  INTO id;
        SET id = id+1;
        IF id<10 THEN
            SET student_id = concat(current_year,'00',id);
        ELSEIF id<100 THEN
            SET student_id = concat(current_year,'0',id);
        ELSE
            SET student_id = concat(current_year,id);
        END IF;
      ELSE
        SET student_id = concat(current_year,"001");
      END IF;
    END IF;


     INSERT INTO student VALUES(student_id, nameWithInitial, sname, addressLine1,addressLine2,addressLine3,tel_home,tel_mobile, email, dob, gender, nic, regFee,school,university,join_date,iq_test);
     SELECT student_id;

  END --

DELIMITER ;


CALL add_student();



DROP PROCEDURE IF EXISTS add_registration;

DELIMITER --

CREATE PROCEDURE add_registration(IN sid VARCHAR(10), IN batch_Id VARCHAR(10), IN registration_Date DATE, IN bcs BOOLEAN)
  BEGIN
    DECLARE reg_Id VARCHAR(15);
    DECLARE id INT;
    DECLARE course VARCHAR(10);
    DECLARE varbranch VARCHAR(20);
    DECLARE varbatchNo INT;
    DECLARE prefix VARCHAR(10);
    SELECT regId FROM registration WHERE batchID = batch_Id ORDER BY regId DESC LIMIT 1 INTO reg_Id;   
    SELECT code FROM course_details C, batch B WHERE B.courseID=C.courseID && B.batchID = batch_Id INTO course;
    SELECT branch FROM batch WHERE batch.batchID=batch_Id INTO varbranch;
    SELECT batchNo FROM batch WHERE batch.batchID=batch_Id INTO varbatchNo;

    SET prefix = concat(course,'/',SUBSTR(varbranch,1,1),'/',varbatchNo,'/');
    IF reg_Id IS NULL THEN
      SET reg_Id = concat(prefix,'001');
    ELSE
      SELECT CAST(SUBSTR(reg_Id,(CHAR_LENGTH(prefix)+1)) AS UNSIGNED) INTO id;
      SET id = id+1;
        IF id<10 THEN
            SET reg_Id = concat(prefix,'00',id);
        ELSEIF id<100 THEN
            SET reg_Id = concat(prefix,'0',id);
        ELSE
            SET reg_Id = concat(prefix,id);
        END IF;
    END IF;

    INSERT INTO registration (regID, sid, batchID, registration_date, bcs )VALUES (reg_Id, sid, batch_Id, registration_Date, bcs);
    SELECT reg_Id;

  END --

DELIMITER ;

ALTER TABLE student ADD COLUMN join_date DATE;

ALTER TABLE student ADD COLUMN iq_test INT(3);

UPDATE student
INNER JOIN stu_other_info USING (sid)
SET student.iq_test = stu_other_info.iq_test;

DROP TABLE stu_other_info;

ALTER TABLE student DROP COLUMN grade;

CREATE TABLE school(
    school varchar(400)
);


DROP TRIGGER IF EXISTS school ;

DELIMITER --
CREATE TRIGGER school BEFORE INSERT ON student 
FOR EACH ROW
    BEGIN
        DECLARE school_exist VARCHAR(400) DEFAULT NULL;
        SELECT school FROM student WHERE school=NEW.school INTO school_exist;
        IF  school_exist IS NULL THEN
            INSERT INTO school VALUES(NEW.school);
        END IF;
    END--
DELIMITER;


