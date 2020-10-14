package com.three.psyco.model.dto;

public class MidDTO {

	private int mid_num;
	private String mid_category;
	private int big_num;
	public int getMid_num() {
		return mid_num;
	}
	public void setMid_num(int mid_num) {
		this.mid_num = mid_num;
	}
	public String getMid_category() {
		return mid_category;
	}
	public void setMid_category(String mid_category) {
		this.mid_category = mid_category;
	}
	public int getBig_num() {
		return big_num;
	}
	public void setBig_num(int big_num) {
		this.big_num = big_num;
	}
	@Override
	public String toString() {
		return "MidDTO [mid_num=" + mid_num + ", mid_categoty=" + mid_category + ", big_num=" + big_num + "]";
	}
}
