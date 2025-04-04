create table jpapaging (
    ID NUMBER PRIMARY KEY,
    EMAIL VARCHAR2(50),
    NAME VARCHAR2(20)
);

CREATE SEQUENCE JPAPAGING_SEQ NOCACHE;

INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user01@test.com', 'user01');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user02@test.com', 'user02');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user03@test.com', 'user03');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user04@test.com', 'user04');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user05@test.com', 'user05');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user06@test.com', 'user06');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user07@test.com', 'user07');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user08@test.com', 'user08');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user09@test.com', 'user09');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user10@test.com', 'user10');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user11@test.com', 'user11');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user12@test.com', 'user12');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user13@test.com', 'user13');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user14@test.com', 'user14');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user15@test.com', 'user15');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user16@test.com', 'user16');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user17@test.com', 'user17');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user18@test.com', 'user18');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user19@test.com', 'user19');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user20@test.com', 'user20');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user21@test.com', 'user21');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user22@test.com', 'user22');
INSERT INTO JPAPAGING VALUES(jpapaging_seq.nextval, 'user23@test.com', 'user23');

commit;