package com.smhrd.hotelreservation.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smhrd.hotelreservation.service.ReservationsService;
import com.smhrd.hotelreservation.service.RoomTypesService;
import com.smhrd.hotelreservation.service.RoomsService;
import com.smhrd.hotelreservation.service.UsersService;
import com.smhrd.hotelreservation.web.dto.ReservationDetailListResDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AdminController {
	
	private final ReservationsService reservationsService;

	
	// 예약 상세 내역
	@GetMapping("/admin/reservationList/detail")
	public List<ReservationDetailListResDto> reservationDetail(Model model, @RequestParam("reservation_id") String reservationId, RedirectAttributes redirectAttributes) {
		log.info("예약상세 이동 가져오기...");
//		model.addAttribute("reservtionDetail", reservationsService.findOne(Long.parseLong(reservationId)));
//		return "reservationDetailsList";
		return reservationsService.findOne(Long.parseLong(reservationId));
	}
	
	
	
}
