EXEC DBMS_XDB.SETLISTENERLOCALACCESS(FALSE);

-- DDL
DROP TABLE member;

CREATE TABLE member (
    id VARCHAR2(50),
    pwd NVARCHAR2(50),
    gender NCHAR(9),
    name NVARCHAR2(50),
    brithday CHAR(10),
    phone CHAR(13),
    regdate DATE
);

INSERT INTO member(name) VALUES('남성');

ALTER TABLE member MODIFY id NVARCHAR2(50); --자료형 변경
ALTER TABLE member DROP COLUMN age; -- 컬럼삭제
ALTER TABLE member ADD email VARCHAR2(200); -- 컬럼 추가

CREATE TABLE notice (
    id              NUMBER,
    title           NVARCHAR2(100),
    writer_id       NVARCHAR2(50),
    content         CLOB,
    regdate         TIMESTAMP,
    hit             NUMBER,
    files           NVARCHAR2(1000)
);
INSERT INTO notice VALUES ('1', '안녕하세요', 'satelite54', '내용입니다.', SYSTIMESTAMP,
0, 'C:\Users\satellite\Pictures\컴퓨터1.png');

CREATE TABLE "comment" ( -- 테이블 명이 예약어인 경우 큰 따옴표를 사용하면 예약어라도 테이블 생성가능
    id              NUMBER,
    content         NVARCHAR2(2000),
    regdate         TIMESTAMP,
    writer_id       NVARCHAR2(50),
    notice_id       NUMBER
);

CREATE TABLE role (
    id              VARCHAR2(50),
    discription     NVARCHAR2(500)
);

CREATE TABLE member_role (
    member_id       NVARCHAR2(50),
    role_id         VARCHAR2(50)
);

---------------------------------- DML -----------------------------------------

--INSERT

INSERT INTO member VALUES('satelite54', '1', '남성', '김태헌', '1994-09-25', '010-3484-5022', SYSDATE); -- 모든 필드 값을 입력하기

INSERT INTO member(id, pwd) VALUES('newlec', '111'); -- 튜플 추가하면서 특정 컬럼에 데이터넣기
INSERT INTO member(pwd, id) VALUES('111', 'test'); -- 속성, 필드 컬럼 같은 말임

SELECT id "user id", name, pwd FROM member; -- 테이블 명 as로 컬럼명 별칭 지정가능

--UPDATE

UPDATE member SET pwd='222'; -- 이러면 모든 패스워드가 바뀌게 됨
UPDATE member SET pwd='111' WHERE id = 'dragon'; -- 특정 컬럼만 변경
UPDATE member SET pwd='333', name = '손오공' WHERE id = 'dragon'; -- 두개이상의 컬럼 변경 시

--DELETE

DELETE member WHERE id = 'test';
--------------------------------------------------------------------------------
-- 문자열 연산
-- 숫자 연산
COMMIT;
SELECT hit + 1 FROM notice;
SELECT 1 + '3' FROM DUAL;
SELECT 1 || '3' FROM DUAL;

-- 모든 회원의 이름을 조회하시오.
-- 단 이름은 ID를 붙여서 나타내시오
SELECT name || '(' || id || ')' name FROM member;
--------------------------------------------------------------------------------
-- 비교 연산자
-- =, !=, ^=, <>, >, <, >=, <=, IS NULL, IS NOT NULL;
-- !=, ^=, <>는 같지 않다는 의미 <>는 데이터베이스 ANSI 표준

-- 게시글 중에서 작성자가 'satelite54' 인 게시글만 조회하시오.
SELECT * FROM notice WHERE writer_id = 'satelite54';
-- 게시글 중에서 조회수가 0인 게시글만 조회하시오.
SELECT * FROM notice WHERE hit = 0;
-- 게시글 중에서 내용이 입력된 게시글만 조회하시오.
SELECT * FROM notice WHERE content IS NOT NULL; -- NULL은 비교연산시 이렇게 조회할 수 있음
--------------------------------------------------------------------------------
-- 관계 연산자
-- 조회수가 0, 1, 2인 게시글을 조회하시오.
SELECT * FROM notice WHERE hit = 1 OR hit = 0 OR hit = 2;
SELECT * FROM notice WHERE hit BETWEEN 0 AND 2;

-- 조회수가 0, 2, 7인 게시글을 조회하시오.
SELECT * FROM notice WHERE hit IN(0, 2, 7);
-- 조회수가 0, 2, 7이 아닌 게시글을 조회하시오.
SELECT * FROM notice WHERE hit NOT IN(0, 2, 7);