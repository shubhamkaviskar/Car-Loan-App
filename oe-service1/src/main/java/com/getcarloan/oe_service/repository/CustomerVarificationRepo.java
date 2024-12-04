package com.getcarloan.oe_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getcarloan.oe_service.entites.CustomerVarification;

@Repository
public interface CustomerVarificationRepo extends JpaRepository<CustomerVarification, Integer>{

}
