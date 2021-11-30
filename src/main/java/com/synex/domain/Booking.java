package com.synex.domain;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	private long userId;
	private String mobile;
	private String email;
	private String address;	
	private Timestamp checkIn;	
	private Timestamp checkOut;
	private int hotelId;
	private int roomId;
	private int noOfGuests;
	private int noOfRooms;
	private double totalPrice;
	private String status;
	private Timestamp bookedOn; 
	private double discount;
	@OneToMany
	private Set<Reviews> reviews;
	
	public Booking() {
		super();
	}

	public Booking(int bookingId, long userId, String mobile, String email, String address, Timestamp checkIn,
			Timestamp checkOut, int hotelId, int roomId, int noOfGuests, int noOfRooms, double totalPrice,
			String status, Timestamp bookedOn, double discount, Set<Reviews> reviews) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.noOfGuests = noOfGuests;
		this.noOfRooms = noOfRooms;
		this.totalPrice = totalPrice;
		this.status = status;
		this.bookedOn = bookedOn;
		this.discount = discount;
		this.reviews = reviews;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Timestamp checkIn) {
		this.checkIn = checkIn;
	}

	public Timestamp getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Timestamp checkOut) {
		this.checkOut = checkOut;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getNoOfGuests() {
		return noOfGuests;
	}

	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getBookedOn() {
		return bookedOn;
	}

	public void setBookedOn(Timestamp bookedOn) {
		this.bookedOn = bookedOn;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Set<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Reviews> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", mobile=" + mobile + ", email=" + email
				+ ", address=" + address + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", hotelId=" + hotelId
				+ ", roomId=" + roomId + ", noOfGuests=" + noOfGuests + ", noOfRooms=" + noOfRooms + ", totalPrice="
				+ totalPrice + ", status=" + status + ", bookedOn=" + bookedOn + ", discount=" + discount + ", reviews="
				+ reviews + "]";
	}

	
	
}
