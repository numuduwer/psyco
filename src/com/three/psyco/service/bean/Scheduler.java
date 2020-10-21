package com.three.psyco.service.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.three.psyco.model.dao.ItemDAOImpl;





@Component
public class Scheduler {
	
	
	@Autowired
	private ItemDAOImpl itemDAO = null; 
	
	// 1분마다 가격 변경  
	@Scheduled(fixedDelay = 3000)
	public void  autoUpdate1() {
		int cycle = 3;
		itemDAO.updatePrice(cycle);
	}
		
	
	
	// 30분마다 가격 변경  
	@Scheduled(fixedDelay = 1800000)
	public void autoUpdate30() {
		
	}
	
		
	
}
