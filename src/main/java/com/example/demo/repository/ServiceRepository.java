package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.BranchEntity;
import com.example.demo.Entities.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
	
	List<ServiceEntity> findByBankId(int bankId);
}