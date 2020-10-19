package com.three.psyco.service.bean;

import java.io.File; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dao.ReviewDAO;
import com.three.psyco.model.dao.ReviewDAOImpl;
import com.three.psyco.model.dto.ReviewDTO;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDAOImpl reviewDAO=null;
	
//	후기 등록
	@Override
	public void insertReviews(MultipartHttpServletRequest request, int Shop_num, String writer) throws SQLException {
		ReviewDTO dto=new ReviewDTO();
		//memberDAO에서 writer의 고유번호를 들고옴 그리고 set으로 담아준다.
		int ref =0;
		String confirm="0";
		HttpSession session=request.getSession(); // 로그인시 아이뒤가 들어오게!!!!!!!!!!!!!!!!!!!!!!!
		String member_id=(String)session.getAttribute("memId");
		System.out.println("member_id ="+member_id);
		String category=request.getParameter("category");
		System.out.println("category =" + category);
		String content=request.getParameter("content");
		String grade=request.getParameter("grade");
		System.out.println("grade =" + grade);
		String reply_content=request.getParameter("reply_content");
		MultipartFile mf =request.getFile("review_img");
		try {
			String path=request.getRealPath("review_img");
			System.out.println("path ="+path);
			String orgName=mf.getOriginalFilename();
			System.out.println("orgName ="+orgName);
			String imgName=orgName.substring(0,orgName.lastIndexOf('.'));
			System.out.println("imgName ="+imgName);
			String ext= orgName.substring(orgName.indexOf('.'));
			System.out.println("ext ="+ext);
			Long date =System.currentTimeMillis();
			String newName=imgName+date+ext;
			System.out.println("newName ="+newName);
			String imgPath=path+"\\"+newName;
			System.out.println("imgPath ="+imgPath);
			File file =new File(imgPath);
			mf.transferTo(file);
			dto.setReview_img(newName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		dto.setConfirm(confirm);
		dto.setContent(content);
		dto.setRef(ref);
		dto.setCategory(category);
		dto.setGrade(grade);
		dto.setReply_content("이용해주셔서 감사합니다.");
		dto.setShop_num(Shop_num);
		dto.setMember_id("gogo");
		dto.setWriter(writer);
		reviewDAO.insertReview(dto);
	}

	// 후기 리스트
	@Override
	public List getReviews(int startRow,int endRow,String member_id) throws SQLException {
		List list=reviewDAO.getReview(startRow,endRow,member_id);
		return list;
	}

	@Override
	public int getReviewc()throws SQLException {
		int count=reviewDAO.getCount();
			return count;
		
	}

	@Override
	public ReviewDTO getReviewDetails(int num) throws SQLException {
		ReviewDTO dto=reviewDAO.getReviewDetail(num);
		return dto;
	}

		//ref , reply ,confirm 1 일 경우와 0일 경우 나눠야함!
	@Override
	public void updateReviews(MultipartHttpServletRequest request) throws SQLException {
		ReviewDTO dto=new ReviewDTO();
		int review_num=Integer.parseInt(request.getParameter("review_num"));
		int ref=Integer.parseInt(request.getParameter("ref"));
		int shop_num=Integer.parseInt(request.getParameter("shop_num"));
		String writer=request.getParameter("writer");
		String category=request.getParameter("category");
		String content=request.getParameter("content");
		String grade=request.getParameter("grade");
		String confirm=request.getParameter("confirm");
		String reply_content=request.getParameter("reply_content");
		String member_id=request.getParameter("member_id");
		String shop_name=request.getParameter("shop_name");
		MultipartFile mf = request.getFile("review_img");
		try {
			String path=request.getRealPath("reivew_img");
			System.out.println("path ="+path);
			String orgName =mf.getOriginalFilename();
			System.out.println("orgName ="+orgName);
			String imgName =orgName.substring(0, orgName.lastIndexOf('.'));
			System.out.println("imgName ="+imgName);
			String ext = orgName.substring(orgName.lastIndexOf('.'));
			System.out.println("ext ="+ext);
			Long date=System.currentTimeMillis();
			String newName=imgName+date+ext;
			System.out.println("newName ="+newName);
			String imgPath = path+"\\"+newName;
			File file=new File(imgPath);
			mf.transferTo(file);
			dto.setReview_img(newName);
			System.out.println("dto="+dto.getReview_img());
		}catch(Exception e) {
			e.printStackTrace();
		}
		dto.setCategory(category);
		dto.setConfirm(confirm);
		dto.setContent(content);
		dto.setGrade(grade);
		dto.setMember_id(member_id);
		dto.setReview_num(review_num);
		dto.setShop_name(shop_name);
		dto.setShop_num(shop_num);
		dto.setWriter(writer);
		reviewDAO.updateReview(dto);

	}


}