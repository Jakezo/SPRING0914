package com.koreait.simple3.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.ui.Model;

import com.koreait.simple3.dto.SimpleDto;
import com.koreait.simple3.config.AppContext;
import com.koreait.simple3.dao.SimpleDao;

public class SimpleUpdateCommand implements SimpleCommand {

	@Override
	public void execute(Model model) {
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		SimpleDao simpleDao = ctx.getBean("simpleDao", SimpleDao.class);
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		SimpleDto simpleDto = new SimpleDto();
		
		simpleDto.setNo(Integer.parseInt(request.getParameter("no")));
		simpleDto.setTitle(request.getParameter("title"));
		simpleDto.setContent(request.getParameter("content"));
		
		simpleDao.simpleUpdate(simpleDto);
		
		ctx.close();
		
	}

}
