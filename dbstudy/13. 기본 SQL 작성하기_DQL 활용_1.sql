-- << employees 테이블 >> --

-- SELECT 검색할 칼럼
-- FROM 테이블
-- [WHERE 조건식]
-- [GROUP BY 그룹화할 칼럼]
-- [ORDER BY 정렬 칼럼]


-- 1. 전체 사원의 모든 칼럼을 조회한다.
SELECT *
FROM EMPLOYEES;

SELECT EMPLOYEES.*  -- OWNER(칼럼의 주인: 테이블명)를 명시
FROM EMPLOYEES;

SELECT E.*
FROM EMPLOYEES E;  -- EMPLOYEES 테이블의 ALIAS(별명)가 E(별명은 붙이는 사람 맘대로 정함)

-- 동작 순서
-- 1. FROM 절
-- 2. SELECT 절

-- 2. 전체 사원의 first_name, last_name, job_id 를 조회한다.
SELECT FIRST_NAME, LAST_NAME, JOB_ID
FROM EMPLOYEES;

SELECT EMPLOYEES.FIRST_NAME, EMPLOYEES.LAST_NAME, EMPLOYEES.JOB_ID
FROM EMPLOYEES;

SELECT E.FIRST_NAME, E.LAST_NAME, E.JOB_ID
FROM EMPLOYEES E;

-- 3. 연봉(salary)이 12000 이상되는 사원들의 last_name, salary 를 조회한다.
SELECT LAST_NAME, SALARY
  FROM EMPLOYEES
 WHERE SALARY >= 12000;

-- 4. 사원번호(employee_id)가 150 인 사원의 last_name, department_id 를 조회한다.
SELECT LAST_NAME, DEPARTMENT_ID
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 150;

-- 5. 커미션(commission_pct)을 받는 모든 사원들의 last_name, salary, commission_pct 를 조회한다.
-- 1) NULL 조건 : COMMISSION_PCT IS NULL
-- 2) NOT NULL 조건 : COMMISSION_PCT IS NOT NULL
SELECT LAST_NAME, SALARY, COMMISSION_PCT
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;

SELECT LAST_NAME, SALARY, COMMISSION_PCT
FROM EMPLOYEES
WHERE COMMISSION_PCT > 0;

-- NULL 처리 함수
-- NVL 함수
-- NVL(값, 값이 NULL일 때 사용할 값)
SELECT LAST_NAME, SALARY, COMMISSION_PCT
FROM EMPLOYEES
WHERE NVL(COMMISSION_PCT, 0) != 0;  -- NVL(COMMISSION_PCT, 0) : COMMISSION_PCT가 NULL이면 0으로 바꿔 사용한다.
--WHERE NVL(COMMISSION_PCT, 0) <> 0;

-- 6. 모든 사원들의 last_name, commission_pct 를 조회하되 커미션(commission_pct)이 없는 사원은 0으로 처리하여 조회한다.
SELECT LAST_NAME, NVL(COMMISSION_PCT, 0)
FROM EMPLOYEES;

-- 7. 커미션(commission_pct)이 없는 사원들은 0으로 처리하고, 커미션이 있는 사원들은 기존 커미션보다 10% 인상된 상태로 조회한다.
SELECT NVL2(COMMISSION_PCT, COMMISSION_PCT + 0.1, 0) AS NEW_COMMISSION_PCT  -- 칼럼 별명(ALIAS) : 칼럼 AS 별명
FROM EMPLOYEES;

-- 8. 연봉(salary)이 5000 에서 12000 인 범위의 사원들의 first_name, last_name, salary 를 조회한다.
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY >= 5000 AND SALARY <= 12000;

SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY BETWEEN 5000 AND 12000;

-- 9. 연봉(salary)이 5000 에서 12000 사이의 범위가 아닌 사원들의 first_name, last_name, salary 를 조회한다.
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY < 5000 OR SALARY > 12000;

SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY NOT BETWEEN 5000 AND 12000;

-- 10. 직업(job_id)이 SA_REP 이나 ST_CLERK 인 사원들의 전체 칼럼을 조회한다.
SELECT *
FROM EMPLOYEES
WHERE JOB_ID = 'SA_REP' OR JOB_ID = 'ST_CLEAK';

SELECT *
FROM EMPLOYEES
WHERE JOB_ID IN('SA_REP', 'ST_CLERK');

-- 11. 연봉(salary)이 2500, 3500, 7000 이 아니며 직업(job_id) 이 SA_REP 이나 ST_CLERK 인 사람들을 조회한다.
SELECT *
FROM EMPLOYEES
WHERE (SALARY != 2500 AND SALARY != 3500 AND SALARY != 7000)
AND (JOB_ID = 'SA_REP' OR JOB_ID = 'ST_CLERK');

SELECT *
FROM EMPLOYEES
WHERE SALARY NOT IN(2500, 3500, 7000)
AND JOB_ID IN('SA_REP', 'ST_CLERK');

