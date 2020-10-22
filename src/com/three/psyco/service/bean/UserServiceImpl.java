package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.three.psyco.model.dao.CommunityDAOImpl;
import com.three.psyco.model.dao.ZzimDAOImpl;
import com.three.psyco.model.dto.ListData;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	CommunityDAOImpl commnuityDAO = null;
	@Autowired
	ZzimDAOImpl zzimDAO = null;
	
	
	@Override
	public ListData getMyAsk(String pageNum,String category,Model model) throws SQLException {
		
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = servletRequestAttribute.getRequest().getSession();
//		String writer = (String) session.getAttribute("memId");
		String writer = "asd";
		
		List myHelpList = null;
		List myHelpList2 = null;
		int start = 1;
		int end  = 10;
		int number = 10;
		int numbers = 10;
		category = "5";
		
		// 고객센터 자신이 문의한 글 가져오기
		myHelpList = commnuityDAO.getMyAsk(start,end,category,writer);
		
		// 고객센터외 자신이 작성한 글 가져오기
		myHelpList2 = commnuityDAO.getMyAsk2(start,end,category,writer);
		
		// 자신이 찜한 정보 가져오기 (리스트)
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// session 필요
		List myPageZzim = null;
		int mem_num = 123;
		myPageZzim = zzimDAO.myPageZzim(mem_num);
		
		
		ListData data  = new ListData();
		data.setArticleList(myHelpList);
		data.setNumber(number);
		
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("category",category);
		model.addAttribute("articleList2",myHelpList2);
		model.addAttribute("numbers",numbers);
		model.addAttribute("myPageZzim",myPageZzim);
		
		return data;

		
	}

	@Override
	public int zzimDeleteOne(int zzim_num,Model model) {
		
		int result = zzimDAO.zzimDeleteOne(zzim_num);
		
		model.addAttribute("result",result);
		
		return result;
	}
	
	
	
	
	
}
