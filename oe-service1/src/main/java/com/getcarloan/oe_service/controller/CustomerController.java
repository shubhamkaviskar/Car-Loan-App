package com.getcarloan.oe_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getcarloan.oe_service.entites.Customer;
import com.getcarloan.oe_service.entites.CustomerVarification;
import com.getcarloan.oe_service.entites.CustomerVerificationStatus;
import com.getcarloan.oe_service.entites.LoanApproval;
import com.getcarloan.oe_service.service.CustomerService;
import com.getcarloan.oe_service.service.CustomerServiceIMPL;

@RestController
@RequestMapping("/oe-service")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/")
	public ResponseEntity<String> check() {
		return new ResponseEntity<String>("App Working", HttpStatus.OK);

	}

	@GetMapping("/viewAllCustomer")
	public ResponseEntity<List<Customer>> viewAllCustomer() {
		return ResponseEntity.status(HttpStatus.OK).body(service.viewAllCustomer());
	}

	@GetMapping("/viewCustomerById/{cid}")
	public ResponseEntity<Customer> viewCustomerById(@PathVariable int cid) {

		return new ResponseEntity<Customer>(service.viewCustomerById(cid), HttpStatus.OK);

	}

	@PostMapping("/approval")
	public ResponseEntity<LoanApproval> loanApproval(@RequestBody LoanApproval s1) {

		LoanApproval loanapp = service.loanApproval(s1);

		return new ResponseEntity<LoanApproval>(loanapp, HttpStatus.CREATED);

	}

	@GetMapping("/getallLoanSantioned")
	public ResponseEntity<List<LoanApproval>> getallLoanSantioned() {

		List<LoanApproval> santioned = service.getallLoanSantioned();
		return new ResponseEntity<List<LoanApproval>>(santioned, HttpStatus.ACCEPTED);
	}

	@GetMapping("/sanctionAmt/{cid}")

	public ResponseEntity<LoanApproval> loanSantionByCid(@PathVariable int cid) {
		LoanApproval byCid = service.loanSantionByCid(cid);
		return ResponseEntity.status(HttpStatus.OK).body(byCid);
	}

	@GetMapping("/customerVerificationStatusbyId/{cid}")
	public ResponseEntity<CustomerVerificationStatus> viewCustomerVerificationStatusbyId(@PathVariable int cid) {

		return new ResponseEntity<CustomerVerificationStatus>(service.viewCustomerVerificationStatusbyId(cid),
				HttpStatus.OK);

	}

	@PostMapping("/customerVerification")
	public ResponseEntity<CustomerVarification> saveCustomerVerification(@RequestBody CustomerVarification v1) {

		CustomerVarification verification = service.saveCustomerVerification(v1);
		return new ResponseEntity<CustomerVarification>(verification, HttpStatus.OK);

	}

	@GetMapping("/getVarification/{cid}")
	public ResponseEntity<CustomerVarification> getVarification(@PathVariable int cid) {

		CustomerVarification cusvarification = service.getVarification(cid);
		return new ResponseEntity<CustomerVarification>(cusvarification, HttpStatus.OK);
	}

	@DeleteMapping("/cancelVarification/{cid}")
	public ResponseEntity<String> cancelVarification(@PathVariable int cid) {
		String msg = service.deleteVarification(cid);
		return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);

	}

}
