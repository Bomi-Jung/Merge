package com.smhrd.hotelreservation.web.dto;

import com.smhrd.hotelreservation.model.entity.RoomTypes;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RoomTypesResDto {
	private Long id;
	private String roomName;
	private Long price;
	
	@Builder
	public RoomTypesResDto(RoomTypes roomTypes) {
		this.id = roomTypes.getId();
		this.roomName = roomTypes.getRoomName();
		this.price = roomTypes.getPrice();
	}
}
