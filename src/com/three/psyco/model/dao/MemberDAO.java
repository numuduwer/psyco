package com.three.psyco.model.dao;

import java.sql.SQLException;

import com.three.psyco.model.dto.MemberDTO;
import com.three.psyco.model.dto.MemberShopDTO;

public interface MemberDAO {
	
	public int existUserCheck(String email);
	
	public MemberDTO getMemberProfile(String email);
	
	public MemberDTO getMemberProfileFromId(String member_Id);
	
	public MemberDTO getMemberProfileFromNum(int member_Num);
	
	public int insertMember(MemberDTO dto);
	
	public int loginCheck(String member_Id, String pw);
	
	public int userDelete(String member_Id, String pw);
	
	public int modifySocialUserPro(int member_Num, String member_Id, String phoneNum, String birth);
	
	public int modifyNormalUserPro(MemberDTO dto);
	
	public void insertMemberShop(MemberShopDTO dto)throws SQLException;
}
