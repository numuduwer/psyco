package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.three.psyco.model.dto.MemberDTO;
import com.three.psyco.model.dto.MemberShopDTO;

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
	public MemberDTO getMemberProfileFromNum(int member_Num) {
		MemberDTO dto = sqlSession.selectOne("getMemberProfileFromNum", member_Num);
		return dto;
	}
	
	@Override
	public MemberDTO getMemberProfileFromId(String member_Id) {
		MemberDTO dto = sqlSession.selectOne("member.getMemberProfileFromId", member_Id);
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
	
	@Override
	public int userDelete(String member_Id, String pw) {
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("member_Id", member_Id);
		hMap.put("pw", pw);
		
		int result = sqlSession.delete("member.userDelete", hMap);
		return result;
	}
	
	@Override
	public int modifySocialUserPro(int member_Num, String member_Id, String phoneNum, String birth) {
		HashMap<Object, Object> hMap = new HashMap<Object, Object>();
		hMap.put("member_Num", member_Num);
		hMap.put("member_Id", member_Id);
		hMap.put("phoneNum", phoneNum);
		hMap.put("birth", birth);
		
		int result = sqlSession.update("member.modifySocialUserPro", hMap);
		
		return result;
	}
	
	@Override
	public int modifyNormalUserPro(MemberDTO dto) {
		int result = sqlSession.update("member.modifyNormalUserPro", dto);
		return result;
	}
	
	@Override
	public void insertMemberShop(MemberShopDTO dto) throws SQLException {
		System.out.println(dto.getShop_name());
		System.out.println(dto.getShop_num());
		System.out.println(dto.getShop_phone());
		System.out.println(dto.getStatus());
		System.out.println("shop 이미지: " + dto.getShop_img());
		System.out.println("takeout"+dto.getTakeout());
		if(dto.getTakeout() == null) {
			dto.setTakeout("0");
			sqlSession.insert("member.insertMemberShop",dto);	
		}else {
			sqlSession.insert("member.insertMemberShop",dto);	
		}
	}
}
