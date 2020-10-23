package com.three.psyco.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BuyDAOImpl implements BuyDAO {
	@Autowired
	private SqlSessionTemplate sqlSession = null;

	public  int countAll() {
		int count = sqlSession.selectOne("buy.countAll");
		return count;
	}

	public List getList(int startRow, int endRow) {
		HashMap map = new HashMap();
		endRow = 20;
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		
		List list = sqlSession.selectList("buy.getBuyList",map);
		
		return list;
	}
	
	

}
