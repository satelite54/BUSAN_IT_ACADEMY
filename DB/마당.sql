SELECT bookname, price FROM book;

SELECT * FROM book;

SELECT DISTINCT publisher FROM book;

SELECT bookname FROM book WHERE price < 20000;

SELECT * FROM Book WHERE price BETWEEN 10000 AND 20000;

SELECT * FROM Book WHERE publisher IN('�½�����', '���ѹ̵��');

SELECT * FROM Book WHERE publisher NOT IN('�½�����', '���ѹ̵��');

SELECT bookname, publisher
FROM book 
WHERE bookname LIKE '�౸�� ����';

SELECT bookname, publisher
FROM book 
WHERE bookname LIKE '%�౸%';

SELECT * FROM Book WHERE bookname LIKE '_��%';

SELECT * FROM book WHERE bookname LIKE '%�౸%' AND price >= 20000;

SELECT * FROM book ORDER BY bookname;

SELECT * FROM book ORDER BY price, bookname;

SELECT * FROM book ORDER BY price DESC, publisher ASC;


SELECT
    SUM(saleprice)
FROM Orders;

SELECT custid, COUNT(*) AS ��������
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
WHERE name LIKE '��%';

SELECT name, address FROM customer
WHERE name LIKE '��%' AND name LIKE '%��';

SELECT name, address FROM customer
WHERE name LIKE '%�迬%';

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
WHERE name LIKE '��%';

SELECT name, address FROM customer
WHERE name LIKE '��%' AND name LIKE '%��';

SELECT * FROM customer, orders; -- �ΰ� ���̺� ����(��ġ��) �������̺� ����
-- ������ ������ �� 5�� �ֹ� 10�� 5 * 10 = 50��

-- ���� ���� �ֹ��� ���� �����͸� ��� ���̽ÿ�
SELECT * FROM customer, orders
WHERE customer.custid = orders.custid;
-- ���� ���� �ֹ��� ���� �����͸� ����ȣ ������ �����Ͽ� ���̽ÿ�.
SELECT * FROM customer, orders
WHERE customer.custid = orders.custid
ORDER BY customer.custid;
-- ���� �̸��� ���� �ֹ��� ������ �ǸŰ����� �˻��Ͻÿ�.
SELECT customer.name, orders.saleprice FROM customer, orders
WHERE customer.custid = orders.custid; -- ��ģ���̺��� � �Ӽ����� ��ȸ�� ���� ������ ���ΰ�? ���⼭�� custid
-- ������ �ֹ��� ��� ������ ���Ǹž��� ���ϰ�, ������ �����Ͻÿ�.
SELECT customer.name, SUM(saleprice) FROM customer, orders
WHERE customer.custid = orders.custid
GROUP BY customer.name
ORDER BY customer.name;

-- ���� �̸��� ���� �ֹ��� ������ �̸��� ���Ͻÿ�.
SELECT customer.name, book.bookname
FROM customer, orders, book
WHERE customer.custid = orders.custid AND orders.bookid = book.bookid;
-- ������ 20000���� ������ �ֹ��� ���� �̸��� ������ �̸��� ���Ͻÿ�.
SELECT customer.name, book.bookname FROM customer, book, orders
WHERE customer.custid = orders.custid 
    AND orders.bookid =book.bookid
    AND book.price = 20000;
-- ��������� innerjoin
  
-- �̰� outerjoin
SELECT customer.name, saleprice FROM customer LEFT OUTER JOIN orders
ON Customer.custid = orders.custid; -- å�� ����̶� �Ȼ��� �̶� å�� ��� �ǸŰ��� ��δ� ����ض�
-- ���ʿ� �ִ� ����� ������ �����ض� �����ʿ� ���� ��� ������ ����
-- ���ʿ� �ִ� ��� ��� �����Ҷ� Ǯ�ƿ������̶�� �Ѵ�.

-- �μ����� ����
-- ���� ��� ������ �̸��� ������.
SELECT bookname FROM book
WHERE price = (SELECT MAX(price) FROM book);

-- ������ ������ ���� �ִ� ���� �̸��� �˻��Ͻÿ�.
SELECT name FROM customer
WHERE custid IN(SELECT custid FROM orders);

-- ���ѹ̵��� ������ ������ ������ ���� �̸��� ���̽ÿ�.
SELECT name FROM customer -- customer ���̺��� name �Ӽ��� �����Ѵ�.
WHERE custid IN(SELECT custid -- ���� ������ IN ����ؼ� IN�� ���ϰ��� custid�� ���� �͸����
                FROM orders -- orders ���̺���
                WHERE bookid IN(SELECT bookid -- 
                                FROM book 
                                WHERE publisher='���ѹ̵��'));

