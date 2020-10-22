package com.three.psyco.controller.bean;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.event.MenuListener;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dto.ItemDTO;
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
		System.out.println("controller 잘연결");
		int memNum = 0;

		pageName = "shopList";


		if (session.getAttribute("memNum") == null) {
			System.out.println("session이 nulll 입니다.");
		}else { 
			 memNum= (Integer)session.getAttribute("memNum");
		}
		ListData data = commonsService.getListData(pageName,pageNum,memNum,controllerName);
		commonsService.setListDataToModel(model, data);
		return "shop/shopList";
	}
	
	@RequestMapping("menuList.com")
	public String menuList(int shop_num,String pageNum,  Model model) throws SQLException {
		String pageName = "menuList";

		ListData data = commonsService.getListData(pageName,pageNum,shop_num,controllerName);
		commonsService.setListDataToModel(model, data);
		return "shop/menuList";
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
	
	
	
	@RequestMapping("MyMenuList.com")
	public String MyMenuList(HttpSession session, Model model) throws SQLException {
		int member_Num = (int) session.getAttribute("memNum");
		List<Integer> myShop_ShopNumList = commonsService.getMyShop_MemberNumList(member_Num);
		List<MenuDTO> menuList = commonsService.getMyMenuListFromShopNum(myShop_ShopNumList);
		model.addAttribute("menuList", menuList);
		
		return "shop/myMenuList";
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
		
		dto.setMenu_num(Integer.parseInt(request.getParameter("menu_num")));
		dto.setMenu_name(request.getParameter("menu_name"));
		dto.setContent(request.getParameter("content"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		
		dto.setCategory(request.getParameter("category"));
		dto.setSeason(request.getParameter("season"));
		dto.setSett(request.getParameter("sett"));
		dto.setShop_num(Integer.parseInt(request.getParameter("shop_num")));
	
		System.out.println(" controller 잘 연결 ");
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
		model.addAttribute("shopNum", dto.getShop_num());
		model.addAttribute("result", result);
		return "shop/menuModifyPro";
	}

	@RequestMapping(value="deleteMenu.com", method = RequestMethod.POST)
	@ResponseBody
	void deleteMenu(@RequestParam("menu_num") int menuNum) {
		String name = "menuNum";
		shopService.deleteListSV(menuNum, name);
		
	}
	
	
	
	///////////////// item ///////////// 

	@RequestMapping("itemList.com")
	public String itemList(String pageName, String pageNum, HttpSession session, Model model) throws SQLException {
		
		int id = 123;
		System.out.println(id);
		
		System.out.println("itemList Controller id :" + id);
		ListData data = shopService.getItemList(pageName,pageNum,id,model);
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

	@RequestMapping("itemEnrollmentForm.com")
	public String itemEnrollment() {
		return "shop/itemEnrollmentForm";
	}
	
	@RequestMapping(value="getMenuInfoFromMenuNum.com")
	@ResponseBody
	public ResponseEntity<String> getMenuInfoFromMenuNum(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int menu_num = Integer.parseInt(request.getParameter("menu_num"));
		JSONObject jSONObject = shopService.getMenuInfoFromMenuNum(menu_num);
		response.setContentType("text/html;charset=UTF-8");
		String json = jSONObject.toString();

		// 응답헤더 설정
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(json, resHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="itemEnrollmentPro.com")
	@ResponseBody
	public String itemEnrollmentPro(HttpServletRequest request, HttpServletResponse response, @RequestBody String jsonData) throws ParseException {
		System.out.println(jsonData);
		
		int result = shopService.itemEnrollmentPro(jsonData);
		String result_str = "{\"result\":" + result + "}";
		System.out.println(result);
		return result_str;
		
	}
	
	
	
	@RequestMapping("shopPageList.com")
	public String shopPageList() {
		return "shop/shopPageList";
	}
	
	@RequestMapping("shopPageList2.com")
	public String shopPageList2(String pageName, String pageNum, HttpSession session, Model model) throws SQLException {
		
		int id = 123;
	
		
		System.out.println("itemList Controller id :" + id);
		ListData data = shopService.getItemList(pageName,pageNum,id,model);
		commonsService.setListDataToModel(model, data);
		
		return "shop/shopPageList2";
	}
	
	
}
