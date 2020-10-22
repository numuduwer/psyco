package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.JoinResultDTO;

public interface ItemDAO {
	
	public int count()throws SQLException;
	
	public List getList(String pageName)throws SQLException;
	
	public ItemDTO getItemOne(int item_num)throws SQLException;
	
	public int count1(int id)throws SQLException;
	
	public List getItemList(int id, int startRow, int endRow)throws SQLException;


	public int itemModifyAticle(ItemDTO dto);

	public int itemDeleteAticle(int item_num);
	
	public int itemEnrollmentPro(ItemDTO dto) throws ParseException;
	
	public List<JoinResultDTO> getEntireList();
	
	public int modifyStatus(int item_num);
	
	public int modifyAmountZero(int item_num);
}
