package com.three.psyco.model.dto;

import java.sql.Timestamp;

public class ItemDTO {
	
	private int item_num;
	private String item_name;
	private String content;
	private int amount;
	private Timestamp startDate;
	private Timestamp endDate;
	private int discount_cycle;
	private String selling_status;
	private String progress_status;
	private int maxPrice;
	private int minPrice;
	private String aution_unit;
	private String sett;
	private String comment;
	private int menu_num;
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getAution_unit() {
		return aution_unit;
	}
	public void setAution_unit(String aution_unit) {
		this.aution_unit = aution_unit;
	}
	public String getSett() {
		return sett;
	}
	public void setSett(String sett) {
		this.sett = sett;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}
}
