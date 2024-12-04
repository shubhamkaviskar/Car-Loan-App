package com.getcarloan.oe_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.getcarloan.oe_service.entites.Customer;
import com.getcarloan.oe_service.entites.CustomerVarification;
import com.getcarloan.oe_service.entites.CustomerVerificationStatus;
import com.getcarloan.oe_service.entites.LoanApproval;
import com.getcarloan.oe_service.proxy.feignCommVerification;
import com.getcarloan.oe_service.proxy.feignCommunication;
import com.getcarloan.oe_service.repository.CustomerVarificationRepo;
import com.getcarloan.oe_service.repository.LoanApprovalRepo;

@Service
public class CustomerServiceIMPL implements CustomerService {

	@Autowired
	private feignCommunication communication;

	@Autowired
	private feignCommVerification vcommunication;

	@Autowired
	private CustomerVarificationRepo crepo;

	@Autowired
	private LoanApprovalRepo lrepo;

	@Override
	public List<Customer> viewAllCustomer() {

		List<Customer> allCustomer = communication.getAllCustomer();
		return allCustomer;
	}

	@Override
	public Customer viewCustomerById(int cid) {
		Customer customerById = communication.getCustomerById(cid);
		return customerById;
	}

	@Override
	public LoanApproval loanApproval(LoanApproval s1) {
		LoanApproval approval = lrepo.save(s1);
		return approval;
	}

	@Override
	public CustomerVarification saveCustomerVerification(CustomerVarification v1) {
		CustomerVarification vari = crepo.save(v1);
		return vari;

	}

	@Override
	public CustomerVarification getVarification(int cid) {

		Optional<CustomerVarification> varid = crepo.findById(cid);

		if (varid.isPresent()) {
			return crepo.findById(cid).get();
		}
		return null;
	}

	@Override
	public String deleteVarification(int cid) {
		crepo.deleteById(cid);
		return "Customer Varification Cancel ...";
	}

	@Override
	public LoanApproval loanSantionByCid(int cid) {

		if (lrepo.existsById(cid))
			return lrepo.findByCid(cid);
		else
			return null;
	}

	@Override
	public List<LoanApproval> getallLoanSantioned() {

		return lrepo.findAll();
	}

	@Override
	public CustomerVerificationStatus viewCustomerVerificationStatusbyId(int cid) {
		CustomerVerificationStatus verificationbyId = vcommunication.customerVerificationbyId(cid);
		return verificationbyId;
	}

}
