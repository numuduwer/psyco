package com.three.psyco.model.dto;

import java.sql.Timestamp;

public class MemberDTO {
<<<<<<< HEAD

	private int member_Num;
	private String member_Id;
	private String pw;
	private String name;
	private String birth;
	private String phoneNum;
=======
	
	private int member_num;
	private String member_id;


	private String pw;
	private String name;
	private String birth;
	
	private String phonenum;
>>>>>>> master
	private String gender;
	private String nickname;
	private String email;
	private int purchase_count;
<<<<<<< HEAD
	private int business_license;
	private Timestamp reg;
	
	public int getMember_Num() {
		return member_Num;
	}
	public void setMember_Num(int member_Num) {
		this.member_Num = member_Num;
	}
	public String getMember_Id() {
		return member_Id;
	}
	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPurchase_count() {
		return purchase_count;
	}
	public void setPurchase_count(int purchase_count) {
		this.purchase_count = purchase_count;
	}
	public int getBusiness_license() {
		return business_license;
	}
	public void setBusiness_license(int business_license) {
		this.business_license = business_license;
	}
	public Timestamp getReg() {
		return reg;
	}
=======
	
	
	private int business_license;
	private Timestamp reg;
	
	
	
	

	public int getMember_num() {
		return member_num;
	}

	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public int getPurchase_count() {
		return purchase_count;
	}

	public void setPurchase_count(int purchase_count) {
		this.purchase_count = purchase_count;
	}

	public int getBusiness_license() {
		return business_license;
	}

	public void setBusiness_license(int business_license) {
		this.business_license = business_license;
	}

	public Timestamp getReg() {
		return reg;
	}

>>>>>>> master
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	
	
<<<<<<< HEAD
=======

>>>>>>> master
}