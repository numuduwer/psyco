package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.three.psyco.model.dto.CommunityDTO;

public interface CommunityDAO {
	
	// 게시글 저장	
	public void insertArticle(CommunityDTO dto) throws SQLException;
	
	// 페이지 관련 정보 가져오기 
	public Map getPageData(String pageNum) throws SQLException;
	// 전체글 개수 검색
	public int getArticleCount() throws SQLException;
	
	// 게시글 범위 지정 가져오기 
	public List getArticles(int start, int end) throws SQLException;
	
	// 게시글 한개 정보 가져오기  (조회수 up 0) 
	public CommunityDTO getArticle(int num) throws SQLException;
	
	// 게시글 한개 정보 가져오기 	(조회수 up x)
	public CommunityDTO getArticleForUpdate(int num) throws SQLException;
	
	// 게시글 수정 
	public int updateArticle(CommunityDTO dto) throws SQLException;
	
	// 게시글 삭제 
	public int deleteArticle(CommunityDTO dto) throws SQLException;

	int getMyArticleCount(String id) throws SQLException;
	
	
}
