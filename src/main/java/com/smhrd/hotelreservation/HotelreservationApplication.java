package com.smhrd.hotelreservation;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.smhrd.hotelreservation.model.entity.Users;



@SpringBootApplication
@EnableJpaAuditing
public class HotelreservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelreservationApplication.class, args);
	}

	// Bean
	@Bean
	public AuditorAware<String> auditorProvider() {
		return () -> Optional.of(Users.builder().build().getUsername());
	}
}
