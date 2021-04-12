package com.cg.homeloan.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lvo")
public class LandVerificationOfficer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String officerName;
	private String officerContact;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOfficerName() {
		return officerName;
	}

	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}

	public String getOfficerContact() {
		return officerContact;
	}

	public void setOfficerContact(String officerContact) {
		this.officerContact = officerContact;
	}

	public LandVerificationOfficer(int userId, String officerName, String officerContact) {
		super();
		this.userId = userId;
		this.officerName = officerName;
		this.officerContact = officerContact;
	}

	public LandVerificationOfficer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LandVerificationOfficer [userId=" + userId + ", officerName=" + officerName + ", officerContact="
				+ officerContact + "]";
	}

}
