package com.synex.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synex.domain.AmenitiesHotel;
import com.synex.domain.AmenitiesRoom;
import com.synex.domain.Hotel;
import com.synex.domain.Room;
import com.synex.domain.RoomType;
import com.synex.repository.AmenitiesHotelRepo;
import com.synex.repository.AmenitiesRoomRepo;
import com.synex.repository.RoomTypeRepo;
import com.synex.services.HotelService;
import com.synex.services.RoomService;

@Controller
public class TG_CreateResourcesController {
	@Autowired HotelService hotelService;
	@Autowired RoomService roomService;
	@Autowired AmenitiesHotelRepo amenHotelRepo;
	@Autowired AmenitiesRoomRepo amenRoomRepo;
	@Autowired RoomTypeRepo roomTypeRepo;

	

	
	@RequestMapping(value = "/getRoomTypeForm") 
	public String getRoomType() { 
		 return "roomTypeform";	
	}
	
	@RequestMapping(value = "/createRoomType", method = RequestMethod.POST) 
	public String createRoomType(@ModelAttribute RoomType roomType, BindingResult br, Model model) { 
		if(!br.hasErrors()) {
		  roomTypeRepo.save(roomType); 
		  return "redirect:admin.html";
		}
		return "roomTypeform";	
	}
	
	
	@RequestMapping(value = "/getAmenitiesHotelForm") 
	public String getAmenitiesHotelForm() { 
		 return "amenitiesHotelForm";	
	}
	
	@RequestMapping(value = "/createAmenitiesHotel", method = RequestMethod.POST) 
	public String createAmenitiesHotel(@ModelAttribute AmenitiesHotel amenitiesHotel, BindingResult br, Model model) { 
		if(!br.hasErrors()) {
			amenHotelRepo.save(amenitiesHotel); 
		  return "redirect:admin.html";
		}
		return "amenitiesHotelForm";	
	}
	
	
	@RequestMapping(value = "/getAmenitiesRoomForm") 
	public String getAmenitiesRoomForm() { 
		 return "amenitiesRoomForm";	
	}
	
	@RequestMapping(value = "/createAmenitiesRoom", method = RequestMethod.POST) 
	public String createAmenitiesRoom(@ModelAttribute AmenitiesRoom amenitiesRoom, BindingResult br, Model model) { 
		if(!br.hasErrors()) {
			amenRoomRepo.save(amenitiesRoom); 
		  return "redirect:admin.html";
		}
		return "amenitiesRoomForm";	
	}
	
	
	@RequestMapping(value = "/getRoomForm") 
	public String getRoomForm() { 
		 return "roomForm";	
	}
	
	@RequestMapping(value = "/createRoom", method = RequestMethod.POST) 
	public String createRoom(@ModelAttribute Room room, BindingResult br, Model model) { 
		Set<AmenitiesRoom> preSelectedRoomAmenities = new HashSet<>();
		preSelectedRoomAmenities.add(amenRoomRepo.findById(2).get());

		room.setRoomAmenities(preSelectedRoomAmenities);
		if(!br.hasErrors()) {
			roomService.saveRoom(room); 
		  return "redirect:admin.html";
		}
		System.out.println("&&&&&&&& error");
		return "roomForm";	
	}
	
/////////////////////////////////////////////////////////////////////////////////////	
	
