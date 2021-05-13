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
-- 오라클 함수 종류
-- 문자열 함수, 숫자 함수, 날짜 함수, 변환 함수, NULL 관련 함수, 집계 함수
-- SUBSTR(문자열, 시작위치, 길이)
SELECT SUBSTR('ABCDEFG',3,4) "Substring"
     FROM DUAL;
SELECT SUBSTRB('안녕하세요',5) FROM DUAL;

-- 모든 학생의 이름과 출생 월만을 조회하시오.
SELECT member.name, SUBSTR(member.brithday, 6, 2) FROM member;
-- 회원 중에서 전화번호가 010으로 시작하는 회원의 모든 정보를 출력하시오.
SELECT * FROM member WHERE '010' = SUBSTR(phone, 1, 3);
-- 함수가 WHERE 절에 들어가게 되면 만약 전체 테이블의 레코드가 1억개 정도 되면 함수호출이 1억번 일어나게된다.

-- 회원 중에서 생년 월일이 7,8,9월인 회원의 모든 정보를 출력 -- 비효율적인 것 같다..
SELECT * FROM member WHERE REGEXP_LIKE(SUBSTR(brithday, 7, 1) ,'[7-9]');
SELECT * FROM member WHERE SUBSTR(brithday, 6, 2) IN('07', '08', '09');

-- 전화번호를 등록하지 않은 회원 중에서 생년월일이 7, 8, 9월인 회원의 모든 정보를 출력하시오.
SELECT * FROM member WHERE phone IS NULL AND SUBSTR(brithday, 6, 2) IN('07', '08', '09');

-- 문자열 덧셈 함수
-- CONCAT('문자','문자')
-- 문자열 함수보다 문자열 더하기 연산자 사용하는 거를 추천!!!
SELECT CONCAT('호', '동') FROM DUAL;
SELECT '호' || '동' name FROM DUAL;

-- 문자열 트림 함수
-- LTRIM('  HELLO   ') 왼쪽 공백 제거
-- RTRIM('  HELLO   ') 오른쪽 공백 제거
-- TRIM('  HELLO  ') 양쪽다 제거

SELECT TRIM('  HELLO  ') FROM DUAL;

-- 문자열 소문자, 대문자 변경
SELECT LOWER('NeWlEC') FROM DUAL;
SELECT UPPER('neWlec') FROM DUAL;

-- 회원의 아이디가 'satelite54'인 회원을 조회하시오. (대소문자 구문 안함)
SELECT * FROM member WHERE UPPER('satelite54') = UPPER(id);

-- 문자열 대치 함수 REPLACE(문자열, 찾는 문자열, 대치할 문자열) / TRANSLATE()
-- WE라는 문자만 찾는다.
SELECT REPLACE('WHERE WE ARE','WE','YO') "Changes"
     FROM DUAL;
-- W는 Y로 E는 O로 바꾼다.
SELECT TRANSLATE('WHERE WE ARE','WE','YO') "Changes"
     FROM DUAL;

-- 회원의 이름과 생년월일을 조회하시오.(단 생년월일은 빈칸 없이 출력)
SELECT REPLACE(name, ' ', '') brithday FROM member;  

--------------------------------------------------------------------------------
-- 문자열 함수 2
-- 문자열 패딩 RPAD(문자열, 바이트 수, 문자)
SELECT RPAD(name, 7, '0') FROM member;

-- 첫 글자를 대문자로 교체하는 함수(영어) INITCAP('the dwdwda')
SELECT INITCAP('the dwdwda') FROM DUAL;

-- 문자열의 위치 반환 함수 INSTR('ALL WE NEED TO IS JUST TO..', 'TO')
-- INSTR(문자열, 찾을문자) INSTR(문자열, 찾을문자, 찾을 인덱스) INSTR(문자열, 찾을문자, 첫번째 찾을 인덱스, 찾은 몇 번째 인덱스를 반환할껀지?)
SELECT INSTR('ALL WE NEED TO IS JUST TO..', 'TO') ind FROM DUAL;
--------------------------------------------------------------------------------
-- 날짜 관련 함수
-- SYSDATE 는 서버 기준 날짜, CURRENT_DATE는 사용자 세션기준 날짜 그차이
SELECT SYSDATE, CURRENT_DATE, SYSTIMESTAMP, CURRENT_TIMESTAMP FROM DUAL;

-- 사용자 접속 세션의 설정을 바꿀 수 있다.
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';

-- 날짜 추출함수
-- EXTRACT(YEAR/MONTH.....)
SELECT EXTRACT(YEAR FROM SYSDATE) || '년' 년도 FROM DUAL;

-- 날짜 누적함수
SELECT ADD_MONTHS(SYSDATE, 1) FROM DUAL;

-- 날짜의 차이를 알아내는 함수
SELECT MONTHS_BETWEEN(SYSDATE, TO_DATE('2013-12-25'))
  FROM DUAL;

-- 다음 요일의 날짜 알려주는 함수
SELECT NEXT_DAY(SYSDATE, '토요일') FROM DUAL;

-- 월의 마지막 일자를 알려주는 함수
SELECT LAST_DAY(SYSDATE) FROM DUAL;

-- 지정된 범위에서 날짜를 반올림하는/자르는 함수 ROUND/TRUNC(날짜, 포멧)
SELECT ROUND(SYSDATE, 'CC'), TRUNC(SYSDATE, 'CC') FROM DUAL;