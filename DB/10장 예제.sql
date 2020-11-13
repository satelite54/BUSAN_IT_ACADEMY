-- 10장 시작
-- 테이블 복사(DEPT) 해서 새 DEPT_TMP 테이블을 만듬

-- 기존 테이블 복사
CREATE TABLE dept_temp AS SELECT * FROM dept;

CREATE TABLE CHAP10HW_EMP AS SELECT * FROM emp;
CREATE TABLE chap10hw_dept AS SELECT * FROM dept;
CREATE TABLE chap10hw_salgrade as SELECT * FROM SALGRADE;

INSERT INTO chap10hw_dept
VALUE (50, 'ORACLE', 'busan')