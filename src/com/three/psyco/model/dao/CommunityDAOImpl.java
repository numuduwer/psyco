package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.three.psyco.model.dto.CommunityDTO;

@Repository
public class CommunityDAOImpl implements CommunityDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	

	@Override
	public void insertArticle(CommunityDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map getPageData(String pageNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getArticleCount() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getArticles(int start, int end) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommunityDTO getArticle(int num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommunityDTO getArticleForUpdate(int num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateArticle(CommunityDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteArticle(CommunityDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMyArticleCount(String id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
