package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class GuestDetail {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int guestId;

	private String guestName;
	private int guestAge;
	private String guestGender;
	private String address;
	
	@OneToOne
	private User user;
	
	public GuestDetail() {
		super();
	}

	public GuestDetail(int guestId, String guestName, int guestAge, String guestGender, String address, User user) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
		this.guestAge = guestAge;
		this.guestGender = guestGender;
		this.address = address;
		this.user = user;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public int getGuestAge() {
		return guestAge;
	}

	public void setGuestAge(int guestAge) {
		this.guestAge = guestAge;
	}

	public String getGuestGender() {
		return guestGender;
	}

	public void setGuestGender(String guestGender) {
		this.guestGender = guestGender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "GuestDetail [guestId=" + guestId + ", guestName=" + guestName + ", guestAge=" + guestAge
				+ ", guestGender=" + guestGender + ", address=" + address + ", user=" + user + "]";
	}

	
}
