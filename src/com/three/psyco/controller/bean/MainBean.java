package com.three.psyco.controller.bean;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.JoinResultDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.ShopDTO;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.ShopServiceImpl;
import com.three.psyco.service.bean.Scheduler;



@Controller
@RequestMapping("/main/")
public class MainBean {
	
	@Autowired
	private CommonsServiceImpl commonsService = null;
	
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@Autowired
	public static String controller = "mainBean";
	
	@Autowired
	private ShopServiceImpl shopService=null;
	
	public Scheduler scheduler = null;
	
	@RequestMapping("main.com")
	public String main(Model model,String pageNum, String pageName, HttpSession session) throws SQLException {
		System.out.println("controller 잘 연결 ");
		//int mem_num = Integer.valueOf((String)session.getAttribute("memNum"));
		
		//ListData data = commonsService.getListData(pageName,pageNum,controller);
		//commonsService.setListDataToModel(model, data);
		
		List<JoinResultDTO> itemList = commonsService.getEntireList();
		
		ListData data = commonsService.getListData(pageName,pageNum,controller);
		commonsService.setListDataToModel(model, data);	

		System.out.println("itemList의 사이즈 : " + itemList.size());
		model.addAttribute("itemList", itemList);
		

		return "main/main";
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
	
	
	
	
	
	
	

}
