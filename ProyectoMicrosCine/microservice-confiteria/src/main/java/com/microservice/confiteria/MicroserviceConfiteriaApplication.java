package com.microservice.confiteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceConfiteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfiteriaApplication.class, args);
	}

}
