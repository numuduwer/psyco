package com.three.psyco.controller.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/")
public class UserBean {

	@RequestMapping("myPageList.com")
	public String loginForm() {
		return "user/myPageList";
	}
	
	@RequestMapping("zzim.com")
	public String zzim() {
		
		return "user/zzim";
	}
}