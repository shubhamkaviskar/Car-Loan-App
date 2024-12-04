package com.getcarloan.cmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.getcarloan.cmservice.entities.CustomerVerificationStatus;

@Repository
public interface CustomerVerificationRepo extends JpaRepository<CustomerVerificationStatus, Integer>{

}
