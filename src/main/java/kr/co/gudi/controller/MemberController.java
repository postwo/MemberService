package kr.co.gudi.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.gudi.dto.MemberDTO;
import kr.co.gudi.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberService service;
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@RequestParam Map<String,String> params) {
		logger.info("params : "+params);
		service.join(params); 
		return "index";
	}
	
	@RequestMapping(value="login")
	public String login(@RequestParam String id, @RequestParam String pw, 
			Model model, HttpSession session) {
		String page = "index";
		
		MemberDTO dto = service.login(id,pw);
		logger.info("dto="+dto);
		if(dto != null) { // 로그인 성공
			logger.info("permission : "+dto.getPerm());
			session.setAttribute("loginInfo", dto);
			if(dto.getPerm() != null) {// 관리자
				page = "redirect:/member/list";
			}else {// 일반 사용자
				page = "redirect:/board/list";
			}			
		}else { // 로그인 실패
			model.addAttribute("msg", "id 또는 pw 를 확인 하세요");
		}
		
		return page;
	}
	
	@RequestMapping("/member/list")
	public String memberList(Model model, HttpSession session) {
		
		MemberDTO info = (MemberDTO) session.getAttribute("loginInfo");
		String page = "index";
		
		if(info != null && info.getPerm() != null) {
			page = "member_list";
			ArrayList<MemberDTO> list = service.memberList();
			model.addAttribute("list", list);
		}else {
			model.addAttribute("msg", "해당 페이지에 대한 권한이 없습니다.");
		}
				
		return page;
	}
	
	@RequestMapping(value="/member/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginInfo");
		return "redirect:/";
	}
	
	
	
	
	
	
	

}
