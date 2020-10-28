SELECT bookname, price FROM book;

SELECT * FROM book;

SELECT DISTINCT publisher FROM book;

SELECT bookname FROM book WHERE price < 20000;

SELECT * FROM Book WHERE price BETWEEN 10000 AND 20000;

SELECT * FROM Book WHERE publisher IN('±Â½ºÆ÷Ã÷', '´ëÇÑ¹Ìµð¾î');

SELECT * FROM Book WHERE publisher NOT IN('±Â½ºÆ÷Ã÷', '´ëÇÑ¹Ìµð¾î');

SELECT bookname, publisher
FROM book 
WHERE bookname LIKE 'Ãà±¸ÀÇ ¿ª»ç';

SELECT bookname, publisher
FROM book 
WHERE bookname LIKE '%Ãà±¸%';

SELECT * FROM Book WHERE bookname LIKE '_±¸%';

SELECT * FROM book WHERE bookname LIKE '%Ãà±¸%' AND price >= 20000;

SELECT * FROM book ORDER BY bookname;

SELECT * FROM book ORDER BY price, bookname;

SELECT * FROM book ORDER BY price DESC, publisher ASC;


SELECT
    SUM(saleprice)
FROM Orders;

SELECT custid, COUNT(*) AS µµ¼­¼ö·®
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
WHERE name LIKE '±è%';

SELECT name, address FROM customer
WHERE name LIKE '±è%' AND name LIKE '%¾Æ';

SELECT name, address FROM customer
WHERE name LIKE '%±è¿¬%'