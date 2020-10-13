package com.three.psyco.service.bean;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

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
}