package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.JoinResultDTO;

public interface ItemDAO {
	
	public int count(String selling)throws SQLException;
	
	public List getList(String pageName,String selling)throws SQLException;
	
	public ItemDTO getItemOne(int item_num)throws SQLException;
	


	public int itemModifyAticle(ItemDTO dto);

	public int itemDeleteAticle(int item_num);

	public ItemDTO getContentInfo(int item_num);
	
	public int itemEnrollmentPro(ItemDTO dto) throws ParseException;
	
	public List<JoinResultDTO> getEntireList(String menuDivision);

	
	public int modifyStatusIntoEnd(int item_num);
	
	public int modifyStatusIntoBefore(int item_num);
	
	public int modifyStatusIntoProProceed(int item_num);
	
	public int modifyAmountZero(int item_num);

	

	
	

	
	

	public int reduceItemCount(int item_num, int amount);

	public int itemAmountCheck(int item_num);

	public List<JoinResultDTO> getMyEntireList(int id, int startRow, int endRow);

	public int countA(int id) throws SQLException;
	public List getItemListA(int id, int startRow, int endRow);

	public int countC(int id) throws SQLException;
	public List getItemListC(int id, int startRow, int endRow);

	public int countD(int id) throws SQLException;
	public List getItemListD(int id, int startRow, int endRow);

	
	
}
