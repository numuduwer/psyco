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
import com.three.psyco.model.dto.JoinResultDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.MainServiceImpl;

import com.three.psyco.service.bean.Scheduler;




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
	public static String controller = "mainBean";
	
	@Autowired
	public Scheduler scheduler = null;
	
	@RequestMapping("main.com")
	public String main(Model model,String pageNum, String pageName, HttpSession session) throws SQLException {
		System.out.println("controller 잘 연결 ");
		
		//List<Object> itemMapList = commonsService.getEntireList();
		//System.out.println("itemMapList의 길이 :" + itemMapList.size());
		//model.addAttribute("itemMapList", itemMapList);

	//	List<JoinResultDTO> itemList = commonsService.getEntireList();	
		ListData data = commonsService.getListData(pageName,pageNum,controller);
		commonsService.setListDataToModel(model, data);	
		//System.out.println("itemList의 사이즈 : " + itemList.size());
		//model.addAttribute("itemList", itemList);
		return "main/main";
	}
	
	@RequestMapping(value="getListData.com", method=RequestMethod.POST)
	@ResponseBody
	public String getListData() throws JsonProcessingException {
		List<Object> jsonArray = commonsService.getEntireList();
		String jsonString = jsonArray.toString();
		System.out.println(jsonString);	
		return jsonString;
	}
	

	@RequestMapping("content.com")
	public String content(int itemNum, Model model) {
		
		System.out.println("controller 잘 연결 ");
		
		// 임의로 값 지정해서 테스트
		int item_num = 23;
		int shop_num = 1233;
		mainService.getContentInfo(item_num,model);
		mainService.getContentImg(shop_num,model);
		return "main/content";
	}
	
	@RequestMapping("endContent.com")
	public String endContent(Model model, String pageNum) throws SQLException {
		String pageName = "endContent";
		ListData data = commonsService.getListData(pageName,pageNum,controllerName);
		commonsService.setListDataToModel(model, data);
		return "main/endContent";
	}
	
	
	
	
	
	

}
