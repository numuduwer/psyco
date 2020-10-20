package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.three.psyco.model.dto.ItemDTO;

public interface ItemDAO {
	
	public int count()throws SQLException;
	
	public List getList(String pageName)throws SQLException;
	
	public ItemDTO getItemOne(int item_num)throws SQLException;
	
	public int count1(int id)throws SQLException;
	
	public List getItemList(int id, int startRow, int endRow)throws SQLException;


	public int itemModifyAticle(ItemDTO dto);

	public int itemDeleteAticle(int item_num);

	public ItemDTO getContentInfo(int item_num);
	
	
	
}
