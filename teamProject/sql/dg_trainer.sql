-- 트레이너 계정
-- 시퀀스
	CREATE SEQUENCE DG_TRAINER_SEQ;
-- 테이블
	CREATE TABLE DG_TRAINER(
		TRAINERID VARCHAR2(200),
		TRAINERPW VARCHAR2(300),
		TRAINERNAME VARCHAR2(200),
		TRAINERPHONENUM VARCHAR2(100),
		TRAINERGENDER VARCHAR(10),
		TRAINEREMAIL VARCHAR2(300),
		TRAINERACCOUNT VARCHAR2(300),
		TRAINERADDRESSZIPCODE VARCHAR2(500),
		TRAINERADDRESS VARCHAR2(500),
		TRAINERADDRESSDETAIL VARCHAR2(500),
		TRAINERPRICE NUMBER DEFAULT 0,
		TRAINERPOINT NUMBER DEFAULT 0,
		TRAINERNUM NUMBER UNIQUE NOT NULL,     
		TRAINERCONTENT VARCHAR2(3000),
		TRAINERURL VARCHAR2(500),
		TRAINERLIKE NUMBER DEFAULT 0,
		TRAINERPROFILEIMAGE VARCHAR2(1000),
		CONSTRAINT DG_TRAINER_PK PRIMARY KEY(TRAINERID)
	);

	SELECT * FROM DG_TRAINER;

	INSERT INTO DG_TRAINER VALUES('trainer6', 'ģģģccc', '테스트6', '01046420130', '여자', 'test@test.com', '0', '12453', '...', '...', 2300, 0, 100, '월화수 체형교정', 'https://open.kakao.com/o/saA4SG5c', 0, 'null');
	INSERT INTO DG_TRAINER VALUES('trainer7', 'ģģģccc', '테스트7', '01046420130', '남자', 'test@test.com', '0', '13254', '...', '...', 200, 0, 101, '목금 다이어트 체형교정', 'https://open.kakao.com/o/saA4SG5c', 0, 'null');
	INSERT INTO DG_TRAINER VALUES('trainer8', 'ģģģccc', '테스트8', '01046420130', '남자', 'test@test.com', '0', '13464', '...', '...', 300, 0, 102, '월금 체형교정 재활통증케어', 'https://open.kakao.com/o/saA4SG5c', 0, 'null');
	INSERT INTO DG_TRAINER VALUES('trainer9', 'ģģģccc', '테스트9', '01046420130', '여자', 'test@test.com', '0', '14536', '...', '...', 800, 0, 103, '상담 후 결정 대회준비 바디프로필', 'https://open.kakao.com/o/saA4SG5c', 0, 'null');
	INSERT INTO DG_TRAINER VALUES('trainer10', 'ģģģccc', '테스트10', '01046420130', '여자', 'test@test.com', '0', '15754', '...', '...', 900, 0, 104, '월 상담 후 결정 기타', 'https://open.kakao.com/o/saA4SG5c', 0, 'null');
	INSERT INTO DG_TRAINER VALUES('trainer11', 'ģģģccc', '테스트11', '01046420130', '남자', 'test@test.com', '0', '12346', '...', '...', 1000, 0, 105, '월화수 체형교정', 'https://open.kakao.com/o/saA4SG5c', 0, 'null');
	INSERT INTO DG_TRAINER VALUES('trainer12', 'ģģģccc', '테스트12', '01046420130', '여자', 'test@test.com', '0', '15477', '...', '...', 500, 0, 106, '월화목 체중증가 체력증진', 'https://open.kakao.com/o/saA4SG5c', 0, 'null');
	INSERT INTO DG_TRAINER VALUES('trainer13', 'ģģģccc', '테스트13', '01046420130', '여자', 'test@test.com', '0', '15473', '...', '...', 700, 0, 107, '화 목 토 근력 강화', 'https://open.kakao.com/o/saA4SG5c', 0, 'null');
	INSERT INTO DG_TRAINER VALUES('trainer14', 'ģģģccc', '테스트14', '01046420130', '남자', 'test@test.com', '0', '16548', '...', '...', 800, 0, 108, '일 월 수 재활통증케어', 'https://open.kakao.com/o/saA4SG5c', 0, 'null');
	INSERT INTO DG_TRAINER VALUES('trainer15', 'ģģģccc', '테스트15', '01046420130', '남자', 'test@test.com', '0', '14634', '...', '...', 1000, 0, 109, '토일 다이어트 바디프로필', 'https://open.kakao.com/o/saA4SG5c', 0, 'null');
	INSERT INTO DG_TRAINER VALUES('trainer16', 'ģģģccc', '테스트16', '01046420130', '남자', 'test@test.com', '0', '14646', '...', '...', 1500, 0, 110, '월화수목 금 기타', 'https://open.kakao.com/o/saA4SG5c', 0, 'null');
	INSERT INTO DG_TRAINER VALUES('trainer17', 'ģģģccc', '테스트17', '01046420130', '여자', 'test@test.com', '0', '14537', '...', '...', 1700, 0, 111, '월목금 상담 후 결정 기타', 'https://open.kakao.com/o/saA4SG5c', 0, 'null');
	INSERT INTO DG_TRAINER VALUES('trainer18', 'ģģģccc', '테스트18', '01046420130', '여자', 'test@test.com', '0', '18746', '...', '...', 1400, 0, 112, '월수 상담 후 결정 바디프로필 다이어트', 'https://open.kakao.com/o/saA4SG5c', 0, 'null');

	UPDATE DG_TRAINER SET TRAINERPROFILEIMAGE = '코코바이킹_바디프로필__(9).jpg' WHERE TRAINERID = 'trainer6';