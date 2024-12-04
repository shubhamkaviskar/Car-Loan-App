package com.getcarloan.oe_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.getcarloan.oe_service")
public class OeService1Application {

	public static void main(String[] args) {
		SpringApplication.run(OeService1Application.class, args);
		System.out.println("Oe app started...........");
	}

}
