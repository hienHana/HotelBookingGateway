package com.synex.restclients;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.synex.domain.Booking;
import com.synex.domain.Feedback;
import com.synex.domain.Reviews;
import com.synex.domain.User;
import com.synex.services.UserService;

@Component
public class TG_ReviewRestClient {
	@Autowired private RestTemplate restTemplate;
	@Autowired UserService userService;
	
	public Booking saveFeedback(Feedback feedback, Principal pricipal) {
		final String uri = "http://localhost:8484/saveFeedback";
		System.out.println("In Rest Client before saving feedback: "+ feedback);        
		Booking booking = restTemplate.postForObject(uri, feedback, Booking.class);
		System.out.println("In Rest Client after saving feedback"+booking);
		return booking;
	}
	
	public List<Reviews> getReviewByUserId(Principal principal){
		User user = userService.findByUsername(principal.getName());
		long userId = user.getUserId();
		final String uri = "http://localhost:8484/getReviewByUserId/{userId}";
		Reviews[] reviews = restTemplate.getForObject(uri, Reviews[].class, userId);
		List<Reviews> result = Arrays.asList(reviews);
		return result;
	}
}
