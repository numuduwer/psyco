package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

import com.three.psyco.model.dto.JoinResultDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.MenuDTO;

public interface CommonsService {
	public void setListDataToModel(Model model, ListData data);
	public ListData getListData(String pageName, String pageNum) throws SQLException;
	
	public List<Integer> getMyShop_MemberNumList(int member_Num) throws SQLException;
	
	public List<MenuDTO> getMyMenuListFromShopNum(List<Integer> myShop_ShopNumList);
	
	public List<JoinResultDTO> getEntireList();
}
