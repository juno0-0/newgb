CREATE TABLE TABLE_MEMBER(
	memberId VARCHAR2(300),
	memberPw VARCHAR2(300),
	memberName VARCHAR2(300),
	memberAge NUMBER(3),
	memberGender VARCHAR2(20),
	memberEmail VARCHAR2(200),
	memberZipcode VARCHAR2(20),
	memberAddress VARCHAR2(300),
	memberAddressDetail VARCHAR2(300),
	memberAddressEtc VARCHAR2(100),
	CONSTRAINT MEMBER_PK PRIMARY KEY(memberId)
);

INSERT INTO TABLE_MEMBER VALUES('iu', '123', '이지은', 29, '여', 'abc@iu.com', '1234', '...', '...', '...');\

SELECT * FROM TABLE_MEMBER;

