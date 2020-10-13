package com.three.psyco.service.bean;

import java.sql.SQLException;

import org.springframework.ui.Model;

import com.three.psyco.model.dto.ListData;

public interface CommonsService {
	public void setListDataToModel(Model model, ListData data);
	public ListData getListData(String pageName, String pageNum,SuperService superService) throws SQLException;
	public ListData getrListData(String pageNum,Model model) throws SQLException;
}
