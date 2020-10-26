package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.JsonObject;
import com.three.psyco.controller.bean.ShopBean;
import com.three.psyco.model.dao.BuyDAO;
import com.three.psyco.model.dao.BuyDAOImpl;
import com.three.psyco.model.dao.ItemDAOImpl;
import com.three.psyco.model.dao.MenuDAO;
import com.three.psyco.model.dao.MenuDAOImpl;
import com.three.psyco.model.dao.ReviewDAOImpl;
import com.three.psyco.model.dao.ShopDAOImpl;
import com.three.psyco.model.dao.SuperDAOImpl;
import com.three.psyco.model.dto.JoinResultDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.MenuDTO;

@Service
public class CommonsServiceImpl implements CommonsService {
	
	@Autowired
	private SuperServiceImpl superService = null;
	
	@Autowired BuyServiceImpl buyService = null;
	
	@Autowired
	private ShopServiceImpl ShopService = null;
	
	
	@Autowired
	private ShopDAOImpl shopDAO = null;

	@Autowired
	private ItemDAOImpl itemDAO = null;
	
	@Autowired
	private MenuDAOImpl menuDAO = null;
	
	@Autowired
	private BuyDAOImpl buyDAO = null;
	
	@Autowired
	private ReviewDAOImpl reviewDAO =null;
	

	
	public void setListDataToModel(Model model, ListData data) {
		model.addAttribute("pageNum", data.getPageNum());
		model.addAttribute("pageSize", data.getPageSize());
		model.addAttribute("currPage", data.getCurrPage());
		model.addAttribute("startRow", data.getStartRow());
		model.addAttribute("endRow", data.getEndRow());
		model.addAttribute("number", data.getNumber());
		model.addAttribute("articleList", data.getArticleList());
		model.addAttribute("count", data.getCount());
	}

