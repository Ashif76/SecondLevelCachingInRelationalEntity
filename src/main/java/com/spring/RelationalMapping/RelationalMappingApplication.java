package com.spring.RelationalMapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RelationalMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationalMappingApplication.class, args);
	}
}
