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
	
	//후기 등록 memid-->writer = nickname / 가게 이름 = num 으로 뽑아와야함.
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
		list=sqlSession.selectList("review.getReview",map);
		return list;
	}

	@Override
	public int getCount() throws SQLException {
		int count = sqlSession.selectOne("review.getCount");
		System.out.println("dao count : " + count);
		return count;
	}

	@Override
	public ReviewDTO getReviewDetail(int num) throws SQLException {
		ReviewDTO dto=sqlSession.selectOne("review.getReivewDetail",num);
		return dto;
	}

	@Override
	public ReviewDTO updateReview(ReviewDTO dto) throws SQLException {
		sqlSession.update("review.updateReview",dto);
		return null;
	}

}
