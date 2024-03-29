package kr.co.gudi.dao;

import java.util.ArrayList;
import java.util.Map;

import kr.co.gudi.dto.MemberDTO;

public interface MemberDAO {

	void join(Map<String, String> params);

	void setPermission(String id, String perm);

	MemberDTO login(String id, String pw);

	ArrayList<MemberDTO> memberList();

}
