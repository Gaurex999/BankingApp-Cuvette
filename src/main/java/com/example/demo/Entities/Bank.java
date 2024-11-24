package com.example.demo.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "banks")
public class Bank {
		
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(nullable = false, unique = true)
	    private String name;

	    @JsonManagedReference  // Prevents recursion during serialization
	    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<BranchEntity> branches;

	    @JsonManagedReference  // Prevents recursion during serialization
	    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<ServiceEntity> services;
	
}
