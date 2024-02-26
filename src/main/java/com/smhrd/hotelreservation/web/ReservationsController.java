package com.smhrd.hotelreservation.web;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.hotelreservation.service.ReservationsService;
import com.smhrd.hotelreservation.web.dto.ReservationDeleteReqDto;
import com.smhrd.hotelreservation.web.dto.ReservationDetailSaveReqDto;
import com.smhrd.hotelreservation.web.dto.ReservationSaveReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ReservationsController {
	
	private final ReservationsService reservationsService;
	
	// post	예약등록
	@PostMapping("/home/reservation/add")
	public Long reservation(@RequestBody ReservationSaveReqDto requestDto) {
		System.out.println(requestDto);
		log.info("view to controller with addReservation");
		return reservationsService.reservation(requestDto);
	}
	
	// delete 관리자 예약 취소 ( 삭제 )
		@DeleteMapping("/admin/reservation/remove")
		public Long deleteReservation(@RequestBody ReservationDeleteReqDto requestDto) {
			log.info("view to controller with deleteReservation");
			return reservationsService.deleteReservation(requestDto);
		}
	
	// delete 관리자 상세예약 취소 ( 삭제 )
	@DeleteMapping("/admin/reservationdetails/remove")
	public Long deleteReservationDetails(@RequestBody ReservationDetailSaveReqDto requestDto) {
		log.info("view to controller with deleteReservationDetails");
		return reservationsService.deleteReservationDetails(requestDto);
	}
	
	
	
}
