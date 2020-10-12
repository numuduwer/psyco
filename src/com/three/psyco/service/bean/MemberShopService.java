package com.three.psyco.service.bean;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dao.MemberShopDAOImpl;
import com.three.psyco.model.dto.MemberShopDTO;


public interface MemberShopService {
	

	
	public void insertMemberShops(MultipartHttpServletRequest request,int member_num,String status,String approve_status)throws SQLException;

}
