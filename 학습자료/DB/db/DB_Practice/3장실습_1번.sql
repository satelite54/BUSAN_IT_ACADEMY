--1. ���缭���� ���� �䱸�ϴ� ���� ������ ���� SQL ���� �ۼ��Ͻÿ�.
--  (1) ������ȣ�� 1�� ������ �̸�
    select bookname
    from book
    where bookid = 1;
    
--  (2) ������ 20,000�� �̻��� ������ �̸�
    select bookname
    from book
    where price >= 20000;
--  (3) �������� �� ���ž�
    select sum(saleprice)
    from orders
    where custid = 1;
    
    select sum(saleprice)
    from customer, orders
    where customer.custid = orders.custid
        and name like '������' ;
    
    
--  (4) �������� ������ ������ ��
    select count(distinct bookid)
    from orders
    where custid = 1;
    
    select count(distinct bookid)
    from customer, orders
    where customer.custid = orders.custid
       and name like '������';
    
--  
--2. ���缭���� ��ڿ� �濵�ڰ� �䱸�ϴ� ���� ������ ���� SQL ���� �ۼ��Ͻÿ�.
--  (1) ���缭�� ������ �� ����
    select count(*)
    from book;
    
--  (2) ���缭���� ������ ����ϴ� ���ǻ��� �� ����
    select count(distinct publisher)
    from book;
        
--  (3) ��� ���� �̸�, �ּ�
    select name, address
    from customer;
    
--  (4) 2014�� 7�� 4��~7�� 7�� ���̿� �ֹ����� ������ �ֹ���ȣ
    select orderid
    from  orders
    where orderdate between '20140704' and '20140707';
    
    select orderid
    from  orders
    where orderdate >= '20140704' and orderdate <= '20140707';

--  (5) 2014�� 7�� 4��~7�� 7�� ���̿� �ֹ����� ������ ������ ������ �ֹ���ȣ
    select orderid
    from  orders
    where orderdate not between '14 07 04' and '14 07 07';

--  (6) ���� ���衯 ���� ���� �̸��� �ּ�
    select name, address
    from customer
    where name like '��%';

--  (7) ���� ���衯 ���̰� �̸��� ���ơ��� ������ ���� �̸��� �ּ�
    select name, address
    from customer
    where name like '��%��';
