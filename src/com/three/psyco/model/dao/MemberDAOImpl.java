package com.three.psyco.model.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.three.psyco.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private final SqlSessionTemplate sqlSession;
	public MemberDAOImpl(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int existUserCheck(String email) {
		int count = sqlSession.selectOne("member.existUserCheck", email);
		return count;
	}
	
	@Override
	public MemberDTO getMemberProfile(String email) {
		MemberDTO dto = sqlSession.selectOne("member.getMemberProfile", email);
		return dto;
	}
	
	@Override
	public int insertMember(MemberDTO dto) {
		int result = sqlSession.insert("member.insertMember", dto);
		return result;
	}
	
	@Override
	public int loginCheck(String member_Id, String pw) {
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("member_Id", member_Id);
		hMap.put("pw", pw);
		int count = sqlSession.selectOne("member.loginCheck", hMap);
		return count;
	}
	
	
}
