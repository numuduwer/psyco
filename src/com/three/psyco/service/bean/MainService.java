package com.three.psyco.service.bean;

import java.util.List;

import org.springframework.ui.Model;

import com.three.psyco.model.dto.ItemDTO;

public interface MainService {
	
	public ItemDTO getContentInfo(int item_num,Model model);

	public List getContentImg(int shop_num,Model model);


	
	
	
}
