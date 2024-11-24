package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.BranchEntity;



public interface BranchRepository extends JpaRepository<BranchEntity, Long> {
	  List<BranchEntity> findByBankId(int bankId);
}