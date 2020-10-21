package com.three.psyco.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZzimDAOImpl implements ZzimDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	

	public List myPageZzim(int mem_num) {
		
		
		System.out.println("dao 다");
		List list = sqlSession.selectList("zzim.myPageZzim",mem_num);
		
		
		return list;
	}
	
	
	
	
}
