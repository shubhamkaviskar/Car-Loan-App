package com.getcarloan.cmservice.entities;

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
public class CustomerVerificationStatus {

	@Id
	
	private int cid;
	private String panNo;
	private Long cibilScore;
	private double remainingAmount;
	private String cibilStatus;
	private String priviousLoanStatus;
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private CIBILScore cibilScore;
}
