SELECT bookname, price FROM book;

SELECT * FROM book;

SELECT DISTINCT publisher FROM book;

SELECT bookname FROM book WHERE price < 20000;

SELECT * FROM Book WHERE price BETWEEN 10000 AND 20000;

SELECT * FROM Book WHERE publisher IN('굿스포츠', '대한미디어');

SELECT * FROM Book WHERE publisher NOT IN('굿스포츠', '대한미디어');

SELECT bookname, publisher
FROM book 
WHERE bookname LIKE '축구의 역사';

SELECT bookname, publisher
FROM book 
WHERE bookname LIKE '%축구%';

SELECT * FROM Book WHERE bookname LIKE '_구%';

SELECT * FROM book WHERE bookname LIKE '%축구%' AND price >= 20000;

SELECT * FROM book ORDER BY bookname;

SELECT * FROM book ORDER BY price, bookname;

SELECT * FROM book ORDER BY price DESC, publisher ASC;


SELECT
    SUM(saleprice)
FROM Orders;

SELECT custid, COUNT(*) AS 도서수량
FROM Orders
WHERE saleprice >= 8000
GROUP BY custid
HAVING count(*) >= 2; 

SELECT bookname FROM book
WHERE bookid = 1;

SELECT bookname FROM book
WHERE price >= 20000;

SELECT SUM(saleprice) FROM Orders
WHERE custid = 1;

SELECT COUNT(*) FROM Orders
WHERE custid = 1;

SELECT COUNT(*) FROM book;

SELECT COUNT(DISTINCT publisher) FROM book;

SELECT name, address FROM customer;

SELECT orderid FROM orders
WHERE orderdate BETWEEN '14/07/04' AND '14/07/07';

SELECT  orderid FROM orders
WHERE NOT(orderdate BETWEEN '14/07/04' AND '14/07/07');

SELECT name, address FROM customer
WHERE name LIKE '김%';

SELECT name, address FROM customer
WHERE name LIKE '김%' AND name LIKE '%아';

SELECT name, address FROM customer
WHERE name LIKE '%김연%';

SELECT bookname FROM book
WHERE bookid = 1;

SELECT bookname FROM book
WHERE price > 20000;

SELECT SUM(saleprice) FROM orders
WHERE custid = 1;

SELECT COUNT(*) FROM orders
WHERE custid = 1;

SELECT COUNT(*) FROM book;
SELECT COUNT(DISTINCT publisher) FROM book;

SELECT name, address FROM customer;

SELECT orderid FROM orders
WHERE orderdate BETWEEN '14/07/04' AND '14/07/07';

SELECT orderid FROM orders
WHERE NOT(orderdate BETWEEN '14/07/04' AND '14/07/07');

SELECT name, address FROM customer
WHERE name LIKE '김%';

SELECT name, address FROM customer
WHERE name LIKE '김%' AND name LIKE '%아';

SELECT * FROM customer, orders; -- 두개 테이블 조인(합치기) 가상테이블 생성
-- 투플의 개수는 고객 5명 주문 10개 5 * 10 = 50개

-- 고객과 고객의 주문에 관한 데이터를 모두 보이시오
SELECT * FROM customer, orders
WHERE customer.custid = orders.custid;
-- 고객과 고객의 주문에 관한 데이터를 고객번호 순으로 정렬하여 보이시오.
SELECT * FROM customer, orders
WHERE customer.custid = orders.custid
ORDER BY customer.custid;
-- 고객의 이름과 고객이 주문한 도서의 판매가격을 검색하시오.
SELECT customer.name, orders.saleprice FROM customer, orders
WHERE customer.custid = orders.custid; -- 합친테이블에서 어떤 속성으로 조회할 값을 리턴할 것인가? 여기서는 custid
-- 고객별로 주문한 모든 도서의 총판매액을 구하고, 고객별로 정렬하시오.
SELECT customer.name, SUM(saleprice) FROM customer, orders
WHERE customer.custid = orders.custid
GROUP BY customer.name
ORDER BY customer.name;

