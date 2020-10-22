package com.three.psyco.controller.bean;

import java.awt.Image;
import java.io.File;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.three.psyco.model.dto.CommunityDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.CommunityServiceImpl;
import com.three.psyco.service.bean.MemberServiceImpl;

@EnableWebMvc
@Controller
public class CommunityBean {
	
	@Autowired
	private CommonsServiceImpl commonsService = null;
	
	@Autowired
	private CommunityServiceImpl communityService = null;
	
	
	
	@RequestMapping("community.com")
	public String community(CommunityDTO dto, Model model,HttpServletRequest request) {
		String category = request.getParameter("category");
		model.addAttribute("category",category);
		
		
		
		return "community/community";
	}
	
	@RequestMapping(value="communityList.com")
	public String communityList(String pageNum,Model model,HttpServletRequest request) throws SQLException {
		
		
		String category = request.getParameter("category");
		
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);
		int startRow = (currPage - 1)*pageSize +1;
		int endRow = currPage * pageSize;
		
		int number = 0;
		
		List articleList = null;
		List viewImg =  null;
		
		int count = communityService.getArticleCountSv(category);
		System.out.println("count : " + count);
		if(count > 0) {
			articleList = communityService.getArticlesSv(startRow, endRow, category);
						
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
		model.addAttribute("category", category);
		

		
		
		return "community/communityList";
	}
	
	


	@RequestMapping("communityForm.com")
	public String communityForm(CommunityDTO dto, HttpServletRequest request, Model model,String pageNum) {
		
		
		String community_num = request.getParameter("community_num");
		String category = request.getParameter("category");
		String grade = request.getParameter("grade");
		model.addAttribute("category", category);
		model.addAttribute("grade", grade);
		model.addAttribute("community_num", community_num);
		model.addAttribute("pageNum", pageNum);
		
		
	
		return "community/communityForm";
	}
	
	
	// 글 저장
	@RequestMapping("communityPro.com")
	public String communityPro(MultipartHttpServletRequest request, Model model,String pageNum,String grade,String category) throws Exception {
		
		

			communityService.insertArticleSv(request, pageNum, grade, category, model);
		
		

		
		return "community/communityPro";
	}
	
	
	@RequestMapping("communityDetail.com")
	public String communityDetail(String pageNum,int community_num, Model model,HttpServletRequest request) throws SQLException {
		
		
		
		CommunityDTO article = communityService.getArticleSv(community_num);
		
		
		
		String category = request.getParameter("category");
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("community_num", community_num);
		model.addAttribute("article", article);
		model.addAttribute("category", category);
		
		
		return "community/communityDetail";
	}
	
	// 사진 변경 있어야하는 페이지(홍보,음식점추천)
	@RequestMapping("communityModifyForm.com")
	public String communityModifyForm(HttpServletRequest request, Model model,String pageNum) throws SQLException {
		
		int community_num = Integer.parseInt(request.getParameter("community_num"));
		String category = request.getParameter("category");
		
		
		CommunityDTO article = communityService.getArticleSv(community_num);
		
		model.addAttribute("community_num", community_num);
		model.addAttribute("category", category);
		model.addAttribute("article", article);
		model.addAttribute("pageNum", pageNum);
		
		return "community/communityModifyForm";
	}
	
	// 사진 변경 있어야하는 페이지(홍보,음식점추천)
	@RequestMapping("communityModifyPro.com")
	public String communityModifyPro(MultipartHttpServletRequest request,String pageNum,Model model) throws SQLException {
		
		



		communityService.updateArticleSv(request, pageNum, model);
		
		return "community/communityModifyPro";
	}
	
	
	
	@RequestMapping("communityModifyForm1.com")
	public String communityModifyForm1(HttpServletRequest request,String pageNum,Model model) throws SQLException {
		
		int community_num = Integer.parseInt(request.getParameter("community_num"));
		String category = request.getParameter("category");
		
		
		CommunityDTO article = communityService.getArticleSv(community_num);
		
		model.addAttribute("community_num", community_num);
		model.addAttribute("category", category);
		model.addAttribute("article", article);
		model.addAttribute("pageNum", pageNum);
		
		
		
		return "community/communityModifyForm1";
	}
	
	@RequestMapping("communityModifyPro1.com")
	public String communityModifyPro1(HttpServletRequest request,CommunityDTO dto,String pageNum,Model model) throws SQLException {

		
		communityService.updateArticleSv1(request, dto, pageNum, model);
		
		return "community/communityModifyPro1";
	}
	
	
	@RequestMapping("communityDeleteForm.com")
	public String communityDeleteForm(HttpServletRequest request,Model model,String pageNum,String category) {
		String community_num = request.getParameter("community_num");
		model.addAttribute("community_num",community_num);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("category",category);
		
		
		return "community/communityDeleteForm";
	}
	
	@RequestMapping("communityDeletePro.com")
	public String communityDeletePro(CommunityDTO dto,String pageNum,Model model,String category) throws SQLException {
		System.out.println("category : " + category);
		communityService.deleteArticleSv(dto);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("category",category);   
		
		return "community/communityDeletePro";
	}
	
	// 고객센터---------------------------------------------------------------
	
		@RequestMapping("help.com")
		public String help(String pageNum, Model model, String category) throws SQLException {
			
			HashMap map = new HashMap();
			
			// map = communityService.abc(pageNum, category);
			ListData data = communityService.abc(pageNum, category);
			commonsService.setListDataToModel(model, data);
			//model.addAttribute("map", map);
			model.addAttribute("category", category);
			model.addAttribute("pageNum", pageNum);
			
			return "community/help";
		}
		
		
		@RequestMapping("helpForm.com")
		public String helpForm(@ModelAttribute("dto") CommunityDTO dto) throws SQLException {
			return "community/helpForm";
		}
		
		@RequestMapping("helpPro.com")
		public String helpPro(CommunityDTO dto) throws SQLException{
			

			communityService.insertHelpSv(dto);
			dto.setCommunity_img("0");
			dto.setCategory("5");
			dto.setGrade("0");
			
			return "community/helpPro";
		}
		
		@RequestMapping("myHelpList.com")
		public String myHelpList(String pageNum, String category, Model model) throws SQLException {
			ListData list = communityService.getMyAskSv(pageNum,category);
			commonsService.setListDataToModel(model,list);

			model.addAttribute("pageNum",pageNum);
			model.addAttribute("category",category);
			
			return "community/myHelpList";
		}
		
		@RequestMapping("helpDetail.com")
		public String helpDetail(Model model, int community_num, String pageNum) throws SQLException {
			
			CommunityDTO article = communityService.getAskSv(community_num);
			
			
			model.addAttribute("pageNum", pageNum);
			model.addAttribute("num", community_num);
			model.addAttribute("article", article);
			
			return "community/helpDetail";
		}
	
		@RequestMapping("communityMyArticle.com")
		public String communityMyArticle(String pageNum, String category, Model model) throws SQLException {
			
			ListData list = communityService.getMyAskSv(pageNum,category);
			commonsService.setListDataToModel(model,list);

			model.addAttribute("pageNum",pageNum);
			model.addAttribute("category",category);
			
			
			
			return "community/communityMyArticle";
		}
	
	
	
	
	
}
