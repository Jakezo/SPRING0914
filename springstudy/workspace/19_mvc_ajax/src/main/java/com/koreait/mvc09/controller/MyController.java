package com.koreait.mvc09.controller;

import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	
	@RequestMapping(value="/",
					method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	
	@RequestMapping(value="getText",
					method=RequestMethod.GET,
					produces="text/plain; charset=utf-8")  // return text; 할 때  text가 "text/plain" 타입입니다.
	
	@ResponseBody  // return 하는 데이터는 응답입니다. (뷰나 다른 매핑값이 아니고, 데이터를 반환합니다.)
	public String getText(@RequestParam("send") String send) {
		
		String text = send + "를 받았습니다.";
		
		// ajax는 반환하는(return) 값이 "뷰"도 아니고, "다른 매핑값"도 아닙니다.
		// 실제로 데이터(텍스트, json, xml 등)를 반환합니다.
		
		return text;  // text는 데이터를 의미합니다. return 하는 데이터는 요청한 곳으로 보내는 데이터입니다. 즉 응답(response)하는 방식입니다.
		
	}
	
	@RequestMapping(value="getJson",
					method=RequestMethod.POST,
					produces="application/json; charset=utf-8")
	/*
		produces=MediaType.APPLICATION_JSON_VALUE
		produces="application/json"
	*/
	@ResponseBody
	public String getJson(@RequestParam("send") String send) {
		
		// json 데이터를 넘겨 주기
		JSONObject obj = new JSONObject();
		obj.put("send", send);
		obj.put("exist", send.isEmpty() ? "없음" : "있음");
		
		return obj.toJSONString();
		
		// send가 있다면,
		// return {"send": "보낸데이터", "exist": "있음"};
		
		// send가 없다면,
		// return {"send": "", "exist": "없음"};
		
		// return 하는 데이터가 JSON이므로
		// 1. @ResponseBody 가 필요하고, (return 하는 것이 뷰나 다른 매핑값이 아니라 "데이터"이다.)
		// 2. produces="application/json; charset=utf-8" 이 필요하다.
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
