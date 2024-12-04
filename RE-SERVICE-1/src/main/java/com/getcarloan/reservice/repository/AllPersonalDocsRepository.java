package com.getcarloan.reservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getcarloan.reservice.entities.AllPersonalDocs;

@Repository
public interface AllPersonalDocsRepository extends JpaRepository<AllPersonalDocs,Integer>{

	
}
