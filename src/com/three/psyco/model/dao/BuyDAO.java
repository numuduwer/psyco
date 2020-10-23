package com.three.psyco.model.dao;

import java.sql.SQLException; 
import java.util.List;

public interface BuyDAO {

	public List getBuyList(int startRow,int endRow,int member_num) throws SQLException ;

	public int getBuyCount()throws SQLException ;


	public int countAll()throws SQLException;

}
