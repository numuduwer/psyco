package com.three.psyco.service.bean;

import java.sql.SQLException;

import com.three.psyco.model.dto.ShopDTO;

public interface ShopService {
	public ShopDTO getShopDataSV(int id) throws SQLException ;

}
