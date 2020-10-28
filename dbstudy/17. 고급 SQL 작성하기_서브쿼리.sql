-- '구창민'과 직급(POSITION)이 같은 직원들의 목록을 출력하시오.
-- SELECT *
-- FROM EMPLOYEE
-- WHERE POSITION = '구창민의 직급';

SELECT *
FROM EMPLOYEE
WHERE POSITION IN (SELECT POSITION 
                   FROM EMPLOYEE
                   WHERE NAME = '구창민');  -- NAME 칼럼이 PK나 UQ가 아니므로 만족하는 데이터가 2개 이상일 수 있다.(다중 행 서브쿼리는 IN 연산자를 사용한다.)

-- 가장 기본급(SALARY)이 높은 직원의 정보를 출력하시오.
-- SELECT *
-- FROM EMPLOYEE
-- WHERE SALARY = '최대SALARY';

SELECT *
FROM EMPLOYEE
WHERE SALARY = (SELECT MAX(SALARY)
                FROM EMPLOYEE);  -- MAX의 결과는 항상 1개이므로 단일 행 서브쿼리이다. =, !=, >, >=, <, <= 를 사용할 수 있다.


-- 부서번호가 1인 부서에 근무하는 모든 직급과 동일한 직급을 가지는 직원을 조회하시오.
-- SELECT *
-- FROM EMPLOYEE
-- WHERE POSITION IN ('부서번호가 1인 부서에 근무하는 모든 직급');

SELECT *
FROM EMPLOYEE
WHERE POSITION IN (SELECT POSITION
                   FROM EMPLOYEE
                   WHERE DEPARTMENT = 1);
                   
-- 가장 높은 기본급을 가지고 있는 직원과 가장 낮은 기본급을 가지고 있는 직원을 조회하시오.
-- 같은 기본급 간의 처리는 하지 않는다.
-- SELECT *
-- FROM EMPLOYEE
-- WHERE SALARY IN('최대기본급', '최소기본급');
SELECT *
FROM EMPLOYEE
WHERE SALARY IN((SELECT MAX(SALARY) FROM EMPLOYEE), (SELECT MIN(SALARY) FROM EMPLOYEE));

-- DUAL 테이블
-- 테이블 내부에 데이터를 저장하는 목적이 아니다.
-- FROM절에 작성할 테이블이 없는 경우(FROM절이 필요 없는 경우)에 DUAL 테이블을 사용한다.
-- 오라클은 FROM절이 필수이기 때문에 뭐라도 적어줘야 해서.

DESC DUAL;
SELECT * FROM DUAL;

-- 총 몇 명의 직원이 있고, 총 몇 개의 부서가 있는지 조회하시오.
-- 결과
-- 총직원  총부서
--    5      4

SELECT
    (SELECT COUNT(*) FROM EMPLOYEE) AS 총직원,
    (SELECT COUNT(*) FROM DEPARTMENT) AS 총부서
FROM
    DUAL;


-- 전체 기본급에서 자신의 기본급이 몇 %를 차지하는지 조회하시오.
-- 자신의 기본급 / 전체 기본급
SELECT
    NAME, (SALARY / (SELECT SUM(SALARY) FROM EMPLOYEE)) AS 지분
FROM
    EMPLOYEE;
