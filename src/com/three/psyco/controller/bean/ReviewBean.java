package com.three.psyco.controller.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.ReviewDTO;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.MemberServiceImpl;
import com.three.psyco.service.bean.ReviewServiceImpl;


@Controller
@RequestMapping("/user/")
public class ReviewBean {
	
	@Autowired
	private ReviewServiceImpl reviewService=null;
	
	@Autowired
	private MemberServiceImpl memberService=null;

	@Autowired
	private CommonsServiceImpl commonsService= null;
	
	//후기 등록!	
	@RequestMapping("reviewForm.com") //,int Shop_num 페이지 붙일땐 필요
	public String reviewForm(HttpServletRequest request,Model model,int item_num)throws Exception {
		//int shop_num=Integer.getInteger(request.getParameter("shop_num"));
		HttpSession sessions=request.getSession();
		String session=(String)sessions.getAttribute("memId");
		//String nickname=memberService.getNickNames(session); 붙일때 풀기
		String nicknames="gogo";
		model.addAttribute("nickname", nicknames);
		model.addAttribute("session", session);
		//나중에 필요
		model.addAttribute("item_num", 3);
		return "review/reviewForm";
	}
	//페이지 설정 다시해야할 듯 ! JSP
	@RequestMapping("reviewPro.com")
	public String reviewPro(MultipartHttpServletRequest request,String writer,int item_num,Model model)throws Exception {
		System.out.println(writer);
		System.out.println(item_num);
		reviewService.insertReviews(request, item_num, writer);
		return "review/reviewList";
	}
	//나의 후기 리스트

	@RequestMapping("reviewList.com")
	public String reviewList(String pageNum,Model model) throws SQLException {		
		 
		ListData data=commonsService.getrListData(pageNum, model);
		
		
		model.addAttribute("pageNum",  data.getPageNum());
		model.addAttribute("pageSize", data.getPageSize());
		model.addAttribute("currPage", data.getCurrPage());
		model.addAttribute("startRow", data.getStartRow());
		model.addAttribute("endRow", data.getEndRow());
		model.addAttribute("number", data.getNumber());
		model.addAttribute("count", data.getCount());
		model.addAttribute("articleList", data.getArticleList());
		System.out.println("getArticleList="+data.getArticleList());
		return "review/reviewList";
	}
	
	//리스트 상세보기
	@RequestMapping("reviewDetail.com")
	public String reviewDetail(String pageNum,Model model,int review_num)throws SQLException {
		
		ReviewDTO article=reviewService.getReviewDetails(review_num);
		model.addAttribute("article",article);
		model.addAttribute("pageNum",pageNum);
		return "review/reviewDetail";
	}
	//리스트 수정
	@RequestMapping("reviewModify.com")
	public String reviewModify(int review_num,String pageNum,Model model)throws SQLException {
		
		ReviewDTO article=reviewService.getReviewDetails(review_num);
		model.addAttribute("article",article);
		model.addAttribute("pageNum",pageNum);
		
		
		return "review/reviewModify";
	}
	@RequestMapping("reviewModifyPro.com")
	public String reviewModifyPro(MultipartHttpServletRequest request,int review_num,String pageNum,Model model)throws SQLException {
		int result=reviewService.updateReviews(request);
		model.addAttribute("review_num",review_num);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("result",result);
		
		
		return "review/reviewModifyPro";
	}
	@RequestMapping("reviewDelete.com")
	public String reviewDelete(int review_num,String pageNum,Model model)throws SQLException {
		System.out.println("review_num1="+review_num);
		String res=reviewService.deleteReviews(review_num);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("res",res);
		return "review/reviewDelete";
		
	}
	

}
