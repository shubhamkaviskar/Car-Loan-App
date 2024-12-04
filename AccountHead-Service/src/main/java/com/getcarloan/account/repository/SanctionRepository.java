package com.getcarloan.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getcarloan.account.entity.SanctionLetter;

@Repository
public interface SanctionRepository extends JpaRepository<SanctionLetter, Integer> {

}
