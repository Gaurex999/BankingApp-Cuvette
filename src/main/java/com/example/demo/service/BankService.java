package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BankDTO;
import com.example.demo.Entities.Bank;
import com.example.demo.Entities.BranchEntity;
import com.example.demo.Entities.ServiceEntity;
import com.example.demo.repository.BankRepository;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.ServiceRepository;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    // Fetch all banks and convert them to DTO
    public List<BankDTO> getAllBanks() {
        return bankRepository.findAll().stream().map(bank -> {
            BankDTO dto = new BankDTO();
            dto.setId(bank.getId());
            dto.setName(bank.getName());
            dto.setBranches(
                bank.getBranches().stream().map(branch -> branch.getName()).collect(Collectors.toList())
            );
            dto.setServices(
                bank.getServices().stream().map(service -> service.getName()).collect(Collectors.toList())
            );
            return dto;
        }).collect(Collectors.toList());
    }

    // Fetch the bank by ID
    public Bank getBankById(int id) {
        // Handling possible null return if the bank does not exist
        return bankRepository.findById(id).orElse(null);
    }

    // Fetch branches by bank ID (returns list of BranchEntities)
    public List<BranchEntity> getBranchesByBankId(int bankId) {
        // Fetching branches by bankId using the custom query method
        List<BranchEntity> branches = branchRepository.findByBankId(bankId);
        
        // Handling case where no branches are found
        if (branches.isEmpty()) {
            return null;  // Or return an empty list depending on your preference
        }
        return branches;
    }

    // Fetch services by bank ID (returns list of ServiceEntities)
    public List<ServiceEntity> getServicesByBankId(int bankId) {
        // Fetching services by bankId using the custom query method
        List<ServiceEntity> services = serviceRepository.findByBankId(bankId);
        
        // Handling case where no services are found
        if (services.isEmpty()) {
            return null;  // Or return an empty list depending on your preference
        }
        return services;
    }
}
