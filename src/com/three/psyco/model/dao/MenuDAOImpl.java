package com.three.psyco.model.dao;

import java.sql.SQLException;

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

	

}
