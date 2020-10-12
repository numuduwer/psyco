package com.three.psyco.service.bean;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface MemberShopMenuService {

	public void insertMemberMenus(MultipartHttpServletRequest request,int shop_num)throws SQLException;
	public List selectMenus(int param)throws SQLException;
}
