package com.three.psyco.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.three.psyco.model.dto.MenuDTO;

@Repository
public class MenuDAOImpl implements MenuDAO {

	@Autowired
	private SqlSessionTemplate sqlSession = null;

	public MenuDTO getMenuData(int shop_num) {
		MenuDTO data = sqlSession.selectOne("menu.getMenuData", shop_num);
		return data;
	}

	public int  updateMenuData(MenuDTO dto) {
		System.out.println("---------dao------");
		System.out.println("menu modifyPro dto menu_num : " + dto.getMenu_num());
		System.out.println("menu modifyPro dto menu_name : " + dto.getMenu_name());
		System.out.println("menu modifyPro dto content : " + dto.getContent());
		System.out.println("menu modifyPro dto menu_img : " + dto.getMenu_img());
		System.out.println("menu modifyPro dto price : " + dto.getPrice());
		
		System.out.println("menu modifyPro dto category : " + dto.getCategory());
		System.out.println("menu modifyPro dto season : " + dto.getSeason());
		System.out.println("menu modifyPro dto SETT : " + dto.getSett());
		System.out.println("menu modifyPro dto shop_num : " + dto.getShop_num());
		System.out.println("menu modifyPro dto reg : " + dto.getReg());
		int result = 0; 
		result = sqlSession.update("menu.update", dto);
		return result;
	}

	public void deleteMenu(int id) {
		sqlSession.delete("shop.deleteShop", id);
	}

	

}
