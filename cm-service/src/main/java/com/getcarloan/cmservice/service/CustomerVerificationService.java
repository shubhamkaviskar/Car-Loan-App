package com.getcarloan.cmservice.service;

import java.util.List;

import com.getcarloan.cmservice.dto.CustomerVerificationaDTO;
import com.getcarloan.cmservice.entities.CIBILScore;
import com.getcarloan.cmservice.entities.Customer;

import com.getcarloan.cmservice.entities.CustomerVerificationStatus;
import com.getcarloan.cmservice.entities.PreviousLoan;

public interface CustomerVerificationService {

	

	Integer cibilScorecheck(String panNo);

	

	List<PreviousLoan> viewAllPreviousLoan();

	PreviousLoan viewPreviousLoanById(int pLoanId);



	String checkPreviousLoanStabilityResult(Integer cid, double remainingAmount);


	Customer viewCustomerById(int cid);

	List<Customer> viewAllCustomer();

	CIBILScore saveCustomerVerification(CIBILScore cibilScore);

	CIBILScore cibilScoreCheckByCid(Integer cid);

	void updateCustomerVerificationStatus(CustomerVerificationaDTO verificationdto);

	CustomerVerificationStatus customerVerificationbyId(int cid);

}
