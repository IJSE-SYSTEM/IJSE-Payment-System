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


     INSERT INTO student VALUES(student_id, nameWithInitial, sname, addressLine1,addressLine2,addressLine3,tel_home,tel_mobile, email, dob, gender, nic, regFee,school,grade,university);
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
