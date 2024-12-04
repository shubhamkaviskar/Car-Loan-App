package com.getcarloan.reservice.communication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.getcarloan.reservice.entities.CustomerVarification;


@FeignClient (url="http://localhost:8083/oe-service",name="Operations-Executive1")
public interface FeignClientOE {

	@GetMapping("/getVarification/{cid}")
	public ResponseEntity<CustomerVarification> getVarification(@PathVariable int cid);
	
}