-- ���ǻ纰�� ���ǻ��� ��� ���� ���ݺ��� ��� ������ ���Ͻÿ�.
-- 
SELECT b1.bookname FROM book b1 -- book ���̺��� b1���� �ϰ� b1.bookname�� ��ȸ�Ѵ�.
WHERE b1.price > (SELECT AVG(b2.price) -- b1.price�� b2.price�� ��հ��ݺ��� ��� �� 
                    FROM book b2
                    WHERE b2.publisher=b1.publisher); -- b2 ���ǻ� �̸��� b1 ���ǻ� �̸��� ���� ���

-- ���տ���
-- ������ �ֹ����� ���� ���� �̸��� ���̽ÿ�.
SELECT name FROM customer 
MINUS SELECT name FROM customer -- ������
-- ã�ƺ��� MySQL������ EXCEPT�� ���� Oracle������ MINUS�� �������̶�� �Ѵ�. PPT�� �߸��ȵ�
WHERE custid IN(SELECT custid FROM orders);

-- EXISTS�� ���ǿ� �´� Ʃ���� �����ϸ� ��(����� ����) -- row Ʃ�� ��ü�� �¾ƾ��� ��
-- NOT EXISTS�� ��� Ʃ���� ���� ���ǿ� �������� ������ ��
-- �ֹ��� �ִ� ���� �̸��� �ּҸ� ���̽ÿ�.
SELECT name, address
FROM customer cs
WHERE EXISTS (SELECT * FROM orders od -- �μ����ǹ�
                WHERE cs.custid = od.custid);

-- ����

-- �������� ������ ������ ���ǻ� �� (����Ǯ�� �ٽ��� ����)
SELECT COUNT(DISTINCT publisher)
FROM book, orders, customer
WHERE orders.custid = customer.custid AND orders.custid = 1;

-- �������� ������ ������ �̸�, ����, ������ �ǸŰ����� ���� (����Ǯ�� �ٽ��� ����)
SELECT bookname, price, book.price - orders.saleprice AS "���� - �ǸŰ���"
FROM book, orders, customer
-- �����ߴٴ� ���� orders ���̺� �������� id�� �ִ� ��
WHERE  orders.custid = customer.custid AND orders.custid = 1;

-- �������� �������� ���� ������ �̸�(��� ��������)
-- 1. ��� ������� ������ ���� - �������� �� ���� (������)
-- 2. WHERE���� �������� �� ������ ���ؼ� NOT IN �����(�μ������ٰ�)
-- 3. WHERE �������� �� ���� ���ؼ� NOT EXISTS ���(�³�????)
-- ���� ���������� Ǯ����.
SELECT book.bookname FROM book -- (1)
MINUS SELECT name FROM customer, orders
WHERE customer.custid = 1 AND orders.custid = 1;

SELECT bookname FROM book-- (2)
WHERE bookname NOT IN (SELECT bookname FROM customer, orders, book
                        WHERE customer.custid = orders.custid
                        AND orders.bookid = book.bookid
                        AND NAME LIKE '������');

SELECT bookname FROM book-- (3)
WHERE NOT EXISTS (SELECT bookname FROM customer, orders-- book
                        WHERE customer.custid = orders.custid
                        AND orders.bookid = book.bookid
                        AND NAME LIKE '������');

-- �ֹ����� ���� ���� �̸�(���� ���) -- ��... ��Ǯ����. ��ƴ�
-- (1)������ ���

SELECT name FROM customer
MINUS
SELECT name FROM orders, customer
WHERE orders.custid = customer.custid;
-- (2) NOT IN (3) NOT EXISTS ���
SELECT DISTINCT customer.name FROM customer, orders
WHERE customer.custid IN (orders.custid);
-- �ֹ����� ���� ���� �̸�(������ ���) )
SELECT name FROM customer --(1)
MINUS
SELECT name FROM customer
WHERE custid IN(SELECT custid FROM orders);

-- OUTER JOIN
SELECT customer.name FROM customer LEFT OUTER JOIN orders
ON customer.custid = orders.custid; -- ���� ���ǹ�
-- LEFT OUTER JOIN �������� ���ʿ� �ִ� ���̺��� ��� ��� ������ �� �������� ���̺���
-- �����͸� ��Ī, ��Ī�Ǵ� �����Ͱ� ���� ��� NULL
-- �̷��� ǥ�õǾ����
-- �������� id�� 3�̹Ƿ� ������3�� ��µ�
--  ������3�� �迬��2�� ��̶� 3�� �߽ż� 2�� �ڼ��� 1�� ��µǾ����
-- �������ΰ� �ܺ����� ����ؾ��ϴ� ����? �Ӽ� ���� NULL�� �ִ��� ������
-- ���������� ��� NULL �׸��� ǥ������ �ʱ� ������ NULL�� ǥ���� �ַ��� �ܺ������� ����ؾ��Ѵ�.

