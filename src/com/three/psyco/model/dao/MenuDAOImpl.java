package com.three.psyco.model.dao;

import java.sql.SQLException;


import java.util.HashMap;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.three.psyco.model.dto.MenuDTO;

@Repository
public class MenuDAOImpl implements MenuDAO {

	@Autowired
	private SqlSessionTemplate sqlSession = null;

	public MenuDTO getMenuData(int menu_num) throws SQLException {
		MenuDTO data = sqlSession.selectOne("menu.getMenuData", menu_num);
		return data;
	}

	public int  updateMenuData(MenuDTO dto) {
		int result = 0; 
		result = sqlSession.update("menu.update", dto);
		return result;
	}

	public void deleteMenu(int id) {
		sqlSession.delete("shop.deleteShop", id);
	}


	public List getContentImg(int shop_num) {
		

		List list = sqlSession.selectList("menu.getContentImgList",shop_num);
		
		return list;
	}


	@Override
	public List<MenuDTO> getMyMenuListFromShopNum(List<Integer> myShop_ShopNumList) {
		List<MenuDTO> menuList = sqlSession.selectList("shop.getMyMenuListFromShopNum", myShop_ShopNumList);
		return menuList;
	}

	
	@Override
	public MenuDTO getMenuInfoFromMenuNum(int menu_num) throws SQLException {
		MenuDTO menu = sqlSession.selectOne("menu.getMenuInfoFromMenuNum", menu_num);
		return menu;
	}

}
