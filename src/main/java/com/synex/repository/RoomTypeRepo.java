package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.RoomType;

public interface RoomTypeRepo extends JpaRepository<RoomType, Integer> {

}
