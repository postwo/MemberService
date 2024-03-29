package kr.co.gudi.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gudi.dto.BoardDTO;
import kr.co.gudi.service.BoardService;

@Controller
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardService service;
	
	@RequestMapping(value="/board/list")
	public String boardList(Model model, HttpSession session) {
		
		String page = "index";
		
		if(session.getAttribute("loginInfo") != null) {
			ArrayList<BoardDTO> list = service.boardList();
			model.addAttribute("list", list);
			page = "board_list";
		}else {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
		}
		
		return page;
	}

}
