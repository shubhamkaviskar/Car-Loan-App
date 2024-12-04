package com.getcarloan.cmservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getcarloan.cmservice.dto.CustomerVerificationaDTO;
import com.getcarloan.cmservice.entities.CIBILScore;
import com.getcarloan.cmservice.entities.Customer;

import com.getcarloan.cmservice.entities.CustomerVerificationStatus;
import com.getcarloan.cmservice.entities.PreviousLoan;
import com.getcarloan.cmservice.service.CustomerVerificationService;

@RestController
@RequestMapping("/cmService")
public class CustomerVerificationController {

	@Autowired
	private CustomerVerificationService cvservice;

	@GetMapping("/")
	public ResponseEntity<String> check() {
		return new ResponseEntity<String>("App Working", HttpStatus.OK);

	}

	@GetMapping("/viewAllCustomer")
	public ResponseEntity<List<Customer>> viewAllCustomer() {
		return ResponseEntity.status(HttpStatus.OK).body(cvservice.viewAllCustomer());
	}

	@GetMapping("/viewCustomerById/{cid}")
	public ResponseEntity<Customer> viewCustomerById(@PathVariable int cid) {

		return new ResponseEntity<Customer>(cvservice.viewCustomerById(cid), HttpStatus.OK);

	}

//http://localhost:8089/cmService/cibilScoreCheck/{panNo}
	@GetMapping("/cibilScoreCheck/{panNo}")
	public ResponseEntity<Integer> cibilScorecheck(@PathVariable String panNo) {

		return new ResponseEntity<Integer>(cvservice.cibilScorecheck(panNo), HttpStatus.OK);

	}

	@GetMapping("/cibilScoreCheckByCid/{cid}")
	public ResponseEntity<CIBILScore> cibilScoreCheckByCid(@PathVariable Integer cid) {

		return new ResponseEntity<CIBILScore>(cvservice.cibilScoreCheckByCid(cid), HttpStatus.OK);

	}



	@PostMapping("/saveCIBILScoreDetails")
	public ResponseEntity<CIBILScore> saveCustomerVerification(@RequestBody CIBILScore cibilScore) {

		CIBILScore verification = cvservice.saveCustomerVerification(cibilScore);
		return new ResponseEntity<CIBILScore>(verification, HttpStatus.OK);

	}

	@GetMapping("/viewPreviousLoanById/{pLoanId}")
	public ResponseEntity<PreviousLoan> viewPreviousLoanById(@PathVariable int pLoanId) {
		return new ResponseEntity<PreviousLoan>(cvservice.viewPreviousLoanById(pLoanId), HttpStatus.OK);
	}


	@GetMapping("/viewAllPreviousLoan")
	public ResponseEntity<List<PreviousLoan>> viewAllPreviousLoan() {
		return new ResponseEntity<List<PreviousLoan>>(cvservice.viewAllPreviousLoan(), HttpStatus.OK);
	}

	
	@GetMapping("/checkPreviousLoanStability/{cid}/{remainingAmount}")
	public ResponseEntity<String> checkPreviousLoanStabilityResult(@PathVariable Integer cid,
			@PathVariable double remainingAmount) {
		return new ResponseEntity<String>(cvservice.checkPreviousLoanStabilityResult(cid, remainingAmount),
				HttpStatus.OK);
	}

	@PostMapping("/saveCustomerVerifcation")
	public ResponseEntity<CustomerVerificationaDTO> updateCustomerVerificationStatus(
			@RequestBody CustomerVerificationaDTO verificationdto) {
		cvservice.updateCustomerVerificationStatus(verificationdto);
		return ResponseEntity.status(HttpStatus.OK).body(verificationdto);

	}

	@GetMapping("/customerVerificationbyId/{cid}")
	public ResponseEntity<CustomerVerificationStatus> customerVerificationbyId(@PathVariable int cid) {

		return new ResponseEntity<CustomerVerificationStatus>(cvservice.customerVerificationbyId(cid), HttpStatus.OK);

	}
}
