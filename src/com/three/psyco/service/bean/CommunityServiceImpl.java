package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.three.psyco.model.dao.CommunityDAO;
import com.three.psyco.model.dao.CommunityDAOImpl;
import com.three.psyco.model.dto.CommunityDTO;

@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private CommunityDAOImpl communityDAO = null;

	@Override
	public void insertArticleSv(CommunityDTO dto) throws SQLException {
		communityDAO.insertArticle(dto);
		
	}

	@Override
	public Map getPageData(String pageNum) throws SQLException {
		return null;
	}

	@Override
	public int getArticleCountSv(String category) throws SQLException {
		
		int count = communityDAO.getArticleCount(category);
		
		return count;
	}

	@Override
	public List getArticlesSv(int start, int end, String category) throws SQLException {
		List articles = communityDAO.getArticles(start, end, category);
		return articles;
	}
	
	@Override
	public List getArticlesImg(String category) throws SQLException{
		
		List getArticlesImg = communityDAO.getArticlesImg(category);

		
		return getArticlesImg;
	}

	@Override
	public CommunityDTO getArticleSv(int community_num) throws SQLException {
		
		CommunityDTO article = communityDAO.getArticle(community_num);
		
		return article;
	}

	@Override
	public CommunityDTO getArticleForUpdateSv(int num) throws SQLException {
		return null;
	}

	@Override
	public int updateArticleSv(CommunityDTO dto) throws SQLException {
		return 0;
	}

	@Override
	public int deleteArticleSv(CommunityDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMyArticleCountSv(String id) throws SQLException {
		return 0;
	}

	/* 고객센터 */
	
	@Override
	public int getAskCountSv(String category) throws SQLException {
		int count = communityDAO.getAskCount(category);
		
		return count;
	}

	@Override
	public CommunityDTO getAskSv(int community_num) throws SQLException {
		
		CommunityDTO article = communityDAO.getArticle(community_num);
		
		return article;
	}
	
	@Override
	public void insertHelpSv(CommunityDTO dto) throws SQLException {
		
		communityDAO.insertHelp(dto);
	}

	@Override
	public List getMyAskSv(String category) throws SQLException {
		
		return null;
	}
	
	@Override
	public HashMap abc(String pageNum, String category) throws SQLException {
		
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
		
		count = communityDAO.getAskCount(category);
		
		helpList = communityDAO.getAllAsk(start, end, category);
		number = count - (currPage -1) * pageSize;
		
		HashMap map = new HashMap();
		map.put("helpList", helpList);
		map.put("pageSize", currPage);
		map.put("count", count);
		
		return map;
	}

}
