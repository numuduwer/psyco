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
import com.three.psyco.service.bean.MainServiceImpl;



@Controller
@RequestMapping("/main/")
public class MainBean {
	
	@Autowired
	private CommonsServiceImpl commonsService = null;
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@Autowired
	private MainServiceImpl mainService = null;
	
	@Autowired
	public static String controller = "mainBean";

	
	@RequestMapping("main.com")
	public String main(Model model,String pageNum, String pageName) throws SQLException {
		System.out.println("controller 잘 연결 ");
		
		ListData data = commonsService.getListData(pageName,pageNum,controller);
		commonsService.setListDataToModel(model, data);
		
		return "main/main";
	}
	

	@RequestMapping("content.com")
	public String content(Model model) throws SQLException {
		// 나중에 페이지 콘텐트 페이지 전 페이지랑 연결되면 매개변수 item_num 이랑 shop_num 받아야함.
		System.out.println("controller 잘 연결 ");
		
		// 임의로 값 지정해서 테스트
		int item_num = 23;
		int shop_num = 1233;
		
		
		mainService.getContentInfo(item_num,model);
		mainService.getContentImg(shop_num,model);
		
		
		return "main/content";
	}
	
	
	
	
	

}
