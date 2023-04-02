package com.entity;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String about;
	private long phone;
	private int userId;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(String name, String email, String about, long phone, int userId) {
		super();
		this.name = name;
		this.email = email;
		this.about = about;
		this.phone = phone;
		this.userId = userId;
	}
	public Contact(int id,String name, String email, String about, long phone) {
		super();
		this.id=id;
		this.name = name;
		this.email = email;
		this.about = about;
		this.phone = phone;
	}
	

	public int getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
