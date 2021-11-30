package com.synex.domain;


public class SearchDetails {
	@Override
	public String toString() {
		return "SearchDetails [searchHotel=" + searchHotel + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", noOfRooms=" + noOfRooms + ", noOfGuests=" + noOfGuests + "]";
	}

	private String searchHotel;
	private String checkIn;
	private String checkOut;
	private int noOfRooms;
	private int noOfGuests;
	
	public SearchDetails() {
		super();
	}

	public SearchDetails(String searchHotel, String checkIn, String checkOut, int noOfRooms, int noOfGuests) {
		super();
		this.searchHotel = searchHotel;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.noOfRooms = noOfRooms;
		this.noOfGuests = noOfGuests;
	}

	public String getSearchHotel() {
		return searchHotel;
	}

	public void setSearchHotel(String searchHotel) {
		this.searchHotel = searchHotel;
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

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public int getNoOfGuests() {
		return noOfGuests;
	}

	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	
	
}
