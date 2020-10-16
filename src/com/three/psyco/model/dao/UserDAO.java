package com.three.psyco.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.three.psyco.model.dto.ZzimDTO;

public interface UserDAO {

	// 찜 하실?
	public void zzim(ZzimDTO dto) throws SQLException;
	
	// 찜 목록 불러오기
	public List zzimList() throws SQLException;
	
	// 찜 개수 가져오기
	public int zzimCount() throws SQLException;

}
