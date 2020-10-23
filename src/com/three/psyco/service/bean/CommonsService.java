package com.three.psyco.service.bean;

import java.sql.SQLException;

import java.util.List;

import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.three.psyco.model.dto.JoinResultDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.MenuDTO;

public interface CommonsService {
	public void setListDataToModel(Model model, ListData data);
	
	public ListData getrListData(String pageNum,Model model) throws SQLException;
	
	public ListData getListData(String pageName, String pageNum) throws SQLException;
	
	public ListData getbuyData(String pageNum,int member_num) throws SQLException;
	public List<Integer> getMyShop_MemberNumList(int member_Num) throws SQLException;
	
	public List<MenuDTO> getMyMenuListFromShopNum(List<Integer> myShop_ShopNumList);
	

	public ListData getShopNumLists(String pageNum, List shop_num) throws SQLException;
	
	public List<Object> getEntireList() throws JsonProcessingException;
}
