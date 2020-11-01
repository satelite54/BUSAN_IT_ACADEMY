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
SELECT book.bookname FROM book
MINUS SELECT name FROM customer, orders
WHERE customer.custid = 1 AND orders.custid = 1;

-- 주문하지 않은 고객의 이름(조인 사용) -- 하... 못풀었다. 답아님
-- (1)차집합 사용
-- (2) NOT IN (3) NOT EXISTS 사용
SELECT DISTINCT customer.name FROM customer, orders
WHERE customer.custid IN (orders.custid);
-- 주문하지 않은 고객의 이름(차집합 사용) )
SELECT name FROM customer
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