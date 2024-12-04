package com.getcarloan.cmservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreviousLoan {
        
	  
		private int pLoanId;
		private double ploanAmount;
		private int pTenure;
		private double paidAmount;
		private double remainingAmount;
		private int deafulterCount;
		private String status;
		private String remark;

}
