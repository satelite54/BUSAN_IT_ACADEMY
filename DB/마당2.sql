SELECT bookname, price FROM book;
SELECT * FROM book;
SELECT DISTINCT publisher FROM book;
SELECT bookname FROM book WHERE price < 20000;
SELECT * FROM book WHERE price BETWEEN 10000 AND 20000;
SELECT * FROM book WHERE publisher IN('굿스포츠', '대한미디어');
SELECT * FROM book WHERE publisher NOT IN('굿스포츠', '대한미디어');
SELECT bookname, publisher FROM book WHERE bookname LIKE '%축구%';
SELECT * FROM book WHERE bookname LIKE '_구%';
SELECT * FROM book WHERE bookname LIKE '%축구%' AND price > 20000;
SELECT * FROM book ORDER BY bookname;
SELECT * FROM book ORDER BY price, bookname;
SELECT * FROM book ORDER BY price DESC, publisher ASC;

SELECT SUM(saleprice) FROM orders;