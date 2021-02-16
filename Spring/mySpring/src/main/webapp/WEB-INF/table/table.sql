create table tblNote(
    id number(4,0) NOT NULL ENABLE, 
    writer varchar2(20 BYTE),
    content VARCHAR2(300 BYTE),
    CONSTRAINT tblNote_PK PRIMARY KEY(id)
);

create SEQUENCE tblNoteSeq;