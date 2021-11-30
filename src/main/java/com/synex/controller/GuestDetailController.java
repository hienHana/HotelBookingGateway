package com.synex.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synex.domain.GuestDetail;
import com.synex.repository.GuestDetailRepository;

@Controller
public class GuestDetailController {
	@Autowired GuestDetailRepository guestDetailRepository;
	
	@RequestMapping(value="/getGuestDetailForm")
	public String getGuestDetailForm() {
		return "guestDetailForm";
	}
	
	
	@RequestMapping(value="createGuestDetail" , method = RequestMethod.POST)
	public String createGuestDetail(@ModelAttribute GuestDetail guestDetail) {
		guestDetail = guestDetailRepository.save(guestDetail);
		return "login";
	}
}
