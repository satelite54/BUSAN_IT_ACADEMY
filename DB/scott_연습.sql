-- 1. �μ� ��ȣ�� 10���� �μ��� ��� �� �����ȣ, �̸�, �޿��� ����϶�.

SELECT empno, ename, sal FROM emp
WHERE deptno = 10;
--�����ȣ�� 7639�� ��� �� �̸�, �Ի�����, �μ���ȣ�� ����϶�.

SELECT ename, hiredate, deptno FROM emp
WHERE empno = 7369;

--�̸��� allen�� ����� ��� ������ ����϶�

SELECT * FROM emp
WHERE ename LIKE '%ALLEN%';

--�ϻ����ڰ� 83/01/12�� ����� �̸�, �μ� ��ȣ, �޿��� ����϶�.
SELECT ename, deptno, sal FROM emp
WHERE hiredate = TO_DATE('80/12/17');

--������ MANAGER�� �ƴ� ����� ��� ������ ����϶�.
SELECT * FROM emp
WHERE NOT(job LIKE 'MANAGER');

--�Ի����ڰ� 81/04/02 ���Ŀ� �Ի��� ����� ������ ����϶�.

SELECT * FROM emp
WHERE TO_DATE('81/04/02') < hiredate;

--�޿��� $800�̻��� ����� �̸�, �޿�, �μ� ��ȣ�� ����϶�.

SELECT ename, sal, deptno FROM emp
WHERE 800 < sal;

--�μ���ȣ�� 20�� �̻��� ����� ��� ������ ����϶�.

--������ K�� �����ϴ� ������� ���� �̸��� ���� ����� ��� ������ ����϶�.

SELECT * FROM emp
WHERE ename > 'K' AND NOT(ename LIKE 'K%');

--�Ի����ڰ� 81/12/09 ���� ���� �Ի��� ������� ��� ������ ����϶�.
--

--�Ի��ȣ�� 7698 ���� �۰ų� ���� ������� �Ի��ȣ�� �̸��� ����϶�.
--�Ի����ڰ� 81/04/02 ���� �ʰ� 82/12/09 ���� ���� ����� �̸�, ����, �μ� ��ȣ�� ����϶�.
--�޿��� 1600���� ũ�� 3000���� ���� ����� �̸�, ����, �޿��� ����϶�.
--�����ȣ�� 7654�� 7782 ���� �̿��� ����� ��� ������ ����϶�
--�̸��� B�� J������ ��� ����� ������ ����϶�.
--�Ի����ڰ� 81�� �̿ܿ� �Ի��� ����� ��� ������ ����϶�.
--������ MANGER�� SALESMAN�� ����� ��� ������ ����϶�.
--�μ� ��ȣ�� 20, 30���� ������ ��� ����� �̸�, �����ȣ, �μ� ��ȣ�� ����϶�.
--�̸��� S�� �����ϴ� ����� �����ȣ, �̸�, �Ի�����, �μ���ȣ�� ����϶�.
--�Ի����ڰ� 81�⵵�� ����� ��� ������ ����϶�.
SELECT * FROM emp
WHERE TO_CHAR(hiredate, 'YY') LIKE '81%';
--�̸� �� S�ڰ� �� �ִ� ����� ��� ������ ����϶�.

SELECT * FROM emp
WHERE ename LIKE '%S%';

--22. ����) �̸��� M�� �����ϰ� ������ ���ڰ� N�� ����� ��� ������ ����϶�
--(��, �̸��� ��ü 6�ڸ��̴�. �ڸ����� �̿��� ���ϵ�ī�� '_' �� �̿�)

SELECT * FROM emp
WHERE ename LIKE 'M%' AND ename LIKE '_____%N';

--23. ����) �̸��� ù ��° ���ڴ� �������, �� ��° ���ڰ� A�� ����� ������ ����϶�.
SELECT * FROM emp
WHERE ename LIKE '_%A____';

--24. ����) Ŀ�̼��� NULL�� ����� ������ ����϶�.  ( IS NULL �Ǵ� IS NOT NULL ���)

SELECT * FROM emp
WHERE comm IS NULL;

--25. ����) Ŀ�̼��� NULL�� �ƴ� ����� ��� ������ ����϶�. ( IS NULL �Ǵ� IS NOT NULL ���)
SELECT * FROM emp
WHERE comm IS NOT NULL;
--26. ����) �μ��� 30�� �μ��̰� �޿��� $1,500 �̻��� ����� �̸�, �μ� ,������ ����϶�.

--27. ����) �̸��� ù ���ڰ� K�� �����ϰų� �μ���ȣ�� 30�� ����� �����ȣ, �̸�, �μ���ȣ�� ����϶�.

--28. ����) �޿��� $1,500 �̻��̰� �μ���ȣ�� 30���� ��� �� ������MANAGER�� ����� ������ ����϶�

