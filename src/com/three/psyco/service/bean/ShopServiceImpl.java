package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.psyco.model.dao.ShopDAOImpl;
import com.three.psyco.model.dto.ListData;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDAOImpl shopDAO = null;

	public ListData getListData(String pageName, String pageNum, int memNum) throws SQLException{
		// 디폴트 값 설정 
		if(pageNum == null) {
			pageNum = "1";
		}
		if(pageName == null) {
			pageName = "shopList";
		}
		System.out.println("Service  pageNum :"+pageNum);
		System.out.println("Service  pageName :"+pageName);
	
		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		List articleList = null;
		
		int count = 0;
		
		// 글 갯수 불러오기 
		if(pageName.equals("shopList")) {
			count =  shopDAO.count(pageName,memNum);
		}
		
	
		if(count >0) {
			articleList = shopDAO.getList(pageName, memNum,startRow, endRow);	
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
