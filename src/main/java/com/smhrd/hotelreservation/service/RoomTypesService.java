package com.smhrd.hotelreservation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smhrd.hotelreservation.model.entity.RoomTypes;
import com.smhrd.hotelreservation.model.entity.Rooms;
import com.smhrd.hotelreservation.model.repository.RoomTypesJpaRepository;
import com.smhrd.hotelreservation.model.repository.RoomsJpaRepository;
import com.smhrd.hotelreservation.web.dto.RoomTypesResDto;
import com.smhrd.hotelreservation.web.dto.RoomTypesSaveReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoomTypesService {
	
private final RoomTypesJpaRepository roomTypesJpaRepository;
private final RoomsJpaRepository roomsJpaRepository;
	
	/**
	 * method	객실타입 등록
	 */
	@Transactional
	public Long addRoomtype(RoomTypesSaveReqDto requestDto) {
		return roomTypesJpaRepository.save(requestDto.toEntity()).getId();
	}
	
	/**
	 * method	모든 객실정보 전송
	 */
	@Transactional(readOnly = true)
	public List<RoomTypesResDto> findAll(){
		return roomTypesJpaRepository.findAll().stream().map(RoomTypesResDto::new).collect(Collectors.toList());
	}
	
	/**
	 * method	객실타입 삭제
	 */
	@Transactional
	public Long removeRoomtype(RoomTypesSaveReqDto requestDto) {
		RoomTypes roomType = roomTypesJpaRepository.findById(requestDto.getId()).orElseThrow(() -> new IllegalArgumentException("해당 룸타입이 존재하지 않습니다."));
		
		// roomType과 연관된 방들을 먼저 찾아서 roomTypes 필드를 null로 설정
	    List<Rooms> roomsToDelete = roomsJpaRepository.findByRoomTypes(roomType);
	    for (Rooms room : roomsToDelete) {
	        room.setRoomTypes(null);
	    }
		Long roomTypeId = roomType.getId();
		
		roomTypesJpaRepository.delete(roomType);
		
		return roomTypeId;
	}
	
	/**
	 * method	객실타입 변경
	 */
	@Transactional
	public Long updateRoomtype(RoomTypesSaveReqDto requestDto) {
		RoomTypes roomType = roomTypesJpaRepository.findById(requestDto.getId()).orElseThrow(() -> new IllegalArgumentException("해당 룸타입이 존재하지 않습니다."));
		// 방법1 : set사용
		roomType.setPrice(requestDto.getPrice());
		roomType.setRoomName(requestDto.getRoomName());
		// 방법2 : save로 다시 저장
		return roomType.getId();
	}
	
	
}
