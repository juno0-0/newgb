package com.koreait.beans;

/*CREATE TABLE TABLE_MEMBER(
		NUM NUMBER PRIMARY KEY,
		ID VARCHAR2(500),
		NAME VARCHAR2(500),
		PASSWORD VARCHAR2(500),
		GENDER VARCHAR2(50),
		ZIPCODE VARCHAR2(50),
		ADDRESS VARCHAR2(500),
		ADDRESSDETAIL VARCHAR2(500), 변수명을 _로 구분을 안한 이유는 DB에서 자바로 데이터를 가져올 때 _가 있으면 인식을 못할 때가 있다.
		ADDRESSETC VARCHAR2(500)		왠만하면 카멜표기법(단어가 2개일때 첫글자가 대문자)로 쓰자.
	);
*/

public class TABLE_MEMBER_VO {
	private int num;
	private String id;
	private String name;
	private String password;
	private String gender;
	private String zipcode;
	private String address;
	private String addressDetail;
	private String addressEtc;
	
	public TABLE_MEMBER_VO() {}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getAddressEtc() {
		return addressEtc;
	}

	public void setAddressEtc(String addressEtc) {
		this.addressEtc = addressEtc;
	}
}
