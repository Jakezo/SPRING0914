-- 시퀀스와 테이블

DROP TABLE BOARD;
DROP SEQUENCE BOARD_SEQ;

CREATE TABLE BOARD (
    BOARD_NO NUMBER PRIMARY KEY,
    BOARD_TITLE VARCHAR2(2000) NOT NULL,
    BOARD_CONTENT VARCHAR2(4000)
);

CREATE SEQUENCE BOARD_SEQ
INCREMENT BY 1  -- 번호는 1씩 증가한다.
START WITH 1  -- 번호는 1부터 시작한다.
NOMAXVALUE   -- 최대번호는 없다.
NOMINVALUE   -- 최소번호는 없다.
NOCYCLE      -- 번호는 순환되지 않는다.
NOCACHE;     -- CACHE를 사용하지 않는다.


INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '가지사항', '오늘 재평가가 있습니다.');
INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '나림', '내일은 본평가가 있습니다.');
INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '다녕하세요', '잘부탁드립니다.');
INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '라업해주세요(냉무)', NULL);
INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '마려주세요', '지금이 몇 시 인가요?');


-- ROWNUM
-- 가상이다. (실제하지 않는다.)
-- 1이 포함된 숫자는 조회가 가능하다.
-- 실제 칼럼으로 바꿔서 원하는 값이나 범위를 사용할 수 있다.
--SELECT * FROM BOARD WHERE ROWNUM = 1;  -- 가능하다.
--SELECT * FROM BOARD WHERE ROWNUM < 3;  -- 가능하다.
--SELECT * FROM BOARD WHERE ROWNUM = 2;  -- 불가능하다.
--SELECT * FROM BOARD WHERE ROWNUM > 1;  -- 불가능하다.


-- 1. 게시글의 제목을 가나다 역순으로 정렬하고 첫 번째 게시글을 조회하시오.

-- 1) 정상적으로 처리 되지 못함
SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT
FROM BOARD
WHERE ROWNUM = 1
ORDER BY BOARD_TITLE DESC;  -- ORDER BY 절은 항상 마지막에 처리된다. 먼저 정렬하고 싶으면 서브쿼리를 활용한다.

-- 2) 정상적으로 처리하는 방법
SELECT
    BOARD_NO, BOARD_TITLE, BOARD_CONTENT
FROM
    (SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT
     FROM BOARD
     ORDER BY BOARD_TITLE DESC)
WHERE ROWNUM = 1;


-- 2. 게시글의 제목을 가나다 역순으로 정렬하고 두 번째 게시글을 조회하시오.

-- 1) 정상적으로 처리 되지 못함
SELECT
    BOARD_NO, BOARD_TITLE, BOARD_CONTENT
FROM
    (SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT
     FROM BOARD
     ORDER BY BOARD_TITLE DESC)
WHERE ROWNUM = 2;  -- ROWNUM은 1이 포함된 범위만 사용할 수 있다. 이외의 범위를 사용하고 싶으면 ROWNUM에 별명을 주고 사용한다.

-- 2) 정상적으로 처리하는 방법
SELECT
    BOARD_NO, BOARD_TITLE, BOARD_CONTENT
FROM
    (SELECT ROWNUM AS RN, BOARD_NO, BOARD_TITLE, BOARD_CONTENT
     FROM (SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT
           FROM BOARD
           ORDER BY BOARD_TITLE DESC))
WHERE RN = 4;