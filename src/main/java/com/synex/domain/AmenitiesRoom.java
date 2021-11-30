package com.synex.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class AmenitiesRoom {
	@Id
	private int amenityRoomId;
	
	
	private String amenityRoom;

	public AmenitiesRoom() {
		super();
	}

	public AmenitiesRoom(int amenityRoomId, String amenityRoom) {
		super();
		this.amenityRoomId = amenityRoomId;
		this.amenityRoom = amenityRoom;
	}

	public int getAmenityRoomId() {
		return amenityRoomId;
	}

	public void setAmenityRoomId(int amenityRoomId) {
		this.amenityRoomId = amenityRoomId;
	}

	public String getAmenityRoom() {
		return amenityRoom;
	}

	public void setAmenityRoom(String amenityRoom) {
		this.amenityRoom = amenityRoom;
	}

	
}
