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



	public int count(String pageName)throws SQLException {
		int count= 0;
		
		if(pageName.equals("sMemberList"))  {
			count = sqlSession.selectOne("super.getMemberCount");	
		}else if(pageName.equals("sShopList")) {
			count = sqlSession.selectOne("super.getShopCount");
		}else if(pageName.equals("sCommunityList")) {
			count = sqlSession.selectOne("super.getCommunityCount");
		}
		return count;
	}
	
	public List List(String pageName, int startRow, int endRow) throws SQLException {
		
		HashMap map = new HashMap();
		map.put("start", startRow);
		map.put("end", endRow);
		
		List list = null;

		if(pageName.equals("sMemberList")) {
			list = sqlSession.selectList("super.getMemberList", map);	
		}else if(pageName.equals("sShopList")){
			list = sqlSession.selectList("super.getShopList", map);	
		}else if(pageName.equals("sCommunityList")){
			list = sqlSession.selectList("super.sCommunityList", map);	
		}	
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

	public void deleteMember(String memberNum) {
		System.out.println("dao memberId :" + memberNum);
		sqlSession.update("super.deleteMember",memberNum);
		
	}
		
}
