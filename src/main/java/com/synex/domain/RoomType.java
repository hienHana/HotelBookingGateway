package com.synex.domain;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoomType {
	@Id
	private int roomTypeId;
	
	private String typeRoom;

	public RoomType() {
		super();
	}

	public RoomType(int roomTypeId, String typeRoom) {
		super();
		this.roomTypeId = roomTypeId;
		this.typeRoom = typeRoom;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getTypeRoom() {
		return typeRoom;
	}

	public void setTypeRoom(String typeRoom) {
		this.typeRoom = typeRoom;
	}

	
	
	
}
