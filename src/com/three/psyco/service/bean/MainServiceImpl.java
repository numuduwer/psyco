package com.three.psyco.service.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.three.psyco.model.dao.ItemDAOImpl;
import com.three.psyco.model.dao.MenuDAOImpl;
import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.MenuDTO;

@Service
public class MainServiceImpl implements MainService{
	
	@Autowired
	ItemDAOImpl itemDAO = null;
	
	@Autowired
	MenuDAOImpl menuDAO = null;
	
	
	@Override
	public ItemDTO getContentInfo(int item_num,Model model) {
		
		
		ItemDTO item = itemDAO.getContentInfo(item_num);
		String item1 = item.getComment1();
		
		model.addAttribute("item",item1);
		
		return item;
	}
	
	
	@Override
	public List getContentImg(int shop_num,Model model) {
		System.out.println(shop_num);
		List list = menuDAO.getContentImg(shop_num);
		System.out.println("size : " + list.size());
		model.addAttribute("list",list);
		
		return list;
	}
	
	
	
}
