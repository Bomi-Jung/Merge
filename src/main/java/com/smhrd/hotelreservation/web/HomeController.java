package com.smhrd.hotelreservation.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smhrd.hotelreservation.service.ReservationsService;
import com.smhrd.hotelreservation.service.RoomTypesService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
	
	private final ReservationsService reservationsService;
	private final RoomTypesService roomTypesService;
	
	// reservation(예약하기)
	@GetMapping("/home/reservation")
	public String reservation(Model model) {
		log.info("예약하기 이동...");
		model.addAttribute("roomTypes", roomTypesService.findAll());
		return "reservation";
	}
	
	// 예약내역
	@GetMapping("/home/reservationList")
	public String reservationList(Model model) {
		log.info("예약내역 이동...");
		model.addAttribute("reservtionList", reservationsService.findAll());
		return "reservationList";
	}
	
	// 예약 상세 내역
	@GetMapping("/home/reservationList/detail")
	public String reservationDetail(Model model, @RequestParam("reservation_id") String reservationId, RedirectAttributes redirectAttributes) {
		log.info("예약상세 이동...");
		model.addAttribute("reservtionDetail", reservationsService.findOne(Long.parseLong(reservationId)));
		return "reservationDetailsList";
	}
	
}
