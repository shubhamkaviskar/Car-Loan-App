package com.getcarloan.oe_service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.getcarloan.oe_service.entites.CustomerVerificationStatus;


@FeignClient("CREDIT-MANEGER")
public interface feignCommVerification {
	
	@GetMapping("/cmService/customerVerificationbyId/{cid}")
	public CustomerVerificationStatus customerVerificationbyId(@PathVariable int cid);

}
