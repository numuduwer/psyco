package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.three.psyco.model.dto.CommunityDTO;

public interface CommunityService {
	
	// 게시글 저장	
	public void insertArticleSv(CommunityDTO dto) throws SQLException;
	
	// 페이지 관련 정보 가져오기 
	public Map getPageData(String pageNum) throws SQLException;
	
	// 전체글 개수 검색
	public int getArticleCountSv(String category) throws SQLException;
	
	// 이미지 가져오기
	public CommunityDTO getArticleImg(int community_num) throws SQLException;
	
	// 게시글 범위 지정 가져오기 
	public List getArticlesSv(int start, int end, String category) throws SQLException;
	
	// 게시글 한개 정보 가져오기  (조회수 up 0) 
	public CommunityDTO getArticleSv(int community_num) throws SQLException;
	
	// 게시글 한개 정보 가져오기 	(조회수 up x)
	public CommunityDTO getArticleForUpdateSv(int num) throws SQLException;
	
	// 게시글 수정 
	public int updateArticleSv(CommunityDTO dto) throws SQLException;
	
	// 게시글 삭제 
	public int deleteArticleSv(CommunityDTO dto) throws SQLException;

	int getMyArticleCountSv(String id) throws SQLException;
	// <고객센터>
	// 문의 개수 검색
	public int getAskCountSv(String category) throws SQLException;
	
	// 문의 하나 가져오기
	public CommunityDTO getAskSv(int community_num) throws SQLException;

	// 문의 글 작성
	public void insertHelpSv(CommunityDTO dto) throws SQLException;

	// 내 문의 가져오기
	public List getMyAskSv(String category) throws SQLException;
	
	public HashMap abc(String pageNum, String category) throws SQLException;
	
}
