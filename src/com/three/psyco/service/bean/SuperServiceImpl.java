package com.three.psyco.service.bean;

import java.sql.SQLException; 
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.three.psyco.model.dao.SuperDAOImpl;

@Service
public class SuperServiceImpl implements SuperService {
	
	@Autowired
	private SuperDAOImpl superDAO = null;
	
	@Override
	public int getCountSV(String pageName) throws SQLException{
		int count = superDAO.count(pageName);
		return count;
	}

	@Override
	public List getListSV(String pageName, int startRow, int endRow) throws SQLException {
		System.out.println("superrService --------");
		System.out.println("pageName : " + pageName);
		List articleList = superDAO.List(pageName,startRow, endRow);	
		return articleList;
	}

	@Override
	public int deleteSV(String pageName,String id) throws SQLException {
		int result = superDAO.delete(pageName,id);	
		return result;
	}

	public void deleteMemberSV(String memberNum) {
		System.out.println("Service memberNum : " + memberNum);
		superDAO.deleteMember(memberNum);
		
	}

	


	

	

}
