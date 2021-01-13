package com.koreait.mvc10.controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.mvc10.dto.Calculator;

@Controller
public class CalController {
	
	@RequestMapping("/1")
	public String index1() {
		return "index1";
	}
	
	@RequestMapping("calc")
	public String summary(Calculator calculator,@RequestParam("iter") int iter, Model model) {
			model.addAttribute("n1", calculator.getN1());
			model.addAttribute("n2", calculator.getN2());
			String[] btn = {"뺄셈","곱하기","나눗셈","초기화면"}; 
			String result="";
		switch(iter) {
		
		case 0: 
			 result = calculator.getN1() + " + " + calculator.getN2() + " = " + calculator.summary();
			iter = 1;
			model.addAttribute("result", result);
			model.addAttribute("iter", iter);
			model.addAttribute("btn", btn[0]);
			break;
		case 1:
			 result = calculator.getN1() + " - " + calculator.getN2() + " = " + calculator.subtract();
			iter = 2;
			model.addAttribute("result", result);
			model.addAttribute("iter", iter);
			model.addAttribute("btn", btn[1]);
			break;
		case 2:
			 result = calculator.getN1() + " * " + calculator.getN2() + " = " + calculator.multyply();
			iter = 3;
			model.addAttribute("result", result);
			model.addAttribute("iter", iter);
			model.addAttribute("btn", btn[2]);
			break;
			
		case 3:
			result = calculator.getN1() + " / " + calculator.getN2() + " = " + calculator.divide();
			iter = 4;
			model.addAttribute("result", result);
			model.addAttribute("iter", iter);
			model.addAttribute("btn", btn[3]);
			break;
			
		case 4:
			
			return "redirect:1";
			
		}
		
		return "result1";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	ajax
	@RequestMapping(value="sum",
					method=RequestMethod.GET,
					produces="application/json; charset=utf-8")
	@ResponseBody
	public String sum(@RequestParam(value="one") int one,
						@RequestParam(value="two") int two) {
		
		int result = one + two;
		JSONObject obj = new JSONObject();
		obj.put("one", one);
		obj.put("two", two);
		obj.put("result", result);
		
		return obj.toJSONString();
	}
	
	@RequestMapping(value="subtraction",
			method=RequestMethod.GET,
			produces="application/json; charset=utf-8")
	@ResponseBody
	public String subtraction(@RequestParam(value="one") int one,
			@RequestParam(value="two") int two) {
		
		int result = one - two;
		JSONObject obj = new JSONObject();
		obj.put("one", one);
		obj.put("two", two);
		obj.put("result", result);
		
		return obj.toJSONString();
	}
	@RequestMapping(value="multyply",
			method=RequestMethod.GET,
			produces="application/json; charset=utf-8")
	@ResponseBody
	public String multyply(@RequestParam(value="one") int one,
			@RequestParam(value="two") int two) {
		
		int result = one * two;
		JSONObject obj = new JSONObject();
		obj.put("one", one);
		obj.put("two", two);
		obj.put("result", result);
		
		return obj.toJSONString();
	}
	@RequestMapping(value="divide",
			method=RequestMethod.GET,
			produces="application/json; charset=utf-8")
	@ResponseBody
	public String divide(@RequestParam(value="one") int one,
			@RequestParam(value="two") int two) {
		
		double result = (double)(one / two);
		JSONObject obj = new JSONObject();
		obj.put("one", one);
		obj.put("two", two);
		obj.put("result", result);
		
		return obj.toJSONString();
	}
	

	
	
}
