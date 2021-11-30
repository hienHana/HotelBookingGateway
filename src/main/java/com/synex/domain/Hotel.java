package com.synex.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="hotels")
public class Hotel {
	@Id
	private int hotelId;	
	private String hotelName;
	private String address;
	private String city;
	private String state;
	private int star;
	private double minPrice;
	
	@ManyToMany
	private Set<AmenitiesHotel> hotelAmenities = new HashSet<>();
	private double discount;	
	private String description;
	private String email;
	private String mobile;
	private String imageUrl;
	private int timesBooked;
	private int customerRating;
	
	@OneToMany
	private Set<Room> hotelRooms = new HashSet<>();
	
	
	public Hotel() {
		super();
	}


	public Hotel(int hotelId, String hotelName, String address, String city, String state, int star, double minPrice,
			Set<AmenitiesHotel> hotelAmenities, double discount, String description, String email, String mobile,
			String imageUrl, int timesBooked, int customerRating, Set<Room> hotelRooms) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.star = star;
		this.minPrice = minPrice;
		this.hotelAmenities = hotelAmenities;
		this.discount = discount;
		this.description = description;
		this.email = email;
		this.mobile = mobile;
		this.imageUrl = imageUrl;
		this.timesBooked = timesBooked;
		this.customerRating = customerRating;
		this.hotelRooms = hotelRooms;
	}


	public int getHotelId() {
		return hotelId;
	}


	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getStar() {
		return star;
	}


	public void setStar(int star) {
		this.star = star;
	}


	public double getMinPrice() {
		return minPrice;
	}


	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}


	public Set<AmenitiesHotel> getHotelAmenities() {
		return hotelAmenities;
	}


	public void setHotelAmenities(Set<AmenitiesHotel> hotelAmenities) {
		this.hotelAmenities = hotelAmenities;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public int getTimesBooked() {
		return timesBooked;
	}


	public void setTimesBooked(int timesBooked) {
		this.timesBooked = timesBooked;
	}


	public int getCustomerRating() {
		return customerRating;
	}


	public void setCustomerRating(int customerRating) {
		this.customerRating = customerRating;
	}


	public Set<Room> getHotelRooms() {
		return hotelRooms;
	}


	public void setHotelRooms(Set<Room> hotelRooms) {
		this.hotelRooms = hotelRooms;
	}


	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", star=" + star + ", minPrice=" + minPrice + ", hotelAmenities="
				+ hotelAmenities + ", discount=" + discount + ", description=" + description + ", email=" + email
				+ ", mobile=" + mobile + ", imageUrl=" + imageUrl + ", timesBooked=" + timesBooked + ", customerRating="
				+ customerRating + ", hotelRooms=" + hotelRooms + "]";
	}

	
	
}
