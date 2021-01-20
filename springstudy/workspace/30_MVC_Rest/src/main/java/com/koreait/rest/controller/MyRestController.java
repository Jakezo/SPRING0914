package com.koreait.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.rest.dto.PersonDto;

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
	
	
	@GetMapping(value="getJSON",
			    produces="application/json; charset=utf-8")
	public PersonDto getJSON() {
		return new PersonDto("제임스", 20);
		// jackson 라이브러리는
		// Bean을 자동으로 JSON으로 바꿔줍니다.
	}
	
	/*
	public String getJSON() {
		// 1) 우리가 연습한 json-simple
		JSONObject obj = new JSONObject();
		obj.put("name", "제임스");
		obj.put("age", 20);
		return obj.toJSONString();
		// 2) open api
		String responseBody = "{\"name\": \"제임스\", \"age\": 20}";
		return responseBody;
	}
	*/
	
	@GetMapping(value="getXML",
			    produces="application/xml; charset=utf-8")
	public PersonDto getXML() {
		return new PersonDto("앨리스", 30);
		// jackson 라이브러리가 Bean을 XML로 자동으로 변환합니다.
		/*
			<name>앨리스</name>
			<age>30</age>
		*/
	}
	
	@GetMapping(value="getJSONList",
			    produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<PersonDto> getJSONList() {
		List<PersonDto> list = new ArrayList<PersonDto>();
		for (int i = 0; i < 10; i++) {
			list.add(new PersonDto("사용자" + (i + 1), 20 + i));
		}
		return list;
	}
	
	@GetMapping(value="getXMLList",
			    produces="application/xml; charset=utf-8")
	public List<PersonDto> getXMLList() {
		List<PersonDto> list = new ArrayList<PersonDto>();
		for (int i = 0; i < 10; i++) {
			list.add(new PersonDto("사용자" + (i + 1), 20 + i));
		}
		return list;
	}
	
	@PostMapping(value="sendJSON",
			     produces="application/json; charset=utf-8")
	public PersonDto sendJSON(@RequestBody PersonDto personDto) {
		// @RequestBody
		// 전달 받은 데이터가 JSON/XML인 경우 이를 자동으로 Bean으로 변환한다.
		return personDto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
