package kr.co.gudi.service;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gudi.dao.MemberDAO;
import kr.co.gudi.dto.MemberDTO;

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberDAO dao;

	public void join(Map<String, String> params) {
		
		dao.join(params);		
		// auth=on 여부에 따라서 관리자 여부가 판단됨		
		if(params.get("auth") != null) {
			logger.info("관리자");
			dao.setPermission(params.get("id"),"admin");
		}
		
	}

	public MemberDTO login(String id, String pw) {		
		return dao.login(id,pw);
	}

	public ArrayList<MemberDTO> memberList() {
		return dao.memberList();
	}

}
