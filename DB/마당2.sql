SELECT bookname, price FROM book;
SELECT * FROM book;
SELECT DISTINCT publisher FROM book;
SELECT bookname FROM book WHERE price < 20000;
SELECT * FROM book WHERE price BETWEEN 10000 AND 20000;
SELECT * FROM book WHERE publisher IN('�½�����', '���ѹ̵��');
SELECT * FROM book WHERE publisher NOT IN('�½�����', '���ѹ̵��');
SELECT bookname, publisher FROM book WHERE bookname LIKE '%�౸%';
SELECT * FROM book WHERE bookname LIKE '_��%';
SELECT * FROM book WHERE bookname LIKE '%�౸%' AND price > 20000;
SELECT * FROM book ORDER BY bookname;
SELECT * FROM book ORDER BY price, bookname;
SELECT * FROM book ORDER BY price DESC, publisher ASC;

SELECT SUM(saleprice) FROM orders;