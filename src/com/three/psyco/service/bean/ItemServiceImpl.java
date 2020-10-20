package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.three.psyco.model.dao.ItemDAOImpl;
import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.ListData;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDAOImpl itemDAO = null;
	
	@Override
	public ItemDTO getItemOne(int item_num, String pageNum, Model model) throws SQLException {
		String pageName = "itemOne";
		System.out.println("itemOne Service : " + pageName);
		ItemDTO article = itemDAO.getItemOne(item_num);	
		
		return article;
	}

	
	
}
