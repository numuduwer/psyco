package com.three.psyco.controller.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.three.psyco.service.CommunityService;

@Controller
@EnableWebMvc
public class CommunityBean {
	
	@Autowired
	private CommunityService communityService = null;
	
	// 커뮤니티(카테고리) 페이지 이동
	@RequestMapping("community.com")
	public String community() {
		return "community/community";
	}
	
	
}
