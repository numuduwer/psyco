package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.three.psyco.model.dao.ItemDAOImpl;
import com.three.psyco.model.dao.ShopDAOImpl;
import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.ShopDTO;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDAOImpl shopDAO = null;
	
	@Autowired
	private ItemDAOImpl itemDAO = null;

	@Override
	public ShopDTO getShopDataSV(int id) throws SQLException {
		
		ShopDTO data = shopDAO.getShopData(id);
		return data;
	}
	@Override
	public int updateShopDataSV(ShopDTO dto) throws SQLException {
		int result = 0 ;	
		shopDAO.updateShopData(dto);
		result = 1;
		return result;
	}
	
	public ListData getItemList(String pageName, String pageNum, int id) throws SQLException{
		// 디폴트 값 설정 
		if(pageNum == null) {
			pageNum = "1";
		}
		if(pageName == null) {
			pageName = "itemList";
		}
		System.out.println("commons Serrvice pageName : " + pageName);
		System.out.println("commons Serrvice id : " + id);
		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		List articleList = null;
		
		int count = 0;
		
	
		count = itemDAO.count1(id);
		System.out.println("MyItemListcount : " + count);
	
		if(count >0) {
			articleList = itemDAO.getItemList(id,startRow, endRow);	
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
	public ItemDTO getItemOne(int item_num, String pageNum, Model model) throws SQLException {
		String pageName = "itemOne";
		System.out.println("itemOne Service : " + pageName);
		ItemDTO article = itemDAO.getItemOne(item_num);
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("item_num",item_num);
		
		return article;
	}
	
	@Override
	public int itemModifyAticle(ItemDTO dto, Model model,int item_num) {
		
		int result = itemDAO.itemModifyAticle(dto);
		
		model.addAttribute("result",result);
		model.addAttribute("item_num",item_num);
		
		return result;
	}
	
	@Override
	public int itemDeleteAticle(int item_num, String pageNum, Model model) {
		
		int result = itemDAO.itemDeleteAticle(item_num);
		
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("result",result);
		
		return result;
	}
	
	
	
	
	
	

}
