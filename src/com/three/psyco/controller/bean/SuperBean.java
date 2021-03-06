package com.three.psyco.controller.bean;

import java.sql.SQLException;  
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.three.psyco.model.dao.SuperDAO;
import com.three.psyco.model.dto.CommunityDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.MemberDTO;
import com.three.psyco.model.dto.ShopDTO;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.SuperServiceImpl;

@Controller
@RequestMapping("/super/")
public class SuperBean {
	
@Autowired 
private SuperServiceImpl superService = null;
@Autowired
private CommonsServiceImpl commonsService = null;

	
	
//////// 리스트 뽑기  /////////
	@RequestMapping("memberList.com")
	public String memberList(String pageName, String pageNum,  Model model) throws SQLException {	
		ListData data = commonsService.getListData(pageName,pageNum);
		commonsService.setListDataToModel(model, data);
		return "super/sMemberList.mm";
	}
	@RequestMapping("shopList.com")
	public String shopList(String pageName, String pageNum,  Model model) throws SQLException {
		pageName ="sShopList";
		ListData data = commonsService.getListData(pageName,pageNum);
		commonsService.setListDataToModel(model, data);
		return "super/sShopList.mm";
	}
	
	@RequestMapping("shopEnrollList.com")
	public String shopEnrollList(String pageName, String pageNum,  Model model) throws SQLException {
		pageName ="sShopEnrollment";
		ListData data = commonsService.getListData(pageName,pageNum);
		commonsService.setListDataToModel(model, data);
		System.out.println(" controller 잘연 결 shopEnrollList ----------------- ");
		return "super/sShopEnrollment.mm";
	}
	@RequestMapping("shopEnrollPro.com")
	public String shopEnrollPro(int member_Num, String pageNum,  Model model) throws SQLException {
		
		int result = superService.enrollShopSV(member_Num);
		System.out.println("controller result : " + result);
		model.addAttribute("result", result);
		return "super/shopEnrollPro.mm";
	}
	@RequestMapping("helpList")
	public String helpList(String pageName, String pageNum,  Model model) throws SQLException {
		ListData data = commonsService.getListData(pageName,pageNum);
		commonsService.setListDataToModel(model, data);
		return "super/sHelpList.mm";
	}
	@RequestMapping("communityList")
	public String communityList(String pageName, String pageNum,  Model model) throws SQLException {
		ListData data = commonsService.getListData(pageName,pageNum);
		commonsService.setListDataToModel(model, data);
		return "super/sCommunityList.mm";
	}

	
	
///////  삭제하기 ////// 
	@RequestMapping(value="deleteMember", method = RequestMethod.POST)
	@ResponseBody
	 void delete(@RequestParam("member_Num") String memberNum) {
		System.out.println(memberNum);
		
		superService.deleteMemberSV(memberNum);
		
	}
	
	
	
}
