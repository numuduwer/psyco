package com.three.psyco.controller.bean;

import java.io.File;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.ShopDTO;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.ItemServiceImpl;
import com.three.psyco.service.bean.ShopService;
import com.three.psyco.service.bean.ShopServiceImpl;

@Controller
@RequestMapping("/shop/")
public class ShopBean {
	
	@Autowired
	private ShopServiceImpl shopService = null;
	@Autowired
	private CommonsServiceImpl commonsService = null;
	@Autowired
	private ItemServiceImpl itemService = null;


	
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
	
	
	@RequestMapping("itemList.com")
	public String itemList(String pageName, String pageNum, HttpSession session, Model model) throws SQLException {
		
		int id = 123;
	
		
		System.out.println("itemList Controller id :" + id);
		ListData data = shopService.getItemList(pageName,pageNum,id);
		commonsService.setListDataToModel(model, data);
		return "shop/itemList";
	}
	
	
	// buy페이지에서 만들어놓은 해당 구매 상품 정보 가져오는거 사용
	@RequestMapping("itemDetail.com")
	public String itemDetail(int item_num,Model model,String pageNum) throws SQLException {
		System.out.println("item_num : " + item_num);
		ItemDTO article = shopService.getItemOne(item_num, pageNum, model);
		model.addAttribute("article",article);
		
		return "shop/itemDetail";
	}
	
	@RequestMapping("itemModifyForm.com")
	public String itemModifyForm(int item_num,Model model,String pageNum) throws SQLException {
		
		ItemDTO article = shopService.getItemOne(item_num, pageNum, model);
		System.out.println(article.getStartDate());
		model.addAttribute("article",article);
		
		return "shop/itemModifyForm";
	}
	
	@RequestMapping("itemModifyPro.com")
	public String itemModifyPro(Model model, HttpServletRequest request,ItemDTO dto,int item_num) throws SQLException {
		
		String startDate = request.getParameter("startDate1") +" "+ request.getParameter("startDate2") + ":00";
		dto.setStartDate(Timestamp.valueOf(startDate));
		String endDate = request.getParameter("endDate1") + " " + request.getParameter("endDate2") + ":00";
		dto.setEndDate(Timestamp.valueOf(endDate));
		
		shopService.itemModifyAticle(dto,model,item_num);
		
		return "shop/itemModifyPro";
	}
	
	
	@RequestMapping("itemDeleteForm.com")
	public String itemDeleteForm(String pageNum,Model model,int item_num) {
		
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("item_num",item_num);
		
		return "shop/itemDeleteForm";
	}
	
	@RequestMapping("itemDeletePro.com")
	public String itemDeletePro(int item_num,String pageNum, Model model) {
	
		shopService.itemDeleteAticle(item_num,pageNum,model);
		
		return "shop/itemDeletePro";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
