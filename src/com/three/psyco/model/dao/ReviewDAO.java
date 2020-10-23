package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dto.ReviewDTO;

public interface ReviewDAO {
	
	public int insertReview(ReviewDTO dto)throws SQLException;

	public List getReview(int startRow,int endRow,String member_id)throws SQLException;

	public int getCount() throws SQLException ;
	
	public ReviewDTO getReviewDetail(int review_num) throws SQLException;
	
	public int updateReview(ReviewDTO dto)throws SQLException;
	
	public String deleteReview(int review_num)throws SQLException;
	
}
