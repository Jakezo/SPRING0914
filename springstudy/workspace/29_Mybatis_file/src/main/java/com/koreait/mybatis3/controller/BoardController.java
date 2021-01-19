package com.koreait.mybatis3.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.mybatis3.command.BoardListCommand;

@Controller
public class BoardController {

	@Autowired
	private SqlSession sqlSession;
	
	
	private BoardListCommand boardListCommand;
	
	
	@Autowired
	public void setCommand(BoardListCommand boardListCommand) {
		this.boardListCommand = boardListCommand;
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
		return "";
	}
	
}








