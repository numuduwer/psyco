package com.three.psyco.service.bean;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dto.CommunityDTO;
import com.three.psyco.model.dto.ListData;

public interface CommunityService {
	
	// 게시글 저장	
	public void insertArticleSv(MultipartHttpServletRequest request, String pageNum, String grade, String category,Model model) throws SQLException;
	
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
	public int updateArticleSv(MultipartHttpServletRequest request, String pageNum, Model model) throws SQLException;
	
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
	public ListData getMyAskSv(String pageNum,String category) throws SQLException;
	
	public ListData abc(String pageNum, String category) throws SQLException;
	
	public int getMyAskCount(String category, String writer) throws SQLException;

	

	

	
	
}
