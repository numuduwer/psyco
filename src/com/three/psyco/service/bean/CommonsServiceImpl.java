package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.three.psyco.model.dto.ListData;



@Service
public class CommonsServiceImpl implements CommonsService {

	@Autowired
	private SuperService superService = null;
	@Autowired
	private ReviewService reviewService = null;
	
	public void setListDataToModel(Model model, ListData data) {
		model.addAttribute("pageNum", data.getPageNum());
		model.addAttribute("pageSize", data.getPageSize());
		model.addAttribute("currPage", data.getCurrPage());
		model.addAttribute("startRow", data.getStartRow());
		model.addAttribute("endRow", data.getEndRow());
		model.addAttribute("number", data.getNumber());
		model.addAttribute("articleList", data.getArticleList());
		model.addAttribute("count", data.getCount());
	}
	
	
	public ListData getListData(String pageName, String pageNum,SuperService superService) throws SQLException {
		
		// 디폴트 값 설정 
		if(pageNum == null) {
			pageNum = "1";
		}
		if(pageName == null) {
			pageName = "sMemberList";
		}
		System.out.println("list Test pageName :" + pageName);
		System.out.println("list Test pageNum :" + pageNum);
		
		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		List articleList = null;
		
		
		// 글 갯수 불러오기 
		int count =  superService.getCountSV(pageName);
		System.out.println("list Test count :" + count);
		
		// 글 있으면 전부 가져오기
		if(count >0) {
			articleList = superService.getListSV(pageName, startRow, endRow);	
		}
		
		number = count - (currPage-1) * pageSize;

		
		ListData data = new ListData();
		
		data.setArticleList(articleList);
		data.setCount(count);
		data.setCurrPage(currPage);
		data.setEndRow(endRow);
		data.setNumber(number);
		data.setPageNum( Integer.parseInt(pageNum));
		data.setPageSize(pageSize);
		data.setStartRow(startRow);
		return data;
		
	}
	
	//후기 리스트
	public ListData getrListData(String pageNum,Model model) throws SQLException {
		//String member_id =(String)RequestContextHolder.getRequestAttributes().getAttribute("memId", RequestAttributes.SCOPE_SESSION);
		// 디폴트 값 설정 
		String member_id = "kimshin";
		if(pageNum == null) {
			pageNum = "1";
		}
		
		
		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		List  articleList = null;
		
		
		// 글 갯수 불러오기 
		int count =  reviewService.getReviewc();
		System.out.println("list Test count :" + count);
		
		// 글 있으면 전부 가져오기
		if(count >0) {
			 articleList = reviewService.getReviews(startRow, endRow,member_id);
		}
		
		number = count - (currPage-1) * pageSize;

		
		ListData data = new ListData();
		data.setArticleList(articleList);
		data.setCount(count);
		data.setCurrPage(currPage);
		data.setEndRow(endRow);
		data.setNumber(number);
		data.setPageNum( Integer.parseInt(pageNum));
		data.setPageSize(pageSize);
		data.setStartRow(startRow);
	

		return data;
		
	}





}
