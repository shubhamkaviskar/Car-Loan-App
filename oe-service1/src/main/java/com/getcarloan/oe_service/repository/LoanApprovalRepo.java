package com.getcarloan.oe_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getcarloan.oe_service.entites.LoanApproval;

@Repository
public interface LoanApprovalRepo extends JpaRepository<LoanApproval, Integer>{

	LoanApproval findByCid(int cid);

}