	  @RequestMapping(value = "/createHotel", method = RequestMethod.POST) 
	  public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		  hotelService.saveHotel(hotel); 
		  return new ResponseEntity<Hotel>(hotel,HttpStatus.OK); 
	  }
	  
	  @RequestMapping(value = "/getHotelAmenities", method = RequestMethod.GET)
	  public ResponseEntity<List<AmenitiesHotel>> getHotelAmenities() {
	  List<AmenitiesHotel> amenHotelList = amenHotelRepo.findAll(); return new
	  ResponseEntity<List<AmenitiesHotel>>(amenHotelList , HttpStatus.OK); }
	  
	  
	  @RequestMapping(value = "/createARoom", method = RequestMethod.POST) 
	  public ResponseEntity<Room> createARoom(@RequestBody Room room) {
//		  Set<AmenitiesRoom> preSelectedRoomAmenities = new HashSet<>();
//		  preSelectedRoomAmenities.add(amenRoomRepo.findById(2).get());
//		  
//		  RoomType rt = roomTypeRepo.findById(2).get();
////			room.setRoomAmenities(preSelectedRoomAmenities);
//		  room = new Room(2, rt, preSelectedRoomAmenities, 3, 250, 0,
//			"King room", "Non smoking room");

		  roomService.saveRoom(room); 
		  return new ResponseEntity<Room>(room,HttpStatus.OK); 
	  }
	  
	  
	  
	  @RequestMapping(value = "/getRoomAmenities", method = RequestMethod.GET)
	  public ResponseEntity<List<AmenitiesRoom>> getRoomAmenities() {
	  List<AmenitiesRoom> amenRoomList = amenRoomRepo.findAll(); return new
	  ResponseEntity<List<AmenitiesRoom>>(amenRoomList , HttpStatus.OK); }
	 
////////////////////////////////////////////////////////////////////////////////////////////////	
	
//		@RequestMapping(value="hotelForm")
//		public String createHotelForm( Model model) {
//			List<AmenitiesHotel> amenHotelList = new ArrayList<>();
//			amenHotelList = amenHotelRepo.findAll();
//			Map<Integer, String> amenHotelMap = new LinkedHashMap<>();
//			for(AmenitiesHotel a:amenHotelList) {
//				amenHotelMap.put(a.getAmenityHotelId(), a.getAmenityHotel());
//			}
//			model.addAttribute("amenitiesHotel", amenHotelMap);
//			return "hotelForm";
//		}
	//	
//		@RequestMapping(value = "/createHotel", method = RequestMethod.POST)
//		public String createHotel(@Valid @ModelAttribute Hotel hotel, BindingResult br, Model model) {
//			if(!br.hasErrors()) {
//				hotelService.saveHotel(hotel);
//				return "hotelForm";
//			}
//			return "hotelForm";
//		}
	  
	  
//	@RequestMapping(value = "/getRoomType", method = RequestMethod.GET)
//	public ResponseEntity<List<RoomType>> getRoomType() {
//		List<RoomType> roomTypes = roomTypeRepo.findAll();
//		System.out.println("&&&&&&&"+ roomTypes);
//		return  new  ResponseEntity<List<RoomType>>(roomTypes, HttpStatus.OK);
//	}
	
	
//	@RequestMapping(value="roomForm")
//	public String createRoomForm( Model model) {
//		List<AmenitiesRoom> amenRoomList = new ArrayList<>();
//		amenRoomList = amenRoomRepo.findAll();
//		Map<Integer, String> amenRoomMap = new LinkedHashMap<>();
//		for(AmenitiesRoom a:amenRoomList) {
//			amenRoomMap.put(a.getAmenityRoomId(), a.getAmenityRoom());
//		}
//		model.addAttribute("amenitiesRoom", amenRoomMap);
//		
//		List<RoomType> roomTypeList = new ArrayList<>();
//		roomTypeList = roomTypeRepo.findAll();
//		Map<Integer, String> roomTypeMap = new LinkedHashMap<>();
//		for(RoomType a:roomTypeList) {
//			roomTypeMap.put(a.getRoomTypeId(), a.getTypeRoom());
//		}
//		model.addAttribute("roomTypes", roomTypeMap);
//		return "roomForm";
//	}
//	
//	@RequestMapping(value = "/createRoom", method = RequestMethod.POST)
//	public String createRoom(@Valid @ModelAttribute Room room, BindingResult br, Model model) {
//		if(!br.hasErrors()) {
//			roomService.saveRoom(room);
//			return "roomForm";
//		}
//		return "roomForm";
//	}

}
