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
                FROM EMPLOYEE);

