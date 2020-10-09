package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface SuperDAO {
	
	
	
	
	public int count(String pageName)throws SQLException;
	public List List(String pageName, int startRow, int endRow) throws SQLException;
	public int delete(String pageName, String id) throws SQLException;

}
