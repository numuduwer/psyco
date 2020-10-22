package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.JoinResultDTO;

public interface ItemDAO {
	
	public int count(String selling)throws SQLException;
	
	public List getList(String pageName,String selling)throws SQLException;
	
	public ItemDTO getItemOne(int item_num)throws SQLException;
	
	public int count1(int id)throws SQLException;
	
	public List getItemList(int id, int startRow, int endRow)throws SQLException;


	public int itemModifyAticle(ItemDTO dto);

	public int itemDeleteAticle(int item_num);

	public ItemDTO getContentInfo(int item_num);
	
	public int itemEnrollmentPro(ItemDTO dto) throws ParseException;
	
	public List<JoinResultDTO> getEntireList();

	
	public int countA(int id) throws SQLException;
	public List getItemListA(int id, int startRow, int endRow);
	
	public int countB(int id) throws SQLException;	
	public List getItemListB(int id, int startRow, int endRow);
		
	public int countC(int id) throws SQLException;
	public List getItemListC(int id, int startRow, int endRow);
	
	public int countD(int id) throws SQLException;	
	public List getItemListD(int id, int startRow, int endRow);




}
