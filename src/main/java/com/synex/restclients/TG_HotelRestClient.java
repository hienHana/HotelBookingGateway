package com.synex.restclients;




import java.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synex.domain.Booking;
import com.synex.domain.BookingDetails;
import com.synex.domain.Hotel;
import com.synex.domain.Room;
import com.synex.domain.SearchDetails;


@Component
public class TG_HotelRestClient {
	@Autowired
	private RestTemplate restTemplate;
	
	
	public List<Hotel> getAllHotels() {
		final String uri = "http://localhost:8383/getAllHotels";
		
		Hotel[] result = restTemplate.getForObject(uri, Hotel[].class);
		List<Hotel> listHotel = Arrays.asList(result);
		return listHotel;
	}
	
	
	public List<Hotel> getHotels(SearchDetails searchDetails) {

//			final String uri = "http://localhost:8383/getHotels";
//			
//			HttpHeaders headers = new HttpHeaders();
//			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//			HttpEntity<SearchDetails> entity = new HttpEntity<SearchDetails>(searchDetails, headers);
//			System.out.println("entity..." + entity.getBody());
//			ResponseEntity<Hotel[]> result = restTemplate.postForEntity(uri, entity, Hotel[].class);
//			List<Hotel> hotels = Arrays.asList(result.getBody());
//			System.out.println("hotel received at restclient " + result);
//
//			return hotels;
//			
//	}		
		
		
		
		final String bookingUri = "http://localhost:8484/getHotelIdsAvailByInOutkDate";
		Integer[] hotelIdsAvail = restTemplate.postForObject(bookingUri, searchDetails, Integer[].class);
		List<Integer> hotelIdsAvailList = Arrays.asList(hotelIdsAvail);
		
		//add hotelName from search as a key in map to send
		Map<String, List<Integer>> map = new HashMap<>();
		String name = searchDetails.getSearchHotel();
		
		map.put(name, hotelIdsAvailList);
		
		final String hotelSearchUri = "http://localhost:8383/getHotelsBySearchButton";
		Hotel[] searchResult = restTemplate.postForObject(hotelSearchUri,map, Hotel[].class);
		List<Hotel> listHotel = Arrays.asList(searchResult);
		return listHotel; 
		
	}
	
	/////
	public List<Room> getRoomsByHotelSelection(int hotelIdSel) {
				
		final String uri = "http://localhost:8383/getRoomsByHotelId/{hotelIdSel}";
		Room[] result = restTemplate.getForObject(uri, Room[].class, hotelIdSel);
		List<Room> listRooms = Arrays.asList(result);
		return listRooms;		
	}
	
	
	public List<Room> getRoomsByHotelSelectionWithDateSearch(int hotelIdSel, String checkInDate ) {
		
		final String uri = "http://localhost:8383/getRoomsByHotelIdWithDateSearch/{hotelIdSel}/{checkInDate}";
		Room[] result = restTemplate.getForObject(uri, Room[].class, hotelIdSel,checkInDate);
		List<Room> listRooms = Arrays.asList(result);
		return listRooms;		
	}
	
	
}
