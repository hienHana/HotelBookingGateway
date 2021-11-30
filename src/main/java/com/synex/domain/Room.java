package com.synex.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="rooms")
public class Room {
	@Id
	private int roomId;	
	@ManyToOne
	private RoomType roomType;		
	@ManyToMany
	private Set<AmenitiesRoom> roomAmenities;	
	private int noRooms;
	private float price;
	private float discount;
	private String description;
	private String policies;
	
//	@Transient
//	private String hotelName;
//	
//	@Transient
//	private String roomType;
//	
//	@Transient
//	private Set<String> hotelRoomAmenityNames = new HashSet<>();
	public Room() {
		super();
	}

	public Room(int roomId, RoomType roomType, Set<AmenitiesRoom> roomAmenities, int noRooms, float price, float discount,
			String description, String policies) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomAmenities = roomAmenities;
		this.noRooms = noRooms;
		this.price = price;
		this.discount = discount;
		this.description = description;
		this.policies = policies;
	}
	

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public Set<AmenitiesRoom> getRoomAmenities() {
		return roomAmenities;
	}

	public void setRoomAmenities(Set<AmenitiesRoom> roomAmenities) {
		this.roomAmenities = roomAmenities;
	}

	public int getNoRooms() {
		return noRooms;
	}

	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPolicies() {
		return policies;
	}

	public void setPolicies(String policies) {
		this.policies = policies;
	}
	
	
}
