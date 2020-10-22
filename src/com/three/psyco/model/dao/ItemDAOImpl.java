package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.JoinResultDTO;

@Repository
public class ItemDAOImpl implements ItemDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@Override
	public int count() {
		int count = sqlSession.selectOne("item.countAll");
		return count;
	}
	
	// main 페이지 경매상품 전부 뿌려주기
	@Override
	public List getList(String pageName) throws SQLException {
		
		System.out.println("pageNameDAO : " + pageName);
		List list = sqlSession.selectList("item.itemList");
		
		return list;
	}
	
	


	@Override
	public ItemDTO getItemOne(int item_num) throws SQLException {
		
		System.out.println("itemOne DAO : " + item_num);
		ItemDTO dto = sqlSession.selectOne("item.getItemOne", item_num);
		
		return dto;
	}
	
	
	// 사장님 역경매 등록 해놓은것들 전부 가져오기.
	@Override
	public int count1(int id) throws SQLException {

		int count = sqlSession.selectOne("item.itemOneCount",id);
		System.out.println("count : " + count);
		return count;
	}
	
	@Override
	public List getItemList(int id, int startRow, int endRow) {
		
		HashMap map = new HashMap();
		map.put("mem_num", id);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		List list = sqlSession.selectList("item.getMyItemList",map);
		
		return list;
	}
	
	@Override
	public int itemModifyAticle(ItemDTO dto) {
		
		int result = sqlSession.update("item.itemModifyAticle",dto);
		
		return result;
	}
	
	@Override
	public int itemDeleteAticle(int item_num) {
		
		int result = sqlSession.delete("item.itemDeleteAticle",item_num);
		
		return result;
	}

	@Override
	public int itemEnrollmentPro(ItemDTO dto) throws ParseException {
		int result = sqlSession.insert("item.itemEnrollmentPro", dto);
		return result;
	}
	


	public void updatePrice(int cycle) {
		sqlSession.update("item.updatePrice", cycle);
		
	}

	
	
	

	@Override
	public List<JoinResultDTO> getEntireList() {
		List<JoinResultDTO> list = sqlSession.selectList("item.getEntireList");
		return list;
		
	}

	
	
	
}
