package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.MenuDTO;
import com.three.psyco.model.dto.ShopDTO;

@Repository
public class ShopDAOImpl implements ShopDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	// ShopList.jsp
	@Override
	public int count(String pageName, int id)throws SQLException {
		int count = 0; 
		
		if(pageName.equals("shopList")) {
			count = sqlSession.selectOne("shop.getMyShopCount",id);
		}else if(pageName.equals("menuList")) {
			count = sqlSession.selectOne("shop.getMyMenuCount", id);
		}else if(pageName.equals("reviewList")) {
			count = sqlSession.selectOne("shop.getShopReviewCount", id);
		}
		
		
		return count;
	}
	
	
	
	
	@Override
	public List getList(String pageName, int id, int startRow, int endRow) throws SQLException {
		HashMap map = new HashMap();
		map.put("start", startRow);
		map.put("end", endRow);
		map.put("id", id);
		

		List list = null;
		if(pageName.equals("shopList")) {
			list = sqlSession.selectList("shop.getMyShopList", map);	
		}else if(pageName.equals("menuList")){
			list = sqlSession.selectList("shop.getMenuList", map);
		}else if(pageName.equals("reviewList")){
			list = sqlSession.selectList("shop.getShopReviewList", map);
		}
		return list;
	}
	
	@Override
	public ShopDTO getShopData(int shop_num) throws SQLException {
		ShopDTO data = sqlSession.selectOne("shop.getShopData", shop_num);
		return data;
	}
	
	@Override
	public int updateShopData(ShopDTO dto) throws SQLException {
		int result = 0; 
		result = sqlSession.update("shop.update", dto);
		return result;
	}

	public void  deleteShop(int shopNum) {
		sqlSession.delete("shop.deleteShop", shopNum);
		
	}
	
	@Override
	public List<Integer> getMyShop_ShopNumList(int member_Num) throws SQLException {
		List<Integer> myShop_ShopNumList = sqlSession.selectList("shop.getMyShop_ShopNumList", member_Num);
		return myShop_ShopNumList;
	}



}
