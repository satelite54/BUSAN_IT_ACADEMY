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
--------------------------------------------------------------------------------
-- 패턴 연산자 "%, _"
-- 이름이 김으로 시작하는 맴버를 검색해라
SELECT * FROM member WHERE name LIKE '김%';
-- 김씨 성을 제외한 회원을 조회하시오.
SELECT * FROM member WHERE name NOT LIKE '김%';
-- 회원중에 이름이 '태'자가 들어간 회원을 조회
SELECT * FROM member WHERE name LIKE '%태%';
--------------------------------------------------------------------------------
-- 정규식
-- 데이터 준비
INSERT INTO notice(id, title, writer_id, content, regdate, hit, files) VALUES (6,
'전화번호로 연락주시기 바랍니다. 010-2212-3432', 'quest', '연락처를 남깁니다.', SYSTIMESTAMP, 12, 'C:\Users\satellite\Pictures\컴퓨터1.png');
INSERT INTO notice(id, title, writer_id, content, regdate, hit, files) VALUES (7,
'선반-접시-그릇 이 세가지요~~', 'okay', ' soso', SYSTIMESTAMP, 12, 'C:\Users\satellite\Pictures\컴퓨터1.png');
INSERT INTO notice(id, title, writer_id, content, regdate, hit, files) VALUES (1,
'JDBC란 무엇인가?', 'newlec', 'aaa', SYSTIMESTAMP, 12, 'C:\Users\satellite\Pictures\컴퓨터1.png');
INSERT INTO notice(id, title, writer_id, content, regdate, hit, files) VALUES (2,
'JDBC 드라이버 다운로드 방법', 'dragon', 'aaa', SYSTIMESTAMP, 12, 'C:\Users\satellite\Pictures\컴퓨터1.png');
INSERT INTO notice(id, title, writer_id, content, regdate, hit, files) VALUES (3,
'파라미터를 가지는 문장 실행하기', 'good', 'aaa', SYSTIMESTAMP, 12, 'C:\Users\satellite\Pictures\컴퓨터1.png');
INSERT INTO notice(id, title, writer_id, content, regdate, hit, files) VALUES (4,
'JSP에서 JDBC 사용하기', 'dragon', 'ddd', SYSTIMESTAMP, 12, 'C:\Users\satellite\Pictures\컴퓨터1.png');
INSERT INTO notice(id, title, writer_id, content, regdate, hit, files) VALUES (5,
'Service 게층 추가하기', 'good', 'qqq', SYSTIMESTAMP, 12, 'C:\Users\satellite\Pictures\컴퓨터1.png');

-- 제목에 전화번호 패턴이 들어간 제목을 찾고 싶다.
SELECT * FROM notice WHERE title LIKE '%-%-%';

-- 이렇게하면 전화번호가 아닌 데이터 출력 된다.
-- 숫자 패턴만 출력되게 제약을 걸고 싶다.
-- 01[016789] 0 또는 1 또는 6.... \d는 0부터 9까지 표현
-- 01[016-9]-\d\d\d\d-\d\d\d\d
-- 01[016-9]-\d{3, 4}-\d{4} -- {} 반복적으로 쓰이는 문자를 줄일 수 있음 ','를 쓰면 3번 반복되거나 4번 반복되거나 다 표현 가능
-- 정규식은 ^로 시작하고 $로 끝난다.

-- 정규식으로 조회하기
SELECT * FROM notice WHERE REGEXP_LIKE(title, '^01[016-9]-\d{3,4}-\d{4}$');
-- 이렇게 하면 안나온다 ^ $ 딱 저것만 검색함 시작은 ^01[016-9]고 끝은 \d{4}로 끝나야함
SELECT * FROM notice WHERE REGEXP_LIKE(title, '01[016-9]-\d{3,4}-\d{4}');
-- ^ $를 지워주면 검색된다.

-- \w는 [a-zA-Z_0-9] +는 0이상의 문자  \D는 0-9가 아닌문자 *는 1개 이상의 문자 ()는 한단어인지? |는 표현 단어 OR
-- 이메일을 표현하기 위한 표현식
-- 이메일은 숫자로 시작하면 안되고 1글자 이상이여야 하므로 \D\w*
SELECT * FROM member WHERE REGEXP_LIKE(email, '\D\w*@\D\w*.(org|net|com)');
--------------------------------------------------------------------------------
-- ROWNUM, 행 제한하기
SELECT * FROM notice;

-- 이렇게 하면 1~5 밖에 출력되지 않는다 왜냐 비교할때 한 로우 불러온다음 조건에 안맞으면 빼버리기 때문에
SELECT * FROM notice WHERE ROWNUM BETWEEN 1 AND 5;
-- 이렇게 SELECT 절로  View를 생성해 ROWNUM 범위 조회 할수 있다. 이때 ROWNUM을 별칭으로 num으로 준다.
SELECT * FROM (SELECT ROWNUM num, notice.* FROM notice) WHERE num BETWEEN 6 AND 10;
--------------------------------------------------------------------------------
-- 중복 제거 (DISTINCT)
SELECT DISTINCT id FROM member;
-- 한 컬럼에서 중복을 제거할때 사용한다.
--------------------------------------------------------------------------------
-- 날짜 함수
