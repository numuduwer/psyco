package com.three.psyco.controller.bean;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.three.psyco.model.dto.BuyDTO;
import com.three.psyco.model.dto.MemberDTO;
import com.three.psyco.service.bean.MemberServiceImpl;

@Controller
@RequestMapping("member")
public class MemberBean {
	
	@Autowired
	private MemberServiceImpl memberService;

	@RequestMapping("loginForm.com")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping("loginCheck.com")
	public String loginCheck(String member_Id, String pw, Model model, HttpSession session) {
		System.out.println("member_id : "+member_Id );
		System.out.println("pw : "+pw );
		int count = memberService.loginCheck(member_Id, pw);
		
		model.addAttribute("count", count);
		return "member/loginCheck";
	}
	
	@RequestMapping("naverLoginPro.com")
	public String naverLoginPro() throws UnsupportedEncodingException {
		String apiURL = memberService.naverLogin();
		//System.out.println(apiURL);
		return "redirect:" + apiURL;
	}
	
	@RequestMapping("naverCallback.com")
	public String naverCallback(Model model) throws UnsupportedEncodingException, ParseException {
		StringBuffer res = memberService.callBack();
		HashMap<String, String> MemberProfile = memberService.MemberProfile(res);
		int count = memberService.existUserCheck(MemberProfile);
		if (count == 0) {	// 유저가 DB에 존재하지 않을 때
			MemberDTO member = memberService.setInfoFromNaver(MemberProfile);
			model.addAttribute("memberProfile", member);
			return "member/socialSignupForm";
			
		} else { // 유저가 DB에 존재할 때 
			memberService.psycoLogin(MemberProfile);
			return "main/main";
		}
	}
	
	@RequestMapping("signupSelect.com")
	public String signupSelect() {
		return "member/signupSelect";
	}
	
	@RequestMapping("normalSignupForm.com")
	public String normalSignupForm() {
		return "member/normalSignupForm";
	}
	
	@RequestMapping("businessSignupForm.com")
	public String businessSignupForm() {
		return "member/businessSignupForm";
	}
	
	@RequestMapping("signup.com")
	public String insertMember(MemberDTO dto, Model model) {
		int result = memberService.insertMember(dto);
		model.addAttribute("result", result);
		return "member/signupPro";
	}
	
	@RequestMapping("logout.com")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/main.com";
	}
	
	@RequestMapping("licenseLookup.com")
	public ResponseEntity<String> licenseLookup(String text1, String text2, String text3) throws IOException, ParseException {
		String license_number = text1 + text2 + text3;
		String status = memberService.licenseLookup(license_number).trim();
		status = "{ \"status\" : " + "\"" + status + "\"" + "}";
		
		// 응답헤더 설정
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(status, resHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping("mapsTest.com")
	public String mapTest() {
		return "member/mapsTest";
	}
	
	@RequestMapping("geoLocation.com")
	public String geoLocation() {
		return "member/geoLocation";
	}
	
	@RequestMapping("paymentTest.com")
	public String paymentTest() {
		return "member/paymentTest";
	}
	
	@RequestMapping("shopSignupForm.com")
	public String shopSignupForm(String license_number, Model model) {
		model.addAttribute("license_number", license_number);
		return "member/shopSignupForm";
	}

	@RequestMapping("shopSignupPro.com")
	public String shopSignPro(MultipartHttpServletRequest request,int member_num) {
	
	
		String status ="0";
		String approve_status="0";
		
		try {
			memberService.insertMemberShops(request,member_num,status,approve_status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "member/menuSignupForm";
	}
	
	@RequestMapping(value="getUserInfo.com")
	@ResponseBody
	public ResponseEntity<String> getUserInfo(HttpServletRequest request) throws JsonProcessingException {
		
		int member_Num = Integer.parseInt(request.getParameter("mem_num"));
		MemberDTO dto = memberService.getMemberProfileFromNum(member_Num);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(dto);
		
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(jsonString, resHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping("paymentInsert.com")
	public String paymentInsert(String abc) {
		
		
		
		System.out.println(abc);
		return "";
	}
}