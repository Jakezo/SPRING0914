-- EMPLOYEES        DEPARTMENTS         LOCATIONS
--   EMPLOYEE_ID      DEPARTMENT_ID       LOCATION_ID
--   FIRST_NAME       DEPARTMENT_NAME     STREET_ADDRESS
--   LAST_NAME        MANAGER_ID          POSTAL_CODE
--   EMAIL            LOCATION_ID         CITY
--   PHONE_NUMBER                         STATE_PROVINCE
--   HIRE_DATE                            COUNTRY_ID
--   JOB_ID
--   SALARY
--   COMMISSION_PCT
--   MANAGER_ID
--   DEPARTMENT_ID

-- 1. 부서의 위치(location_id)가 1700 인 사원들의 employee_id, last_name, department_id, salary 를 조회한다.
-- 사용할 테이블 (departments, employees)
SELECT E.EMPLOYEE_ID, E.LAST_NAME, E.DEPARTMENT_ID, E.SALARY
FROM DEPARTMENTS D, EMPLOYEES E
WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID
AND D.LOCATION_ID = 1700;

SELECT E.EMPLOYEE_ID, E.LAST_NAME, E.DEPARTMENT_ID, E.SALARY
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE D.LOCATION_ID = 1700;


-- 2. 부서명(department_name)이 'Executive' 인 부서에 근무하는 모든 사원들의 department_id, last_name, job_id 를 조회한다.
-- 사용할 테이블 (departments, employees)
SELECT E.DEPARTMENT_ID, E.LAST_NAME, E.JOB_ID
FROM DEPARTMENTS D, EMPLOYEES E
WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID
AND D.DEPARTMENT_NAME = 'Executive';

SELECT E.DEPARTMENT_ID, E.LAST_NAME, E.JOB_ID
FROM DEPARTMENTS D INNER JOIN EMPLOYEES E
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
WHERE D.DEPARTMENT_NAME = 'Executive';


-- 3. 기존의 직업(job_id)을 여전히 가지고 있는 사원들의 employee_id, job_id 를 조회한다.
-- 사용할 테이블 (employees, job_history)
SELECT E.EMPLOYEE_ID, E.JOB_ID
FROM EMPLOYEES E, JOB_HISTORY JH
WHERE E.EMPLOYEE_ID = JH.EMPLOYEE_ID  -- JOB_HISTORY에 기록이 남아 있는 직원들
AND E.JOB_ID = JH.JOB_ID;  -- 현재 JOB_ID(E.JOB_ID)와 과거 JOB_ID(JH.JOB_ID)가 같은 직원들

SELECT E.EMPLOYEE_ID, E.JOB_ID
FROM EMPLOYEES E INNER JOIN JOB_HISTORY JH
ON E.EMPLOYEE_ID = JH.EMPLOYEE_ID
WHERE E.JOB_ID = JH.JOB_ID;


-- 4. 각 부서별 사원수와 평균연봉을 department_name, location_id 와 함께 조회한다.
-- 평균연봉은 소수점 2 자리까지 반올림하여 표현하고, 각 부서별 사원수의 오름차순으로 조회한다.
-- 사용할 테이블 (departments, employees)
-- 반올림 : ROUND 함수
-- ROUND(값, DIGITS)
-- ROUND(평균, 2) : 평균의 소수2자리 반올림

SELECT D.DEPARTMENT_NAME, D.LOCATION_ID, COUNT(*) AS 사원수, ROUND(AVG(SALARY), 2) AS 평균연봉
FROM DEPARTMENTS D, EMPLOYEES E
WHERE D.DEPARTMENT_ID(+) = E.DEPARTMENT_ID  -- 왼쪽에 '(+)'가 추가되면 '오른쪽 외부 조인'이다.
GROUP BY D.DEPARTMENT_NAME, D.LOCATION_ID  -- SELECT절에서 표시하고자 하는 칼럼은 GROUP BY절에도 추가해야 한다.
ORDER BY COUNT(*);  -- ORDER BY 사원수;  모두 동일한 결과이다. ORDER BY절은 칼럼의 별명도 사용할 수 있다.

SELECT D.DEPARTMENT_NAME, D.LOCATION_ID, COUNT(*) AS 사원수, ROUND(AVG(SALARY), 2) AS 평균연봉
FROM DEPARTMENTS D RIGHT OUTER JOIN EMPLOYEES E  -- 오른쪽 테이블인 EMPLOYEES 테이블의 모든 정보가 조회된다.
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
GROUP BY D.DEPARTMENT_NAME, D.LOCATION_ID  -- SELECT절에서 표시하고자 하는 칼럼은 GROUP BY절에도 추가해야 한다.
ORDER BY COUNT(*);


