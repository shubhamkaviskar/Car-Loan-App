package com.getcarloan.oe_service.service;

import java.util.List;

import com.getcarloan.oe_service.entites.Customer;
import com.getcarloan.oe_service.entites.CustomerVarification;
import com.getcarloan.oe_service.entites.CustomerVerificationStatus;
import com.getcarloan.oe_service.entites.LoanApproval;

public interface CustomerService {

	List<Customer> viewAllCustomer();

	Customer viewCustomerById(int cid);
	
	LoanApproval loanApproval(LoanApproval s1);

	

	CustomerVarification saveCustomerVerification(CustomerVarification v1);

	CustomerVarification getVarification(int varId);

	String deleteVarification(int cid);

	LoanApproval loanSantionByCid(int cid);

	List<LoanApproval> getallLoanSantioned();

	CustomerVerificationStatus viewCustomerVerificationStatusbyId(int cid);

}
