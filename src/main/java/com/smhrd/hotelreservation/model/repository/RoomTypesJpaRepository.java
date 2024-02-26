package com.smhrd.hotelreservation.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smhrd.hotelreservation.model.entity.RoomTypes;

public interface RoomTypesJpaRepository extends JpaRepository<RoomTypes, Long>{

}
