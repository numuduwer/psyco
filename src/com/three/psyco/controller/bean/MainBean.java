package com.three.psyco.controller.bean;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
	public String main(Model model,String pageNum, String pageName) throws SQLException {
		System.out.println("controller 잘 연결 ");
		
		ListData data = commonsService.getListData(pageName,pageNum,controller);
		commonsService.setListDataToModel(model, data);
		
		return "main/main";
	}

	
	
	
	
	
	
	
	@RequestMapping("test.com")
	public String layout() {
		System.out.println("controller 잘 연결 ");
		

		return "test";
	}
	
	
	
	
	

}
