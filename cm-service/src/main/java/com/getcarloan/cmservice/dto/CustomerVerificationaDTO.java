package com.getcarloan.cmservice.dto;

import lombok.Data;

@Data
public class CustomerVerificationaDTO {
	
	private int cid;
	private String panNo;
	private Long cibilScore;
	private double remainingAmount;
	private String cibilStatus;
	private String priviousLoanStatus;
	

}
