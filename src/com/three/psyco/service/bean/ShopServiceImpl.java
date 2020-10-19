package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.psyco.model.dao.MenuDAOImpl;
import com.three.psyco.model.dao.ShopDAOImpl;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.MenuDTO;
import com.three.psyco.model.dto.ShopDTO;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDAOImpl shopDAO = null;
	
	@Autowired
	private MenuDAOImpl menuDAO = null;
	

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
	
	
	
	

}
