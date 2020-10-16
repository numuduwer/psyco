package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.three.psyco.model.dto.ZzimDTO;

public class UserDAOimpl implements UserDAO{

	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@Override
	public void zzim(ZzimDTO dto) throws SQLException{
		int number = 0;
		sqlSession.insert("zzim.insertZzim", dto);
		
		return;
	}

	@Override
	public List zzimList() throws SQLException {
		
		return null;
	}

	@Override
	public int zzimCount() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
