package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Hotel;


public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
