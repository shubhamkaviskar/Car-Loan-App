package com.getcarloan.reservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVarification {
	
    private int cid;
	private String varificationDate;
    private String status;
    private String remarks;
}