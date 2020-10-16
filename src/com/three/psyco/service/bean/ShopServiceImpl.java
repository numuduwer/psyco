package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.psyco.model.dao.ShopDAOImpl;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.ShopDTO;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDAOImpl shopDAO = null;

	@Override
	public ShopDTO getShopDataSV(int id) throws SQLException {
		
		ShopDTO data = shopDAO.getShopData(id);
		return data;
	}
	@Override
	public int updateShopDataSV(ShopDTO dto) throws SQLException {
		int result = 0 ;	
		shopDAO.updateShopData(dto);
		result = 1;
		return result;
	}
	
	public void deleteListSV(int shopNum) {
		// TODO Auto-generated method stub
		System.out.println("Service shopNum :" + shopNum);
		shopDAO.deleteShop(shopNum);
		
	}
	
	
	
	

}
