package com.cg.homeloan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int userId;
	@Column
	private String password;
	@Column
	private String adminName;
	@Column
	private String adminContact;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String password, String adminName, String adminContact) {
		super();
		this.password = password;
		this.adminName = adminName;
		this.adminContact = adminContact;
	}

	public Admin(int userId, String password, String adminName, String adminContact) {
		super();
		this.userId = userId;
		this.password = password;
		this.adminName = adminName;
		this.adminContact = adminContact;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	@Override
	public String toString() {
		return "Admin [userId=" + userId + ", password=" + password + ", adminName=" + adminName + ", adminContact="
				+ adminContact + "]";
	}

}
