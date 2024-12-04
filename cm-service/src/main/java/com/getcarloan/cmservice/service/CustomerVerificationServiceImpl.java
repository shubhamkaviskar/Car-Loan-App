package com.getcarloan.cmservice.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.getcarloan.cmservice.entities.CIBILScore;
import com.getcarloan.cmservice.entities.Customer;

import com.getcarloan.cmservice.entities.CustomerVerificationStatus;
import com.getcarloan.cmservice.entities.PreviousLoan;
import com.getcarloan.cmservice.proxy.feignCommunication;
import com.getcarloan.cmservice.repository.CustomerVerificationRepo;
//import com.getcarloan.cmservice.fieng.FeignCommunicationcm;
import com.getcarloan.cmservice.repository.CustomerVerificationRepository;
import com.getcarloan.cmservice.dto.CustomerVerificationaDTO;




@Service
public class CustomerVerificationServiceImpl  implements CustomerVerificationService{

	
	@Autowired
	private feignCommunication communication;
	@Autowired
	private CustomerVerificationRepository cibilrepo;
	
	@Autowired
	private CustomerVerificationRepo crepo;
	
	@Autowired
	private ModelMapper mapper;

	


	@Override
	public Integer cibilScorecheck(String panNo) {

		int min = 600;
		int max = 900;
		Random random = new Random();
		int cibilScore = random.nextInt(max - min + 1) + min;

		if (panNo != null && !panNo.isEmpty()) {

			return cibilScore;
		} else {
			throw new IllegalArgumentException("Invalid PAN card number");
		}
	}


	@Override
	public String checkPreviousLoanStabilityResult(Integer cid, double remainingAmount) {
		
		if(remainingAmount < 200000)
        {
            return "applicable for new car loan";
        } 
        else
        {
            return "not applicable for this car Loan";
        }		
	}

	

	

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
	public CIBILScore saveCustomerVerification(CIBILScore cibilScore) {
		
		
		CIBILScore score = cibilrepo.save(cibilScore);
		
		return score;
	}

	@Override
	public CIBILScore cibilScoreCheckByCid(Integer cid) {
		
		
		Optional<CIBILScore> varid = cibilrepo.findById(cid);
		
		if (varid.isPresent()) {
			return cibilrepo.findById(cid).get();
		}
		return null;
		
		
	}

	@Override
	public List<PreviousLoan> viewAllPreviousLoan() {
		List<PreviousLoan> previousloan = communication.getAllPreviousLoan();
		return previousloan;
	}

	@Override
	public PreviousLoan viewPreviousLoanById(int pLoanId) {
		PreviousLoan previosloanbyid = communication.getPreviousLoanById(pLoanId);
		return previosloanbyid;
	}

	@Override
	public void updateCustomerVerificationStatus(CustomerVerificationaDTO verificationdto) {
		// TODO Auto-generated method stub
		
		CustomerVerificationStatus verification = mapper.map(verificationdto,CustomerVerificationStatus.class);
		crepo.save(verification);
		
	}

	@Override
	public CustomerVerificationStatus customerVerificationbyId(int cid) {

		Optional<CustomerVerificationStatus> varid = crepo.findById(cid);
		
		if (varid.isPresent()) {
			return crepo.findById(cid).get();
		}
		return null;
	}

	
	

	
}
