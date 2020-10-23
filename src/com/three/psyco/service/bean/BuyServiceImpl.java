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
	public int getBuyCounts() throws SQLException {
		int count=0;
		count =buyDAO.getBuyCount();
		return count;
		
	}

}
