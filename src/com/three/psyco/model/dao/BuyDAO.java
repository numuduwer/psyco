package com.three.psyco.model.dao;

import java.sql.SQLException; 
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

public interface BuyDAO {

	public List getBuyList(int startRow,int endRow,int member_num) throws SQLException ;

	public int getBuyCount()throws SQLException ;

	public int countAll()throws SQLException;

	public int paymentInsert(Map<String, Object> map);
}
