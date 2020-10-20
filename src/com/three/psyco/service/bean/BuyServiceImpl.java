package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.psyco.model.dao.BuyDAOImpl;

@Service
public class BuyServiceImpl implements BuyService {

	@Autowired
	private BuyDAOImpl buyDAO=null;
	
	@Override
	public List getBuyLists(int startRow, int endRow, int member_num) throws SQLException {
		List list =new ArrayList();
		System.out.println("member_num3=="+member_num);
		list=buyDAO.getBuyList(startRow, endRow, member_num);
		System.out.println("list1=="+list);
		return list;
	}

	@Override
	public int getBuyCounts() throws SQLException {
		int count=0;
		count =buyDAO.getBuyCount();
		return count;
		
	}

}
