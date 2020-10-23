package com.three.psyco.model.dto;

import java.sql.Timestamp;

public class BuyDTO {
	private Integer buy_num;
	private String price;
	private Integer amount;
	private String discount_rate;
	private String gender;
	
	private Integer mem_num;
	private Integer menu_num;
	private Integer item_num;
	private Timestamp reg;
	public Integer getBuy_num() {
		return buy_num;
	}
	public void setBuy_num(Integer buy_num) {
		this.buy_num = buy_num;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(String discount_rate) {
		this.discount_rate = discount_rate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getMem_num() {
		return mem_num;
	}
	public void setMem_num(Integer mem_num) {
		this.mem_num = mem_num;
	}
	public Integer getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(Integer menu_num) {
		this.menu_num = menu_num;
	}
	public Integer getItem_num() {
		return item_num;
	}
	public void setItem_num(Integer item_num) {
		this.item_num = item_num;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	
	

}
