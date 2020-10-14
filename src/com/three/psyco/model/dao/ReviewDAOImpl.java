package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dto.ReviewDTO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

	@Autowired
	private SqlSessionTemplate sqlSession=null;
	
	//후기 등록
	@Override
	public void insertReview(ReviewDTO dto) throws SQLException {
		
		sqlSession.insert("review.insertReview",dto);
	}

	//멤버 후기 가져오기
	@Override
	public List getReview(int startRow,int endRow,String member_id ) throws SQLException {
		List list=new ArrayList();
		HashMap map = new HashMap();
		map.put("start", startRow);
		map.put("end", endRow);
		map.put("member_id", "gogo");
		System.out.println("endRow="+endRow);
		list=sqlSession.selectList("review.getReview",map);
		return list;
	}

	@Override
	public int getCount() throws SQLException {
		int count = sqlSession.selectOne("review.getCount");
		System.out.println("dao count : " + count);
		return count;
	}

}