	public ListData getListData(String pageName, String pageNum) throws SQLException {
		// 디폴트 값 설정 
		if(pageNum == null) {
			pageNum = "1";
		}
		if(pageName == null) {
			pageName = "sMemberList";
		}
		
		System.out.println("------- Service -----");
		System.out.println("list pageName :" + pageName);
		System.out.println("list pageNum :" + pageNum);
		
		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		List articleList = null;
		
		
		
		// 글 갯수 불러오기 
		int count =  superService.getCountSV(pageName);
		System.out.println("count :" + count);
		
		
		
		// 글 있으면 전부 가져오기
		if(count >0) {
			articleList = superService.getListSV(pageName, startRow, endRow);	
		}
		

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
	

	public ListData getListData(String pageName, String pageNum, int memNum, String controller) throws SQLException{
		// 디폴트 값 설정 

		if(pageNum == null) {
			pageNum = "1";
		}
	

		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		List articleList = null;
		
		int count = 0;
		
		
		// 글 갯수 불러오기 
		if(controller.equals("shopBean")) {
			count = shopDAO.count(pageName, memNum);
		}
		

		if(count >0) {
				articleList = shopDAO.getList(pageName, memNum,startRow, endRow);
		}
		
		
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
	
	
	
	
	// main 조건 상관없이 테이블 모든 글 가져오기
	public ListData getListData(String pageName, String pageNum, String controller) throws SQLException {
		// 디폴트 값 설정 
		if(pageNum == null) {
			pageNum = "1";
		}
		if(pageName == null) {
			pageName = "itemList";
		}
		System.out.println("commons Serrvice pageName : " + pageName);
		
		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		List articleList = null;
		
		int count = 0;
		
		// 글 갯수 불러오기 
		if(controller.equals("mainBean")) {
			String selling = "3";
			count = itemDAO.count(selling);
		}
		
		if(pageName.equals("endContent")) {
			count = buyDAO.countAll();
		}
	
		if(count >0) {
			if(pageName.equals("endContent")) {
				articleList = buyDAO.getList(startRow, endRow);
		
			}
			
			//String selling = "3";
			//articleList = itemDAO.getList(pageName,selling);	
		}
		
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
	public List<Integer> getMyShop_MemberNumList(int member_Num) throws SQLException {
		System.out.println("-------- service ----- review ---- ");
		System.out.println("member_Num :" + member_Num );
		List<Integer> myShop_ShopNumList = shopDAO.getMyShop_ShopNumList(member_Num);
		return myShop_ShopNumList;
	}
	
	@Override
	public List<MenuDTO> getMyMenuListFromShopNum(List<Integer> myShop_ShopNumList) {
		List<MenuDTO> menuList = menuDAO.getMyMenuListFromShopNum(myShop_ShopNumList);
		return menuList;
		
	}
	
	


	@Override
	public List<Object> getEntireList(String menuDivision) throws JsonProcessingException {
		List<JoinResultDTO> itemList = itemDAO.getEntireList(menuDivision);
		
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
			long discount_cycle = dto.getDiscount_cycle() / 60;					// 할인 주기
			long auction_unit = Long.parseLong(dto.getAuction_unit());			// 할인 단위
			long discount_count = time_difference / discount_cycle;				// 할인 횟수
			long discount_price = discount_count *  auction_unit;				// 할인 된 가격
			
			long current_price = Long.valueOf(dto.getMaxPrice()) - discount_price;	// 현재 가격
			
			if (current_price <= Long.valueOf(dto.getMinPrice())) {
				current_price = Long.valueOf(dto.getMinPrice());
				discount_price = dto.getMaxPrice() - current_price;
			}
			
			double discount_rate = ((double)discount_price / Long.valueOf(dto.getMaxPrice())) * 100;		// 할인율
			
			int progress_status = 0;														// 진행 중 경매인지 종료 된 경매인지 확인할 수 있는 변수
			int selling_status = 0;
			
			if (item_endTime_minuet < current_minuets || dto.getAmount() == 0) {				// 경매 시간이 종료 되었으면  
				itemDAO.modifyStatusIntoEnd(dto.getItem_num());									// selling_status=4 (판매종료), progress_status=1 (종료)
				progress_status = 1;
				selling_status = 4;
			} else if (item_StartTime_minuet > current_minuets) {								// 경매 시작 시간이 되지 않을 시(진행중이 아닐 시)
				itemDAO.modifyStatusIntoBefore(dto.getItem_num());								// selling_status=1 (시작전), progress_tatus=2 (판매 대기)
				progress_status = 2;
				selling_status = 1;
			} else if (item_StartTime_minuet <= current_minuets && item_endTime_minuet >= current_minuets) {	// 경매 중일 시
				itemDAO.modifyStatusIntoProProceed(dto.getItem_num());											// selling_status=3 (판매중), progress_status=0 (판매중)
				selling_status = 3;
			}
			
			String jsonOfItemList = new ObjectMapper().writeValueAsString(dto);		// string으로 형 변환하면 timestamp -> long타입으로 바뀌는듯 (확인 결과 값 일치)
			
			itemMap.put("itemList", dto);
			itemMap.put("discount_price", discount_price);
			itemMap.put("current_price", current_price);
			itemMap.put("discount_rate", discount_rate);
			itemMap.put("progress_status", progress_status);
			itemMap.put("selling_status", selling_status);
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
	public ListData getShopNumLists(String pageNum,List list) throws SQLException{
		// 디폴트 값 설정 
		if(pageNum == null) {
			pageNum = "1";
		}

		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		List articleList = null;
		int shop_num = 0;
		
		
		
		// 글 갯수 불러오기 
		int	count = shopDAO.ShopNumcount(list);
		if(count >0) {
		
				articleList = shopDAO.getShopNumList(list,startRow, endRow);
	
		}
		
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
	}	//후기 리스트
	public ListData getrListData(String pageNum,Model model) throws SQLException {
		//String member_id =(String)RequestContextHolder.getRequestAttributes().getAttribute("memId", RequestAttributes.SCOPE_SESSION);
		// 디폴트 값 설정 
		String member_id ="gogo";
		if(pageNum == null) {
			pageNum = "1";
		}
		
		
		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		List  articleList = null;
		
	
		// 글 갯수 불러오기 
		int count = reviewDAO.getCount();
		System.out.println("list Test count :" + count);
		
		// 글 있으면 전부 가져오기
		if(count >0) {
			 articleList = reviewDAO.getReview(startRow, endRow, member_id);
		}
		
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

	//구매 리스트
	@Override
	public ListData getbuyData(String pageNum,int member_num) throws SQLException {
		// 디폴트 값 설정 
		System.out.println("member_num2=="+member_num);
		if(pageNum == null) {
			pageNum = "1";
		}
		
		
		// 페이징 처리 초기값
		int pageSize = 10;
		int currPage = Integer.parseInt(pageNum);	// 페이지 계산을 위해  형변환 
		int startRow = (currPage-1) * pageSize +1;
		int endRow = currPage * pageSize;
		int number = 0; //(게시판에 보여주기식 글번호 )
		List  articleList = null;
		
		
		// 글 갯수 불러오기 
		int count =  buyService.getBuyCounts();
		System.out.println("list Test count :" + count);
		
		// 글 있으면 전부 가져오기
		if(count >0) {
			articleList = buyDAO.getBuyList(startRow, endRow, member_num);
		}
		
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



	

}
