package kr.co.gudi.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gudi.dao.BoardDAO;
import kr.co.gudi.dto.BoardDTO;

@Service
public class BoardService {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired BoardDAO dao;
	
	public ArrayList<BoardDTO> boardList() {
		return dao.boardList();
	}

}
