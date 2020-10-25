package com.three.psyco.service.bean;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.three.psyco.model.dao.MemberShopMenuDAOImpl;
import com.three.psyco.model.dto.MemberShopMenuDTO;
import com.three.psyco.model.dto.MidDTO;

@Service
public class MemberShopMenuServiceImpl implements MemberShopMenuService {

	@Autowired
	private MemberShopMenuDAOImpl memberShopMenuDAO =null;
	
	@Override
	public void insertMemberMenus(MultipartHttpServletRequest request,int shop_num) throws SQLException {
			MemberShopMenuDTO dto=new MemberShopMenuDTO();
			String menu_name=request.getParameter("menu_name");
			String content=request.getParameter("content");
			int price=Integer.parseInt((request.getParameter("price")));
			String category=request.getParameter("category");
			String season=request.getParameter("season");
			String sett=request.getParameter("sett");
			MultipartFile mf = request.getFile("menu_img");
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
				dto.setMenu_img(newName);
			}catch(Exception e) {
				e.printStackTrace();
			}
			dto.setMenu_name(menu_name);
			dto.setContent(content);
			dto.setCategory("0");
			dto.setPrice(price);
			dto.setSeason(season);
			dto.setSett(sett);
			dto.setShop_num(shop_num);
			System.out.println(dto.getCategory());
			memberShopMenuDAO.insertMemberMenu(dto);
		
	}

	@Override
	public List selectMenus(int param) throws SQLException {
		List<MidDTO> list=null;
		list =memberShopMenuDAO.selectMenu(param);
		return list;
	}

}
