CREATE DATABASE IF NOT EXISTS bbs DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
use bbs;
DROP TABLE IF EXISTS user;
CREATE TABLE user 
( 
	userID 		 VARCHAR(20),
    userPassword VARCHAR(20),
    userName 	 VARCHAR(20),
    userGender 	 VARCHAR(20),
    userEmail 	 VARCHAR(50),
    PRIMARY KEY (userID)
);

INSERT INTO user VALUES ('pengsu', '1234', '펭수', '남성', 'pengsu@naver.com');

drop table BBS;
CREATE TABLE BBS (
	bbsID int,  -- 기본키
	bbsTitle varchar(50), -- 제목
	userID varchar(20),	-- 작성자id
	bbsDate DATETIME, -- 날짜
	bbsContent varchar(2048),
	bbsAvailable int, -- 1,0 0일때 삭제됨
	primary key (bbsID)
);






