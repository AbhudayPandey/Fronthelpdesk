package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableCaching
@SpringBootApplication
public class HospitalFrontDeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalFrontDeskApplication.class, args);
	}

}