-- �ֹ��ݾ��� �Ѿװ� �ֹ��� ��� �ݾ�
SELECT SUM(saleprice), AVG(saleprice) FROM orders;

-- ���� �̸��� ���� ���ž� -- ��, �ֹ� (����)
SELECT customer.name, SUM(orders.saleprice) FROM customer, orders
WHERE customer.custid = orders.custid
GROUP BY customer.name;
-- ���� �̸��� ���� ������ ���� ���(����) -- ????? ���߿� ����
SELECT customer.name, book.bookname FROM customer, orders, book
WHERE customer.custid = orders.custid AND orders.custid = book.bookid;

-- ������ ���ݰ� �ǸŰ����� ���̰� ���� ���� �ֹ� -- max()��� �μ����� S F W���� W �ڿ� ���

SELECT DISTINCT o1.orderid AS "�ֹ���ȣ", (b1.price - o1.saleprice) AS "�Ǹ�����" 
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

-- ������ �Ǹž� ��պ��� �ڽ��� ���ž� ����� �� ���� ���� �̸� -- S F W G H HAVING ������ S F W�� ��ü ���

select name, avg(saleprice)
from customer t1, orders t2
where t1.custid = t2.custid
group by name
having avg(saleprice) > (select avg(t3.saleprice) from orders t3);
-- ���Ŀ���� ������ ���ϱ� ���Ҳ��� �μ������� ó��

SELECT * FROM customer, orders, book
WHERE customer.custid = orders.custid AND orders.bookid = book.bookid;

--------------------------------------------------------------------------------------------
--Create ��

CREATE TABLE NewBook(
bookid      NUMBER,
bookname       VARCHAR2(20),
publisher      VARCHAR2(20),
price          NUMBER,
PRIMARY KEY (bookid));

DROP TABLE newbook;

