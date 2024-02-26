package com.smhrd.hotelreservation.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smhrd.hotelreservation.model.entity.Users;


public interface UsersJpaRepository extends JpaRepository<Users, Long>{
	@Query("select u from Users u where u.username = :name")
	Users findByUsername(@Param("name") String username);
}
