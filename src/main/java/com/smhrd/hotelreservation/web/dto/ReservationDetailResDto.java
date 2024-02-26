package com.smhrd.hotelreservation.web.dto;

import java.time.LocalDate;
import java.util.List;

import com.smhrd.hotelreservation.model.entity.ReservationDetails;
import com.smhrd.hotelreservation.model.entity.Reservations;
import com.smhrd.hotelreservation.model.entity.Users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationDetailResDto extends ReservationListResDto{
	
	private String roomName;
	private Long totalPrice;

	public ReservationDetailResDto(Users user, Reservations reservation, List<ReservationDetails> l) {
		super(user, reservation, l);
		this.roomName = reservation.getReservationDetails().get(0).getRooms().getRoomTypes().getRoomName();
		this.totalPrice = reservation.getTotalPrice();
	}
	
}