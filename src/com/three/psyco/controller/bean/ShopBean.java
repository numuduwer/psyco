package com.three.psyco.controller.bean;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.three.psyco.model.dto.ListData;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.ShopService;
import com.three.psyco.service.bean.ShopServiceImpl;

@Controller
@RequestMapping("/shop/")
public class ShopBean {
	
	@Autowired
	private ShopServiceImpl shopService = null;
	@Autowired
	private CommonsServiceImpl commonsService = null;
	

	
	
	@RequestMapping("shopList.com")
	public String storeList(String pageName, String pageNum, HttpSession session, Model model) throws SQLException {
		
		int memNum = 0; 
		
		
		if (session.getAttribute("memNum") == null) {
			// table에 있는 값 아무거나 찍어줌 
			memNum =2;
		}else { 
			memNum = (Integer)session.getAttribute("memNum");
		
		}
		ListData data = shopService.getListData(pageName,pageNum,memNum);

		model.addAttribute("pageNum", data.getPageNum());
		model.addAttribute("pageSize", data.getPageSize());
		model.addAttribute("currPage", data.getCurrPage());
		model.addAttribute("startRow", data.getStartRow());
		model.addAttribute("endRow", data.getEndRow());
		model.addAttribute("number", data.getNumber());
		model.addAttribute("articleList", data.getArticleList());
		model.addAttribute("count", data.getCount());	
		return "shop/shopList";
	}

}
