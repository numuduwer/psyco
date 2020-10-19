package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

<<<<<<< HEAD
import com.three.psyco.model.dao.ItemDAOImpl;
=======
import com.three.psyco.model.dao.MenuDAOImpl;
>>>>>>> master
import com.three.psyco.model.dao.ShopDAOImpl;
import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.MenuDTO;
import com.three.psyco.model.dto.ShopDTO;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDAOImpl shopDAO = null;
	
	@Autowired
<<<<<<< HEAD
	private ItemDAOImpl itemDAO = null;
=======
	private MenuDAOImpl menuDAO = null;
	
>>>>>>> master

	@Override
	public ShopDTO getShopDataSV(int shop_num) throws SQLException {
		
		ShopDTO data = shopDAO.getShopData(shop_num);
		return data;
	}
	@Override
	public int updateShopDataSV(ShopDTO dto) throws SQLException {
		int result = 0 ;	
		shopDAO.updateShopData(dto);
		result = 1;
		return result;
	}
	
<<<<<<< HEAD
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
	public int itemModifyAticle(ItemDTO dto, Model model) {
		
		int result = itemDAO.itemModifyAticle(dto);
		
		model.addAttribute("result",result);
		
		return result;
	}
	
	
	
=======
	public void deleteListSV(int id, String name) {
		if(name.equals("shopNum")){
			shopDAO.deleteShop(id);
		}else if(name.equals("menuNum")){
			menuDAO.deleteMenu(id);
		}
	}
	
	public MenuDTO getMenuDataSV(int shop_num) throws SQLException {
		MenuDTO data = menuDAO.getMenuData(shop_num);
		return data;
	}
	public int  updateMenuDataSV(MenuDTO dto) {
		System.out.println("------service------");
		System.out.println("menu modifyPro dto menu_num : " + dto.getMenu_num());
		System.out.println("menu modifyPro dto menu_name : " + dto.getMenu_name());
		System.out.println("menu modifyPro dto content : " + dto.getContent());
		System.out.println("menu modifyPro dto menu_img : " + dto.getMenu_img());
		System.out.println("menu modifyPro dto price : " + dto.getPrice());
		
		System.out.println("menu modifyPro dto category : " + dto.getCategory());
		System.out.println("menu modifyPro dto season : " + dto.getSeason());
		System.out.println("menu modifyPro dto SETT : " + dto.getSett());
		System.out.println("menu modifyPro dto shop_num : " + dto.getShop_num());
		System.out.println("menu modifyPro dto reg : " + dto.getReg());
		int result = 0;
		result =  menuDAO.updateMenuData(dto);
		return result;
	}
	
>>>>>>> master
	
	
	

}
