package com.synex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Hotel;
import com.synex.repository.HotelRepository;

@Service
public class HotelServiceImpl implements  HotelService {
	@Autowired HotelRepository hotelRepo;
	
	@Override
	public void saveHotel(Hotel hotel) {		
		hotelRepo.save(hotel);
	}

	
}
