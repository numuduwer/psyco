package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SuperDAOImpl implements SuperDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;

	@Override
	public int getMemberCount() throws SQLException {
		int count = sqlSession.selectOne("super.getMemberCount");
		return count;
	}

	@Override
	public List getMemberList(int start, int end) throws SQLException {

		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List list = sqlSession.selectList("super.getMemberList", map);
		
		return list;
	}

	
	
	
	public int delete(String pageName, String id) throws SQLException {
		int result = 0;
		
		if (pageName.equals("memberList")) {
			sqlSession.update("super.deleteMember",id);
			result = 1;
			
		}else if(id.equals("ShopList")) {
			sqlSession.update("super.delteShop", id);
			result = 1;
		}
		return result;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getShopCount() {
		int count = sqlSession.selectOne("super.getShopCount");
		return count;
	}

	public List getShoplist(int startRow, int endRow) throws SQLException {
		HashMap map = new HashMap();
		map.put("start", startRow);
		map.put("end", endRow);
		List list = sqlSession.selectList("super.getShopList", map);
		
		
		return list;
	}


	
}
