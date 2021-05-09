package com.koreait.domain;

import lombok.Data;

//import org.springframework.stereotype.Component;

// @Component 사용자가 입력한 값이 SampleDTO로 자동으로 매핑되서 들어오기 때문에 Component를 붙이지 않아도 된다.
// 의존성 주입이 아니라 new임
@Data
public class SampleDTO {
	private String name;
	private int age;
}
