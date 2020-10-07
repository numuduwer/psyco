package com.three.psyco.service.bean;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

public interface MemberService {

	public String naverLogin() throws UnsupportedEncodingException;
	
	public StringBuffer callBack() throws UnsupportedEncodingException;
	
	public HashMap<String, String> MemberProfile(StringBuffer res) throws ParseException;
	
	public int existUserCheck(HashMap<String, String> MemberProfile);
}
