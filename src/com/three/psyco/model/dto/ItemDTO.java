 package com.three.psyco.model.dto;

import java.sql.Timestamp;

public class ItemDTO {
	
	private Integer item_num;
	private String item_name;
	private String content;
	private Integer amount;
	private Timestamp startDate;
	private Timestamp endDate;
	private Integer discount_cycle;
	private String selling_status;
	private String progress_status;
	private Integer maxPrice;
	private Integer minPrice;
	private String auction_unit;
	private String sett;
	private String comment1;
	private Integer menu_num;
	private Integer mem_num;
	private Integer shop_num;
	
	public Integer getItem_num() {
		return item_num;
	}
	public void setItem_num(Integer item_num) {
		this.item_num = item_num;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
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
	public Integer getDiscount_cycle() {
		return discount_cycle;
	}
	public void setDiscount_cycle(Integer discount_cycle) {
		this.discount_cycle = discount_cycle;
	}
	public String getSelling_status() {
		return selling_status;
	}
	public void setSelling_status(String selling_status) {
		this.selling_status = selling_status;
	}
	public String getProgress_status() {
		return progress_status;
	}
	public void setProgress_status(String progress_status) {
		this.progress_status = progress_status;
	}
	public Integer getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Integer getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}
	public String getAuction_unit() {
		return auction_unit;
	}
	public void setAuction_unit(String auction_unit) {
		this.auction_unit = auction_unit;
	}
	public String getSett() {
		return sett;
	}
	public void setSett(String sett) {
		this.sett = sett;
	}
	public String getComment1() {
		return comment1;
	}
	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}
	public Integer getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(Integer menu_num) {
		this.menu_num = menu_num;
	}
	public Integer getMem_num() {
		return mem_num;
	}
	public void setMem_num(Integer mem_num) {
		this.mem_num = mem_num;
	}
	public Integer getShop_num() {
		return shop_num;
	}
	public void setShop_num(Integer shop_num) {
		this.shop_num = shop_num;
	}
}
