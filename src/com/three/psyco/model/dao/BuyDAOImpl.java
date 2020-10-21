package com.three.psyco.model.dao;

import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BuyDAOImpl implements BuyDAO {

	@Autowired SqlSessionTemplate sqlSession = null;
	
	@Override
	public List getBuyList(int startRow, int endRow, int member_num) throws SQLException {
		List list = new ArrayList();
		HashMap map =new HashMap();
		map.put("start", startRow);
		map.put("end", endRow);
		map.put("member_num", member_num);
		list = sqlSession.selectList("buy.buyList",map);
		System.out.println("buyList=="+list);
		return list;
	}

	@Override
	public int getBuyCount() throws SQLException {
		int count=sqlSession.selectOne("buy.buyCount");
		return count;
	}

}
