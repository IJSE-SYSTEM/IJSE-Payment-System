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
    no_of_semesters INT(2),
    course_fee DECIMAL(8,2),
    dscntFull DECIMAL(3,2),
    dscnt2Sem DECIMAL(3,2),
    dscnt1Sem DECIMAL(3,2),
    CONSTRAINT PRIMARY KEY (code)
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
    code VARCHAR(10),
    batchNo INT(3),
    CONSTRAINT FOREIGN KEY (code) REFERENCES course(code)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PRIMARY KEY (batchID),
    CONSTRAINT UNIQUE KEY (code,batchNo)
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
    school VARCHAR(255),
    grade VARCHAR(50),
    university VARCHAR(255),
    faculty VARCHAR(100),
    hi_edu_qua VARCHAR(255),
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
    birthCertificate BINARY,
    photos BINARY,
    nic BINARY,
    academicCertificates BINARY,
    sportsCertificates BINARY,
    professionalCertificates BINARY,
    CONSTRAINT FOREIGN KEY (sid) REFERENCES student(sid)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PRIMARY KEY (sid)
);


CREATE TABLE registration(
    regID VARCHAR(10) NOT NULL,
    sid VARCHAR(10) NOT NULL,
    batchID VARCHAR(10) NOT NULL,
    registration_date DATE,
    transferred_to_batch VARCHAR(10),
    new_reg_id VARCHAR(10),
    CONSTRAINT FOREIGN KEY (sid) REFERENCES student(sid) 
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (batchID) REFERENCES batch(batchID)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (transferred_to_batch) REFERENCES batch(batchID)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PRIMARY KEY (regID)
);

CREATE TABLE payment(
    payID VARCHAR(10) NOT NULL,
    regID VARCHAR(10) NOT NULL,
    semester INT(2) NOT NULL,
    sem_half INT(1) NOT NULL,
    pay_date DATE,
    amount DECIMAL(8,2) NOT NULL,
    discount DECIMAL(8,2),
    amount_recieved DECIMAL(8,2) NOT NULL,
    CONSTRAINT FOREIGN KEY (regID) REFERENCES registration(regID)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PRIMARY KEY (payID),
    CONSTRAINT UNIQUE KEY (regID,semester,sem_half)
);