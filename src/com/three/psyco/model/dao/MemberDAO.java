package com.three.psyco.model.dao;

import com.three.psyco.model.dto.MemberDTO;

public interface MemberDAO {
	
	public int existUserCheck(String email);
	
	public MemberDTO getMemberProfile(String email);
	
	public int insertMember(MemberDTO dto);
	
	public int loginCheck(String member_Id, String pw);
	
	public MemberDTO memberInfo(String session)throws Exception;
	
	public String getNickName(String session)throws Exception;
}
