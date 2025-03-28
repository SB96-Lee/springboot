CREATE sequence seq_board nocache;

CREATE TABLE boardtest (
    boardno NUMBER PRIMARY KEY,
    title VARCHAR2(100),
    writer VARCHAR2(20),
    content VARCHAR2(500)
)

INSERT INTO BOARDTEST VALUES(seq_board.nextval, '제목1', '더조은' , '내용1');
INSERT INTO BOARDTEST VALUES(seq_board.nextval, '제목2', '나빛나' , '내용2');

commit;