package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.MenuDTO;
import com.three.psyco.model.dto.ShopDTO;

public interface ShopDAO {

	public int count(String pageName, int memNum)throws SQLException;
	public List getList(String pageName, int memNum, int startRow, int endRow) throws SQLException;
	public ShopDTO getShopData(int id ) throws SQLException;
	public int updateShopData(ShopDTO dto) throws SQLException;
	public List<Integer> getMyShop_ShopNumList(int member_Num) throws SQLException;
	public List getShopNumList(List shop_num,int startRow, int endRow)throws SQLException;
	public int ShopNumcount(List shop_num)throws SQLException; 
	public int deleteShop1(int member_num)throws SQLException;
	public List getShopNum(int member_num)throws SQLException;
	
}
