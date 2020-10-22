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
	public String main(Model model,String pageNum, String pageName, HttpSession session) throws SQLException {
		System.out.println("controller 잘 연결 ");
		
		//List<Object> itemMapList = commonsService.getEntireList();
		
		//System.out.println("itemMapList의 길이 :" + itemMapList.size());
		//model.addAttribute("itemMapList", itemMapList);
		
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
	public String content() {
		
		System.out.println("controller 잘 연결 ");
		return "main/content";
	}
	
	
	
	
	

}
