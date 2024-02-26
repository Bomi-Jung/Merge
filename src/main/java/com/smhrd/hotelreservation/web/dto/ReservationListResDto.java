package com.smhrd.hotelreservation.web.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.smhrd.hotelreservation.model.entity.ReservationDetails;
import com.smhrd.hotelreservation.model.entity.Reservations;
import com.smhrd.hotelreservation.model.entity.Users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationListResDto {
	
	private String username;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private Long roomNumber;
	private Long reservation_id;
	private LocalDateTime CreatedAt;
	private Long totalPrice;
	
	@Builder
	public ReservationListResDto(Users user, Reservations reservation, List<ReservationDetails> l) {
		this.username = user.getUsername();
		this.checkInDate  = l.get(0).getDate();
		this.checkOutDate = l.size() == 1 ? l.get(0).getDate() : l.get(l.size() - 1).getDate();
		this.roomNumber = reservation.getReservationDetails().get(0).getRooms().getRoomNumber();
		this.reservation_id = reservation.getId();
		this.CreatedAt = reservation.getCreatedAt();
		this.totalPrice = reservation.getTotalPrice();
	}

}