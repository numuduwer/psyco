package com.three.psyco.controller.bean;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.ItemServiceImpl;

@Controller
@RequestMapping("item")
public class ItemBean {
	
	@Autowired
	ItemServiceImpl itemService = null;
	
	
	
	@RequestMapping("itemEnrollmentForm.com")
	public String itemEnrollmentForm() {
		return "item/itemEnrollmentForm";
	}
	
	@RequestMapping("buy.com")
	public String buy(Model model,int item_num, String pageNum,String pageName) throws SQLException {
		
		ItemDTO dto = itemService.getItemOne(item_num, pageNum, model);
		
		
		model.addAttribute("dto",dto);
		
		return "main/buy";
	}
	
	
	
	
	
}
