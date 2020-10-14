package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.psyco.model.dao.CommunityDAO;
import com.three.psyco.model.dao.CommunityDAOImpl;
import com.three.psyco.model.dto.CommunityDTO;

@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private CommunityDAOImpl commnuityDAO = null;

	@Override
	public void insertArticleSv(CommunityDTO dto) throws SQLException {
		commnuityDAO.insertArticle(dto);
		
	}

	@Override
	public Map getPageData(String pageNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
	public int updateArticleSv(CommunityDTO dto) throws SQLException {
		
		commnuityDAO.updateArticle(dto);
		
		return 0;
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

}