CREATE TABLE NewBook( -- ���̺� ����
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

CREATE TABLE neworders ( -- ���̺� ����
orderid NUMBER,
custid  NUMBER NOT NULL,
bookid  NUMBER NOT NULL,
saleprice  NUMBER,
orderdate   DATE,
PRIMARY KEY(orderid), -- �⺻Ű ����
FOREIGN KEY(custid) REFERENCES newcustomer(custid) ON DELETE CASCADE);
-- �ܷ�Ű ���� -- �������� ��ý� �ݵ�� ������ ���̺��� �����ؾ���
-- �����Ǵ� �θ� ���̺��� �⺻Ű�����Ѵ�.

ALTER TABLE newbook ADD isbn VARCHAR2(13); -- newbook ���̺� varchar2�� �ڷ����� ���� �Ӽ��� 
-- �߰��ض�

ALTER TABLE newbook MODIFY isbn NUMBER; -- newbook ���̺� isbn�Ӽ� ������ Ÿ���� NUMBER�� ����

ALTER TABLE newbook DROP COLUMN isbn; -- newbook ���̺��� isbn�Ӽ��� �����ض�

ALTER TABLE newbook MODIFY bookid NUMBER NOT NULL; -- bookid�Ӽ��� NOT NULL ���������� ����

ALTER TABLE newbook ADD PRIMARY KEY(bookid);

DROP TABLE newbook;

DROP TABLE newcustomer; -- newcustomer ���̺� ���� ������ ���̺� �������� �Ͻ�!
                        -- DELETE�� �����͸� ����
DROP TABLE newcustomer CASCADE CONSTRAINTS; -- �ٸ� ���̺��� �ش� ���̺��� ������ ��� �׳� ���
-- �ϸ� �ȵȴ�. CASCADE CONSTRINTS �ɼ��� �ٿ� �ָ� �ش� �����ϴ� ���̺���� �� ������

INSERT INTO book(bookid, bookname, publisher, price) -- Ʃ�� ����
        VALUES(11, '������ ����', '�Ѽ����м���', 90000);

ALTER TABLE book MODIFY price NUMBER NULL;

INSERT INTO book(bookid, bookname, publisher)
VALUES(14, '������ ����', '�Ѽ����м���'); -- �Է� �����Ͱ� ������ null ������ ����.
                                        -- price = NULL
                                        -- ���̺� ���Ἲ ���������� ������ �������� ���� �߻�

UPDATE customer SET address= '���ѹα� �λ�' -- Ư�� �Ӽ� ���� ����
WHERE custid = 5;

-- �ڼ����� �ּҸ��� �迬���� �ּҸ����� �ٲ��
UPDATE customer SET address = (SELECT address FROM customer
                                WHERE name LIKE '�迬��'
                                )
WHERE name LIKE '�ڼ���';

-- customer ���̺��� ����ȣ�� 5�� ���� �����ض�.
DELETE FROM customer
WHERE custid = 5;

-- ��� ���� �����ض� -- �ڽķ��ڵ� �߽߰� ���� ���� ���Ἲ �������� ����
DELETE FROM customer;
-------����

--�������� ������ ������ ���ǻ�� ���� ���ǻ翡�� ������ ������ ���� �̸� ????
SELECT DISTINCT name FROM customer, orders, book b1
WHERE customer.custid = orders.custid AND orders.bookid = b1.bookid
AND b1.publisher IN (SELECT b2.publisher FROM customer, orders, book b2
WHERE customer.custid = '1')
AND name NOT LIKE '������';

SELECT name FROM (SELECT name FROM orders, customer, book
                    WHERE orders.bookid = book.bookid AND customer.custid = orders.custid
                            AND publisher IN (SELECT book.publisher FROM orders, customer, book
                                                WHERE orders.bookid = book.bookid AND customer.custid = orders.custid
      AND customer.name LIKE '������'))
WHERE name NOT LIKE '������'; --- ���� �����°� ������ �ʹ� ��� �ФФФ� �������� ��� �ذ��ϸ�
-- ȿ�������� �� �� ������ ����ؾ��� ���ϴ�....

-- �� �� �̻��� ���� �ٸ� ���ǻ翡�� ������ ������ ���� �̸� - �������
-- GROUP BY �� ����� ������ ��������� �ٲ� �� �ִ�
SELECT C1.NAME
FROM customer C1 -- ���������� C.NAME LIKE C1.NAME �̷��� �����ϸ� GROUP BY�� �Ⱦ��� �׷��Լ��� �� �� �ִ�.
WHERE 2 <= (SELECT COUNT(DISTINCT B.PUBLISHER) 
            FROM customer C, ORDERS O, BOOK B WHERE c.custid = o.custid AND o.bookid = b.bookid AND C.NAME = C1.NAME);

-- �� �� �̻��� ���� �ٸ� ���ǻ翡�� ������ ������ ���� �̸�
SELECT C.NAME, COUNT(DISTINCT b.publisher) FROM customer C, ORDERS O, BOOK B 
                                            WHERE c.custid = o.custid AND o.bookid = b.bookid
                                            GROUP BY C.NAME
                                            HAVING COUNT(DISTINCT b.publisher) >= 2;

-- ��ü ���� 30% �̻��� ������ ����
SELECT B1.BOOKNAME FROM BOOK B1 
WHERE (SELECT COUNT(b.bookname) FROM ORDERS O, BOOK B 
              WHERE o.bookid = b.bookid AND B.BOOKID = B1.BOOKID) >= ( SELECT (COUNT(*) * 0.3) FROM customer);
-- �׷� ���� ��� �׷���� �� �� �ִ� ������ ��κ� ���Ŀ���� �ذ��� �����ϴ�.
SELECT bookname FROM book, orders
WHERE book.bookid = orders.bookid
group by book.bookname
HAVING COUNT(book.bookid) >= (SELECT COUNT(*) FROM customer) *0.3;
-- �׷� ���� ������ �����Լ��� SELECT ���� �Ӽ��� ���� ������ HAVING ���� ���� �Լ��� ����߱� ������ ���� �����Ҳ��� �˰� �־.


-- ���ο� ����('������ ����', '���ѹ̵��', 10000��)�� ���缭���� �԰�Ǿ���.
-- ������ �ȵ� ��� �ʿ��� �����Ͱ� �� �ִ��� ã�ƺ���.
INSERT INTO book(book.bookid, book.bookname, book.price, book.publisher)
        VALUES(15,'������ ����', 10000, '���ѹ̵��');

DELETE FROM book
WHERE publisher LIKE '�Ｚ��';

DELETE FROM book -- orders�� bookid�� �����Ǿ� �ִ°Ͱ���.. �׷��� ������ �ȵǳ�.
WHERE publisher LIKE '�̻�̵��';

UPDATE book SET publisher = '�������ǻ�'
WHERE publisher LIKE '���ѹ̵��';

select
    constraint_name,
    table_name,
    r_constraint_name
from
    user_constraints
where
    constraint_name = 'SYS_C007021';

-- 4�� SQL ���
-- ABS ���밪

CREATE TABLE dual(
                value1 NUMBER,
                value2 NUMBER
                );
INSERT INTO dual(value1, value2)
VALUES(-78, 78);

SELECT ABS(value1), ABS(value2) FROM dual;
-- ���밪 
SELECT ROUND(4.875, 1) FROM dual;