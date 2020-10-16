package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.ShopDTO;

public interface ShopService {
	public ShopDTO getShopDataSV(int id) throws SQLException ;
	public int updateShopDataSV(ShopDTO dto) throws SQLException;
	
	
	
	public ListData getItemList(String pageName, String pageNum, int id) throws SQLException;
	
	

}
