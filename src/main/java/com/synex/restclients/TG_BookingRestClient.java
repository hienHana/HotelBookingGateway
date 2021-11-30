package com.synex.restclients;

import java.security.Principal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.synex.domain.Booking;
import com.synex.domain.BookingDetails;
import com.synex.domain.Feedback;
import com.synex.domain.GuestDetail;
import com.synex.domain.Room;
import com.synex.domain.User;
import com.synex.services.GuestDetailService;
import com.synex.services.UserService;

@Component
public class TG_BookingRestClient {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired UserService userService;
	@Autowired GuestDetailService guestDetailService;
	
	public Booking saveBooking(Booking bookingDetail, Principal principal) {
		
		//get userId from login and use it to get guest's mobile, email, address
		System.out.println("In Rest Client getting "+bookingDetail +", principal: "+ principal.getName());
		 User user = userService.findByUsername(principal.getName() );
		 Booking booking = new Booking();
		 long userId = user.getUserId();
		 bookingDetail.setUserId(userId);
		 bookingDetail.setMobile(user.getMobile());
		 bookingDetail.setEmail(user.getEmail());
		 bookingDetail.setAddress(guestDetailService.getAddressByUserId(userId));	 
		 
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 bookingDetail.setBookedOn(timestamp);
	 
		final String uri = "http://localhost:8484/saveBooking";
		Booking result = restTemplate.postForObject(uri, bookingDetail, Booking.class);
		System.out.println("In Rest Client getting booking result: "+result);
		return result;
		
	
//	        System.out.println("In Rest Client "+bookingDetails);
//	        JSONObject jo = new JSONObject(bookingDetails);
//	        HttpHeaders headers = new HttpHeaders();
//	        headers.setContentType(MediaType.APPLICATION_JSON);
//	        HttpEntity<String> entity = new HttpEntity<String>(jo.toString(), headers);
//	        System.out.println("entity..." + entity.getBody());
//	        ResponseEntity<String> result = restTemplate.postForEntity(uri, entity, String.class);
//	        System.out.println("In Rest Client getting "+result.getBody());
//	        return result.getBody();
	}
	
	
	public List<BookingDetails> getBookingByUserId(Principal principal) {
		System.out.println("principal: "+ principal.getName());
		User user = userService.findByUsername(principal.getName());
		System.out.println("user: "+user);
		long userId = user.getUserId();
		System.out.println("userId: "+userId);
		
		final String uri = "http://localhost:8484/getBookingsByUserId/{userId}";
		
		
		BookingDetails[] bookings = restTemplate.getForObject(uri, BookingDetails[].class, userId);
		List<BookingDetails> bookingList = Arrays.asList(bookings);
		System.out.println("In Rest Client getting booking result: "+bookingList);
		
		return bookingList;
	}
	
	public Booking cancelBooking(int bookingId) {
		final String uri = "http://localhost:8484/cancelBooking/{bookingId}";
		System.out.println("In Rest Client before cancel "+ bookingId);
		Booking booking = restTemplate.getForObject(uri, Booking.class, bookingId);
		System.out.println("In Rest Client after cancel"+ booking);
		return booking;
	}
	
}
