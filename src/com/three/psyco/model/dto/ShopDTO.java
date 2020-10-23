package com.three.psyco.model.dto;

import java.sql.Timestamp;

public class ShopDTO {
	
	private int shop_num;
	private String shop_name;
	private String shop_phone;
	private String operating_time;
	private String address;
	private String origin;
	private String takeout;
	private String shop_img;
	private String license_number;
	private Timestamp request_time;
	private Timestamp approve_time;
	private String status;
	private String approve_status;
	private int member_num;
	

	
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
	public String getShop_phone() {
		return shop_phone;
	}
	public void setShop_phone(String shop_phone) {
		this.shop_phone = shop_phone;
	}
	
	public String getOperating_time() {
		return operating_time;
	}
	public void setOperating_time(String operating_time) {
		this.operating_time = operating_time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getTakeout() {
		return takeout;
	}
	public void setTakeout(String takeout) {
		this.takeout = takeout;
	}
	public String getShop_img() {
		return shop_img;
	}
	public void setShop_img(String shop_img) {
		this.shop_img = shop_img;
	}
	public String getLicense_number() {
		return license_number;
	}
	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}
	public Timestamp getRequest_time() {
		return request_time;
	}
	public void setRequest_time(Timestamp request_time) {
		this.request_time = request_time;
	}
	public Timestamp getApprove_time() {
		return approve_time;
	}
	public void setApprove_time(Timestamp approve_time) {
		this.approve_time = approve_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApprove_status() {
		return approve_status;
	}
	public void setApprove_status(String approve_status) {
		this.approve_status = approve_status;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	
	
	
	

}
