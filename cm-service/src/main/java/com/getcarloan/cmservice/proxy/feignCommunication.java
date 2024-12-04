package com.getcarloan.cmservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.getcarloan.cmservice.entities.Customer;
import com.getcarloan.cmservice.entities.PreviousLoan;




@FeignClient("Relational-Executive")
public interface feignCommunication {
	
	@GetMapping("/ReService/getAllCustomer")
	public List<Customer> getAllCustomer();

	@GetMapping("/ReService/getCustomerById/{cid}")
	public Customer getCustomerById(@PathVariable int cid);
	
	@GetMapping("/ReService/getAllPreviousLoan")
	public List<PreviousLoan> getAllPreviousLoan();
	

	@GetMapping("/ReService/getPreviousLoan/{pLoanId}")
	public PreviousLoan getPreviousLoanById(@PathVariable int pLoanId);
}
