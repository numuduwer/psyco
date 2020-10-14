package com.three.psyco.controller.bean;

import java.awt.Image;
import java.io.File;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.three.psyco.model.dto.CommunityDTO;
import com.three.psyco.service.bean.CommunityServiceImpl;
import com.three.psyco.service.bean.MemberServiceImpl;

@EnableWebMvc
@Controller
public class CommunityBean {
	
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
	public String communityPro(MultipartHttpServletRequest request, Model model,String pageNum,String grade) throws Exception {
		
		CommunityDTO dto = new CommunityDTO();
		int category = Integer.parseInt(request.getParameter("category"));
		
		
			// - 파일 정보 꺼내기
			MultipartFile mf = null;
			try { 
				mf = request.getFile("img");
				if(request.getFile("img") == null) {
					String orgName = "asd.asd";
					String imgName = orgName.substring(0, orgName.lastIndexOf('.')); 
					String ext = orgName.substring(orgName.lastIndexOf('.'));
					long date = System.currentTimeMillis();
					String newName = imgName+date+ext;
					String newName1 = "ads"+date;
					dto.setSubject(request.getParameter("subject"));
					dto.setContent(request.getParameter("content"));
					dto.setGrade(request.getParameter("grade"));
					dto.setWriter(request.getParameter("writer"));
					if(category == 3 || category == 4) {
						dto.setCommunity_img(newName);
					}else if(category == 1 || category == 2) {
						dto.setCommunity_img(newName1);
					}
					dto.setCategory(request.getParameter("category"));
				}else {				
					String orgName = mf.getOriginalFilename();					
				
					String imgName = orgName.substring(0, orgName.lastIndexOf('.')); 
					String ext = orgName.substring(orgName.lastIndexOf('.'));
					long date = System.currentTimeMillis();
					String newName = imgName+date+ext;
					String newName1 = "ads"+date;
					dto.setSubject(request.getParameter("subject"));
					dto.setContent(request.getParameter("content"));
					dto.setGrade(request.getParameter("grade"));
					dto.setWriter(request.getParameter("writer"));
					if(category == 3 || category == 4) {
						dto.setCommunity_img(newName);
					}else if(category == 1 || category == 2) {
						dto.setCommunity_img(newName1);
					}
					dto.setCategory(request.getParameter("category"));
				}			
			}catch(Exception e) {
				e.printStackTrace();
			}
		communityService.insertArticleSv(dto);
		model.addAttribute("category",category);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("grade",grade);		
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
	
	
	@RequestMapping("communityModifyPro.com")
	public String communityModifyPro(MultipartHttpServletRequest request,String pageNum,Model model) throws SQLException {
		
		
		CommunityDTO dto = new CommunityDTO();
		int a = Integer.parseInt(request.getParameter("category"));
		int community_num = Integer.parseInt(request.getParameter("community_num"));
		String community_img = request.getParameter("community_img");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		
		CommunityDTO getArticleImg = communityService.getArticleSv(community_num);
		
		if(request.getFile("Newcommunity_img") != null) {
			
		}
		
		
		
		
		try {
			
			

	
				if(community_img != null) {
					dto.setCommunity_img(getArticleImg.getCommunity_img());
					dto.setSubject(subject);
					dto.setCommunity_num(community_num);
					dto.setContent(content);
				}else if(community_img == null){
					MultipartFile mf = null;
					mf = request.getFile("Newcommunity_img");
					String orgName = mf.getOriginalFilename();
					System.out.println(orgName + "dsa");
					String imgName = orgName.substring(0, orgName.lastIndexOf('.')); 
					String ext = orgName.substring(orgName.lastIndexOf('.'));
					long date = System.currentTimeMillis();
					String newName = imgName+date+ext;
					dto.setCommunity_img(newName);
					dto.setSubject(subject);
					dto.setCommunity_num(community_num);
					dto.setContent(content);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		model.addAttribute("pageNum",pageNum);

		communityService.updateArticleSv(dto);
		
		
		
		return "community/communityModifyPro";
	}
	
	
	@RequestMapping("communityDeleteForm.com")
	public String communityDeleteForm(HttpServletRequest request,Model model,String pageNum) {
		String community_num = request.getParameter("community_num");
		model.addAttribute("community_num",community_num);
		model.addAttribute("pageNum",pageNum);
		
		
		return "community/communityDeleteForm";
	}
	
	@RequestMapping("communityDeletePro.com")
	public String communityDeletePro(CommunityDTO dto,String pageNum,Model model) throws SQLException {
		
		communityService.deleteArticleSv(dto);
		model.addAttribute("pageNum",pageNum);
		
		return "community/communityDeletePro";
	}
	
	
	
	
	
	
	
	
	
}
