package com.microservice.sedes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceSedesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSedesApplication.class, args);
	}

}
