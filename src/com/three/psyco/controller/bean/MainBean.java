package com.three.psyco.controller.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.JoinResultDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.ShopDTO;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.MainServiceImpl;

import com.three.psyco.service.bean.Scheduler;
import com.three.psyco.service.bean.ShopServiceImpl;




@Controller
@RequestMapping("/main/")
public class MainBean {
	public static String controllerName = "mainBean";
	
	@Autowired
	private CommonsServiceImpl commonsService = null;
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@Autowired
	private MainServiceImpl mainService = null;
	
	@Autowired
	private ShopServiceImpl shopService = null;
	
	@Autowired
	public static String controller = "mainBean";
	
	@Autowired
	public Scheduler scheduler = null;
	
	@RequestMapping("main.com")
	public String main(Model model,String pageNum, String pageName, HttpSession session) throws SQLException, JsonProcessingException {
		

		List<Object> itemMapList = commonsService.getEntireList();
		model.addAttribute("itemMapList", itemMapList);
		System.out.println(itemMapList);
		

		return "main/main";
	}
	
	@RequestMapping(value="getListData.com", produces = "application/json")
	@ResponseBody
	public List<Object> getListData() throws JsonProcessingException {
		
		List<Object> jsonArray = commonsService.getEntireList();
		String jsonString = jsonArray.toString();

		System.out.println(jsonString);	
		return jsonArray;

	}
	

	@RequestMapping("content.com")
	public String content(int item_num) {
		
	
		return "main/content";
	}
	
	@RequestMapping("endContent.com")
	public String endContent(Model model, String pageNum) throws SQLException {
		String pageName = "endContent";
		ListData data = commonsService.getListData(pageName,pageNum,controllerName);
		commonsService.setListDataToModel(model, data);
		return "main/endContent";
	}
	
	
	

	// buy페이지에서 만들어놓은 해당 구매 상품 정보 가져오는거 사용
	@RequestMapping("itemDetail.com")
	public String itemDetail(int item_num,Model model,String pageNum) throws SQLException {
		if (pageNum == null) pageNum = "1";
		
		System.out.println("item_num : " + item_num);
		ItemDTO article = shopService.getItemOne(item_num, pageNum, model);
		ShopDTO shopInfo = shopService.getShopDataSV(article.getShop_num());
		
		model.addAttribute("article", article);
		model.addAttribute("shopInfo", shopInfo);
		
		return "shop/itemDetail";
	}
	
	
	
	
	

}
