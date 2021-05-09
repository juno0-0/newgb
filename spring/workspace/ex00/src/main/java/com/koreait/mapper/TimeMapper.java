package com.koreait.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	/*
	 * SQL이 복잡하거나 길어지는 경우에는 어노테이션보다는 XML을 이용하는 방식을 더 선호하게 된다.
	 * MyBatis-Spring의 경우 Mapper 인터페이스와 XML을 동시에 이용할 수 있다. 
	 */
	
	@Select("SELECT sysdate FROM dual") // 여기에 쿼리문을 작성하는 것, SELECT면 @Select를 쓰는 것
	public String getTime(); // 이 메소드가 실행되면 위에 쿼리문이 실행되는 것

	public String getTime2();
	
}