package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dto.ReviewDTO;

public interface ReviewService {
	
	public int insertReviews(MultipartHttpServletRequest request,int item_num,String writer,int shop_num)throws SQLException;
	
	
	public ReviewDTO getReviewDetails(int review_num) throws SQLException;
	
	public int updateReviews(MultipartHttpServletRequest request)throws SQLException;
	
	public String deleteReviews(int review_num)throws SQLException;
	
}