-- 고객의 이름과 고객이 주문한 도서의 이름을 구하시오.
SELECT customer.name, book.bookname
FROM customer, orders, book
WHERE customer.custid = orders.custid AND orders.bookid = book.bookid;
-- 가격이 20000원인 도서를 주문한 고객의 이름과 도서의 이름을 구하시오.
SELECT customer.name, book.bookname FROM customer, book, orders
WHERE customer.custid = orders.custid 
    AND orders.bookid =book.bookid
    AND book.price = 20000;
-- 여기까지가 innerjoin
  
-- 이게 outerjoin
SELECT customer.name, saleprice FROM customer LEFT OUTER JOIN orders
ON Customer.custid = orders.custid; -- 책산 놈들이랑 안산놈들 이랑 책산 놈들 판매가를 모두다 출력해라
-- 왼쪽에 있는 놈들은 무조건 조인해라 오른쪽에 값이 없어도 무조건 조인
-- 양쪽에 있는 놈들 모두 조인할때 풀아웃조인이라고 한다.

-- 부속질의 시작
-- 가장 비싼 도서의 이름을 보여라.
SELECT bookname FROM book
WHERE price = (SELECT MAX(price) FROM book);

-- 도서를 구매한 적이 있는 고객의 이름을 검색하시오.
SELECT name FROM customer
WHERE custid IN(SELECT custid FROM orders);

-- 대한미디어에서 출판한 도서를 구매한 고객의 이름을 보이시오.
SELECT name FROM customer -- customer 테이블에서 name 속성을 추출한다.
WHERE custid IN(SELECT custid -- 집합 연산자 IN 사용해서 IN의 리턴값이 custid와 같은 것만출력
                FROM orders -- orders 테이블에서
                WHERE bookid IN(SELECT bookid -- 
                                FROM book 
                                WHERE publisher='대한미디어'));

-- 출판사별로 출판사의 평균 도서 가격보다 비싼 도서를 구하시오.
-- 
SELECT b1.bookname FROM book b1 -- book 테이블을 b1으로 하고 b1.bookname을 조회한다.
WHERE b1.price > (SELECT AVG(b2.price) -- b1.price가 b2.price의 평균가격보다 비쌀 때 
                    FROM book b2
                    WHERE b2.publisher=b1.publisher); -- b2 출판사 이름과 b1 출판사 이름이 같은 경우

-- 집합연산
-- 도서를 주문하지 않은 고객의 이름을 보이시오.
SELECT name FROM customer 
MINUS SELECT name FROM customer -- 차집합
-- 찾아보니 MySQL에서는 EXCEPT를 쓰고 Oracle에서는 MINUS가 차집합이라고 한다. PPT가 잘못된듯
WHERE custid IN(SELECT custid FROM orders);

-- EXISTS란 조건에 맞는 튜플이 존재하면 참(결과에 포함) -- row 튜플 자체가 맞아야지 참
-- NOT EXISTS는 모든 튜플의 행이 조건에 만족하지 않으면 참
-- 주문이 있는 고객의 이름과 주소를 보이시오.
SELECT name, address
FROM customer cs
WHERE EXISTS (SELECT * FROM orders od -- 부속질의문
                WHERE cs.custid = od.custid);

-- 예제

-- 박지성이 구매한 도서의 출판사 수 (문제풀이 핵심은 조인)
SELECT COUNT(DISTINCT publisher)
FROM book, orders, customer
WHERE orders.custid = customer.custid AND orders.custid = 1;

-- 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이 (문제풀이 핵심은 조인)
SELECT bookname, price, book.price - orders.saleprice AS "정가 - 판매가격"
FROM book, orders, customer
-- 구매했다는 것은 orders 테이블에 박지성의 id가 있는 것
WHERE  orders.custid = customer.custid AND orders.custid = 1;

