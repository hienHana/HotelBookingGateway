package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class AmenitiesHotel {
	@Id
	private int amenityHotelId;

	private String amenityHotel;
	

	public AmenitiesHotel() {
		super();
	}


	public AmenitiesHotel(int amenityHotelId, String amenityHotel) {
		super();
		this.amenityHotelId = amenityHotelId;
		this.amenityHotel = amenityHotel;
	}


	public int getAmenityHotelId() {
		return amenityHotelId;
	}


	public void setAmenityHotelId(int amenityHotelId) {
		this.amenityHotelId = amenityHotelId;
	}


	public String getAmenityHotel() {
		return amenityHotel;
	}


	public void setAmenityHotel(String amenityHotel) {
		this.amenityHotel = amenityHotel;
	}
	
}
