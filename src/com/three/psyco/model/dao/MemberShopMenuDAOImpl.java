 package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.three.psyco.model.dto.MemberShopMenuDTO;
import com.three.psyco.model.dto.MidDTO;

@Repository
public class MemberShopMenuDAOImpl implements MemberShopMenuDAO {

	@Autowired
	private SqlSessionTemplate sqlSession =null;
	
	@Override
	public void insertMemberMenu(MemberShopMenuDTO dto) throws SQLException {
		sqlSession.insert("MemberMenu.insertMenu",dto);
		
	}

	@Override
	public List selectMenu(int param) throws SQLException {
		List<MidDTO> list = null;
		list=sqlSession.selectList("MemberMenu.selectMenu",param);
		System.out.println("memuDAOImplList|"+list);
		return list;
	}

}
