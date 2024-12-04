package com.getcarloan.oe_service.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVerificationStatus {
	
	private int cid;
	private String panNo;
	private Long cibilScore;
	private double remainingAmount;
	private String cibilStatus;
	private String priviousLoanStatus;
	

}
