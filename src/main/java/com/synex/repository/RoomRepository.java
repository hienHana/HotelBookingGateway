package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.synex.domain.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	
}
