package com.three.psyco.model.dto;

import java.sql.Timestamp;

public class JoinResultDTO {

	private int item_num;
	private String item_name;
	private String menu_img;
	private int shop_num;
	private String shop_name;
	private int amount;
	private Timestamp startDate;
	private Timestamp endDate;
	private int discount_cycle;
	private int maxPrice;
	private int minPrice;
	private String auction_unit;
	
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getMenu_img() {
		return menu_img;
	}
	public void setMenu_img(String menu_img) {
		this.menu_img = menu_img;
	}
	public int getShop_num() {
		return shop_num;
	}
	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public int getDiscount_cycle() {
		return discount_cycle;
	}
	public void setDiscount_cycle(int discount_cycle) {
		this.discount_cycle = discount_cycle;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public String getAuction_unit() {
		return auction_unit;
	}
	public void setAuction_unit(String auction_unit) {
		this.auction_unit = auction_unit;
	}
	
}

