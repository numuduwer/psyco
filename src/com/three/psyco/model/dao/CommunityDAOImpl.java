package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
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
		// ref에 미리 시퀀스 번호 추적해서 다음 번호로 받아 추가하고 insert
			int number = 0;
			String numb = sqlSession.selectOne("community.maxNum");
			if(numb != null) {
				number = Integer.parseInt(numb) + 1;
				
			}else {
				number = 1;
			}
			// 댓글 
			
			if(dto.getCommunity_num() != 0) {
				// 이전 댓글 step 미리 올리기 
				HashMap map = new HashMap();
				map.put("ref", dto.getRef());
				map.put("re_step", dto.getRe_step());
				
				sqlSession.update("community.updateRestep", map);
				
				dto.setRe_step(dto.getRe_step()+1);
				dto.setRe_level(dto.getRe_level()+1);
				
			}else {
				dto.setRef(number);
				dto.setRe_level(0);
				dto.setRe_step(0);
			}
			
			
		sqlSession.insert("community.insertArticle", dto);
		
	}

	@Override
	public Map getPageData(String pageNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getArticleCount(String category) throws SQLException {

		
		int count = sqlSession.selectOne("community.countAll", category);
		return count;
	}

	@Override
	public List getArticles(int start, int end, String category) throws SQLException {
		HashMap map = new HashMap();
		map.put("start",start);
		map.put("end",end);
		map.put("category",category);
		
		List list = sqlSession.selectList("community.selectAll",map);
		CommunityDTO dto = (CommunityDTO) list.get(0);
		
		
		return list;
	}
	
	@Override
	public List getArticlesImg(String category) throws SQLException{
		
		List getArticlesImg = sqlSession.selectList("community.selectImg",category);
		return getArticlesImg;
	}

	@Override
	public CommunityDTO getArticle(int community_num) throws SQLException {
		
		CommunityDTO article = sqlSession.selectOne("community.selectOne",community_num);
		
		return article;
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
