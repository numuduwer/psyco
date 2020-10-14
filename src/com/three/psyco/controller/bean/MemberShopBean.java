package com.three.psyco.controller.bean;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.three.psyco.model.dao.MemberShopDAOImpl;
import com.three.psyco.service.bean.MemberShopServiceImpl;

@EnableWebMvc
@Controller
public class MemberShopBean {
	
	@Autowired
	private MemberShopServiceImpl MemberShopService=null;
	
	@RequestMapping("shopSignupForm")
	public String shopSignForm() {
		
		return "store/shopSignupForm";
	}
	@RequestMapping("shopSignupPro")
	public String shopSignPro(MultipartHttpServletRequest request,int member_num) {
		String status ="0";
		String approve_status="0";
		try {
			MemberShopService.insertMemberShops(request,member_num,status,approve_status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "member/menuSignupForm";
	}

}
