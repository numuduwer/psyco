package com.three.psyco.controller.bean;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.three.psyco.model.dto.ItemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.JoinResultDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.ShopDTO;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.ShopServiceImpl;
import com.three.psyco.service.bean.MainServiceImpl;

import com.three.psyco.service.bean.Scheduler;
import com.three.psyco.service.bean.ShopServiceImpl;




@Controller
@RequestMapping("/main/")
public class MainBean {
	public static String controllerName = "mainBean";
	
	@Autowired
	private CommonsServiceImpl commonsService = null;
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@Autowired
	private MainServiceImpl mainService = null;
	
	@Autowired
	public static String controller = "mainBean";
	
	@Autowired
	private ShopServiceImpl shopService = null;
	
	public Scheduler scheduler = null;
	
	@RequestMapping("main.com")
	public String main(String menuDivision, HttpServletRequest request, Model model) throws SQLException, JsonProcessingException {
		
		if (menuDivision == null) menuDivision = "0";
		
		List<Object> itemMapList = commonsService.getEntireList(menuDivision);

		model.addAttribute("itemMapList", itemMapList);
		

		return "main/main";
	}
	
	
	
	@RequestMapping(value="getListData.com", produces = "application/text;charset=utf8")
	@ResponseBody
	public List<Object> getListData(String menuDivision) throws JsonProcessingException {
		List<Object> jsonArray = commonsService.getEntireList(menuDivision);
		String jsonString = jsonArray.toString();

		//System.out.println(jsonString);
		return jsonArray;

	}
	
	@RequestMapping(value="getEnrollEvent.com")
	@ResponseBody
	public String getEnrollEvent(HttpSession session) {
		String id = (String)session.getAttribute("memId");
		String result_str = "no";
		if(id != null) {
			result_str = mainService.getEnroll(id);
		}else {
			result_str = "noLogin";
		}
		return result_str;
	}
	

	@RequestMapping("content.com")//int item_nums << 변수로 넣을 때 편하게 이름 바꿔둠 나중에 if문 지우면 item_num으로 바꾸기
	public String content(String item_nums,String pageNum,Model model)throws SQLException {
		int items_nums=0;
		if(item_nums == null) {
			item_nums="47";
			int item_num=Integer.parseInt(item_nums);
			ItemDTO idto=shopService.getItemOne(item_num,pageNum, model);
			//---------------------------------item
			model.addAttribute("idto", idto);
			//----------------------------shop
			ShopDTO sdto=shopService.getShopDataSV(idto.getShop_num());
			model.addAttribute("sdto", sdto);
			//--------------------------menu
			String pageName="menuList";
			String controller ="shopBean";
			ListData data=commonsService.getListData(pageName, pageNum, idto.getShop_num(), controller);
			model.addAttribute("pageNum", data.getPageNum());
			model.addAttribute("pageSize", data.getPageSize());
			model.addAttribute("currPage", data.getCurrPage());
			model.addAttribute("startRow", data.getStartRow());
			model.addAttribute("endRow", data.getEndRow());
			model.addAttribute("number", data.getNumber());
			model.addAttribute("articleList", data.getArticleList());
			model.addAttribute("count", data.getCount());
			//---------------------------------------------review
			pageName="reviewList";
			controller ="shopBean";
			ListData rdata=commonsService.getListData(pageName, pageNum, idto.getShop_num(), controller);
			model.addAttribute("pageNum", rdata.getPageNum());
			model.addAttribute("pageSize", rdata.getPageSize());
			model.addAttribute("currPage", rdata.getCurrPage());
			model.addAttribute("startRow", rdata.getStartRow());
			model.addAttribute("endRow", rdata.getEndRow());
			model.addAttribute("rnumber", rdata.getNumber());
			model.addAttribute("rarticleList", rdata.getArticleList());
			model.addAttribute("count", rdata.getCount());
			System.out.println("data.rdata.getArticleList()()=="+rdata.getArticleList());
			System.out.println("data.getArticleList()=="+data.getArticleList());
		}else {// 밑에게 찐이야!
			int item_num=Integer.parseInt(item_nums);
			ItemDTO idto=shopService.getItemOne(item_num,pageNum, model);
			String pageName="menuList";
			String controller ="shopBean";
			ListData data=commonsService.getListData(pageName, pageNum, idto.getShop_num(), controller);
			pageName="reviewList";
			controller ="shopBean";
			ListData rdata=commonsService.getListData(pageName, pageNum, idto.getShop_num(), controller);
			ShopDTO sdto=shopService.getShopDataSV(idto.getShop_num());
			//---------------------------------item
			model.addAttribute("idto", idto);
			//----------------------------shop
			model.addAttribute("sdto", sdto);
			//--------------------------menu
			model.addAttribute("pageNum", data.getPageNum());
			model.addAttribute("pageSize", data.getPageSize());
			model.addAttribute("currPage", data.getCurrPage());
			model.addAttribute("startRow", data.getStartRow());
			model.addAttribute("endRow", data.getEndRow());
			model.addAttribute("number", data.getNumber());
			model.addAttribute("articleList", data.getArticleList());
			model.addAttribute("count", data.getCount());
			//---------------------------------------------review
			model.addAttribute("pageNum", rdata.getPageNum());
			model.addAttribute("pageSize", rdata.getPageSize());
			model.addAttribute("currPage", rdata.getCurrPage());
			model.addAttribute("startRow", rdata.getStartRow());
			model.addAttribute("endRow", rdata.getEndRow());
			model.addAttribute("rnumber", rdata.getNumber());
			model.addAttribute("rarticleList", rdata.getArticleList());
			model.addAttribute("rcount", rdata.getCount());
			System.out.println("data.rdata.getArticleList()()=="+rdata.getArticleList());
		}

		System.out.println("controller 잘 연결 ");


		
	
		return "main/content";
	}
	
	@RequestMapping("endContent.com")
	public String endContent(Model model, String pageNum) throws SQLException {
		String pageName = "endContent";
		ListData data = commonsService.getListData(pageName,pageNum,controllerName);
		commonsService.setListDataToModel(model, data);
		return "main/endContent";
	}
	
	
	


	
	
	
	
	

}
