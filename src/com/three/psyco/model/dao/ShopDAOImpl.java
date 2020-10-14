package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDAOImpl implements ShopDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;

	public int count(String pageName, int memNum) {
		int count = 0; 
		
		if(pageName.equals("shopList")) {
			count = sqlSession.selectOne("shop.getMyShopCount",memNum);
		}
		return count;
	}

	public List getList(String pageName, int memNum, int startRow, int endRow) throws SQLException {
		System.out.println("DAO pageName : "+pageName);
		System.out.println("DAO memNum : "+memNum);
		System.out.println("DAO startRow : "+startRow);
		System.out.println("DAO endRow : "+endRow);
		
		HashMap map = new HashMap();
		map.put("start", startRow);
		map.put("end", endRow);
		map.put("memNum", memNum);
		
		
		System.out.println(map.get("start"));
		List list = null;

		if(pageName.equals("shopList")) {
			list = sqlSession.selectList("shop.getMyShopList", map);	
		}
		return list;
	}
	
	
	
	
	

}
