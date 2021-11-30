package com.synex.domain;

import java.util.Date;

public class BookingDetails {
	private int bookingId;
	private String checkIn;
	private String checkOut;
	private int noGuests;
	private int noRooms;
	private String hotelName;
	private String roomType;
	private double totalPrice;
	
	public BookingDetails() {
		super();
	}

	public BookingDetails(int bookingId, String checkIn, String checkOut, int noGuests, int noRooms, String hotelName,
			String roomType, double totalPrice) {
		super();
		this.bookingId = bookingId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.noGuests = noGuests;
		this.noRooms = noRooms;
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.totalPrice = totalPrice;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public int getNoGuests() {
		return noGuests;
	}

	public void setNoGuests(int noGuests) {
		this.noGuests = noGuests;
	}

	public int getNoRooms() {
		return noRooms;
	}

	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", noGuests=" + noGuests + ", noRooms=" + noRooms + ", hotelName=" + hotelName + ", roomType="
				+ roomType + ", totalPrice=" + totalPrice + "]";
	}

	
	
}
