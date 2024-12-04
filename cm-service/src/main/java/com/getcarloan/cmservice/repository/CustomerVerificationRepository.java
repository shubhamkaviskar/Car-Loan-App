package com.getcarloan.cmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getcarloan.cmservice.entities.CIBILScore;
import com.getcarloan.cmservice.entities.Customer;

@Repository
public interface CustomerVerificationRepository extends JpaRepository<CIBILScore, Integer> {

	
	Customer findByCid(int cid);

	//void save(CIBILScore cibilScore);

	boolean existsById(int cid);

}
