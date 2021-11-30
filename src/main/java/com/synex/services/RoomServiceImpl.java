package com.synex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Room;
import com.synex.repository.RoomRepository;

@Service
public class RoomServiceImpl implements  RoomService {
	@Autowired RoomRepository roomRepo;

	@Override
	public Room saveRoom(Room room) {
		return roomRepo.save(room);
	}

	@Override
	public Room getRoomById(int id) {
		return roomRepo.findById(id).get();
	}

	
}
