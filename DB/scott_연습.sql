-- 1. 부서 번호가 10번인 부서의 사람 중 사원번호, 이름, 급여를 출력하라.

SELECT empno, ename, sal FROM emp
WHERE deptno = 10;
--사원번호가 7639인 사람 중 이름, 입사일자, 부서번호를 출력하라.

SELECT ename, hiredate, deptno FROM emp
WHERE empno = 7369;

--이름이 allen인 사람의 모든 정보를 출력하라

SELECT * FROM emp
WHERE ename LIKE '%ALLEN%';

--일사일자가 83/01/12인 사원의 이름, 부서 번호, 급여을 출력하라.
SELECT ename, deptno, sal FROM emp
WHERE hiredate = TO_DATE('80/12/17');

--직업이 MANAGER가 아닌 사람의 모든 정보를 출력하라.
SELECT * FROM emp
WHERE NOT(job LIKE 'MANAGER');

--입사일자가 81/04/02 이후에 입사한 사원의 정보를 출력하라.

SELECT * FROM emp
WHERE TO_DATE('81/04/02') < hiredate;

--급여가 $800이상인 사람의 이름, 급여, 부서 번호를 출력하라.

SELECT ename, sal, deptno FROM emp
WHERE 800 < sal;

--부서번호가 20번 이상인 사원의 모든 정보를 출력하라.

--성명이 K로 시작하는 사람보다 높은 이름을 가진 사람의 모든 정보를 출력하라.

SELECT * FROM emp
WHERE ename > 'K' AND NOT(ename LIKE 'K%');

--입사일자가 81/12/09 보다 먼저 입사한 사람들의 모든 정보를 출력하라.
--

--입사번호가 7698 보다 작거나 같은 사람들의 입사번호와 이름을 출력하라.
--입사일자가 81/04/02 보다 늦고 82/12/09 보다 빠른 사원의 이름, 월급, 부서 번호를 출력하라.
--급여가 1600보다 크고 3000보다 작은 사람은 이름, 직무, 급여를 출력하라.
--사원번호가 7654와 7782 사이 이외의 사원의 모든 정보를 출력하라
--이름이 B와 J사이의 모든 사원의 정보를 출력하라.
--입사일자가 81년 이외에 입사한 사람의 모든 정보를 출력하라.
--직무가 MANGER와 SALESMAN인 사람의 모든 정보를 출력하라.
--부서 번호와 20, 30번을 제외한 모든 사람의 이름, 사원번호, 부서 번호를 출력하라.
--이름이 S로 시작하는 사원의 사원번호, 이름, 입사일자, 부서번호를 출력하라.
--입사일자가 81년도인 사람의 모든 정보를 출력하라.
SELECT * FROM emp
WHERE TO_CHAR(hiredate, 'YY') LIKE '81%';
--이름 중 S자가 들어가 있는 사람만 모든 정보를 출력하라.

SELECT * FROM emp
WHERE ename LIKE '%S%';

--22. 문제) 이름이 M로 시작하고 마지막 글자가 N인 사람의 모든 정보를 출력하라
--(단, 이름은 전체 6자리이다. 자리수를 이용한 와일드카드 '_' 을 이용)

SELECT * FROM emp
WHERE ename LIKE 'M%' AND ename LIKE '_____%N';

--23. 문제) 이름이 첫 번째 문자는 관계없고, 두 번째 문자가 A인 사람의 정보를 출력하라.
SELECT * FROM emp
WHERE ename LIKE '_%A____';

--24. 문제) 커미션이 NULL인 사람의 정보를 출력하라.  ( IS NULL 또는 IS NOT NULL 사용)

SELECT * FROM emp
WHERE comm IS NULL;

--25. 문제) 커미션이 NULL이 아닌 사람의 모든 정보를 출력하라. ( IS NULL 또는 IS NOT NULL 사용)
SELECT * FROM emp
WHERE comm IS NOT NULL;
--26. 문제) 부서가 30번 부서이고 급여가 $1,500 이상인 사람의 이름, 부서 ,월급을 출력하라.

--27. 문제) 이름의 첫 글자가 K로 시작하거나 부서번호가 30인 사람의 사원번호, 이름, 부서번호를 출력하라.

--28. 문제) 급여가 $1,500 이상이고 부서번호가 30번인 사원 중 직업이MANAGER인 사람의 정보를 출력하라

