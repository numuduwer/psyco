package com.three.psyco.controller.bean;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.ShopDTO;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.ShopService;
import com.three.psyco.service.bean.ShopServiceImpl;

@Controller
@RequestMapping("/shop/")
public class ShopBean {
	
	@Autowired
	private ShopServiceImpl shopService = null;
	@Autowired
	private CommonsServiceImpl commonsService = null;

	
	public static String controllerName = "shopBean";
	
		
	@RequestMapping("shopList.com")
	public String storeList(String pageName, String pageNum, HttpSession session, Model model) throws SQLException {
		
		int id = 0;

		if (session.getAttribute("memNum") == null) {
			// table에 있는 값 아무거나 찍어줌 
			id =2;
		}else { 
			id = (Integer)session.getAttribute("memNum");
		
		}
		
		System.out.println("shopList Controller id :" + id);
		ListData data = commonsService.getListData(pageName,pageNum,id,controllerName);
		commonsService.setListDataToModel(model, data);
		return "shop/shopList";
	}
	
	
	@RequestMapping("menuList.com")
	public String menuList(String pageName, String shop_num, String pageNum,  Model model) throws SQLException {
		if(shop_num == null) {
			shop_num = "2";
		}
		if(pageName == null) {
			pageName = "menuList";
		}
		
		int id = Integer.parseInt(shop_num);
		ListData data = commonsService.getListData(pageName,pageNum,id,controllerName);
		commonsService.setListDataToModel(model, data);
		return "shop/menuList";
	}
	
	
	
	
	
	@RequestMapping("shopDetail.com")
	public String shopDetail(String shop_num, Model model) throws SQLException {
		
		if(shop_num == null) {
			shop_num = "2";
		}
		int id = Integer.parseInt(shop_num);

		ShopDTO shopData = shopService.getShopDataSV(id);

		model.addAttribute("article", shopData);
		model.addAttribute("shop_num", shop_num);
		return "shop/shopDetail";
	}
	
	
	@RequestMapping("shopModify.com")
	public String shopModify(String shop_num, Model model) throws SQLException {

		int id = Integer.parseInt(shop_num);
		ShopDTO shopData = shopService.getShopDataSV(id);

		model.addAttribute("article", shopData);
		model.addAttribute("shop_num", shop_num);
		return "shop/shopModify";
		
		
	}
	
	
	@RequestMapping("shopModifyPro.com")
	public String shopModiyPro(MultipartHttpServletRequest request,  ShopDTO dto , String pageNum, Model model)throws SQLException{
		
		int result = 0;
		
		// 파일 업로드 
		String path = request.getRealPath("save");
		MultipartFile mf = null;
		String img = dto.getShop_img();
		try {
			mf = request.getFile(img);
			if(request.getFile(img) == null) {
				String orgName = "asd.asd";
				String imgName = orgName.substring(0, orgName.lastIndexOf('.'));
				String ext = orgName.substring(orgName.lastIndexOf('.'));
				long date = System.currentTimeMillis();
				String newName = imgName + date + ext;
				String imgPath = path + "\\" + newName;
				
				dto.setShop_img(newName);
				
			}else {
				String orgName = mf.getOriginalFilename();					
				String imgName = orgName.substring(0, orgName.lastIndexOf('.')); 
				String ext = orgName.substring(orgName.lastIndexOf('.'));
				long date = System.currentTimeMillis();
				String newName = imgName+date+ext;
				String imgPath = path + "\\" + newName;
				File copyFile = new File(imgPath);
				mf.transferTo(copyFile);
				
				dto.setShop_img(newName);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		result = shopService.updateShopDataSV(dto);
		model.addAttribute("result", result);
		return "shop/shopModifyPro";
	}
	
	
	
	
	
	

}
