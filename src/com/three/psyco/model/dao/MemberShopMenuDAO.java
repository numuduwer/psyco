package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.three.psyco.model.dto.MemberShopMenuDTO;


public interface MemberShopMenuDAO {
	
	public void insertMemberMenu(MemberShopMenuDTO dto)throws SQLException;
	public List selectMenu(int param)throws SQLException;

}