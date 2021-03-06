-- 제약조건

-- 빈값을 허락하지 않는 NOT NULL
DROP TABLE TABLE_NOTNULL;
CREATE TABLE NOTNULL(
    LOGIN_ID VARCHAR2(20) CONSTRAINT TBNN_LGNID_NN NOT NULL,
    LOGIN_PWD VARCHAR2(20) CONSTRAINT TBNN_LGNPW_NN NOT NULL,
    TEL VARCHAR2(20)
    );
DESC table_notnull;
INSERT INTO TABLE_NOTNULL(LOGIN_ID, LOGIN_PWD)
VALUES('TEST','1234');
SELECT * FROM notnull;

-- 이미 만들어진 테이블에 제약조건 NOT NULL을 추가하기
ALTER TABLE NOTNULL
MODIFY(TEL NOT NULL);

-- 제약조건 삭제하기
ALTER TABLE NOTNULL
DROP CONSTRAINT TBNN_LGNPW_NN;

-- 중복되지 않는 값 UNIQUE
CREATE TABLE TEMP(
    LOGIN_ID VARCHAR2(20) UNIQUE,
    LOGIN_PW VARCHAR2(20) NOT NULL,
    TEL VARCHAR2(20)
    );
DESC TEMP;

-- 중복이 되지 않는지 확인
INSERT INTO TEMP
VALUES(NULL,'PW01','010-1234-5678');

SELECT * FROM TEMP;
-- 기본키 PRIMARY KEY
DROP TABLE TEMP;
CREATE TABLE TEMP(
    LOGIN_ID VARCHAR2(20) CONSTRAINT TEMP_LGNID_PK PRIMARY KEY,
    LOGIN_PW VARCHAR2(20) NOT NULL,
    TEL VARCHAR2(20)
    );
DESC TEMP;

-- 예제 기본키 외래키 북스토어
CREATE TABLE CUSTOMERS(
    ID NUMBER(4) PRIMARY KEY,   
    NAME VARCHAR2(100) NOT NULL,
    EMAIL VARCHAR2(100)
);
DROP TABLE ORDERS;
CREATE TABLE ORDERS(
    ID NUMBER(4) PRIMARY KEY,
    ORDER_DATE DATE,
    PRICE NUMBER(10),
    CUSTOMER_ID NUMBER(4),
    FOREIGN KEY(CUSTOMER_ID) REFERENCES CUSTOMERS(ID)
);
-- 고객 정보를 입력
SELECT * FROM customers;
INSERT INTO CUSTOMERS VALUES(1000,'펭수','PENG@NAVER.COM');
INSERT INTO CUSTOMERS VALUES(1010,'둘리','DULY@NAVER.COM');
INSERT INTO CUSTOMERS VALUES(1020,'나나','NANA@NAVER.COM');
INSERT INTO CUSTOMERS VALUES(1030,'네오','NEO@NAVER.COM');
INSERT INTO CUSTOMERS VALUES(1040,'길동','DONG@NAVER.COM');
-- 주문 정보를 입력
SELECT * FROM ORDERS;
INSERT INTO ORDERS VALUES(1,'2020/10/10',40000,1000);
INSERT INTO ORDERS VALUES(2,'2020-11-11',30000,1000);
INSERT INTO ORDERS VALUES(3,'2020/11/12',20000,1020);
INSERT INTO ORDERS VALUES(4,'2020/11/13',10000,1030);
INSERT INTO ORDERS VALUES(5, SYSDATE, 50000, 1020);
INSERT INTO ORDERS VALUES(6, SYSDATE, 30000, 2000); -- 에러발생
INSERT INTO ORDERS VALUES(6, SYSDATE, 30000, NULL); -- 널값은 입력가능

-- 조인(이너)
SELECT c.name, o.order_date , o.price
FROM customers C
JOIN ORDERS O ON c.id = o.customer_id;

-- 집계
SELECT c.name, SUM(o.price) AS TOTAL
FROM customers C
JOIN ORDERS O ON c.id = o.customer_id
GROUP BY C.NAME -- 고객이름으로 묶어서 그룹
ORDER BY SUM(o.price) DESC;









