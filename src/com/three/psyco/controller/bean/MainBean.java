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



@Controller
@RequestMapping("/main/")
public class MainBean {
	
	@Autowired
	private CommonsServiceImpl commonsService = null;
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@Autowired
	public static String controller = "mainBean";

	
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
		
		
		return jsonArray;
	}
	

	@RequestMapping("content.com")
	public String content(int item_num) {
		
		
		
		
		return "main/content";
	}
	
	
	
	
	

}
