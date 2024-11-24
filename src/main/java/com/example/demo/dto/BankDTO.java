package com.example.demo.dto;

import java.util.List;

import lombok.Data;


@Data
public class BankDTO {
	
	 private int id;
	    private String name;
	    private List<String> branches;
	    private List<String> services;

}
