CREATE TABLE board (
    BNum    NUMBER  NOT NULL,
    BTitle  VARCHAR2(1000),
    BContent VARCHAR2(1000),
    BDate   DATE,
    id      VARCHAR2(1000),
    authority NUMBER,
    views     NUMBER);