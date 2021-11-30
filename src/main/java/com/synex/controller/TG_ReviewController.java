package com.synex.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Booking;
import com.synex.domain.Feedback;
import com.synex.domain.Reviews;
import com.synex.restclients.TG_ReviewRestClient;

@RestController
public class TG_ReviewController {
	@Autowired TG_ReviewRestClient reviewRestClient;
	
	@RequestMapping(value = "/saveFeedback", method = RequestMethod.POST)
	public ResponseEntity<Booking>  saveBooking (@RequestBody Feedback feedback, Principal principal ){
		System.out.println("Inside TravelGig Booking-> feedback: "+ feedback );
		Booking booking = reviewRestClient.saveFeedback(feedback, principal);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	} 
	
	
	@RequestMapping(value = "/getReviewByUserId", method = RequestMethod.GET)
	public ResponseEntity<List<Reviews>> getReviewByUserId(Principal principal){
		List<Reviews> reviews = reviewRestClient.getReviewByUserId(principal);
		return new ResponseEntity<List<Reviews>>(reviews, HttpStatus.OK);
	}
}
