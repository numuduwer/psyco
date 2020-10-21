package com.three.psyco.controller.bean;

import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.MemberDTO;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.MemberServiceImpl;
import com.three.psyco.service.bean.UserServiceImpl;

@Controller
@RequestMapping("/user/")
public class UserBean {
	
	@Autowired
	UserServiceImpl userService = null;
	
	@Autowired
	CommonsServiceImpl commonsService = null;
	
	@Autowired
	private MemberServiceImpl memberService;
	public UserBean(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("myPageList2.com")
	public String myPageList2(String pageNum,String category,Model model) throws SQLException {
		
		ListData list = userService.getMyAsk(pageNum,category,model);
		commonsService.setListDataToModel(model,list);
		
		
		
		
		
		return "user/myPageList2";
		}

	@RequestMapping("myPageList.com")
	public String myPageList() {
		return "user/myPageList";
	}
	
	@RequestMapping("userDeleteForm.com")
	public String userDeleteForm() {
		return "user/userDeleteForm";
	}
	
	@RequestMapping("userDeletePro.com")
	public String userDeletePro(String pw, HttpSession session) throws ParseException {
		
		String member_Id = (String) session.getAttribute("memId");
		int count = memberService.loginCheck(member_Id, pw);
		int result = 0;
		
		if (count == 1) {	// 아이디, 비밀번호가 일치할 시
			result = memberService.userDelete(member_Id, pw);
		}
		String return_str = "{ \"count\": " + count + ", \"result\": "  + result + "}";
		return return_str;
	}
	
	@RequestMapping("modifyInputPw.com")
	public String modifyForm() {
		return "user/modifyInputPw";
	}
	
	@RequestMapping("userPwCheck.com")
	@ResponseBody
	public String userPwCheck(String pw, HttpSession session) {		// social 가입 유저인지, 일반 가입 유저인지 판단하는 메서드
		String member_Id = (String) session.getAttribute("memId");
		int count = memberService.loginCheck(member_Id, pw);
		int typeCount = memberService.userTypeCheck(member_Id);
		String userType = "";
		if (typeCount == 0) {
			userType = "social";
		} else {
			userType = "normal";
		}
		String return_str = "{ \"count\": " + count + ", \"userType\": \"" + userType + "\"}";
		System.out.println(return_str);
		
		return return_str;
	}
	
	@RequestMapping("modifyNormalUserForm.com")
	public String modifyNormalUserForm() {
		return "user/modifyNormalUserForm";
	}
	
	@RequestMapping("modifySocialUserForm.com")
	public String modifySocialUserForm() {
		return "user/modifySocialUserForm";
	}
	
	@RequestMapping("getMemberProfile.com")
	@ResponseBody
	public String getMemberProfile(HttpSession session) {
		int member_Num = (int) session.getAttribute("memNum");
		MemberDTO dto = memberService.getMemberProfileFromNum(member_Num);
		String return_str = "{ \"member_Num\": " + dto.getMember_Num() + ", \"member_Id\": \"" + dto.getMember_Id() + "\", \"pw\": \"" + dto.getPw() + ""
				+ "\", \"name\": \"" + dto.getName() + "\", \"birth\": \"" + dto.getBirth() + "\", \"phoneNum\": \"" + dto.getPhoneNum()
				+ "\", \"gender\": \"" + dto.getGender() + "\", \"nickname\": \"" + dto.getNickname() + "\", \"email\": \"" + dto.getEmail()
				+ "\", \"purchase_count\": " + dto.getPurchase_count() + ", \"business_license\": " + dto.getBusiness_license() + ", \"reg\": \"" + dto.getReg() + "\""
				+ "}";
		//URLEncoder.encode(return_str);
		
		return return_str;
	}
	
	@RequestMapping("modifySocialUserPro.com")
	@ResponseBody
	public String modifySocialUserPro(String phoneNum, String birth) {
		int result = memberService.modifySocialUserPro(phoneNum, birth);
		String return_str = "{\"count\": " + result + "}";
		return return_str;
	}
	
	@RequestMapping("modifyNormalUserPro.com")
	public String modifyNormalUserPro(MemberDTO dto, Model model) {
		int result = memberService.modifyNormalUserPro(dto);
		
		model.addAttribute("count", result);
		return "user/modifyCheck";
	}
	
	@RequestMapping("zzimDelete.com")
	public String zzimDelete(HttpServletRequest request) {
		
		System.out.println(request.getParameter("zzim_num"));
		
		return "zzim/zzimDelete";
	}
	

	
}