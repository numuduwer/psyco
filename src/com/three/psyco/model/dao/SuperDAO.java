package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface SuperDAO {
	
	public int getMemberCount() throws SQLException;
	public List getMemberList(int start, int end) throws SQLException;


	public int getShopCount() throws SQLException;
	public List getShoplist(int startRow, int endRow) throws SQLException;
	
	
	
	public int delete(String pageName, String id) throws SQLException;

}
