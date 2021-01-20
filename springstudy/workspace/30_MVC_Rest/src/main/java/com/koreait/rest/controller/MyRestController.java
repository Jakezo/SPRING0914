package com.koreait.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
	
	@RestController
	1. REST 방식의 Controller입니다.
	2. 모든 메소드에는 자동으로 @ResponseBody가 붙는 것으로 처리합니다.
	   : 모든 메소드의 반환 값은 JSP가 아니라, 데이터 자체입니다.

*/

@RestController
public class MyRestController {

	/*
	@RequestMapping(value="getText",
			        method=RequestMethod.GET,
			        produces="text/plain; charset=utf-8")
	*/
	@GetMapping(value="getText",
	            produces="text/plain; charset=utf-8")
	// @ResponseBody   생략하는 이유는 @RestController이기 때문입니다.
	public String getText() {
		return "안녕하세요";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
