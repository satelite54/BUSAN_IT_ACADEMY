CREATE TABLE Student(
    fullname VARCHAR2(45),
    email VARCHAR2(45),
    password VARCHAR2(45));
    
INSERT INTO student VALUES ('KTH', 'satelite12@naver.com', 1234);

commit;

SHOW autocommit;
SET autocommit on;