-- 박지성이 구매하지 않은 도서의 이름(방법 여러가지)
-- 1. 모든 사람들이 구매한 도서 - 박지성이 산 도서 (차집합)
-- 2. WHERE절에 박지성이 산 도서를 구해서 NOT IN 사용방법(부속절에다가)
-- 3. WHERE 박지성이 산 도서 구해서 NOT EXISTS 사용(맞나????)
-- 나는 차집합으로 풀었다.
SELECT book.bookname FROM book -- (1)
MINUS SELECT name FROM customer, orders
WHERE customer.custid = 1 AND orders.custid = 1;

SELECT bookname FROM book-- (2)
WHERE bookname NOT IN (SELECT bookname FROM customer, orders, book
                        WHERE customer.custid = orders.custid
                        AND orders.bookid = book.bookid
                        AND NAME LIKE '박지성');

SELECT bookname FROM book-- (3)
WHERE NOT EXISTS (SELECT bookname FROM customer, orders-- book
                        WHERE customer.custid = orders.custid
                        AND orders.bookid = book.bookid
                        AND NAME LIKE '박지성');

-- 주문하지 않은 고객의 이름(조인 사용) -- 하... 못풀었다. 답아님
-- (1)차집합 사용

SELECT name FROM customer
MINUS
SELECT name FROM orders, customer
WHERE orders.custid = customer.custid;
-- (2) NOT IN (3) NOT EXISTS 사용
SELECT DISTINCT customer.name FROM customer, orders
WHERE customer.custid IN (orders.custid);
-- 주문하지 않은 고객의 이름(차집합 사용) )
SELECT name FROM customer --(1)
MINUS
SELECT name FROM customer
WHERE custid IN(SELECT custid FROM orders);

-- OUTER JOIN
SELECT customer.name FROM customer LEFT OUTER JOIN orders
ON customer.custid = orders.custid; -- 조인 조건문
-- LEFT OUTER JOIN 조인준의 왼쪽에 있는 테이블의 모든 결과 가져온 후 오른쪽의 테이블의
-- 데이터를 매칭, 매칭되는 데이터가 없는 경우 NULL
-- 이렇게 표시되어야함
-- 박지성의 id는 3이므로 박지성3개 출력됨
--  박지성3개 김연아2개 장미란 3개 추신수 2개 박세리 1개 출력되어야함
-- 내부조인과 외부조인 사용해야하는 경우는? 속성 값에 NULL이 있느냐 없느냐
-- 내부조인인 경우 NULL 항목은 표시하지 않기 때문에 NULL을 표현해 주려면 외부조인을 사용해야한다.

-- 주문금액의 총액과 주문의 평균 금액
SELECT SUM(saleprice), AVG(saleprice) FROM orders;

-- 고객의 이름과 고객별 구매액 -- 고객, 주문 (조인)
SELECT customer.name, SUM(orders.saleprice) FROM customer, orders
WHERE customer.custid = orders.custid
GROUP BY customer.name;
-- 고객의 이름과 고객이 구매한 도서 목록(조인) -- ????? 나중에 하자
SELECT customer.name, book.bookname FROM customer, orders, book
WHERE customer.custid = orders.custid AND orders.custid = book.bookid;

-- 도서의 가격과 판매가격의 차이가 가장 많은 주문 -- max()사용 부속절의 S F W에서 W 뒤에 사용

SELECT DISTINCT o1.orderid AS "주문번호", (b1.price - o1.saleprice) AS "판매차익" 
FROM book b1, orders o1
WHERE (b1.price - o1.saleprice) = (SELECT MAX(b2.price - o2.saleprice)
                                    FROM book b2, orders o2
                                    WHERE b2.bookid = o2.bookid);
                                    
select t1.price, t2.saleprice, t1.price-t2.saleprice, t2.*
from book t1, orders t2
where t1.bookid = t2.bookid
and t1.price - t2.saleprice = (select max(t3.price-t4.saleprice)
                                from book t3, orders t4
                                where t3.bookid = t4.bookid);

-- 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름 -- S F W G H HAVING 절에서 S F W로 전체 평균

