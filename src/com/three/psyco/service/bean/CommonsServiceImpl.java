package com.three.psyco.service.bean;

import java.sql.SQLException; 

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import org.springframework.web.servlet.mvc.Controller;

import com.three.psyco.controller.bean.ShopBean;
import com.three.psyco.model.dao.BuyDAOImpl;
import com.three.psyco.model.dao.ItemDAOImpl;
import com.three.psyco.model.dao.MenuDAO;
import com.three.psyco.model.dao.MenuDAOImpl;
import com.three.psyco.model.dao.ReviewDAOImpl;
import com.three.psyco.model.dao.ShopDAOImpl;
import com.three.psyco.model.dao.SuperDAOImpl;
import com.three.psyco.model.dto.JoinResultDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.MenuDTO;



@Service
public class CommonsServiceImpl implements CommonsService {

	@Autowired
	private ReviewServiceImpl reviewService = null;
	
	@Autowired
	private SuperServiceImpl superService = null;
	
	@Autowired BuyServiceImpl buyService = null;
	
	@Autowired
	private ShopServiceImpl shopService = null;
	
	
	@Autowired
	private ShopDAOImpl shopDAO = null;

	@Autowired
	private ItemDAOImpl itemDAO = null;
	
	@Autowired
	private MenuDAOImpl menuDAO = null;
	
	@Autowired
	private ReviewDAOImpl reviewDAO =null;
	
	@Autowired
	private BuyDAOImpl buyDAO =null;


	
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
	
	
		

	public ListData getListData(String pageName, String pageNum) throws SQLException {
		// 디폴트 값 설정 
		if(pageNum == null) {
			pageNum = "1";
		}
		if(pageName == null) {
			pageName = "sMemberList";
		}
		System.out.println("list pageName :" + pageName);
		System.out.println("list pageNum :" + pageNum);
		
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
	

	public ListData getListData(String pageName, String pageNum,int shop_num, String controller) throws SQLException{
		// 디폴트 값 설정 
		if(pageNum == null) {
			pageNum = "1";
		}

		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		List articleList = null;
		
		int count = 0;
		
		// 글 갯수 불러오기 
		if(controller.equals("shopBean")) {
			count = shopDAO.count(pageName, shop_num);
		}
		if(count >0) {
			
				articleList = shopDAO.getList(pageName, shop_num,startRow, endRow);
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
	
	
	
	
	// main 조건 상관없이 테이블 모든 글 가져오기
	public ListData getListData(String pageName, String pageNum, String controller) throws SQLException {
		// 디폴트 값 설정 
		if(pageNum == null) {
			pageNum = "1";
		}
		if(pageName == null) {
			pageName = "itemList";
		}
		System.out.println("commons Serrvice pageName : " + pageName);
		
		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		List articleList = null;
		
		int count = 0;
		
		// 글 갯수 불러오기 
		if(controller.equals("mainBean")) {
			count = itemDAO.count();
		}
		
	
		if(count >0) {
			articleList = itemDAO.getList(pageName);	
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
		String member_id ="gogo";
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
			 articleList = reviewDAO.getReview(startRow, endRow, member_id);
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

	//구매 리스트
	@Override
	public ListData getbuyData(String pageNum,int member_num) throws SQLException {
		// 디폴트 값 설정 
		System.out.println("member_num2=="+member_num);
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
		int count =  buyService.getBuyCounts();
		System.out.println("list Test count :" + count);
		
		// 글 있으면 전부 가져오기
		if(count >0) {
			articleList = buyDAO.getBuyList(startRow, endRow, member_num);
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
	@Override
	public ListData getShopNumLists(String pageNum,List list) throws SQLException{
		// 디폴트 값 설정 
		if(pageNum == null) {
			pageNum = "1";
		}

		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		List articleList = null;
		int shop_num = 0;
		
		
		for(int i = 0; i <list.size() ; i++) {
			System.out.println("service list : " + list.get(i));
			
		}
		// 글 갯수 불러오기 
		int	count = shopDAO.ShopNumcount(list);
		if(count >0) {
		
				articleList = shopDAO.getShopNumList(list,startRow, endRow);
	
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
	

	@Override
	public List<Integer> getMyShop_MemberNumList(int member_Num) throws SQLException {
		List<Integer> myShop_ShopNumList = shopDAO.getMyShop_ShopNumList(member_Num);
		return myShop_ShopNumList;
	}
	
	@Override
	public List<MenuDTO> getMyMenuListFromShopNum(List<Integer> myShop_ShopNumList) {
		List<MenuDTO> menuList = menuDAO.getMyMenuListFromShopNum(myShop_ShopNumList);
		return menuList;
		
	}
	
	


	@Override
	public List<JoinResultDTO> getEntireList() {
		List<JoinResultDTO> itemList = itemDAO.getEntireList();
	
		
		return itemList;
	}




	

}
