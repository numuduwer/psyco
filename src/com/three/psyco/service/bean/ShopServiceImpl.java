package com.three.psyco.service.bean;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.three.psyco.model.dao.BuyDAOImpl;
import com.three.psyco.model.dao.ItemDAOImpl;
import com.three.psyco.model.dao.MenuDAOImpl;
import com.three.psyco.model.dao.ShopDAOImpl;
import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.JoinResultDTO;
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
	
	private BuyDAOImpl buyDAO;
	public ShopServiceImpl(BuyDAOImpl buyDAO) {
		this.buyDAO = buyDAO;
	}

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
		List articleListC = null;
		List articleListD = null;
		
		int count = 0;
		int countA = 0;
		int countC = 0;
		int countD = 0;
		
		// 0:임시저장,1:시작전,2:대기,3:판매중,4:판매종료
		// 현재 해당가게 사장 아이템리스트    (DAO 에서 판매중인지 아닌지 처리)
		
		//1
		countA = itemDAO.countA(id);
		System.out.println("countA : " + countA);
		if(countA >0) {
			articleListA = itemDAO.getItemListA(id,startRow, endRow);	
		}
		
		
		//3
		countC = itemDAO.countC(id);
		if(countC >0) {
			articleListC = itemDAO.getItemListC(id,startRow, endRow);	
		}
		
		//4
		countD = itemDAO.countD(id);
		if(countD >0) {
			articleListD = itemDAO.getItemListD(id,startRow, endRow);	
		}
		
		int shop_num = id;
		
		// 가게에서 진행예
		countD = itemDAO.countD(shop_num);
		if(countD >0) {
			articleListD = itemDAO.getItemListD(id,startRow, endRow);	
		}
		
		model.addAttribute("countA",countA);
		model.addAttribute("countC",countC);
		model.addAttribute("countD",countD);
		
		model.addAttribute("articleListA",articleListA);
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
		System.out.println(dto.getStartDate());
		dto.setEndDate(Timestamp.valueOf((String)jSONObject.get("endDate")));
		System.out.println(dto.getEndDate());
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
	@Override
	public int deleteShops(int member_num) throws SQLException {
			int count=shopDAO.deleteShop1(member_num);
		return count;
	}
	
	@Override
	public int paymentInsert(String data) throws ParseException  {
		System.out.println("결제 서비스");
		data = data.substring(0, data.length() -1);
		
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(data);
		JSONObject jsonObject = (JSONObject) obj;
		
		Map<String, Object> map = null;
		
		try {
			map = new ObjectMapper().readValue(jsonObject.toJSONString(), Map.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int item_num = (int) map.get("item_num");
		int amount = Integer.parseInt(String.valueOf(map.get("amount")));
		
		int reduce_result = itemDAO.reduceItemCount(item_num, amount);
		if (reduce_result == 1) {
			int item_amount = itemDAO.itemAmountCheck(item_num);
			if (item_amount == 0) {
				itemDAO.modifyStatusIntoEnd(item_num);
			}
		}
		
		int result = buyDAO.paymentInsert(map);
		
		return result;
	}

	@Override
	public List getShopNums(int member_num) throws SQLException {
		System.out.println(member_num);
		List shop_num=shopDAO.getShopNum(member_num);
		System.out.println("shop_num :" + shop_num);
		return shop_num;
	}

	
	
	
	
	
	
	@Override
	public List<Object> getMyEntireList(String pageNum,int id) throws JsonProcessingException {
		
		// 디폴트 값 설정 
		if(pageNum == null) {
			pageNum = "1";
		}
		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0;
		
		
		List<JoinResultDTO> itemList = itemDAO.getMyEntireList(id,startRow,endRow);
		
		List<Map<String, Object>> itemMapList = new ArrayList<Map<String, Object>>();
		
		// 현재 시간
		long date_now = System.currentTimeMillis();
		
		// 시간 계산
		long current_hours = TimeUnit.MILLISECONDS.toHours(date_now);
		long current_minuets = TimeUnit.MILLISECONDS.toMinutes(date_now);
		long current_seconds = TimeUnit.MILLISECONDS.toSeconds(date_now);		
		
		for (int i = 0; i < itemList.size(); i++) {
			JoinResultDTO dto = (JoinResultDTO) itemList.get(i);
			Map<String, Object> itemMap = new HashMap<String, Object>();
			
			long item_StartTime_minuet = TimeUnit.MILLISECONDS.toMinutes(dto.getStartDate().getTime());
			long item_endTime_minuet = TimeUnit.MILLISECONDS.toMinutes(dto.getEndDate().getTime());
			
			long time_difference = current_minuets - item_StartTime_minuet;		// 몇분 지났는지 알 수 있는 시간
			long remainder_time = item_endTime_minuet - current_minuets;
			long discount_cycle = dto.getDiscount_cycle() / 60;				// 할인 주기
			long auction_unit = Long.parseLong(dto.getAuction_unit());			// 할인 단위
			long discount_count = time_difference / discount_cycle;				// 할인 횟수
			long discount_price = discount_count *  auction_unit;				// 할인 된 가격
			
			long current_price = Long.valueOf(dto.getMaxPrice()) - discount_price;	// 현재 가격
			
			if (current_price <= Long.valueOf(dto.getMinPrice())) {
				current_price = Long.valueOf(dto.getMinPrice());
				discount_price = dto.getMaxPrice() - current_price;
			}
			
			double discount_rate = ((double)discount_price / Long.valueOf(dto.getMaxPrice())) * 100;		// 할인율
			
			int progress_status = 0;									// 진행 중 경매인지 종료 된 경매인지 확인할 수 있는 변수
			if (item_endTime_minuet < current_minuets) {	// 경매 시간이 종료 되었으면
				//sprogress_status = itemDAO.modifyStatus(dto.getItem_num());
			}
			
			if (dto.getAmount() == 0) {
				itemDAO.modifyAmountZero(dto.getItem_num());
			}

			String jsonOfItemList = new ObjectMapper().writeValueAsString(dto);		// string으로 형 변환하면 timestamp -> long타입으로 바뀌는듯 (확인 결과 값 일치)
			
			itemMap.put("itemList", dto);
			itemMap.put("discount_price", discount_price);
			itemMap.put("current_price", current_price);
			itemMap.put("discount_rate", discount_rate);
			itemMap.put("progress_status", progress_status);
			itemMap.put("remainder_time", remainder_time);
			itemMapList.add(itemMap);
		}
		
		JSONArray jsonArray = new JSONArray();
		for (Map<String, Object> map : itemMapList) {
			
			
			JSONObject jsonObject = new JSONObject();
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				jsonObject.put(key, value);
			}
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	@Override
	public List getItemList1(String pageName, String pageNum, int shop_num, Model model) throws SQLException {
		int startRow = 1;
		int endRow = 4;

		// 아이템 상태 1
		List articleList = null;
		
		int count = menuDAO.getItemListCount(shop_num);
		articleList = menuDAO.getItemListE(shop_num,startRow, endRow);
		System.out.println("진행예정 경매 상품 개수 : " + count);
		System.out.println("진행예정 경매 상품 리스트 사이즈 : " + articleList.size());
		

		model.addAttribute("articleList3", articleList);
		model.addAttribute("count", count);
		
		return articleList;
		
		
	}
	
	
	@Override
	public List getContentImg(int shop_num,Model model) {
		System.out.println(shop_num);
		List<MenuDTO> list = menuDAO.getContentImg(shop_num);
		int count1 = menuDAO.getContentImgCount(shop_num);
		System.out.println("진행중인 경매 개수 : " + count1);
		System.out.println("진행중인 경매 리스트 사이즈 : " + list.size());
		
		model.addAttribute("count1",count1);
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