-- 5. 도시이름(city)이 T 로 시작하는 지역에서 근무하는 사원들의 employee_id, last_name, department_id, city 를 조회한다.
-- 사용할 테이블 (employees, departments, locations)
SELECT E.EMPLOYEE_ID, E.LAST_NAME, E.DEPARTMENT_ID, L.CITY
FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID  -- 조인조건1
AND D.LOCATION_ID = L.LOCATION_ID        -- 조인조건2
AND L.CITY LIKE 'T%';  -- 'T%': T로 시작하는 모든 텍스트

SELECT E.EMPLOYEE_ID, E.LAST_NAME, E.DEPARTMENT_ID, L.CITY
FROM EMPLOYEES E INNER JOIN DEPARTMENTS D
ON E.DEPARTMENT_ID = D.DEPARTMENT_ID INNER JOIN LOCATIONS L
ON D.LOCATION_ID = L.LOCATION_ID
WHERE L.CITY LIKE 'T%';


-- 6. 자신의 상사(manager_id)의 고용일(hire_date)보다 빨리 입사한 사원을 찾아서 last_name, hire_date, manager_id 를 조회한다. 
-- 사용할 테이블 (employees)
-- EMPLOYEES E : 사원(나)
-- EMPLOYEES M : 상사(남)
-- 조인조건 : 내 상사 번호(E.MANAGER_ID) = 상사 번호(M.EMPLOYEE_ID)
SELECT E.LAST_NAME AS 내이름, E.HIRE_DATE AS 내고용일, M.LAST_NAME AS 상사이름, M.HIRE_DATE AS 상사고용일
FROM EMPLOYEES E, EMPLOYEES M
WHERE E.MANAGER_ID = M.EMPLOYEE_ID  -- 조인조건
AND E.HIRE_DATE < M.HIRE_DATE;  -- 내고용일 < 상사고용일

SELECT E.LAST_NAME AS 내이름, E.HIRE_DATE AS 내고용일, M.LAST_NAME AS 상사이름, M.HIRE_DATE AS 상사고용일
FROM EMPLOYEES E JOIN EMPLOYEES M
ON E.MANAGER_ID = M.EMPLOYEE_ID  -- 조인조건
AND E.HIRE_DATE < M.HIRE_DATE;  -- 내고용일 < 상사고용일


-- 7. 같은 소속부서(department_id)에서 나보다 늦게 입사(hire_date)하였으나 나보다 높은 연봉(salary)을 받는 사원이 존재하는 사원들의
-- department_id, full_name(first_name 과 last_name 사이에 공백을 포함하여 연결), salary, hire_date 를 full_name 순으로 정렬하여 조회한다.
-- 사용할 테이블 (employees)
-- 나 : ME
-- 남 : YOU
SELECT  ME.LAST_NAME AS 내이름, ME.SALARY AS 내연봉, ME.HIRE_DATE AS 내입사일,
        YOU.LAST_NAME AS 남이름, YOU.SALARY AS 남연봉, YOU.HIRE_DATE AS 남입사일
FROM EMPLOYEES ME, EMPLOYEES YOU
WHERE ME.DEPARTMENT_ID = YOU.DEPARTMENT_ID  -- 조인조건
AND ME.HIRE_DATE < YOU.HIRE_DATE
AND ME.SALARY < YOU.SALARY
ORDER BY ME.LAST_NAME;

SELECT DISTINCT ME.LAST_NAME AS 내이름, ME.SALARY AS 내연봉, ME.HIRE_DATE AS 내입사일
FROM EMPLOYEES ME, EMPLOYEES YOU
WHERE ME.DEPARTMENT_ID = YOU.DEPARTMENT_ID  -- 조인조건
AND ME.HIRE_DATE < YOU.HIRE_DATE
AND ME.SALARY < YOU.SALARY
ORDER BY ME.LAST_NAME;


-- 8. 같은 소속부서(department_id)의 다른 사원보다 늦게 입사(hire_date)하였으나 현재 더 높은 연봉(salary)을 받는 사원들의
-- department_id, full_name(first_name 과 last_name 사이에 공백을 포함하여 연결), salary, hire_date 를 full_name 순으로 정렬하여 조회한다.
-- 사용할 테이블 (employees)
-- 나 : ME
-- 남 : YOU
-- 연결 연산자 : ||
SELECT DISTINCT ME.DEPARTMENT_ID AS 내부서번호, ME.FIRST_NAME || ' ' || ME.LAST_NAME AS FULL_NAME
FROM EMPLOYEES ME, EMPLOYEES YOU
WHERE ME.DEPARTMENT_ID = YOU.DEPARTMENT_ID
AND ME.HIRE_DATE > YOU.HIRE_DATE
AND ME.SALARY > YOU.SALARY
ORDER BY FULL_NAME;











