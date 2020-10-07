package com.three.psyco.controller.bean;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.three.psyco.model.dao.SuperDAO;
import com.three.psyco.model.dto.MemberDTO;
import com.three.psyco.service.bean.SuperService;



@EnableWebMvc
@Controller
@RequestMapping("/super/")
public class SuperBean {
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	
	@Autowired SuperService superService = null;
	
	@RequestMapping("memberList")
	public String memberList(String pageNum, Model model) throws SQLException {
		
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		
		int number = 0; //(게시판에 보여주기식 글번호 )
		
		
		
		
		
		
		
		MemberDTO dto = null;
		
		List memberList =null;
		
		
		
		int count = superService.getMemberCountSV();	
		
		if(count >0) {
			memberList = superService.getMemberListSV(startRow, endRow);
			
		}
		
		System.out.println("count : " + count);
		System.out.println("memberList size : " + memberList.size() );
		
		
		number = count - (currPage-1) * pageSize;
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("currPage", new Integer(currPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("number", new Integer(number));
		model.addAttribute("memberList", memberList);
		model.addAttribute("count", count);
		
		
	
		
		return "super/sMemberList";
	}
	

}
