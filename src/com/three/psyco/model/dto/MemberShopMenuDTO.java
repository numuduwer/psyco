package com.three.psyco.model.dto;

import java.sql.Timestamp;

public class MemberShopMenuDTO {
	
	private int menu_num;
	private String menu_name;
	private String content;
	private String menu_img;
	private int price;
	private String category;
	private String season;
	private String sett;
	private int shop_num;
	private Timestamp reg;
	public int getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMenu_img() {
		return menu_img;
	}
	public void setMenu_img(String menu_img) {
		this.menu_img = menu_img;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getSett() {
		return sett;
	}
	public void setSett(String sett) {
		this.sett = sett;
	}
	public int getShop_num() {
		return shop_num;
	}
	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	
	
}
