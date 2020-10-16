package com.three.psyco.controller.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("item")
public class ItemBean {
	
	@RequestMapping("itemEnrollmentForm.com")
	public String itemEnrollmentForm() {
		return "item/itemEnrollmentForm";
	}
}
