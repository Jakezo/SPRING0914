package com.koreait.mvc05.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

	
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	
	/*
		Model 클래스
		
		1. 스프링 2 이전에는 ModelAndView 클래스를 사용했습니다.
		2. 스프링 2 이후에는 Model 클래스를 사용합니다.
		3. Model 클래스는 request의 attribute를 이용하는 클래스입니다.
		
		4. JSP		HttpServletRequest request;
					request.setAttribute(속성이름, 값);
					
		5. Spring	Model model;
					model.addAttribute(속성이름, 값);
		
		6. Model 클래스는 Controller에서 View(JSP)로 데이터를 넘길 때 사용합니다.
		7. new Model()을 하지 않고, 매개변수에 선언해서 사용합니다. (마지막 매개변수로 선언해 주면 됩니다.)
	*/
	
	
	// 1. 단순 변수 넘기기
	@RequestMapping("v01")
	public String goView01(Model model) {  // 매개변수에 Model을 선언합니다.
		
		// model에 View(JSP)로 보낼 데이터를 저장합니다.
		model.addAttribute("name", "데이빗");	// 실제로는 request.setAttribute("name", "데이빗") 입니다.
		model.addAttribute("age", 30);			// 실제로는 request.setAttribute("age", 30) 입니다.
		
		return "view01";	// return "/WEB-INF/views/view01.jsp";
		
	}
	
	
	// 2. Map 넘기기
	@RequestMapping("v02")
	public String goView02(Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "스미스");
		map.put("age", 50);
		
		// map을 model에 저장합니다.
		model.addAttribute("map", map);
		
		return "view02";	// return "/WEB-INF/views/view02.jsp";
		
	}
	
	
	// 3. PersonDto 1개 넘기기
	// com.koreait.mvc05.dto 패키지에 PersonDto 생성 (name, age)
	
	
	
	// 4. PersonDto 2개를 ArrayList에 담아서 넘기기
	
	
	
	
	
}
