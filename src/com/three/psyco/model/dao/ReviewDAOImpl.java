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
	public int insertReview(ReviewDTO dto) throws SQLException {
		int result=0;
		result=sqlSession.insert("review.insertReview",dto);
		return result;
	}

	//멤버 후기 가져오기
	@Override
	public List getReview(int startRow,int endRow,String member_id ) throws SQLException {
		List list=new ArrayList();
		HashMap map = new HashMap();
		System.out.println("member_id=="+member_id);
		map.put("start", startRow);
		map.put("end", endRow);
		map.put("member_id", member_id);
		list=sqlSession.selectList("review.getReview",map);
		System.out.println("list==="+list);
		return list;
	}

	@Override
	public int getCount() throws SQLException {
		int count = sqlSession.selectOne("review.getCount");
		System.out.println("dao count : " + count);
		return count;
	}

	@Override
	public ReviewDTO getReviewDetail(int review_num) throws SQLException {
		ReviewDTO dto=sqlSession.selectOne("review.getReivewDetail",review_num);
		return dto;
	}

	@Override
	public int updateReview(ReviewDTO dto) throws SQLException {
		int result=sqlSession.update("review.updateReview",dto);
		
		return result;
	}

	@Override
	public String deleteReview(int review_num) throws SQLException {
		System.out.println("review_num3="+review_num);
		String res=sqlSession.selectOne("review.deleteReview",review_num);
		System.out.println(res);
		return res;
	}

}
