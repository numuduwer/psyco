package com.three.psyco.service.bean;

import java.io.File;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dao.MemberShopDAOImpl;
import com.three.psyco.model.dto.MemberShopDTO;

@Service
public class MemberShopServiceImpl implements MemberShopService {
	
	@Autowired
	private MemberShopDAOImpl MemberShopDAO=null;

	@Override
	public void insertMemberShops(MultipartHttpServletRequest request,int member_num,String status,String approve_status) throws SQLException {
		MemberShopDTO dto=new MemberShopDTO();
		String shop_name=request.getParameter("shop_name");
		String shop_phone=request.getParameter("shop_phone");
		String operating_time=request.getParameter("operating_time");
		String address=request.getParameter("address");
		String origin=request.getParameter("origin");
		String takeout=request.getParameter("takeout");
		String license_number=request.getParameter("license_number");
		MultipartFile mf = request.getFile("shop_img");
		try {
			String path=request.getRealPath("save");
			System.out.println("path ="+path);
			String orgName =mf.getOriginalFilename();
			String imgName =orgName.substring(0, orgName.lastIndexOf('.'));
			String ext = orgName.substring(orgName.lastIndexOf('.'));
			Long date=System.currentTimeMillis();
			String newName=imgName+date+ext;
			String imgPath = path+"\\"+newName;
			File file=new File(imgPath);
			mf.transferTo(file);
			dto.setShop_img(newName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		dto.setShop_name(shop_name);
		dto.setShop_phone(shop_phone);
		dto.setOperating_time(operating_time);
		dto.setAddress(address);
		dto.setOrigin(origin);
		dto.setApprove_status(approve_status);
		dto.setMember_num(member_num);
		dto.setTakeout(takeout);
		dto.setlicense_number(license_number);
		dto.setStatus(status);
		
		System.out.println(dto.getShop_img()+"1");
		System.out.println(dto.getShop_name()+"1");
		System.out.println(dto.getShop_num()+"1");
		System.out.println(dto.getShop_phone()+"1");
		System.out.println(dto.getStatus()+"1");
		
		MemberShopDAO.insertMemberShop(dto);
		
	}



}
