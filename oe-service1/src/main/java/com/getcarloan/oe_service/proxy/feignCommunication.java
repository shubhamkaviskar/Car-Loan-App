package com.getcarloan.oe_service.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.getcarloan.oe_service.entites.Customer;

@FeignClient("Relational-Executive")
public interface feignCommunication {
	
	@GetMapping("/ReService/getAllCustomer")
	public List<Customer> getAllCustomer();

	@GetMapping("/ReService/getCustomerById/{cid}")
	public Customer getCustomerById(@PathVariable int cid);
}
