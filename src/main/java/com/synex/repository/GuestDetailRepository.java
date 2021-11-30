package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synex.domain.GuestDetail;

public interface GuestDetailRepository extends JpaRepository<GuestDetail, Integer> {
	
	@Query(value="select address from guestDetail where user_userId=?1", nativeQuery=true)
	public String getAddressByUserId(long id);
}
