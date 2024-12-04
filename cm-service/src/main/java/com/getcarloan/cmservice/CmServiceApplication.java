package com.getcarloan.cmservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.getcarloan.cmservice")
public class CmServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmServiceApplication.class, args);
		System.out.println("cm is working");
	}
	
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
		
	}

}
