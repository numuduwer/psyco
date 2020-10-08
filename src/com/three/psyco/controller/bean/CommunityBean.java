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
import com.three.psyco.service.CommunityServiceImpl;

@EnableWebMvc
@Controller
public class CommunityBean {
	
	@Autowired
	private CommunityServiceImpl communityService = null;
	
	@RequestMapping("community.com")
	public String community(CommunityDTO dto, Model model) {
		
		
		
		
		return "community/community";
	}
	
	@RequestMapping(value="communityList.com")
	public String communityList(String pageNum,Model model, String category) throws SQLException {
		
		
		
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
		model.addAttribute("category", category);
		
		CommunityDTO dto = (CommunityDTO) articleList.get(0);
		
		
		
		
		return "community/communityList";
	}
	
	
	@RequestMapping("communityForm.com")
	public String communityForm(CommunityDTO dto, HttpServletRequest request, Model model) {
		
		
		
		int category = Integer.parseInt(request.getParameter("category"));
		String grade = request.getParameter("grade");
		model.addAttribute("category", category);
		model.addAttribute("grade", grade);
		
		
	
		return "community/communityForm";
	}
	
	
	// 글 저장
	@RequestMapping("communityPro.com")
	public String communityPro(MultipartHttpServletRequest request) throws Exception {
		
		CommunityDTO dto = new CommunityDTO();
		int a = Integer.parseInt(request.getParameter("category"));
		
			// - 파일 정보 꺼내기
			MultipartFile mf = null;
		if(request.getFile("img") == null) {

		
		}	
			try { 
				mf = request.getFile("img");
				String path = request.getRealPath("save");
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
					if(a != 1) {
						dto.setCommunity_img(newName);
					}else {
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
	//				System.out.println(newName);
	//				System.out.println(newName1);
	//				
	//				System.out.println(path);
	//				System.out.println(mf.getOriginalFilename()); //이미지 원본 이름
	//				String imgPath = path + "\\" + newName;
	//				System.out.println(imgPath);
	//				File copyFile = new File(imgPath);
	//				mf.transferTo(copyFile);
					
					dto.setSubject(request.getParameter("subject"));
					dto.setContent(request.getParameter("content"));
					dto.setGrade(request.getParameter("grade"));
					dto.setWriter(request.getParameter("writer"));
					if(a != 1) {
						dto.setCommunity_img(newName);
					}else {
						dto.setCommunity_img(newName1);
					}
					dto.setCategory(request.getParameter("category"));

				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}

		communityService.insertArticleSv(dto);
		
		
		
		return "community/communityPro";
	}
	
	
	@RequestMapping("communityDetail.com")
	public String communityDetail(String pageNum,int community_num, Model model) throws SQLException {
		
		
		
		CommunityDTO article = communityService.getArticleSv(community_num);
		
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("num", community_num);
		model.addAttribute("article", article);
		
		
		return "community/communityDetail";
	}
	
	
	
	
	
	
	
}
