package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dto.ReviewDTO;

public interface ReviewService {
	
	public void insertReviews(MultipartHttpServletRequest request,int Shop_num,String writer)throws SQLException;

	public List getReviews(int startRow,int endRow,String member_id)throws SQLException;
	
	public int getReviewc()throws SQLException;
}
