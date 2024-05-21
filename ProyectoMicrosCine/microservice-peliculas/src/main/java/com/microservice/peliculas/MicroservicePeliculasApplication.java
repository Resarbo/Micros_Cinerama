package com.microservice.peliculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicePeliculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePeliculasApplication.class, args);
	}

}
