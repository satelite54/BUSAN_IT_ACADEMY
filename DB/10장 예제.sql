-- 10�� ����
-- ���̺� ����(DEPT) �ؼ� �� DEPT_TMP ���̺��� ����

-- ���� ���̺� ����
CREATE TABLE dept_temp AS SELECT * FROM dept;

CREATE TABLE CHAP10HW_EMP AS SELECT * FROM emp;
CREATE TABLE chap10hw_dept AS SELECT * FROM dept;
CREATE TABLE chap10hw_salgrade as SELECT * FROM SALGRADE;

INSERT INTO chap10hw_dept
VALUE (50, 'ORACLE', 'busan')