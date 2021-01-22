package com.koreait.mybatis3.command;

import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;

public class EmailAuthCommand2 implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		// 이메일을 보내는 작업은 예외 처리가 필요합니다.
		
		try {
			
			Map<String, Object> map = model.asMap();
			HttpServletRequest request = (HttpServletRequest)map.get("request");
			JavaMailSender mailSender = (JavaMailSender)map.get("mailSender");
	
			// MimeMessage 클래스가 이메일의 내용을 작성합니다.
			MimeMessage message = mailSender.createMimeMessage();
			message.setHeader("Content-Type", "text/html; charset=utf-8");
			
			// MimeMessageHelper 클래스를 이용하는 방법도 있습니다.
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8"); 
			helper.setFrom(new InternetAddress("forspringlec@gmail.com", "마스터"));  // 보내는 사람
			helper.setTo(request.getParameter("email"));  // 받는 사람
			helper.setSubject("인증 메일입니다.");  // 제목
			
			// 본문을 만듭니다. 인증링크를 작성합니다.
			helper.setText("<html><body><a href='http://localhost:9090" + request.getContextPath() + "/emailAuth2.do?authKey=ok'>여기를 클릭하세요</a><br/></body></html>", true);
			
			mailSender.send(message);  // 메일을 보냅니다.
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
