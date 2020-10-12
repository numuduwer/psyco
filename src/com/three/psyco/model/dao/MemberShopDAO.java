package com.three.psyco.model.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.three.psyco.model.dto.MemberShopDTO;


public interface MemberShopDAO {
	
	public void insertMemberShop(MemberShopDTO dto)throws SQLException;

}
