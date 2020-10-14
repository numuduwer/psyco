package com.three.psyco.controller.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.three.psyco.model.dto.MidDTO;
import com.three.psyco.service.bean.MemberShopMenuServiceImpl;

@EnableWebMvc
@Controller
public class MemberShopMenuBean {
	
	@Autowired
	private MemberShopMenuServiceImpl memberMenu=null;
	
	
	
	@RequestMapping("menuSignupForm.com")
	public String menuSignupForm() {
		return "member/menuSignupForm";
	}
	
	@RequestMapping("menuSignupPro.com")
	public String menuSignupPro(MultipartHttpServletRequest request,int shop_num)throws SQLException {
		
		memberMenu.insertMemberMenus(request,shop_num);
		
		return "member/menuSignupPro";
	}
	

	@RequestMapping(value =  "ajaxMenuSelect.com" ,method=RequestMethod.GET)
	@ResponseBody
	public List<MidDTO> ajaxMenuSelect(int bigname) throws SQLException{
		System.out.println("Ajax");
		System.out.println(bigname);
		List<MidDTO> list = null;
		list=memberMenu.selectMenus(bigname);
		for(MidDTO dto : list) {
			System.out.println(dto);
		}
		return list;
//		responsebody 리턴 타입을 리스트로 못받는것 알아보기
	}
}
