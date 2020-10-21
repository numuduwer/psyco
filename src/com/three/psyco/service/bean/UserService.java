package com.three.psyco.service.bean;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;

import com.three.psyco.model.dto.ListData;

public interface UserService {

	public ListData getMyAsk(String pageNum,String category,Model model) throws SQLException;
	
}
