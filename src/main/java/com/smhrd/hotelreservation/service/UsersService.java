package com.smhrd.hotelreservation.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.smhrd.hotelreservation.model.entity.Users;
import com.smhrd.hotelreservation.model.repository.UsersJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UsersService {
	private final UsersJpaRepository usersJpaRepository;
	
	@Transactional
	public Long save() {
		log.info("usersService method save start...");
		Users users = usersJpaRepository.findByUsername("user");
		return (users == null) ? usersJpaRepository.save(Users.builder().build()).getId() : users.getId();
	}
}
