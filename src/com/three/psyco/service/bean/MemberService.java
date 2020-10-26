package com.three.psyco.service.bean;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;

import org.json.simple.parser.ParseException;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dto.MemberDTO;

public interface MemberService {

	public String naverLogin() throws UnsupportedEncodingException;
	
	public StringBuffer callBack() throws UnsupportedEncodingException;
	
	public HashMap<String, String> MemberProfile(StringBuffer res) throws ParseException;
	
	public int existUserCheck(HashMap<String, String> MemberProfile);
	
	public void psycoLogin(HashMap<String, String> MemberProfile);
	
	public MemberDTO setInfoFromNaver(HashMap<String, String> MemberProfile);
	
	public int insertMember(MemberDTO dto);
	
	public int loginCheck(String member_Id, String pw);
	
	public String licenseLookup(String license_number) throws IOException;
	
	public MemberDTO memberInfos(String session)throws Exception;
	
	public String getNickNames(String session)throws Exception;
	
	public int userDelete(String member_Id, String pw);
	
	public int userTypeCheck(String member_Num);
	
	public MemberDTO getMemberProfileFromNum(int member_Num);
	
	public int modifySocialUserPro(String phoneNum, String birth);
	
	public int modifyNormalUserPro(MemberDTO dto);
	
	public void insertMemberShops(MultipartHttpServletRequest request,int member_num,String status,String approve_status)throws SQLException;
	
	//아이디 중복 체크
	public int idChk(String id)throws SQLException;
}