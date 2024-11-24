package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Bank;


public interface BankRepository extends JpaRepository<Bank, Integer> {
}
