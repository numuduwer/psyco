package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionException;

import com.three.psyco.model.dto.CommunityDTO;
import com.three.psyco.model.dto.ListData;

public interface CommunityDAO {
	
	// 게시글 저장	
	public void insertArticle(CommunityDTO dto) throws SQLException;
	
	// 전체글 개수 검색
	public int getArticleCount(String category) throws SQLException;
	
	// 이미지 가져오기
	public CommunityDTO getArticleImg(int community_num) throws SQLException;
	
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
	
	// 전체 문의글 가져오기
	public List getAllAsk(int start, int end, String category) throws SQLException;
	
	// 문의글 저장	
	public void insertHelp(CommunityDTO dto) throws SQLException;

	// 내글 가져오기
	public List getMyAsk(int start, int end, String category, String writer) throws SQLException;
	
	public int getMyAskCount(String category, String writer) throws SQLException;

	public List getMyAsk2(int start, int end, String category, String writer) throws SQLException;

	public List getArticleDabgle(int community_num,String category);

	public int DabgleCount(int community_num, String category);


	
	

}
