package com.getcarloan.oe_service.entites;


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
@Entity
public class CustomerVarification {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
	private String varificationDate;
    private String status;
    private String remarks;
}