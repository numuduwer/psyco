package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

public interface SuperService {
	
	int getMemberCountSV() throws SQLException;
	List getMemberListSV(int startRow, int endRow) throws SQLException; 

}
