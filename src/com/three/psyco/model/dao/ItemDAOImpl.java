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
	public int count(String selling) {
		int count = sqlSession.selectOne("item.countAll",selling);
		return count;
	}
	
	// main 페이지 경매상품 전부 뿌려주기
	@Override
	public List getList(String pageName,String selling) throws SQLException {
		
		System.out.println("pageNameDAO : " + pageName);
		List list = sqlSession.selectList("item.itemList",selling);
		
		return list;
	}
	
	


	@Override
	public ItemDTO getItemOne(int item_num) throws SQLException {
		
		System.out.println("itemOne DAO : " + item_num);
		ItemDTO dto = sqlSession.selectOne("item.getItemOne", item_num);
		
		return dto;
	}
	
	
	// 0:임시저장,1:시작전,2:대기,3:판매중,4:판매종료
	// 현재 해당가게 사장 아이템리스트    (DAO 에서 판매중인지 아닌지 처리)
	@Override
	public int count1(int id) throws SQLException {
		String selling = "0";
		
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("selling", selling);
		
		int count = sqlSession.selectOne("item.itemOneCount",map);
		System.out.println("count : " + count);
		
		return count;
	}
	
	@Override
	public List getItemList(int id, int startRow, int endRow) {
		String selling = "0";
		HashMap map = new HashMap();
		map.put("mem_num", id);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("selling", selling);
		
		List list = sqlSession.selectList("item.getMyItemList",map);
		
		return list;
	}
	
	/////////////////////////1
	@Override
	public int countA(int id) throws SQLException {
		String selling = "1";
		
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("selling", selling);
		
		int count = sqlSession.selectOne("item.itemOneCount",map);
		System.out.println("count : " + count);
		
		return count;
	}
	
	@Override
	public List getItemListA(int id, int startRow, int endRow) {
		String selling = "1";
		HashMap map = new HashMap();
		map.put("mem_num", id);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("selling", selling);
		
		List list = sqlSession.selectList("item.getMyItemList",map);
		
		return list;
	}
	/////////////////////////////2
	@Override
	public int countB(int id) throws SQLException {
		String selling = "2";
		
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("selling", selling);
		
		int count = sqlSession.selectOne("item.itemOneCount",map);
		System.out.println("count : " + count);
		
		return count;
	}
	
	@Override
	public List getItemListB(int id, int startRow, int endRow) {
		String selling = "2";
		HashMap map = new HashMap();
		map.put("mem_num", id);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("selling", selling);
		
		List list = sqlSession.selectList("item.getMyItemList",map);
		
		return list;
	}
	/////////////////////////////////3
	@Override
	public int countC(int id) throws SQLException {
		String selling = "3";
		
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("selling", selling);
		
		int count = sqlSession.selectOne("item.itemOneCount",map);
		System.out.println("count : " + count);
		
		return count;
	}
	
	@Override
	public List getItemListC(int id, int startRow, int endRow) {
		String selling = "3";
		HashMap map = new HashMap();
		map.put("mem_num", id);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("selling", selling);
		
		List list = sqlSession.selectList("item.getMyItemList",map);
		
		return list;
	}
	///////////////////////////////////////////4
	@Override
	public int countD(int id) throws SQLException {
		String selling = "4";
		
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("selling", selling);
		
		int count = sqlSession.selectOne("item.itemOneCount",map);
		System.out.println("count : " + count);
		
		return count;
	}
	
	@Override
	public List getItemListD(int id, int startRow, int endRow) {
		String selling = "4";
		HashMap map = new HashMap();
		map.put("mem_num", id);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("selling", selling);
		
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
	
	@Override
	public ItemDTO getContentInfo(int item_num) {
		
		ItemDTO item = sqlSession.selectOne("item.getContentInfo",item_num);
		
		return item;
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
