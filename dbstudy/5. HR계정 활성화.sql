-- 검색: 교육용 계정 HR
-- 1. 관리자 권한을 가진 계정으로 접속
CONN SYSTEM/1111
-- 2. HR계정의 락을 풀고,
ALTER USER HR ACCOUNT UNLOCK;
-- 3. HR계정에 새로운 비밀번호 설정
ALTER USER HR IDENTIFIED BY 1111;
-- 4. HR계정을 새로운 비밀번호로 접속
CONN HR/1111