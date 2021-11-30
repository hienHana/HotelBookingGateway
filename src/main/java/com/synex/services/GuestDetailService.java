package com.synex.services;

import com.synex.domain.GuestDetail;

public interface GuestDetailService {
	public GuestDetail saveGuestDetail(GuestDetail guestDetail);
	
	public String getAddressByUserId(long id);
}
