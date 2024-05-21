package com.microservice.cartelera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceCarteleraApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCarteleraApplication.class, args);
	}

}
