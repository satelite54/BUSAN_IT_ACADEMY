EXEC DBMS_XDB.SETLISTENERLOCALACCESS(FALSE);

DROP TABLE member;

CREATE TABLE member (
    id VARCHAR2(50),
    pwd VARCHAR2(50),
    gender CHAR(6),
    name VARCHAR2(50),
    brithday CHAR(10),
    age NUMBER,
    phone CHAR(13),
    regdate DATE
)

INSERT INTO member(name) VALUES('남성');