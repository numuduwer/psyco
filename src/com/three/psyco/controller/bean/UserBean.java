package com.three.psyco.controller.bean;

import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.three.psyco.model.dto.ItemDTO;
import com.three.psyco.model.dto.ListData;
import com.three.psyco.model.dto.MemberDTO;
import com.three.psyco.model.dto.ReviewDTO;
import com.three.psyco.service.bean.CommonsServiceImpl;
import com.three.psyco.service.bean.MemberServiceImpl;
import com.three.psyco.service.bean.ReviewServiceImpl;
import com.three.psyco.service.bean.ShopServiceImpl;

@Controller
@RequestMapping("/user/")
public class UserBean {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired CommonsServiceImpl commonsService;
	
	@Autowired
	private ReviewServiceImpl reviewService=null;
	
	@Autowired
	private ShopServiceImpl shopService=null;
	

	
	public UserBean(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("myPageList2.com")
	public String myPageList2() {
		return "user/myPageList2";
		}

	//buy 부분
	@RequestMapping("myPageList.com")// int member_num 나중에 넣어야함
	public String myPageList(String pageNum,Model model)throws SQLException {
	
			int member_num=91;
			System.out.println("member_num1=="+member_num);
			ListData data =commonsService.getbuyData(pageNum, member_num); 
			model.addAttribute("pageNum",  data.getPageNum());
			model.addAttribute("pageSize", data.getPageSize());
			model.addAttribute("currPage", data.getCurrPage());
			model.addAttribute("startRow", data.getStartRow());
			model.addAttribute("endRow", data.getEndRow());
			model.addAttribute("number", data.getNumber());
			model.addAttribute("count", data.getCount());
			model.addAttribute("articleList", data.getArticleList());
			System.out.println("data.getArticleList()=="+data.getArticleList());
			
			ListData data2=commonsService.getrListData(pageNum, model);
			model.addAttribute("reviewCount", data2.getCount());
			model.addAttribute("reviewNumber", data2.getNumber());
			model.addAttribute("reviewArticleList", data2.getArticleList());
			System.out.println("data2.getArticleList()=="+data2.getArticleList());
		
		return "user/myPageList";
	}
	
	@RequestMapping("userDeleteForm.com")
	public String userDeleteForm() {
		return "user/userDeleteForm";
	}
	
	@RequestMapping("userDeletePro.com")
	public String userDeletePro(String pw, HttpSession session) throws ParseException {
		
		String member_Id = (String) session.getAttribute("memId");
		int count = memberService.loginCheck(member_Id, pw);
		int result = 0;
		
		if (count == 1) {	// 아이디, 비밀번호가 일치할 시
			result = memberService.userDelete(member_Id, pw);
		}
		String return_str = "{ \"count\": " + count + ", \"result\": "  + result + "}";
		return return_str;
	}
	
	@RequestMapping("modifyInputPw.com")
	public String modifyForm() {
		return "user/modifyInputPw";
	}
	
	@RequestMapping("userPwCheck.com")
	@ResponseBody
	public String userPwCheck(String pw, HttpSession session) {		// social 가입 유저인지, 일반 가입 유저인지 판단하는 메서드
		String member_Id = (String) session.getAttribute("memId");
		int count = memberService.loginCheck(member_Id, pw);
		int typeCount = memberService.userTypeCheck(member_Id);
		String userType = "";
		if (typeCount == 0) {
			userType = "social";
		} else {
			userType = "normal";
		}
		String return_str = "{ \"count\": " + count + ", \"userType\": \"" + userType + "\"}";
		System.out.println(return_str);
		
		return return_str;
	}
	
	@RequestMapping("modifyNormalUserForm.com")
	public String modifyNormalUserForm() {
		return "user/modifyNormalUserForm";
	}
	
	@RequestMapping("modifySocialUserForm.com")
	public String modifySocialUserForm() {
		return "user/modifySocialUserForm";
	}
	
	@RequestMapping("getMemberProfile.com")
	@ResponseBody
	public String getMemberProfile(HttpSession session) {
		int member_Num = (int) session.getAttribute("memNum");
		MemberDTO dto = memberService.getMemberProfileFromNum(member_Num);
		String return_str = "{ \"member_Num\": " + dto.getMember_Num() + ", \"member_Id\": \"" + dto.getMember_Id() + "\", \"pw\": \"" + dto.getPw() + ""
				+ "\", \"name\": \"" + dto.getName() + "\", \"birth\": \"" + dto.getBirth() + "\", \"phoneNum\": \"" + dto.getPhoneNum()
				+ "\", \"gender\": \"" + dto.getGender() + "\", \"nickname\": \"" + dto.getNickname() + "\", \"email\": \"" + dto.getEmail()
				+ "\", \"purchase_count\": " + dto.getPurchase_count() + ", \"business_license\": " + dto.getBusiness_license() + ", \"reg\": \"" + dto.getReg() + "\""
				+ "}";
		//URLEncoder.encode(return_str);
		
		return return_str;
	}
	
	@RequestMapping("modifySocialUserPro.com")
	@ResponseBody
	public String modifySocialUserPro(String phoneNum, String birth) {
		int result = memberService.modifySocialUserPro(phoneNum, birth);
		String return_str = "{\"count\": " + result + "}";
		return return_str;
	}
	
	@RequestMapping("modifyNormalUserPro.com")
	public String modifyNormalUserPro(MemberDTO dto, Model model) {
		int result = memberService.modifyNormalUserPro(dto);
		
		model.addAttribute("count", result);
		return "user/modifyCheck";
	}
	
	//후기 등록!	
	@RequestMapping("reviewForm.com") //,int item_num 페이지 붙일땐 필요
	public String reviewForm(HttpServletRequest request,Model model,int item_num,int shop_num)throws Exception {
		//int shop_num=Integer.getInteger(request.getParameter("shop_num"));
		HttpSession sessions=request.getSession();
		String session=(String)sessions.getAttribute("memId");
		//String nickname=memberService.getNickNames(session); 붙일때 풀기
		String nicknames="gogo";
		model.addAttribute("nickname", nicknames);
		model.addAttribute("session", session);
		//나중에 필요
		model.addAttribute("item_num", item_num);
		return "review/reviewForm";
	}
	//페이지 설정 다시해야할 듯 ! JSP
	@RequestMapping("reviewPro.com")
	public String reviewPro(MultipartHttpServletRequest request,String writer,int item_num,Model model,String pageNum)throws Exception {
		ItemDTO dto=shopService.getItemOne(item_num, pageNum, model);
		System.out.println(writer);
		System.out.println(item_num);
		int result=reviewService.insertReviews(request, item_num, writer,dto.getShop_num());
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "review/reviewPro";
	}
	//나의 후기 리스트

	@RequestMapping("reviewList.com")
	public String reviewList(String pageNum,Model model) throws SQLException {		
		ListData data=commonsService.getrListData(pageNum, model);
		model.addAttribute("pageNum",  data.getPageNum());
		model.addAttribute("pageSize", data.getPageSize());
		model.addAttribute("currPage", data.getCurrPage());
		model.addAttribute("startRow", data.getStartRow());
		model.addAttribute("endRow", data.getEndRow());
		model.addAttribute("number", data.getNumber());
		model.addAttribute("count", data.getCount());
		model.addAttribute("articleList", data.getArticleList());
		return "review/reviewList";
	}
	
	//리스트 상세보기
	@RequestMapping("reviewDetail.com")
	public String reviewDetail(String pageNum,Model model,int review_num)throws SQLException {
		
		ReviewDTO article=reviewService.getReviewDetails(review_num);
		model.addAttribute("article",article);
		model.addAttribute("pageNum",pageNum);
		return "review/reviewDetail";
	}
	//리스트 수정
	@RequestMapping("reviewModify.com")
	public String reviewModify(int review_num,String pageNum,Model model)throws SQLException {
		
		ReviewDTO article=reviewService.getReviewDetails(review_num);
		model.addAttribute("article",article);
		model.addAttribute("pageNum",pageNum);
		
		
		return "review/reviewModify";
	}
	@RequestMapping("reviewModifyPro.com")
	public String reviewModifyPro(MultipartHttpServletRequest request,int review_num,String pageNum,Model model)throws SQLException {
		int result=reviewService.updateReviews(request);
		model.addAttribute("review_num",review_num);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("result",result);
		
		
		return "review/reviewModifyPro";
	}
	@RequestMapping("reviewDelete.com")
	public String reviewDelete(int review_num,String pageNum,Model model)throws SQLException {
		String res=reviewService.deleteReviews(review_num);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("res",res);
		return "review/reviewDelete";
		
	}
	
	



	
}