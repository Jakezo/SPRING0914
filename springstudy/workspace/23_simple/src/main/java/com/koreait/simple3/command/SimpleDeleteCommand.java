package com.koreait.simple3.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.ui.Model;

import com.koreait.simple3.config.AppContext;
import com.koreait.simple3.dao.SimpleDao;

public class SimpleDeleteCommand implements SimpleCommand {

	@Override
	public void execute(Model model) {
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		SimpleDao simpleDao = ctx.getBean("simpleDao", SimpleDao.class);
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		simpleDao.simpleDelete(Integer.parseInt(request.getParameter("no")));
		
		ctx.close();
		
	}

}
