package com.smhrd.hotelreservation.web.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationSaveReqDto {

	private LocalDate checkOutDate;
	private LocalDate checkInDate;
	private Long roomtype_id;
	
	@Builder
	public ReservationSaveReqDto(String checkOutDate, String checkInDate, Long roomtype_id, Long id) {
		this.checkOutDate = convertToLocalDate(checkOutDate);
		this.checkInDate = convertToLocalDate(checkInDate);
		this.roomtype_id = roomtype_id;
	}
	
	// JSON 타입으로 String 으로 들어온 checkInDate, checkOutDate LocalDate타입으로 변환 (YYYY-MM-DD)
	public LocalDate convertToLocalDate(String s) {
		return LocalDate.parse(s, DateTimeFormatter.ISO_DATE);
	}
	
}
