package com.koreait.mybatis3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.mybatis3.command.BoardDeleteCommand;
import com.koreait.mybatis3.command.BoardInsertCommand;
import com.koreait.mybatis3.command.BoardListCommand;
import com.koreait.mybatis3.command.BoardViewCommand;
import com.koreait.mybatis3.command.DownloadCommand;
import com.koreait.mybatis3.command.EmailAuthCommand;
import com.koreait.mybatis3.command.EmailAuthCommand2;

@Controller
public class BoardController {

	@Autowired
	private SqlSession sqlSession;
	
	private BoardListCommand boardListCommand;
	private BoardInsertCommand boardInsertCommand;
	private BoardViewCommand boardViewCommand;
	private BoardDeleteCommand boardDeleteCommand;
	private DownloadCommand downloadCommand;
	private EmailAuthCommand emailAuthCommand;
	private EmailAuthCommand2 emailAuthCommand2;
	
	@Autowired
	public void setCommand(BoardListCommand boardListCommand,
			               BoardInsertCommand boardInsertCommand,
			               BoardViewCommand boardViewCommand,
			               BoardDeleteCommand boardDeleteCommand,
			               DownloadCommand downloadCommand,
			               EmailAuthCommand emailAuthCommand,
		                   EmailAuthCommand2 emailAuthCommand2) {
		this.boardListCommand = boardListCommand;
		this.boardInsertCommand = boardInsertCommand;
		this.boardViewCommand = boardViewCommand;
		this.boardDeleteCommand = boardDeleteCommand;
		this.downloadCommand = downloadCommand;
		this.emailAuthCommand = emailAuthCommand;
		this.emailAuthCommand2 = emailAuthCommand2;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="boardInsertPage.do", method=RequestMethod.GET)
	public String boardInsertPage() {
		return "board/boardInsertPage";
	}
	
	@RequestMapping(value="boardListPage.do", method=RequestMethod.GET)
	public String boardListPage(Model model) {
		boardListCommand.execute(sqlSession, model);
		return "board/boardListPage";
	}
	
	@RequestMapping(value="boardInsert.do", method=RequestMethod.POST)
	public String boardInsert(MultipartHttpServletRequest multipartRequest,
			                  Model model) {
		// 첨부가 없을 때 파라미터 : HttpServletRequest request
		// 첨부가 있을 때 파라미터 : MultipartHttpServletRequest multipartRequest
		model.addAttribute("multipartRequest", multipartRequest);
		boardInsertCommand.execute(sqlSession, model);
		return "redirect:boardListPage.do";
	}
	
	@RequestMapping(value="boardViewPage.do", method=RequestMethod.GET)
	public String boardViewPage(HttpServletRequest request,
			                    Model model) {
		model.addAttribute("request", request);
		boardViewCommand.execute(sqlSession, model);
		return "board/boardViewPage";
	}
	
	@RequestMapping(value="download.do", method=RequestMethod.GET)
	public void download( HttpServletRequest request,
			              HttpServletResponse response,  // 다운로드는 response가 필요합니다.
			              Model model) {
		
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		
		downloadCommand.execute(sqlSession, model);
		
	}
	
	@RequestMapping(value="boardDelete.do", method=RequestMethod.POST)
	public String boardDelete(HttpServletRequest request,
			                  Model model) {
		
		model.addAttribute("request", request);
		boardDeleteCommand.execute(sqlSession, model);
		return "redirect:boardListPage.do";
		
	}
	
	
	/***** 이메일 인증 *****/
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="emailAuth.do", method=RequestMethod.POST)
	public String emailAuth(HttpServletRequest request,
			                Model model) {
		
		model.addAttribute("request", request);
		model.addAttribute("mailSender", mailSender);
		emailAuthCommand.execute(sqlSession, model);
		
		return "board/emailAuthConfirm";
		
	}
	
	@RequestMapping(value="emailAuth2.do", method=RequestMethod.GET)
	public String emailAuth2(HttpServletRequest request,
                             Model model) {
		
		model.addAttribute("request", request);
		model.addAttribute("mailSender", mailSender);
		emailAuthCommand2.execute(sqlSession, model);
		
		return "board/emailAuthConfirm2";
		
	}
	
}
