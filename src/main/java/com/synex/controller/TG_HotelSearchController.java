package com.synex.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Booking;
import com.synex.domain.BookingDetails;
import com.synex.domain.Hotel;
import com.synex.domain.Room;
import com.synex.domain.SearchDetails;
import com.synex.restclients.TG_HotelRestClient;

@RestController
public class TG_HotelSearchController {
	@Autowired TG_HotelRestClient hotelRestClient;
	
	@RequestMapping(value = "/getAllHotels", method = RequestMethod.GET)
	public ResponseEntity<List<Hotel>> getAllHotels(Principal principal){
		if(principal != null) {
			System.out.println("&&&&&&&&&&&&& Principal name: "+principal.getName());
		}else {
			System.out.println("&&&&&&&&&&&&& Principal name: null");
		}
		List<Hotel> hotels = hotelRestClient.getAllHotels();
		return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getHotels", method = RequestMethod.POST)
	public ResponseEntity<List<Hotel>> getHotelsBySearchDetails(@RequestBody SearchDetails searchDetails){
		System.out.println("Inside TravelGig Controller "+searchDetails.getCheckIn() + " "+searchDetails.getCheckOut());
		List<Hotel> hotels = hotelRestClient.getHotels(searchDetails);
		return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
	}
	
	//// 
	@RequestMapping(value = "/getRoomsByHotelId/{hotelIdSel}", method = RequestMethod.GET)
	public ResponseEntity<List<Room>> getRoomsByHotelId(@PathVariable int hotelIdSel){
		List<Room> rooms = hotelRestClient.getRoomsByHotelSelection(hotelIdSel);
		return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getRoomByHotelId/{hotelIdSel}/{checkInDate}", method = RequestMethod.GET)
	public ResponseEntity<List<Room>> getRoomsByHotelIdWithDateSearch(@PathVariable("hotelIdSel") int hotelIdSel, @PathVariable("checkInDate") String checkInDate){
		List<Room> rooms = hotelRestClient.getRoomsByHotelSelectionWithDateSearch(hotelIdSel,checkInDate);
		return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
	}
}
