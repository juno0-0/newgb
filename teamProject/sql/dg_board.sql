-- 신고게시판
-- 시퀀스
	CREATE SEQUENCE DG_REPORT_SEQ;
-- 테이블
	CREATE TABLE DG_REPORT(
		REPORTNUM NUMBER,
		REPORTTITLE VARCHAR2(1000),
		REPORTID VARCHAR2(500),
		REPORTCONTENT VARCHAR2(3000),
		UPLOAD DATE DEFAULT SYSDATE,
		READCOUNT NUMBER,
		CONSTRAINT DG_REPORT_PK PRIMARY KEY(REPORTNUM)
	);

	SELECT * FROM DG_REPORT;
	
-- 사진 게시판
-- 시퀀스
	CREATE SEQUENCE DG_PHOTO_SEQ;
-- 테이블
	CREATE TABLE DG_PHOTOBOARD(
		UPLOAD DATE DEFAULT SYSDATE,
		PHOTOBOARDNUM NUMBER,
		PHOTOBOARDTITLE VARCHAR2(1000),
		MEMBERID VARCHAR2(200),
		PHOTOBOARDCONTENT VARCHAR2(3000),
		READCOUNT NUMBER,
		REPLYNUM NUMBER,
		CONSTRAINT DG_PHOTO_PK PRIMARY KEY(PHOTOBOARDNUM),
		CONSTRAINT DG_PHOTO_FK FOREIGN KEY(MEMBERID) REFERENCES DG_MEMBER(MEMBERID) ON DELETE CASCADE
	);

	SELECT * FROM DG_PHOTOBOARD;

-- 사진 게시판 댓글
-- 시퀀스
	CREATE SEQUENCE DG_MREPLY_SEQ;
-- 테이블
	CREATE TABLE DG_MREPLY(
		MREPLYNUM NUMBER,
		UPLOAD DATE DEFAULT SYSDATE,
		PHOTONUM NUMBER,
		MEMBERID VARCHAR2(200),
		MREPLYCONTENT VARCHAR2(3000),
		CONSTRAINT DG_MREPLY_PK PRIMARY KEY(MREPLYNUM),
		CONSTRAINT DG_MREPLY_MEMBER_FK FOREIGN KEY(MEMBERID) REFERENCES DG_MEMBER(MEMBERID),
		CONSTRAINT DG_MREPLY_PHOTO_FK FOREIGN KEY(PHOTONUM) REFERENCES DG_PHOTOBOARD(PHOTOBOARDNUM) ON DELETE CASCADE
	);

	SELECT * FROM DG_MREPLY;
	
-- 리뷰 게시판
-- 시퀀스
	CREATE SEQUENCE DG_REVIEW_SEQ;
-- 테이블
	CREATE TABLE DG_REVIEW(
		UPLOAD DATE DEFAULT SYSDATE,
		REVIEWNUM NUMBER,
		TRAINERID VARCHAR2(200),
		MEMBERID VARCHAR2(200),
		REVIEWCONTENT VARCHAR2(3000),
		CONSTRAINT DG_REVIEW_PK PRIMARY KEY(REVIEWNUM),
		CONSTRAINT DG_REVIEW_TRAINER_FK FOREIGN KEY(TRAINERID) REFERENCES DG_TRAINER(TRAINERID) ON DELETE CASCADE,
		CONSTRAINT DG_REVIEW_MEMBER_FK FOREIGN KEY(MEMBERID) REFERENCES DG_MEMBER(MEMBERID) ON DELETE CASCADE
	);

	SELECT * FROM DG_REVIEW;
	
-- 문의 게시판
-- 시퀀스
	CREATE SEQUENCE DG_QNA_SEQ;
-- 테이블
	CREATE TABLE DG_QNA(
		QNANUM NUMBER,
		UPLOAD DATE DEFAULT SYSDATE,
		QNATITLE VARCHAR2(500),
		MEMBERID VARCHAR2(200),
		QNACONTENT VARCHAR2(3000),
		READCOUNT NUMBER,
		CONSTRAINT DG_QNA_PK PRIMARY KEY(QNANUM)
	);

	SELECT * FROM DG_QNA;

-- 문의 게시판 댓글
-- 시퀀스
	CREATE SEQUENCE DG_QREPLY_SEQ;
-- 테이블
	CREATE TABLE DG_QREPLY(
		QREPLYNUM NUMBER(10),
		UPLOAD DATE DEFAULT SYSDATE,
		QNANUM NUMBER(10),
		MEMBERID VARCHAR2(100),
		QREPLYCONTENT VARCHAR2(3000),
		CONSTRAINT DG_QREPLY_PK PRIMARY KEY(QREPLYNUM)
	);
	
	SELECT * FROM DG_QREPLY;