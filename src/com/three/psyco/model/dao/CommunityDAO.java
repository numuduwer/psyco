package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionException;

import com.three.psyco.model.dto.CommunityDTO;

public interface CommunityDAO {
	
	// 게시글 저장	
	public void insertArticle(CommunityDTO dto) throws SQLException;
	
	// 페이지 관련 정보 가져오기 
	public Map getPageData(String pageNum) throws SQLException;
	// 전체글 개수 검색
	public int getArticleCount(String category) throws SQLException;
	
	// 이미지 가져오기
	public List getArticlesImg(String category) throws SQLException;
	
	// 게시글 범위 지정 가져오기 
	public List getArticles(int start, int end, String category) throws SQLException;
	
	// 게시글 한개 정보 가져오기  (조회수 up 0) 
	public CommunityDTO getArticle(int community_num) throws SQLException;
	
	// 게시글 한개 정보 가져오기 	(조회수 up x)
	public CommunityDTO getArticleForUpdate(int num) throws SQLException;
	
	// 게시글 수정 
	public int updateArticle(CommunityDTO dto) throws SQLException;
	
	// 게시글 삭제 
	public int deleteArticle(CommunityDTO dto) throws SQLException;

	int getMyArticleCount(String id) throws SQLException;

	// 고객센터
	
	// 전체문의 개수 검색
	public int getAskCount(String category) throws SQLException;
		
	// 문의 글 하나 가져오기
	public CommunityDTO getAsk(int community_num) throws SQLException;
	
	// 문의 리스트 가져오기
	public List getAllAsk(int start, int end) throws SQLException;
	
	// 문의글 저장	
	public void insertHelp(CommunityDTO dto) throws SQLException;

	
	//
	
}
