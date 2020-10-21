package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.ui.Model;

import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.MenuDTO;
import com.three.psyco.model.dto.ShopDTO;

public interface ShopService {
	public ShopDTO getShopDataSV(int id) throws SQLException ;
	public int updateShopDataSV(ShopDTO dto) throws SQLException;
	
	
	
	public ListData getItemList(String pageName, String pageNum, int id) throws SQLException;
	public ItemDTO getItemOne(int item_num, String pageNum, Model model) throws SQLException;
	public int itemDeleteAticle(int item_num, String pageNum, Model model);
	public int itemModifyAticle(ItemDTO dto, Model model, int item_num);
	public JSONObject getMenuInfoFromMenuNum(int menu_num) throws SQLException;
}
