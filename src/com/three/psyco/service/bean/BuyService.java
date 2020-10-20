package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import com.three.psyco.model.dto.ListData;

public interface BuyService {
	
	public List getBuyLists(int startRow,int endRow,int member_num) throws SQLException ;

	public int getBuyCounts()throws SQLException ;
	
	
		
	
}