select name, avg(saleprice)
from customer t1, orders t2
where t1.custid = t2.custid
group by name
having avg(saleprice) > (select avg(t3.saleprice) from orders t3);
-- 상관커리란 고객별로 구하긴 구할껀데 부속절에서 처리

SELECT * FROM customer, orders, book
WHERE customer.custid = orders.custid AND orders.bookid = book.bookid;

--------------------------------------------------------------------------------------------
--Create 문

CREATE TABLE NewBook(
bookid      NUMBER,
bookname       VARCHAR2(20),
publisher      VARCHAR2(20),
price          NUMBER,
PRIMARY KEY (bookid));

DROP TABLE newbook;

CREATE TABLE NewBook( -- 테이블 생성
bookid      NUMBER,
bookname       VARCHAR2(20)     NOT NULL,
publisher      VARCHAR2(20)     UNIQUE,
price          NUMBER DEFAULT 10000 CHECK(price > 1000),
PRIMARY KEY (bookid,price));

CREATE TABLE newcustomer
(custid NUMBER, PRIMARY KEY(custid),
name    VARCHAR2(40),
address VARCHAR2(40),
phone   VARCHAR2(30)
);

CREATE TABLE neworders ( -- 테이블 생성
orderid NUMBER,
custid  NUMBER NOT NULL,
bookid  NUMBER NOT NULL,
saleprice  NUMBER,
orderdate   DATE,
PRIMARY KEY(orderid), -- 기본키 지정
FOREIGN KEY(custid) REFERENCES newcustomer(custid) ON DELETE CASCADE);
-- 외래키 지정 -- 제약조건 명시시 반드시 참조된 테이블이 존재해야함
-- 참조되는 부모 테이블의 기본키여야한다.

ALTER TABLE newbook ADD isbn VARCHAR2(13); -- newbook 테이블에 varchar2의 자료형을 가진 속성을 
-- 추가해라

ALTER TABLE newbook MODIFY isbn NUMBER; -- newbook 테이블에 isbn속성 데이터 타입을 NUMBER로 변경

ALTER TABLE newbook DROP COLUMN isbn; -- newbook 테이블의 isbn속성을 삭제해라

ALTER TABLE newbook MODIFY bookid NUMBER NOT NULL; -- bookid속성에 NOT NULL 제약조건을 적용

ALTER TABLE newbook ADD PRIMARY KEY(bookid);

DROP TABLE newbook;

DROP TABLE newcustomer; -- newcustomer 테이블 삭제 데이터 테이블 구조까지 싹싹!
                        -- DELETE는 데이터만 삭제
DROP TABLE newcustomer CASCADE CONSTRAINTS; -- 다른 테이블이 해당 테이블을 참조할 경우 그냥 드롭
-- 하면 안된다. CASCADE CONSTRINTS 옵션을 붙여 주면 해당 참조하는 테이블까지 다 삭제함

INSERT INTO book(bookid, bookname, publisher, price) -- 튜플 삽입
        VALUES(11, '스포츠 의학', '한솔의학서적', 90000);

ALTER TABLE book MODIFY price NUMBER NULL;

INSERT INTO book(bookid, bookname, publisher)
VALUES(14, '스포츠 의학', '한솔의학서적'); -- 입력 데이터가 없으면 null 값으로 들어간다.
                                        -- price = NULL
                                        -- 테이블에 무결성 제약조건이 있으면 제약조건 에러 발생

UPDATE customer SET address= '대한민국 부산' -- 특정 속성 값을 수정
WHERE custid = 5;

-- 박세리의 주소명을 김연아의 주소명으로 바꿔라
UPDATE customer SET address = (SELECT address FROM customer
                                WHERE name LIKE '김연아'
                                )
WHERE name LIKE '박세리';

-- customer 테이블에서 고객번호가 5인 고객을 삭제해라.
DELETE FROM customer
WHERE custid = 5;

-- 모든 고객을 삭제해라 -- 자식레코드 발견시 삭제 안함 무결성 제약조건 땜시
DELETE FROM customer;
-------예제

