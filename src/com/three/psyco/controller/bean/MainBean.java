package com.three.psyco.controller.bean;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.three.psyco.model.dto.JoinResultDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.Scheduler;



@Controller
@RequestMapping("/main/")
public class MainBean {
	
	@Autowired
	private CommonsServiceImpl commonsService = null;
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@Autowired
	public static String controller = "mainBean";
	
	@Autowired
	public Scheduler scheduler = null;
	
	@RequestMapping("main.com")
	public String main(Model model,String pageNum, String pageName, HttpSession session) throws SQLException {
		System.out.println("controller 잘 연결 ");
		//int mem_num = Integer.valueOf((String)session.getAttribute("memNum"));
		
		//ListData data = commonsService.getListData(pageName,pageNum,controller);
		//commonsService.setListDataToModel(model, data);
		
		List<JoinResultDTO> itemList = commonsService.getEntireList();
		
		ListData data = commonsService.getListData(pageName,pageNum,controller);
		commonsService.setListDataToModel(model, data);	

		System.out.println("itemList의 사이즈 : " + itemList.size());
		model.addAttribute("itemList", itemList);
		

		return "main/main";
	}
	

	@RequestMapping("content.com")
	public String content(int itemNum, Model model) {
		
		System.out.println("controller 잘 연결 ");
		return "main/content";
	}
	
	
	
	
	
	
	

}
