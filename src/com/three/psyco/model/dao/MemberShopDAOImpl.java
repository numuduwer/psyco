package com.three.psyco.model.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.three.psyco.model.dto.MemberShopDTO;

@Repository
public class MemberShopDAOImpl implements MemberShopDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession=null;

	@Override
	public void insertMemberShop(MemberShopDTO dto) throws SQLException {
		System.out.println(dto.getShop_name());
		System.out.println(dto.getShop_num());
		System.out.println(dto.getShop_phone());
		System.out.println(dto.getStatus());
		System.out.println("takeout"+dto.getTakeout());
		if(dto.getTakeout() == null) {
			dto.setTakeout("0");
			sqlSession.insert("MemberShop.isertMemberShop",dto);	
		}else {
			sqlSession.insert("MemberShop.isertMemberShop",dto);	
		}
	}

}
