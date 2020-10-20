package com.three.psyco.service.bean;

import java.sql.SQLException;

import org.springframework.ui.Model;

import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.ListData;

public interface ItemService {
	

	public ItemDTO getItemOne(int item_num, String pageNum, Model model) throws SQLException;


	
	
	
}
