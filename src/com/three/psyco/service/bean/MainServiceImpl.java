package com.three.psyco.service.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.three.psyco.model.dao.ItemDAOImpl;
import com.three.psyco.model.dao.MemberDAOImpl;
import com.three.psyco.model.dao.MenuDAOImpl;
import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.MemberDTO;
import com.three.psyco.model.dto.MenuDTO;

@Service
public class MainServiceImpl implements MainService{
	
	@Autowired
	ItemDAOImpl itemDAO = null;
	
	@Autowired
	MenuDAOImpl menuDAO = null;
	
	@Autowired
	MemberDAOImpl memberDAO = null;
	
	
	@Override
	public ItemDTO getContentInfo(int item_num,Model model) {
		
		
		ItemDTO item = itemDAO.getContentInfo(item_num);
		String item1 = item.getComment1();
		
		model.addAttribute("item",item1);
		
		return item;
	}
	
	



	


	


	public String getEnroll(String id) {
		String result_str = "login but not enroll";		
		MemberDTO dto  = memberDAO.getEnroll(id);
		int business_license = dto.getBusiness_license();

		if (business_license == 1) {
			result_str = "ok";
			memberDAO.upgradeEnroll(id);
			}
	
		
		return result_str;
	}
	
	
	
}
