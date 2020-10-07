package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.psyco.model.dao.SuperDAO;

@Service
public class SuperServiceImpl implements SuperService {
	
	@Autowired
	private SuperDAO superDAO = null;

	@Override
	public int getMemberCountSV() throws SQLException {
		int count = superDAO.getMemberCount();
		return count;
	}

	@Override
	public List getMemberListSV(int start, int end) throws SQLException {
		
		
		List list = superDAO.getMemberList(start, end);
		return list;
	}

}
