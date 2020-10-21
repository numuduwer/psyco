package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.three.psyco.model.dto.MenuDTO;

public interface MenuDAO {

	public List<MenuDTO> getMyMenuListFromShopNum(List<Integer> myShop_ShopNumList);
	
	public MenuDTO getMenuInfoFromMenuNum(int menu_num) throws SQLException;
}