-- 12. 상사(manager_id)가 없는 사람들의 last_name, job_id 를 조회한다.
SELECT LAST_NAME, JOB_ID
FROM EMPLOYEES
WHERE MANAGER_ID IS NULL;

/*
    와일드 카드(WILD CARD)
    1. 모든 문자를 대체할 수 있는 만능 문자
    2. 종류
       1) 글자 수 상관 없는 만능 문자 : %
       2) 한 글자를 대체하는 만능 문자 : _
    3. 와일드 카드 전용 연산자 : LIKE (등호(=) 대신 사용)
    4. 예시
       1) 마차, 마동석, 마요네즈 : 마% (마로 시작하는 문자열)
       2) 공주, 백설공주, 평강공주, 백제공주 : %공주 (공주로 끝나는 문자열)
       3) 맨드라미, 아이언맨, 드라마맨또롱 : %맨% (맨을 포함한 문자열)
*/

-- 13. 성(last_name)에 u 가 포함되는 사원들의 employee_id, last_name 을 조회한다.
SELECT EMPLOYEE_ID, LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME LIKE '%u%' OR LAST_NAME LIKE '%U%';

SELECT EMPLOYEE_ID, LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME LIKE IN('%u%', '%U%');  -- 안 되는 쿼리(IN 연산자와 WILD CARD)

SELECT EMPLOYEE_ID, LAST_NAME
FROM EMPLOYEES
WHERE REGEXP_LIKE (LAST_NAME, 'u|U');  -- 정규표현식: u|U (u 또는 U)

SELECT EMPLOYEE_ID, LAST_NAME
FROM EMPLOYEES
WHERE UPPER(LAST_NAME) LIKE '%U%';  -- UPPER(): 대문자로 변환

SELECT EMPLOYEE_ID, LAST_NAME
FROM EMPLOYEES
WHERE LOWER(LAST_NAME) LIKE '%u%';  -- LOWER(): 소문자로 변환

-- 14. 전화번호(phone_number)가 650 으로 시작하는 사원들의 last_name, phone_number 를 조회한다.
SELECT LAST_NAME, PHONE_NUMBER
FROM EMPLOYEES
WHERE PHONE_NUMBER LIKE '650%';

SELECT LAST_NAME, PHONE_NUMBER
FROM EMPLOYEES
WHERE SUBSTR(PHONE_NUMBER, 1, 3) = '650';  -- PHONE_NUMBER의 1번째 글자부터 3글자, SUBSTR 함수의 반환 값은 언제나 '문자열'

-- 15. 성(last_name)의 네 번째 글자가 a 인 사원들의 last_name 을 조회한다.
SELECT LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME LIKE '___a%';

-- 16. 성(last_name) 에 a 또는 e 가 포함된 사원들의 last_name 을 조회한다.
SELECT LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME LIKE '%a%' OR LAST_NAME LIKE '%e%';

-- 17. 성(last_name) 에 a 와 e 가 모두 포함된 사원들의 last_name 을 조회한다.
SELECT LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME LIKE '%a%' AND LAST_NAME LIKE '%e%';

-- 18. 2008/02/20 ~ 2008/05/01 사이에 고용된(hire_date) 사원들의 last_name, employee_id, hire_date 를 조회한다.
-- 1) 날짜는 문자처럼 ''로 묶는다.
-- 2) 날짜는 숫자처럼 크기 비교를 할 수 있다.
SELECT LAST_NAME, EMPLOYEE_ID, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE >= '2008/02/20' AND HIRE_DATE <= '2008/05/01';

SELECT LAST_NAME, EMPLOYEE_ID, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN '2008/02/20' AND '2008/05/01';

-- 19. 2004년도에 고용된(hire_date) 모든 사원들의 last_name, employee_id, hire_date 를 조회한다.


-- 20. 부서(department_id)를 조회하되 중복을 제거하여 조회한다.


-- 21. 직업(job_id)이 ST_CLERK 가 아닌 사원들의 부서번호(department_id)를 조회한다.
-- 단, 부서번호가 NULL인 값은 제외하고 부서번호의 중복을 제거한다.


-- 22. 커미션(commission_pct)을 받는 사원들의 실제 커미션(commission = salary * commission_pct)을 구하고,
-- employee_id, first_name, job_id 와 함께 조회한다.


-- 23. 가장 오래 전에 입사(hire_date)한 직원부터 최근에 입사한 직원 순으로 last_name, hire_date 를 조회한다.


-- 24. 부서번호(department_id)가 20, 50 인 부서에서 근무하는 모든 사원들의 부서번호의 오름차순으로 조회하되,
-- 같은 부서번호 내에서는 last_name 의 알파벳순으로 조회한다.


-- 25. 커미션(commission_pct)을 받는 모든 사원들의 last_name, salary, commission_pct 을 조회한다.
-- 연봉이 높은 사원을 먼저 조회하고 같은 연봉의 사원들은 커미션이 높은 사원을 먼저 조회한다.
