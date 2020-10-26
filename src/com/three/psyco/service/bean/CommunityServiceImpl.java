package com.three.psyco.service.bean;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dao.CommunityDAO;
import com.three.psyco.model.dao.CommunityDAOImpl;
import com.three.psyco.model.dto.CommunityDTO;
import com.three.psyco.model.dto.ListData;

@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private CommunityDAOImpl commnuityDAO = null;

	@Override
	public void insertArticleSv(MultipartHttpServletRequest request, String pageNum, String grade, String category,Model model) throws SQLException {
		
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = servletRequestAttribute.getRequest().getSession();
		String writer = (String) session.getAttribute("memId");
		
		
		CommunityDTO dto = new CommunityDTO();
		String subject = request.getParameter("subject");
		if(subject.equals("[댓글]")) {
			dto.setRef(Integer.parseInt(request.getParameter("community_num")));
			dto.setCommunity_num(Integer.parseInt(request.getParameter("community_num")));
			dto.setContent(request.getParameter("content"));
			dto.setSubject(request.getParameter("subject"));
			dto.setGrade("11");
			dto.setWriter(writer);
			dto.setCommunity_img(request.getParameter("writer"));
			dto.setCategory(request.getParameter("category"));
			commnuityDAO.insertArticle(dto);
			model.addAttribute("category",category);
			model.addAttribute("pageNum",pageNum);
		}else {
			// - 파일 정보 꺼내기
		String path = request.getRealPath("save");
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
					if(request.getParameter("grade") == null) {
						dto.setGrade("11");
					}else {
					dto.setGrade(request.getParameter("grade"));
					}
					dto.setWriter(writer);
					if(Integer.parseInt(request.getParameter("category")) == 3 || Integer.parseInt(request.getParameter("category")) == 4) {
						dto.setCommunity_img(newName);
					}else if(Integer.parseInt(request.getParameter("category")) == 1 || Integer.parseInt(request.getParameter("category")) == 2 || Integer.parseInt(request.getParameter("category")) == 6) {
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
					String imgPath = path + "\\" + newName;
					System.out.println(imgPath);
					File copyFile = new File(imgPath);
					mf.transferTo(copyFile);
					dto.setSubject(request.getParameter("subject"));
					dto.setContent(request.getParameter("content"));
					dto.setGrade(request.getParameter("grade"));
					dto.setWriter(writer);
					if(Integer.parseInt(request.getParameter("category")) == 3 || Integer.parseInt(request.getParameter("category")) == 4) {
						dto.setCommunity_img(newName);
					}else if(Integer.parseInt(request.getParameter("category")) == 1 || Integer.parseInt(request.getParameter("category")) == 2 || Integer.parseInt(request.getParameter("category")) == 2) {
						dto.setCommunity_img(newName1);
					}
					dto.setCategory(request.getParameter("category"));
				}			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
			commnuityDAO.insertArticle(dto);
			model.addAttribute("category",category);
			

		}
	}



	@Override
	public int getArticleCountSv(String category) throws SQLException {
		
		int count = commnuityDAO.getArticleCount(category);
		return count;
	}

	@Override
	public List getArticlesSv(int start, int end, String category) throws SQLException {
		List articles = commnuityDAO.getArticles(start, end, category);
		
		return articles;
	}
	
	@Override
	public CommunityDTO getArticleImg(int community_num) throws SQLException{
		
		CommunityDTO getArticleImg = commnuityDAO.getArticleImg(community_num);

		
		return getArticleImg;
	}

	@Override
	public CommunityDTO getArticleSv(int community_num) throws SQLException {
		
		CommunityDTO article = commnuityDAO.getArticle(community_num);
		
		
		return article;
	}

	@Override
	public CommunityDTO getArticleForUpdateSv(int num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateArticleSv(MultipartHttpServletRequest request,String pageNum,Model model) throws SQLException {
		
		CommunityDTO dto = new CommunityDTO();
		String category = request.getParameter("category");
		int community_num = Integer.parseInt(request.getParameter("community_num"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		
		CommunityDTO getArticleImg = commnuityDAO.getArticle(community_num);
		String path = request.getRealPath("save");
		try {
			MultipartFile mf = null;
			mf = request.getFile("community_img");
			String orgName = mf.getOriginalFilename();
			if(orgName == "") {
				orgName = getArticleImg.getCommunity_img();
				long date = System.currentTimeMillis();
				dto.setCommunity_img(orgName);
				dto.setSubject(subject);
				dto.setCommunity_num(community_num);
				dto.setContent(content);
			}else {		
				String imgName = orgName.substring(0, orgName.lastIndexOf('.')); 
				String ext = orgName.substring(orgName.lastIndexOf('.'));
				long date = System.currentTimeMillis();
				String newName = imgName+date+ext;
				String imgPath = path + "\\" + newName;
				System.out.println(imgPath);
				File copyFile = new File(imgPath);
				mf.transferTo(copyFile);
				dto.setCommunity_img(newName);
				dto.setSubject(subject);
				dto.setCommunity_num(community_num);
				dto.setContent(content);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("category",category);
		model.addAttribute("community_num",community_num);
		commnuityDAO.updateArticle(dto);
		
		return 0;
	}
	
	public void updateArticleSv1(HttpServletRequest request,CommunityDTO dto,String pageNum,Model model) throws SQLException {
		
		String category = request.getParameter("category");
		int community_num = Integer.parseInt(request.getParameter("community_num"));
		
		CommunityDTO getArticleImg = commnuityDAO.getArticle(community_num);
		
		dto.setCommunity_img(getArticleImg.getCommunity_img());
		
		
		
		model.addAttribute("category", category);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("community_num",community_num);
		
		commnuityDAO.updateArticle(dto);
		
	}

	@Override
	public int deleteArticleSv(CommunityDTO dto) throws SQLException {
		commnuityDAO.deleteArticle(dto);
		return 0;
	}

	@Override
	public int getMyArticleCountSv(String id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
//-------------------------------------------------------------------	
/* 고객센터 */
	
	@Override
	public int getAskCountSv(String category) throws SQLException {
		int count = commnuityDAO.getAskCount(category);
		
		return count;
	}

	@Override
	public CommunityDTO getAskSv(int community_num) throws SQLException {
		
		CommunityDTO article = commnuityDAO.getArticle(community_num);
		
		return article;
	}
	
	@Override
	public void insertHelpSv(CommunityDTO dto) throws SQLException {
		
		commnuityDAO.insertHelp(dto);
	}

	@Override
	public ListData getMyAskSv(String pageNum, String category) throws SQLException {
		

		if (pageNum == null) pageNum = "1";
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);
		int start = (currPage -1) * pageSize + 1;
		int end = currPage * pageSize;
		int number = 0;	// 게시판 상의 글의 번호 띄어줄 변수
		int count = 0;
		
		List myHelpList = null;
		
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = servletRequestAttribute.getRequest().getSession();
		String writer = (String) session.getAttribute("memId");
		
		count = commnuityDAO.getMyAskCount(category,writer);
		
		myHelpList = commnuityDAO.getMyAsk(start,end,category,writer);
		
		
		number = count - (currPage -1) * pageSize;
		
		ListData data  = new ListData();
		data.setArticleList(myHelpList);
		data.setCount(count);
		data.setCurrPage(currPage);
		data.setEndRow(end);
		data.setNumber(number);
		data.setPageNum(Integer.parseInt(pageNum));
		data.setPageSize(pageSize);
		data.setStartRow(start);
		
		return data;
	}
	
	
	public ListData abc(String pageNum, String category) throws SQLException {
		
		if (category == null) {
			category = "5";
		}
		
		if (pageNum == null) pageNum = "1";
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);
		int start = (currPage -1) * pageSize + 1;
		int end = currPage * pageSize;
		int number = 0;	// 게시판 상의 글의 번호 띄어줄 변수
		int count = 0;
		
		List helpList = null;
		
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = servletRequestAttribute.getRequest().getSession();
		String writer = (String) session.getAttribute("memId");
		
		count = commnuityDAO.getAskCount(category);
		
		helpList = commnuityDAO.getAllAsk(start, end, category);
		number = count - (currPage -1) * pageSize;
		
		ListData data  = new ListData();
		data.setArticleList(helpList);
		data.setCount(count);
		data.setCurrPage(currPage);
		data.setEndRow(end);
		data.setNumber(number);
		data.setPageNum( Integer.parseInt(pageNum));
		data.setPageSize(pageSize);
		data.setStartRow(start);
		return data;
	}

	@Override
	public int getMyAskCount(String category, String writer) throws SQLException {
		
		int count = commnuityDAO.getMyAskCount(category, writer);
		
		return count;
	}

	
	@Override
	public List getArticleDabgle(int community_num,String category) throws SQLException {
		
		List list = commnuityDAO.getArticleDabgle(community_num,category);
		return list;
	}



	public int DabgleCount(int community_num, String category) {
		int count = commnuityDAO.DabgleCount(community_num,category);
		return count;
	}

	

}
