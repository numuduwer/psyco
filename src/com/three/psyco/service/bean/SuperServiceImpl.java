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
	public int getMemberCountSV() throws SQLException {
		int count = superDAO.getMemberCount();
		return count;
	}
	

	@Override
	public List getMemberListSV(int startRow, int endRow) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int deleteSV(String pageName,String id) throws SQLException {
		int result = superDAO.delete(pageName,id);
			
		
		
		return result;
	}

	
	
	
	@Override
	public int getShopCountSV() throws SQLException {
		int count = superDAO.getShopCount();
		return count;
	}

	@Override
	public List getShopListSV(int startRow, int endRow) throws SQLException {
		List list = superDAO.getShoplist(startRow, endRow);
		return list;
	}




	

	

}