--박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름 ????
SELECT DISTINCT name FROM customer, orders, book b1
WHERE customer.custid = orders.custid AND orders.bookid = b1.bookid
AND b1.publisher IN (SELECT b2.publisher FROM customer, orders, book b2
WHERE customer.custid = '1')
AND name NOT LIKE '박지성';

SELECT name FROM (SELECT name FROM orders, customer, book
                    WHERE orders.bookid = book.bookid AND customer.custid = orders.custid
                            AND publisher IN (SELECT book.publisher FROM orders, customer, book
                                                WHERE orders.bookid = book.bookid AND customer.custid = orders.custid
      AND customer.name LIKE '박지성'))
WHERE name NOT LIKE '박지성'; --- 답은 나오는것 같은데 너무 길다 ㅠㅠㅠㅠ 문제보고 어떻게 해결하면
-- 효율적으로 할 수 있을까 고민해야할 듯하다....

-- 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름 - 상관쿼리
-- GROUP BY 를 사용한 쿼리는 상관쿼리로 바꿀 수 있다
SELECT C1.NAME
FROM customer C1 -- 하위쿼리에 C.NAME LIKE C1.NAME 이렇게 연결하면 GROUP BY를 안쓰고도 그룹함수를 쓸 수 있다.
WHERE 2 <= (SELECT COUNT(DISTINCT B.PUBLISHER) 
            FROM customer C, ORDERS O, BOOK B WHERE c.custid = o.custid AND o.bookid = b.bookid AND C.NAME = C1.NAME);

-- 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
SELECT C.NAME, COUNT(DISTINCT b.publisher) FROM customer C, ORDERS O, BOOK B 
                                            WHERE c.custid = o.custid AND o.bookid = b.bookid
                                            GROUP BY C.NAME
                                            HAVING COUNT(DISTINCT b.publisher) >= 2;

-- 전체 고객의 30% 이상이 구매한 도서
SELECT B1.BOOKNAME FROM BOOK B1 
WHERE (SELECT COUNT(b.bookname) FROM ORDERS O, BOOK B 
              WHERE o.bookid = b.bookid AND B.BOOKID = B1.BOOKID) >= ( SELECT (COUNT(*) * 0.3) FROM customer);
-- 그룹 바이 사용 그룹바이 쓸 수 있는 문제는 대부분 상관커리로 해결이 가능하다.
SELECT bookname FROM book, orders
WHERE book.bookid = orders.bookid
group by book.bookname
HAVING COUNT(book.bookid) >= (SELECT COUNT(*) FROM customer) *0.3;
-- 그룹 바이 썼지만 집계함수가 SELECT 리턴 속성에 없는 이유는 HAVING 에서 집계 함수를 사용했기 때문에 뭘로 집계할껀지 알고 있어서.


-- 새로운 도서('스포츠 세계', '대한미디어', 10000원)이 마당서점에 입고되었다.
-- 삽입이 안될 경우 필요한 데이터가 더 있는지 찾아보자.
INSERT INTO book(book.bookid, book.bookname, book.price, book.publisher)
        VALUES(15,'스포츠 세계', 10000, '대한미디어');

DELETE FROM book
WHERE publisher LIKE '삼성당';

DELETE FROM book -- orders의 bookid가 연관되어 있는것같다.. 그래서 삭제가 안되네.
WHERE publisher LIKE '이상미디어';

UPDATE book SET publisher = '대한출판사'
WHERE publisher LIKE '대한미디어';

select
    constraint_name,
    table_name,
    r_constraint_name
from
    user_constraints
where
    constraint_name = 'SYS_C007021';

-- 4장 SQL 고급
-- ABS 절대값

CREATE TABLE dual(
                value1 NUMBER,
                value2 NUMBER
                );
INSERT INTO dual(value1, value2)
VALUES(-78, 78);

SELECT ABS(value1), ABS(value2) FROM dual;
-- 절대값 
SELECT ROUND(4.875, 1) FROM dual;