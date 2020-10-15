package com.three.psyco.controller.bean;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.ShopDTO;
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

	
	public static String controllerName = "shopBean";
	
		
	@RequestMapping("shopList.com")
	public String storeList2(String pageName, String pageNum, HttpSession session, Model model) throws SQLException {
		
		int memNum = 0; 
		
		
		if (session.getAttribute("memNum") == null) {
			// table에 있는 값 아무거나 찍어줌 
			memNum =2;
		}else { 
			memNum = (Integer)session.getAttribute("memNum");
		
		}
		ListData data = commonsService.getListData(pageName,pageNum,memNum,controllerName);
		commonsService.setListDataToModel(model, data);
	
		return "shop/shopList";
	}
	
	@RequestMapping("shopDetail.com")
	public String shopDetail(String shop_num, Model model) throws SQLException {
		
		if(shop_num == null) {
			shop_num = "2";
		}
		int id = Integer.parseInt(shop_num);
		
		
		ShopDTO shopData = shopService.getShopDataSV(id);
		model.addAttribute("dto", shopData);
		return "shop/shopDetail";
	}

}
