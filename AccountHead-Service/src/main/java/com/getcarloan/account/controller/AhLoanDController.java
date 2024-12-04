package com.getcarloan.account.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getcarloan.account.entity.Customer;
import com.getcarloan.account.entity.LoanDisbursement;

import com.getcarloan.account.service.LoanDisbursementService;






@RestController
@RequestMapping("/ah-api/LoanDisbursement")
public class AhLoanDController {
	
	
	
	@Autowired
	private LoanDisbursementService ldService;
	
	
	@PostMapping("/generateLoanDisbursementFile")
	public ResponseEntity<String> generateLoanDisbursementFile(@RequestBody LoanDisbursement loanDisbursement) {
		System.out.println(loanDisbursement);
		return new ResponseEntity<String>(ldService.generateLoanDisbursementFile(loanDisbursement),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getAllLoanDisbursement")
	public ResponseEntity<List<LoanDisbursement>> getAllLoanDisbursement(){
		return new ResponseEntity<List<LoanDisbursement>>(ldService.getAllLoanDisbursement(),HttpStatus.OK);
		
	}
	@GetMapping("/getLoanDisbursementByCustId/{cid}")
	public ResponseEntity<LoanDisbursement> getLoanDisbursementByCustId(@PathVariable int cid ){
		return new ResponseEntity<LoanDisbursement>(ldService.getLoanDisbursementByCustId(cid),HttpStatus.OK);
	}
	
	@GetMapping("/getLoanDisbursementByAgrId/{agreementId}")
	public ResponseEntity<LoanDisbursement> getLoanDisbursementByAgrId(@PathVariable int agreementId ){
		return new ResponseEntity<LoanDisbursement>(ldService.getLoanDisbursementByAgrId(agreementId),HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerId/{cid}")
	public ResponseEntity<Customer> getCustomerId(@PathVariable int cid) {
		return new ResponseEntity<Customer>(ldService.getCustomerId(cid),HttpStatus.OK);
		
	
	}
	@GetMapping("/getAllCustomerByFeign")
	public ResponseEntity<List<Customer>> getAllCustomerByFeign() {
		return new ResponseEntity<List<Customer>>(ldService.getAllCustomerByFeign(),HttpStatus.OK);
		
	
	}
	
	
}
