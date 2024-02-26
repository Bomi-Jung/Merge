package com.smhrd.hotelreservation.web.dto;

import com.smhrd.hotelreservation.model.entity.RoomTypes;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoomTypesSaveReqDto {
	private Long id;
	private String roomName;
	private Long price;
	
	@Builder
	public RoomTypesSaveReqDto(Long id,String roomName, Long price) {
		this.id = id;
		this.roomName = roomName;
		this.price = price;
	}
	
	public RoomTypes toEntity() {
		return RoomTypes.builder().roomName(roomName).price(price).build();
	}
}
