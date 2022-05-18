package com.ty.visitor.dto;

public class Visitor {
	private int id;
	private String name;
	private String email;
	private long phone;
	private int age;
	private String gender;
	private String DOB;
	private String visitDateTime;
	
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getVisitDateTime() {
		return visitDateTime;
	}
	public void setVisitDateTime(String visitDateTime) {
		this.visitDateTime = visitDateTime;
	}
	public int getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Visitor [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", age=" + age
				+ ", gender=" + gender + ", DOB=" + DOB + ", visitDateTime=" + visitDateTime + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
