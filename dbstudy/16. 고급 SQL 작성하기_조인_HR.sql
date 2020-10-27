-- EMPLOYEES        DEPARTMENTS
--   EMPLOYEE_ID      DEPARTMENT_ID
--   FIRST_NAME       DEPARTMENT_NAME
--   LAST_NAME        MANAGER_ID
--   EMAIL            LOCATION_ID
--   PHONE_NUMBER
--   HIRE_DATE
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


-- 5. 도시이름(city)이 T 로 시작하는 지역에 사는 사원들의 employee_id, last_name, department_id, city 를 조회한다.
-- 사용할 테이블 (employees, departments, locations)


-- 6. 자신의 담당 매니저(manager_id)의 고용일(hire_date)보다 빨리 입사한 사원을 찾아서 last_name, hire_date, manager_id 를 조회한다. 
-- 사용할 테이블 (employees)


-- 7. 같은 소속부서(department_id)에서 나보다 늦게 입사(hire_date)하였으나 나보다 높은 연봉(salary)을 받는 사원이 존재하는 사원들의
-- department_id, full_name(first_name 과 last_name 사이에 공백을 포함하여 연결), salary, hire_date 를 full_name 순으로 정렬하여 조회한다.


-- 8. 같은 소속부서(department_id)의 다른 사원보다 늦게 입사(hire_date)하였으나 현재 더 높은 연봉(salary)을 받는 사원들의
-- department_id, full_name(first_name 과 last_name 사이에 공백을 포함하여 연결), salary, hire_date 를 full_name 순으로 정렬하여 조회한다.
-- 사용할 테이블 (employees)

