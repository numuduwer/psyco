package com.three.psyco.service.bean;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.three.psyco.model.dao.ItemDAOImpl;
import com.three.psyco.model.dao.MenuDAOImpl;
import com.three.psyco.model.dao.ShopDAOImpl;
import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.MenuDTO;
import com.three.psyco.model.dto.ShopDTO;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDAOImpl shopDAO = null;
	
	@Autowired
	private ItemDAOImpl itemDAO = null;
	
	@Autowired
	private MenuDAOImpl menuDAO = null;
	


	@Override
	public ShopDTO getShopDataSV(int shop_num) throws SQLException {
		
		ShopDTO data = shopDAO.getShopData(shop_num);
		return data;
	}
	@Override
	public int updateShopDataSV(ShopDTO dto) throws SQLException {
		int result = 0 ;	
		shopDAO.updateShopData(dto);
		result = 1;
		return result;
	}
	
	@Override
	public ListData getItemList(String pageName, String pageNum, int id,Model model) throws SQLException{
		// 디폴트 값 설정 
		if(pageNum == null) {
			pageNum = "1";
		}
		if(pageName == null) {
			pageName = "itemList";
		}
		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		
		List articleList = null;
		List articleListA = null;
		List articleListB = null;
		List articleListC = null;
		List articleListD = null;
		
		int count = 0;
		int countA = 0;
		int countB = 0;
		int countC = 0;
		int countD = 0;
		
		// 0:임시저장,1:시작전,2:대기,3:판매중,4:판매종료
		// 현재 해당가게 사장 아이템리스트    (DAO 에서 판매중인지 아닌지 처리)
		count = itemDAO.count1(id);
		if(count >0) {
			articleList = itemDAO.getItemList(id,startRow, endRow);	
		}
		
		//1
		countA = itemDAO.countA(id);
		if(count >0) {
			articleListA = itemDAO.getItemListA(id,startRow, endRow);	
		}
		
		//2
		countB = itemDAO.countB(id);
		if(count >0) {
			articleListB = itemDAO.getItemListB(id,startRow, endRow);	
		}
		
		//3
		countC = itemDAO.countC(id);
		if(count >0) {
			articleListC = itemDAO.getItemListC(id,startRow, endRow);	
		}
		
		//4
		countD = itemDAO.countD(id);
		if(count >0) {
			articleListD = itemDAO.getItemListD(id,startRow, endRow);	
		}
		
		model.addAttribute("countA",countA);
		model.addAttribute("countB",countB);
		model.addAttribute("countC",countC);
		model.addAttribute("countD",countD);
		
		model.addAttribute("articleListA",articleListA);
		model.addAttribute("articleListB",articleListB);
		model.addAttribute("articleListC",articleListC);
		model.addAttribute("articleListD",articleListD);
		
		
	
		
		number = count - (currPage-1) * pageSize;

		
		ListData data = new ListData();
		
		data.setArticleList(articleList);
		data.setCount(count);
		data.setCurrPage(currPage);
		data.setEndRow(endRow);
		data.setNumber(number);
		data.setPageNum( Integer.parseInt(pageNum));
		data.setPageSize(pageSize);
		data.setStartRow(startRow);
		
		return data;
	}
	
	@Override
	public ItemDTO getItemOne(int item_num, String pageNum, Model model) throws SQLException {
		String pageName = "itemOne";
		System.out.println("itemOne Service : " + pageName);
		ItemDTO article = itemDAO.getItemOne(item_num);
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("item_num",item_num);
		
		return article;
	}
	
	@Override
	public int itemModifyAticle(ItemDTO dto, Model model,int item_num) {
		
		int result = itemDAO.itemModifyAticle(dto);
		
		model.addAttribute("result",result);
		model.addAttribute("item_num",item_num);
		
		return result;
	}
	
	@Override
	public int itemDeleteAticle(int item_num, String pageNum, Model model) {
		
		int result = itemDAO.itemDeleteAticle(item_num);
		
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("result",result);
		model.addAttribute("item_num",item_num);
		
		
		return result;
	}
	
	

	public void deleteListSV(int id, String name) {
		if(name.equals("shopNum")){
			shopDAO.deleteShop(id);
		}else if(name.equals("menuNum")){
			menuDAO.deleteMenu(id);
		}
	}
	
	public MenuDTO getMenuDataSV(int menu_num) throws SQLException {
		MenuDTO data = menuDAO.getMenuData(menu_num);
		return data;
	}
	public int  updateMenuDataSV(MenuDTO dto) {
		int result = 0;
		result =  menuDAO.updateMenuData(dto);
		return result;
	}
	
	@Override
	public JSONObject getMenuInfoFromMenuNum(int menu_num) throws SQLException {
		MenuDTO menu = menuDAO.getMenuInfoFromMenuNum(menu_num);
		
		JSONObject jSONObject = new JSONObject();
		jSONObject.put("menu_num", menu.getMenu_num());
		jSONObject.put("menu_name", menu.getMenu_name());
		jSONObject.put("content", menu.getContent());
		jSONObject.put("menu_img", menu.getMenu_img());
		jSONObject.put("price", menu.getPrice());
		jSONObject.put("category", menu.getCategory());
		jSONObject.put("season", menu.getSeason());
		jSONObject.put("sett", menu.getSett());
		jSONObject.put("shop_num", menu.getShop_num());
		jSONObject.put("reg", menu.getReg().toString());
		
		return jSONObject;
	}
	@Override
	public int itemEnrollmentPro(String jsonData) throws ParseException {
	
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession httpSession = servletRequestAttribute.getRequest().getSession();
		int mem_num = Integer.parseInt(httpSession.getAttribute("memNum").toString());
		
		JSONParser jSONParser = new JSONParser();
		JSONObject jSONObject = (JSONObject) jSONParser.parse(jsonData);
		
		ItemDTO dto = new ItemDTO();
		
		dto.setItem_name((String)jSONObject.get("item_name"));
		dto.setContent((String)jSONObject.get("content"));
		dto.setAmount(Integer.valueOf((String)jSONObject.get("amount")));
		dto.setStartDate(Timestamp.valueOf((String)jSONObject.get("startDate")));
		dto.setEndDate(Timestamp.valueOf((String)jSONObject.get("endDate")));
		dto.setDiscount_cycle(Integer.valueOf((String)jSONObject.get("discount_cycle")));
		dto.setMaxPrice(Integer.valueOf((String)jSONObject.get("maxPrice")));
		dto.setMinPrice(Integer.valueOf((String)jSONObject.get("minPrice")));
		dto.setAuction_unit((String)jSONObject.get("auction_unit"));
		dto.setSett((String)jSONObject.get("sett"));
		dto.setComment1((String)jSONObject.get("comment"));
		dto.setMenu_num(Integer.valueOf((String)jSONObject.get("menu_num")));
		dto.setMem_num(mem_num);
		dto.setShop_num(Integer.valueOf((String)jSONObject.get("shop_num")));
		
		/*
		try {
			dto = new ObjectMapper().readValue(jSONObject.toJSONString(), ItemDTO.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		int result = itemDAO.itemEnrollmentPro(dto);
		
		return result;
	}
	

	

}
