package com.synex.services;

import com.synex.domain.Room;


public interface RoomService {
	public Room saveRoom(Room room);
	public Room getRoomById(int id);
}
