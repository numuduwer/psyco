package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

public interface SuperService {
	
	
	public int getCountSV(String pageName) throws SQLException;
	public List getListSV(String pageName, int startRow, int endRow) throws SQLException;
	public int deleteSV(String pageName, String id) throws SQLException;

}
