package com.getcarloan.reservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CIBILScore {

	
	private Integer cid;
	private String panNo;
	private Long cibilScore;
	private String cibilStatus;
	
}
