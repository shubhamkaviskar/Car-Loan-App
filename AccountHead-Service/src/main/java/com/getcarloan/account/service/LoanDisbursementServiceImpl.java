package com.getcarloan.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.getcarloan.account.entity.Customer;
import com.getcarloan.account.entity.LoanDisbursement;
import com.getcarloan.account.entity.SanctionLetter;
import com.getcarloan.account.proxy.Feigncommunication;
import com.getcarloan.account.repository.LoanDisbursementRepository;

@Service
public class LoanDisbursementServiceImpl implements LoanDisbursementService {

	@Autowired
	private LoanDisbursementRepository ldRepo;

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private Feigncommunication communication;

	@Override
	public String generateLoanDisbursementFile(LoanDisbursement loanDisbursement) {
		ldRepo.save(loanDisbursement);

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("sunagujiri22@gmail.com");
		message.setTo(loanDisbursement.getEmail());
		message.setSubject("Confirmation of Loan is Disbursed");
		message.setText(
				"Hello " + loanDisbursement.getApplicantName() 
				+ ".....\nYour Car Loan is Successfully Disbursed....!! "
				+ "\nYour Account is credited with loan amount = \n " 
				+ loanDisbursement.getTotalAmount());
		sender.send(message);
		return "Loan Disbursement File is Generated....!!!";
	}

	@Override
	public List<LoanDisbursement> getAllLoanDisbursement() {
		return ldRepo.findAll();
	}

	@Override
	public LoanDisbursement getLoanDisbursementByCustId(int cid) {
		if (ldRepo.existsById(cid))
			return ldRepo.findById(cid).get();
		else
			return null;
	}

	@Override
	public LoanDisbursement getLoanDisbursementByAgrId(int agreementId) {
		if (ldRepo.existsById(agreementId))
			return ldRepo.findById(agreementId).get();
		else
			return null;
	}

	@Override
	public Customer getCustomerId(int cid) {
		Customer cust = communication.getCustomerById(cid);
		return cust;
	}

	@Override
	public List<Customer> getAllCustomerByFeign() {
		List<Customer> allCustomer = communication.getAllCustomerByFeign();
		return allCustomer;
	}

}
