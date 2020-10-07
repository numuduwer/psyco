package com.three.psyco.controller.bean;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import com.three.psyco.service.CommunityServiceImpl;

@EnableWebMvc
@Controller
public class CommunityBean {
	
	@Autowired
	private CommunityServiceImpl communityService = null;
	
	@RequestMapping("community.com")
	public String community() {
		
		return "community/community";
	}
	
	@RequestMapping("communityList.com")
	public String communityList(String pageNum,Model model) throws SQLException {
		
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);
		int startRow = (currPage - 1)*pageSize +1;
		int endRow = currPage * pageSize;
		
		int number = 0; // 게시판에상의 글번호 뿌려줄 변수 미리 선언 (보여주기 식번호 ) 
		
		List articleList = null;
			
		
		int count = communityService.getArticleCountSv();
		
		if(count > 0) {
			articleList = communityService.getArticlesSv(startRow, endRow);
		}
		number = count  - (currPage-1) *  pageSize;
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currPage", currPage);
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		
		model.addAttribute("number", number);
		model.addAttribute("articleList", articleList);
		
		model.addAttribute("count", count);
		
	
		
		return "community/communityList";
	}
	
	
	
	
	
}
