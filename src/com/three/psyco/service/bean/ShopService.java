package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.MenuDTO;
import com.three.psyco.model.dto.ShopDTO;

public interface ShopService {
	public ShopDTO getShopDataSV(int id) throws SQLException ;
	public int updateShopDataSV(ShopDTO dto) throws SQLException;
	
	
	
	public ListData getItemList(String pageName, String pageNum, Model model) throws SQLException;
	public ItemDTO getItemOne(int item_num, String pageNum, Model model) throws SQLException;
	public int itemDeleteAticle(int item_num, String pageNum, Model model);
	public int itemModifyAticle(ItemDTO dto, Model model, int item_num);
	public JSONObject getMenuInfoFromMenuNum(int menu_num) throws SQLException;
	public int deleteShops(int member_num)throws SQLException;
	public int itemEnrollmentPro(String jsonData) throws ParseException;
	public List getShopNums(int member_num) throws SQLException;
	public int paymentInsert(String data) throws ParseException;
	public List<Object> getMyEntireList(String pageNum,int id) throws JsonProcessingException;
	public List getItemList1(String pageName, String pageNum, int id, Model model) throws SQLException;
	public List getContentImg(int shop_num, Model model);

	
	
}