--29. 문제) 부서번호가 30인 사람의 모든 정보를 출력하고 직원번호로 SORT(정렬)하라.
SELECT * FROM emp
WHERE deptno = 30
ORDER BY empno;
--30. 문제) 직원들의 급여가 많은 순으로 SORT(정렬) 하라.
SELECT * FROM emp
ORDER BY deptno ASC;
--31. 문제) 부서번호로 ASCENDING SORT한 후 급여가 많은 사람 순으로 출력하라.
--( 한개 이상의 열로 정렬시 콤마(,)를 사용합니다.)

SELECT * FROM emp
ORDER BY deptno ASC, sal DESC;

--32. 문제) 부서번호가 DESCENDING SORT하고, 이름 순으로 ASCENDING SORT 급여 순으로 DESCENDING SORT 하라.

SELECT * FROM emp
ORDER BY deptno DESC, ename ASC, sal DESC;
-- 33. 10번부서의 모든 직원에게 급여의 13%를 보너스로 지급하기로 하였다. 이름, 급여, 보너스금액, 부서번호를 출력하라
--( 소수점은 반올림함.)

SELECT ename, sal, ROUND(sal*0.13), deptno FROM emp
WHERE deptno = 10;

--34. 직원의 이름, 급여, 커미션, 총액(급여+커미션)을 구하여 총액이 많은 순서로 출력하여라.
SELECT ename, sal, nvl(comm, 0), COALESCE(sal+comm, sal) total FROM emp -- 다중 IS NULL 적용 COALESCE
ORDER BY COALESCE(sal + comm, sal) DESC;
--(단, 커미션이 null인 사원도 0으로 해서 포함.)

-- nvl 은 NULL 값을 조사해 반환해주는 함수 -- 묵시적 형 변환 수행
-- COALESCE도 NULL 값을 조사해 반환해주나 삽입되는 데이터 타입이 속성의 데이터 타입과 다를 때 묵시적 형 변환 수행 X 

--35. 급여가 $1,500부터 $3,000 사이의 사원에 대해서만 급여의 15%를 회비로 지불하기로 하였다.
--모든 사원의 이름, 급여, 회비(소수이하 2자리에서 반올림)를 출력하여라.
--(단, 회비는 달러표시$로 시작하고 소수점 1자리까지 출력)

SELECT ename, sal, TO_CHAR(ROUND(sal*0.15,1), '$999.0') FROM emp;
--

--36. 사원수가 5명이 넘는 부서의 부서명과 사원수 조회
-- 사원 수가 5명이하인 부서

--SELECT dept.dname, COUNT(*) FROM emp e3, dept, 

SELECT dept.dname, COUNT(*) FROM dept, emp
WHERE dept.deptno = emp.deptno 
AND 5 < (SELECT COUNT(*) FROM emp e2
        WHERE emp.deptno = e2.deptno)
GROUP BY dept.dname;
--37. 직업별 급여합계가  5000을 초과하는 각 직무에 대해서 직무와 월 급여 합계를 조회  
--단 판매원('SALESMAN')은 제외하고 월 급여 합계로 내림차순 정렬. 
                
SELECT job, SUM(e2.sal) FROM emp e2
WHERE e2.job NOT IN('SALESMAN')
GROUP BY job
HAVING SUM(e2.sal) > 5000;

--38. 사원들의 사원번호(empno), 사원명(ename), 급여(sal), 급여등급(grade)을 출력하시오. (테이블 salgrade 조인 )
SELECT empno, ename, sal, grade FROM emp, salgrade
WHERE emp.sal BETWEEN salgrade.losal AND salgrade.hisal;

--39.  부서별(deptno)로 사원의 수와 커미션(comm)을 받은 사원의 수를 출력하여 보시오

SELECT deptno, COUNT(*), COUNT(comm) FROM emp
GROUP BY deptno;

--40.  부서번호(deptno)가 10은 '총무부', 20은 '개발부', 30은 영업부'라고 하여 
--이름, 부서번호, 부서명 순으로 출력하여 보시오. (decode 나 case 함수 사용)
SELECT  dname, deptno, DECODE(deptno, 10, '총무부', 20, '개발부', 30, '영업부', 40, '생산관리', 'EMPTY') FROM dept;

INSERT INTO emp 
VALUES (7788, 'SCOTT', 'ANALYST', 7566, TO_DATE('09-10-1982', 'DD-MM-YYYY'), 3000, NULL, 20);

INSERT INTO emp 
VALUES (7876, 'ADAMS', 'CLERK', 7788, TO_DATE('12-01-1983', 'DD-MM-YYYY'), 1100, NULL, 20);

SELECT * FROM EMP ORDER BY sal;