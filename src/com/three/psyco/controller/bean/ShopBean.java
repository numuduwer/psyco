package com.three.psyco.controller.bean;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.MenuDTO;
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
		pageName = "shopList";
		int memNum = 0;

		if (session.getAttribute("memNum") == null) {
			System.out.println("session이 nulll 입니다.");
		}else { 
			 memNum= (Integer)session.getAttribute("memNum");

		}

		ListData data = commonsService.getListData(pageName,pageNum,memNum,controllerName);
		commonsService.setListDataToModel(model, data);
		return "shop/shopList";
	}
	
	@RequestMapping("shopDetail.com")
	public String shopDetail(int shop_num, Model model) throws SQLException {
		ShopDTO shopData = shopService.getShopDataSV(shop_num);
		model.addAttribute("article", shopData);
		return "shop/shopDetail";
	}
	
	@RequestMapping("shopModify.com")
	public String shopModify(int shop_num, Model model) throws SQLException {
		int id = shop_num;
		ShopDTO shopData = shopService.getShopDataSV(id);

		model.addAttribute("article", shopData);
		model.addAttribute("shop_num", id);
		return "shop/shopModify";
		
	}

	@RequestMapping("menuModifyPro.com")
	public String menuModifyPro(MultipartHttpServletRequest request,MenuDTO dto, Model model) throws SQLException{
		String pageName = "menuList";
		int result = 0; 
		System.out.println("잘연");
		
		
		String path = request.getRealPath("save");
		try {
			MultipartFile mf = null;
			mf = request.getFile("menu_img");
				String orgName = mf.getOriginalFilename();
				String imgName = orgName.substring(0, orgName.lastIndexOf('.')); 
				String ext = orgName.substring(orgName.lastIndexOf('.'));
				long date = System.currentTimeMillis();
				String newName = imgName+date+ext;
				dto.setMenu_img(newName);
				String imgPath = path + "/"+newName ;
				File copyFile = new File(imgPath);
				mf.transferTo(copyFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
		
		result = shopService.updateMenuDataSV(dto);
		model.addAttribute("shopNum", dto.getShop_num());
		model.addAttribute("result", result);
		return "shop/menuModifyPro";
	}

	@RequestMapping("shopModifyPro.com")
	public String shopModiyPro(MultipartHttpServletRequest request,  ShopDTO dto , String pageName, Model model)throws SQLException{
		
		pageName = "shopList";
		
		int result = 0;
		String path = request.getRealPath("save");
		try {
			MultipartFile mf = null;
			mf = request.getFile("shop_img2");
				String orgName = mf.getOriginalFilename();
				String imgName = orgName.substring(0, orgName.lastIndexOf('.')); 
				String ext = orgName.substring(orgName.lastIndexOf('.'));
				long date = System.currentTimeMillis();
				String newName = imgName+date+ext;
				dto.setShop_img(newName);
				String imgPath = path + "/"+newName ;
				File copyFile = new File(imgPath);
				mf.transferTo(copyFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		result = shopService.updateShopDataSV(dto);
		model.addAttribute("result", result);
		model.addAttribute("pageName", pageName);
		return "shop/shopList";
	}
	
	@RequestMapping(value="deleteShop.com", method = RequestMethod.POST)
	@ResponseBody
	void deleteShop(@RequestParam("shop_num") int shopNum) {
		String name = "shopNum";
		shopService.deleteListSV(shopNum, name);
		
	}
	
	
////////////////////// 메뉴  마이페이지 ///////////////////
	
	@RequestMapping("menuList.com")
	public String menuList(int shop_num,String pageNum,  Model model) throws SQLException {
		String pageName = "menuList";
		ListData data = commonsService.getListData(pageName,pageNum,shop_num,controllerName);
		commonsService.setListDataToModel(model, data);
		return "shop/menuList";
	}
		
	@RequestMapping("menuModify.com")
	public String menuModify(int menu_num,String pageName, Model model) throws SQLException {
		pageName = "menuList";
		MenuDTO menuData = shopService.getMenuDataSV(menu_num);
		model.addAttribute("article", menuData);
		return "shop/menuModify";
	}
	

	@RequestMapping("menuModifyPro.com")
	public String menuModifyPro(MultipartHttpServletRequest request,String pageNum,  Model model) throws SQLException{
		MenuDTO dto = new MenuDTO();
		int result = 0; 
		String path = request.getRealPath("save");
		try {
			MultipartFile mf = null;
			mf = request.getFile("menu_img");
				String orgName = mf.getOriginalFilename();
				String imgName = orgName.substring(0, orgName.lastIndexOf('.')); 
				String ext = orgName.substring(orgName.lastIndexOf('.'));
				long date = System.currentTimeMillis();
				String newName = imgName+date+ext;
				dto.setMenu_img(newName);
				String imgPath = path + "/"+newName ;
				File copyFile = new File(imgPath);
				mf.transferTo(copyFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		result = shopService.updateMenuDataSV(dto);
		model.addAttribute("result", result);
		model.addAttribute("shop_num", dto.getShop_num());
		return "shop/menuModifyPro";
	}

	@RequestMapping(value="deleteMenu.com", method = RequestMethod.POST)
	@ResponseBody
	void deleteMenu(@RequestParam("menu_num") int menuNum) {
		String name = "menuNum";
		shopService.deleteListSV(menuNum, name);
		
	}
	
	
	

		
	
	

}
