package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.three.psyco.model.dto.ShopDTO;

public interface ShopDAO {
	
	// ShopList.jsp
	public int count(String pageName, int memNum)throws SQLException;
	public List getList(String pageName, int memNum, int startRow, int endRow) throws SQLException;
	
	// ShopDetail.jsp
	public ShopDTO getShopData(int id ) throws SQLException;
	

}
