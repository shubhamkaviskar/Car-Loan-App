package com.getcarloan.cmservice.entities;



import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CIBILScore {

	@Id
	private Integer cid;
	private String panNo;
	private Long cibilScore;
	private String cibilStatus;
	
}
