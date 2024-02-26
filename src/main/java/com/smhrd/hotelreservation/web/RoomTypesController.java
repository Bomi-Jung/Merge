package com.smhrd.hotelreservation.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.smhrd.hotelreservation.service.RoomTypesService;

import com.smhrd.hotelreservation.web.dto.RoomTypesSaveReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@RestController
public class RoomTypesController {
	
	private final  RoomTypesService roomTypesService;

	@PostMapping("/admin/roomtype/add")
	public Long addRoomtype(@RequestBody RoomTypesSaveReqDto requestDto) {
		log.info("view to controller with addRoomtype");
		return roomTypesService.addRoomtype(requestDto);
	}
	
	@DeleteMapping("/admin/roomtypes/remove")
	public Long removeRoomtype(@RequestBody RoomTypesSaveReqDto requestDto) {
		log.info("view to controller with removeRoomtype");
		return roomTypesService.removeRoomtype(requestDto);
	}
	
	@PutMapping("/admin/roomtypes/update")
	public Long updateRoomtype(@RequestBody RoomTypesSaveReqDto requestDto) {
		log.info("view to controller with updateRoomtype");
		return roomTypesService.updateRoomtype(requestDto);
	}
	
}
