package com.getcarloan.reservice.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_generator")
	@SequenceGenerator(name = "cust_generator", sequenceName = "CUSTOMER_SEQUENCE",initialValue=1000,allocationSize = 0)
	private int cid;
	private int enquireId;
	private String name;
	private String DOB;
	private int age;
	private String gender;
	private String email;
	private long mobileNo;
	private long additionalMobileNo;
	private double downPaymentAmount;
	private double totalLoanRequired;
	

	@OneToOne(cascade = CascadeType.ALL)
	private AllPersonalDocs cAllPersonalDocs;

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress cAddress;

	@OneToOne(cascade = CascadeType.ALL)
	private AccountDetails cAccountDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDetails cLoanDetails;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails cGuarantorDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoan cPreviousLoan;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoanBank pbankDetails;


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getEnquireId() {
		return enquireId;
	}


	public void setEnquireId(int enquireId) {
		this.enquireId = enquireId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		DOB = dOB;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public long getAdditionalMobileNo() {
		return additionalMobileNo;
	}


	public void setAdditionalMobileNo(long additionalMobileNo) {
		this.additionalMobileNo = additionalMobileNo;
	}


	public double getDownPaymentAmount() {
		return downPaymentAmount;
	}


	public void setDownPaymentAmount(double downPaymentAmount) {
		this.downPaymentAmount = downPaymentAmount;
	}


	public double getTotalLoanRequired() {
		return totalLoanRequired;
	}


	public void setTotalLoanRequired(double totalLoanRequired) {
		this.totalLoanRequired = totalLoanRequired;
	}


	public AllPersonalDocs getcAllPersonalDocs() {
		return cAllPersonalDocs;
	}


	public void setcAllPersonalDocs(AllPersonalDocs cAllPersonalDocs) {
		this.cAllPersonalDocs = cAllPersonalDocs;
	}


	public CustomerAddress getcAddress() {
		return cAddress;
	}


	public void setcAddress(CustomerAddress cAddress) {
		this.cAddress = cAddress;
	}


	public AccountDetails getcAccountDetails() {
		return cAccountDetails;
	}


	public void setcAccountDetails(AccountDetails cAccountDetails) {
		this.cAccountDetails = cAccountDetails;
	}


	public LoanDetails getcLoanDetails() {
		return cLoanDetails;
	}


	public void setcLoanDetails(LoanDetails cLoanDetails) {
		this.cLoanDetails = cLoanDetails;
	}


	public GuarantorDetails getcGuarantorDetails() {
		return cGuarantorDetails;
	}


	public void setcGuarantorDetails(GuarantorDetails cGuarantorDetails) {
		this.cGuarantorDetails = cGuarantorDetails;
	}


	public PreviousLoan getcPreviousLoan() {
		return cPreviousLoan;
	}


	public void setcPreviousLoan(PreviousLoan cPreviousLoan) {
		this.cPreviousLoan = cPreviousLoan;
	}


	public PreviousLoanBank getPbankDetails() {
		return pbankDetails;
	}


	public void setPbankDetails(PreviousLoanBank pbankDetails) {
		this.pbankDetails = pbankDetails;
	}
}
