package com.synex.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synex.domain.Booking;
import com.synex.domain.BookingDetails;
import com.synex.domain.Feedback;
import com.synex.domain.Room;
import com.synex.restclients.TG_BookingRestClient;
import com.synex.restclients.TG_HotelRestClient;


@Controller
public class TG_BookingController {
	@Autowired TG_BookingRestClient bookingRestClient;
	
	@RequestMapping(value = "/saveBooking", method = RequestMethod.POST)
	public ResponseEntity<Booking> saveBooking(@RequestBody Booking bookingDetail, Principal principal){
		System.out.println("Inside TravelGig controller before " + bookingDetail);
		Booking booking= bookingRestClient.saveBooking(bookingDetail, principal);
		System.out.println("Inside TravelGig controller " + bookingDetail);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/getBookingByUserId", method = RequestMethod.GET)
	public ResponseEntity<List<BookingDetails>> getBookingByUserId(Principal principal){
		System.out.println("principal: "+ principal.getName());
		List<BookingDetails> bookings = bookingRestClient.getBookingByUserId(principal);
		System.out.println("Inside TravelGig controller " + bookings);
		return new ResponseEntity<List<BookingDetails>>(bookings, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/cancelBooking/{bookingId}", method = RequestMethod.GET)
	public ResponseEntity<Booking> cancelBooking(@PathVariable int bookingId){
		System.out.println("Inside TravelGig cancel controller " + bookingId);
		Booking booking = bookingRestClient.cancelBooking(bookingId);
		System.out.println("Inside TravelGig controller after delete");	
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}
	
	
	//////////////////////////
	@RequestMapping (value="/rooms")
	public String getRoomsPage() {
		return "loadRoomsByHotelSelection";
	}
	
	
}
