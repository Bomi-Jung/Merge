package com.smhrd.hotelreservation.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.hotelreservation.model.entity.RoomTypes;
import com.smhrd.hotelreservation.model.entity.Rooms;

@Repository
public interface RoomsJpaRepository extends JpaRepository<Rooms, Long>{
	List<Rooms> findByRoomTypes(RoomTypes roomType);
}
