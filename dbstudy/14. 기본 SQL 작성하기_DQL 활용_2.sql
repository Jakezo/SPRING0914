-- 26. 연봉(salary) 총액과 연봉(salary) 평균을 조회한다.
SELECT SUM(SALARY) AS 연봉총액, AVG(SALARY) AS 연봉평균
FROM EMPLOYEES;

-- 27. 최대연봉(salary)과 최소연봉의 차이를 조회한다.
SELECT MAX(SALARY) - MIN(SALARY) AS 연봉차이
FROM EMPLOYEES;

-- 28. 직업(job_id) 이 ST_CLERK 인 사원들의 전체 수를 조회한다.
SELECT COUNT(*) AS 사원수  -- COUNT 함수는 일반적으로 NULL 값이 없는 칼럼이 사용된다. 그래서 COUNT(*) 을 사용한다.
FROM EMPLOYEES
WHERE JOB_ID IN('ST_CLERK');

-- 29. 매니저(manager_id)로 근무하는 사원들의 전체 수를 조회한다.
SELECT COUNT(DISTINCT MANAGER_ID) AS 매니저수
FROM EMPLOYEES;

-- 30. 회사 내에 총 몇 개의 부서가 있는지 조회한다.
SELECT COUNT(DISTINCT DEPARTMENT_ID) AS 부서수
FROM EMPLOYEES;


-- 그룹화 연습

-- << departments 테이블 >>

-- 31. 같은 지역(location_id) 끼리 모아서 조회한다.
SELECT DISTINCT LOCATION_ID
FROM DEPARTMENTS;

SELECT LOCATION_ID
FROM DEPARTMENTS
GROUP BY LOCATION_ID;

-- 32. 같은 지역(location_id) 끼리 모아서 각 지역(location_id) 마다 총 몇 개의 부서가 있는지 개수를 함께 조회한다.
SELECT LOCATION_ID, COUNT(*) AS 인원수
FROM DEPARTMENTS
GROUP BY LOCATION_ID;

-- 33. 같은 지역(location_id) 끼리 모아서 해당 지역(location_id) 에 어떤 부서(department_name) 가 있는지 조회한다.
/* SELECT절의 칼럼은 모두 반드시 GROUP BY절에 있어야 한다.
SELECT LOCATION_ID, DEPARTMENT_NAME
FROM DEPARTMENTS
GROUP BY LOCATION_ID;
*/
SELECT LOCATION_ID, DEPARTMENT_NAME
FROM DEPARTMENTS
GROUP BY LOCATION_ID, DEPARTMENT_NAME;


-- << employees 테이블 >>

-- 34. 각 부서(department_id)별로 그룹화하여 department_id 와 부서별 사원의 수를 출력한다.
SELECT DEPARTMENT_ID, COUNT(*) AS 사원수
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID;

-- 35. 부서(department_id)별로 집계하여 department_id 와 급여평균을 department_id 순으로 오름차순 정렬해서 출력한다.
SELECT DEPARTMENT_ID, AVG(SALARY) AS 급여평균
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;

-- 36. 동일한 직업(job_id)을 가진 사원들의 job_id 와 인원수와 급여평균을 급여평균의 오름차순 정렬하여 출력한다.
SELECT JOB_ID, COUNT(*) AS 사원수, AVG(SALARY) AS 급여평균
FROM EMPLOYEES
GROUP BY JOB_ID
ORDER BY AVG(SALARY);
-- ORDER BY 급여평균;  가능합니다.

-- 37. 직업(job_id)이 SH_CLERK 인 직원들의 인원수와 최대급여 및 최소급여를 출력한다.
SELECT COUNT(*) AS 인원수, MAX(SALARY) AS 최대급여, MIN(SALARY) AS 최소급여
FROM EMPLOYEES
WHERE JOB_ID = 'SH_CLERK';

SELECT COUNT(*) AS 인원수, MAX(SALARY) AS 최대급여, MIN(SALARY) AS 최소급여
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING JOB_ID = 'SH_CLERK';

-- 38. 근무 중인 사원수가 5명 이상인 부서의 department_id 와 해당 부서의 사원수를 department_id 의 오름차순으로 정렬하여 출력한다.
SELECT DEPARTMENT_ID, COUNT(*) AS 사원수
FROM EMPLOYEES
-- WHERE COUNT(*) >= 5;   잘못된 배치: WHERE절은 GROUP BY전에 처리되므로 전체 사원수를 의미하는 COUNT(*)가 사용된다.
GROUP BY DEPARTMENT_ID
HAVING COUNT(*) >= 5  -- GROUP BY절 다음에 처리되므로 부서별 사원수를 의미하는 COUNT(*)가 사용된다.
ORDER BY DEPARTMENT_ID;


-- 39. 평균급여가 10000 이상인 부서의 department_id 와 급여평균을 출력한다.
SELECT DEPARTMENT_ID, AVG(SALARY) AS 급여평균
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY) >= 10000;
-- HAVING 급여평균 >= 10000;  불가능하다. (FROM -> GROUP BY -> HAVING -> SELECT 이므로 SELECT에서 만들어진 별명 '급여평균'을 사용할 수 없다.)

-- 40. 부서(department_id)마다 같은 직업(job_id)을 가진 사원수를 department_id 순으로 정렬하여 출력한다.
-- 단, department_id 가 없는 사원은 출력하지 않는다.
SELECT DEPARTMENT_ID, JOB_ID, COUNT(*) AS 사원수
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID, JOB_ID
HAVING DEPARTMENT_ID IS NOT NULL  -- GROUP BY 전에 처리할 수 있는 조건이므로 HAVING으로 처리하면 좋지 않다.
ORDER BY DEPARTMENT_ID;  -- ASC 생략

SELECT DEPARTMENT_ID, JOB_ID, COUNT(*) AS 사원수
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL  -- GROUP BY 전에 먼저 처리하면 그룹핑 대상(모수)을 줄여서 성능을 높일 수 있다.
GROUP BY DEPARTMENT_ID, JOB_ID
ORDER BY DEPARTMENT_ID;  -- ASC 생략