--29. ����) �μ���ȣ�� 30�� ����� ��� ������ ����ϰ� ������ȣ�� SORT(����)�϶�.
SELECT * FROM emp
WHERE deptno = 30
ORDER BY empno;
--30. ����) �������� �޿��� ���� ������ SORT(����) �϶�.
SELECT * FROM emp
ORDER BY deptno ASC;
--31. ����) �μ���ȣ�� ASCENDING SORT�� �� �޿��� ���� ��� ������ ����϶�.
--( �Ѱ� �̻��� ���� ���Ľ� �޸�(,)�� ����մϴ�.)

SELECT * FROM emp
ORDER BY deptno ASC, sal DESC;

--32. ����) �μ���ȣ�� DESCENDING SORT�ϰ�, �̸� ������ ASCENDING SORT �޿� ������ DESCENDING SORT �϶�.

SELECT * FROM emp
ORDER BY deptno DESC, ename ASC, sal DESC;
-- 33. 10���μ��� ��� �������� �޿��� 13%�� ���ʽ��� �����ϱ�� �Ͽ���. �̸�, �޿�, ���ʽ��ݾ�, �μ���ȣ�� ����϶�
--( �Ҽ����� �ݿø���.)

SELECT ename, sal, ROUND(sal*0.13), deptno FROM emp
WHERE deptno = 10;

--34. ������ �̸�, �޿�, Ŀ�̼�, �Ѿ�(�޿�+Ŀ�̼�)�� ���Ͽ� �Ѿ��� ���� ������ ����Ͽ���.
SELECT ename, sal, nvl(comm, 0), COALESCE(sal+comm, sal) total FROM emp -- ���� IS NULL ���� COALESCE
ORDER BY COALESCE(sal + comm, sal) DESC;
--(��, Ŀ�̼��� null�� ����� 0���� �ؼ� ����.)

-- nvl �� NULL ���� ������ ��ȯ���ִ� �Լ� -- ������ �� ��ȯ ����
-- COALESCE�� NULL ���� ������ ��ȯ���ֳ� ���ԵǴ� ������ Ÿ���� �Ӽ��� ������ Ÿ�԰� �ٸ� �� ������ �� ��ȯ ���� X 

--35. �޿��� $1,500���� $3,000 ������ ����� ���ؼ��� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���.
--��� ����� �̸�, �޿�, ȸ��(�Ҽ����� 2�ڸ����� �ݿø�)�� ����Ͽ���.
--(��, ȸ��� �޷�ǥ��$�� �����ϰ� �Ҽ��� 1�ڸ����� ���)

SELECT ename, sal, TO_CHAR(ROUND(sal*0.15,1), '$999.0') FROM emp;
--

--36. ������� 5���� �Ѵ� �μ��� �μ���� ����� ��ȸ
-- ��� ���� 5�������� �μ�

--SELECT dept.dname, COUNT(*) FROM emp e3, dept, 

SELECT dept.dname, COUNT(*) FROM dept, emp
WHERE dept.deptno = emp.deptno 
AND 5 < (SELECT COUNT(*) FROM emp e2
        WHERE emp.deptno = e2.deptno)
GROUP BY dept.dname;
--37. ������ �޿��հ谡  5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �� �޿� �հ踦 ��ȸ  
--�� �Ǹſ�('SALESMAN')�� �����ϰ� �� �޿� �հ�� �������� ����. 
                
SELECT job, SUM(e2.sal) FROM emp e2
WHERE e2.job NOT IN('SALESMAN')
GROUP BY job
HAVING SUM(e2.sal) > 5000;

--38. ������� �����ȣ(empno), �����(ename), �޿�(sal), �޿����(grade)�� ����Ͻÿ�. (���̺� salgrade ���� )
SELECT empno, ename, sal, grade FROM emp, salgrade
WHERE emp.sal BETWEEN salgrade.losal AND salgrade.hisal;

--39.  �μ���(deptno)�� ����� ���� Ŀ�̼�(comm)�� ���� ����� ���� ����Ͽ� ���ÿ�

SELECT deptno, COUNT(*), COUNT(comm) FROM emp
GROUP BY deptno;

--40.  �μ���ȣ(deptno)�� 10�� '�ѹ���', 20�� '���ߺ�', 30�� ������'��� �Ͽ� 
--�̸�, �μ���ȣ, �μ��� ������ ����Ͽ� ���ÿ�. (decode �� case �Լ� ���)
SELECT  dname, deptno, DECODE(deptno, 10, '�ѹ���', 20, '���ߺ�', 30, '������', 40, '�������', 'EMPTY') FROM dept;

INSERT INTO emp 
VALUES (7788, 'SCOTT', 'ANALYST', 7566, TO_DATE('09-10-1982', 'DD-MM-YYYY'), 3000, NULL, 20);

INSERT INTO emp 
VALUES (7876, 'ADAMS', 'CLERK', 7788, TO_DATE('12-01-1983', 'DD-MM-YYYY'), 1100, NULL, 20);

SELECT * FROM EMP ORDER BY sal;