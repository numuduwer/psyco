package com.three.psyco.controller.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.three.psyco.model.dto.TestDTO;

@EnableWebMvc
@Controller
public class CommunityBean {
	
	
	
	@RequestMapping("community.com")
	public String community() {
		System.out.println("zz");
		return "community/community";
	}
	
	
	
}
