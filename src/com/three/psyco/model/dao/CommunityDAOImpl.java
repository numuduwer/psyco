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
			
			// 새글 
			dto.setRe_level(0);
			dto.setRe_step(0);
			
		}
		sqlSession.insert("community.insertArticle", dto);
		
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
		System.out.println("list size : " + list.size());
		
		
		return list;
	}
	
	@Override
	public CommunityDTO getArticleImg(int community_num) throws SQLException{
		
		CommunityDTO getArticleImg = sqlSession.selectOne("community.selectImg",community_num);
		


		return getArticleImg;
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

		sqlSession.update("community.updateOne", dto);

		return 0;
	}

	@Override
	public int deleteArticle(CommunityDTO dto) throws SQLException {
		sqlSession.delete("community.deleteOne", dto);
		return 0;
	}

	@Override
	public int getMyArticleCount(String id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// 고객센터 

		@Override
		public List getAllAsk(int start, int end, String category) throws SQLException {
			HashMap map = new HashMap();
			
			map.put("start", start);
			map.put("end", end);
			map.put("category", category);
			
			List list = sqlSession.selectList("community.helpList", map);
			
			return list;
		}

		@Override
		public void insertHelp(CommunityDTO dto) throws SQLException {
			int number = 0;
			String numb = sqlSession.selectOne("community.maxNum");
			if(numb != null) {
				number = Integer.parseInt(numb) + 1;
			}else {
				number = 1;
			}
			dto.setCategory("5");
			dto.setGrade("null");
			dto.setCommunity_img("null");
			
		sqlSession.insert("community.insertHelp", dto);
		
		}
		
		@Override
		public List getMyAsk(int start, int end, String category, String writer) throws SQLException {
			HashMap map = new HashMap();
			map.put("start", start);
			map.put("end", end);
			map.put("category", category);
			map.put("writer", writer);
			
			List list = sqlSession.selectList("community.myHelpList", map);
			
			return list;
		}


		@Override
		public int getAskCount(String category) throws SQLException {
			
			int count = sqlSession.selectOne("community.helpCountAll", category);
			
			return count;
		}

		@Override
		public int getMyAskCount(String category, String writer) throws SQLException {
			HashMap map = new HashMap();
			map.put("category", category);
			map.put("writer", writer);
			
			
			int count = sqlSession.selectOne("community.myHelpCount", map);
			
			return count;
		}
		
		// 내 문의 내역 외에 다른 활동내역 전부 가져오기
		@Override
		public List getMyAsk2(int start, int end, String category, String writer) throws SQLException {
			HashMap map = new HashMap();
			map.put("start", start);
			map.put("end", end);
			map.put("category", category);
			map.put("writer", writer);
			
			List list = sqlSession.selectList("community.myHelpList2", map);
			
			return list;
		}


}
