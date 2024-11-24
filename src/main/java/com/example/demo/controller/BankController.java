package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entities.Bank;
import com.example.demo.Entities.BranchEntity;
import com.example.demo.Entities.ServiceEntity;
import com.example.demo.service.BankService;

@Controller
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

  
    @GetMapping("/branches")
    public String getBranches(Model model) {
     
        Bank bank = bankService.getBankById(1);  
        List<BranchEntity> branches = bankService.getBranchesByBankId(1); 
        
        model.addAttribute("bank", bank);  
        model.addAttribute("branches", branches);  

        return "branches"; 
    }

  
    @GetMapping("/services")
    public String getServices(Model model) {
      
        Bank bank = bankService.getBankById(1); 
        List<ServiceEntity> services = bankService.getServicesByBankId(1);  
        
        model.addAttribute("bank", bank); 
        model.addAttribute("services", services);  

        return "services";  
    }
}
