package com.rest.rest_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.rest.rest_services.proxy")
public class RestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServicesApplication.class, args);
	}

}
