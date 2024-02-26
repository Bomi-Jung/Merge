package com.smhrd.hotelreservation.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Reservations extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reservation_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users users;
	
	// reservationDetails
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="reservation_id")
	private List<ReservationDetails> reservationDetails;
	
	// totalPrice
	private Long totalPrice;
	
	@Builder
	public Reservations(Users users, List<ReservationDetails> reservationDetails) {
		this.users = users;
		this.reservationDetails = reservationDetails;
		reservationDetails.forEach(x -> this.calculateTotalPrice(x.getRooms().getRoomTypes().getPrice()));

	}
	
	private void calculateTotalPrice(Long price) {
		this.totalPrice = this.totalPrice == null ? price : this.totalPrice + price;
	}
	
	
}
