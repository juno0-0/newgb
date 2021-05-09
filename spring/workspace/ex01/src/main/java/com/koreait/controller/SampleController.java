package com.koreait.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller // 자동으로 스프링의 객체(Bean)로 등록된다.
@RequestMapping("/sample/*") // 만약 sample이라는 요청이 들어오면 들어와라
	// 현재 클래스의 모든 메소드들의 기본 경로 설정(예: /sample/aaa, /sample/bbb 등)
@Log4j
public class SampleController {
	@RequestMapping("")	// GET, POST 상관없이 Controller 로직을 수행한다면 method 옵션을 사용하지 않는다.
	public void basic() {
		log.info("basic.................");
	}
	
	// GET이나 POST로 요청이 들어왔을 때에만 들어옴
	// 여러 개의 RequestMethod를 사용할 경우만 사용
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST}) 
	public void basicGet() {
		log.info("basic get................");
	}
	
	//@PostMapping // POST방식으로 요청한 것만 들어오게 할 경우
	@GetMapping("/basicOnlyGet") // GET방식으로 요청한 것만 들어오게 할 경우
	public void basicGet2() {
		log.info("basic get only get................");
	}
	
	// Controller는 파라미터 타입에 따라 자동으로 매핑된다.
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}
	
	// 파라미터와 매개변수의 이름이 다를 경우
	@GetMapping("/ex02")
	public String ex02(@RequestParam("data1") String name, @RequestParam("data2") int age, Model model) {
		//RequestParam()의 매개변수가 data1이면 뒤에 있는 name에 넣어라
		//RequestParam()의 매개변수가 data2이면 뒤에 있는 age를 넣어라
		//name과 age로 쓸꺼면 RequestParam()을 지우면 된다
		
		log.info("name : "+name);
		log.info("age : "+age);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "ex02";
	}
	
	// ArrayList에 파라미터 담기
	@GetMapping("/ex03")
	public String ex03(@RequestParam("data") ArrayList<String> datas, Model model) {
		//RequestParam()의 매개변수가 data면 전부 datas에 넣어라
		log.info("datas : "+datas);
		model.addAttribute("datas", datas);
		return "ex03";
	}
	
	// 배열에 파라미터 담기
	@GetMapping("/ex04")
	public String ex04(@RequestParam("data") String[] arStr, Model model) {
//		log.info("arStr : "+arStr[0]);
//		log.info("arStr : "+arStr[1]);
//		log.info("arStr : "+arStr[2]);
		log.info("arStr : "+Arrays.toString(arStr));
		model.addAttribute("data", arStr);
		return "ex04";
	}
	
	@GetMapping("/ex05")
	public /*String*/ void ex05(SampleDTO dto, @ModelAttribute("gender") String gender) {
		log.info(dto);
		log.info("gender : "+gender);
//		return "/sample/ex05";
	}
	//요청한 경로랑 같은 경로로 가면 void, 다른 곳으로 보내는거면 return
	
	@GetMapping("/ex06")
	public void ex06(ArrayList<SampleDTO> dto) {
		log.info(dto);
	}
}
