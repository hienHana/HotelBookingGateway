package com.synex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.GuestDetail;
import com.synex.repository.GuestDetailRepository;

@Service
public class GuestDetailServiceImpl implements GuestDetailService {

	@Autowired GuestDetailRepository guestDetailRepository;
	
	@Override
	public GuestDetail saveGuestDetail(GuestDetail guestDetail) {
		return guestDetailRepository.save(guestDetail);
	}

	@Override
	public String getAddressByUserId(long id) {
		return guestDetailRepository.getAddressByUserId(id);
	}

}
