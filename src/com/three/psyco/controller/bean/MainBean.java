package com.three.psyco.controller.bean;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@Controller
@RequestMapping("/main/")
public class MainBean {
	
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	

	
	@RequestMapping("main.com")
	public String main() {
		System.out.println("controller 잘 연결 ");
		return "main/main";
	}
	
	@RequestMapping("content.com")
	public String content() {
		
		System.out.println("controller 잘 연결 ");
		return "main/content";
	}
	

}
