package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "branches")
public class BranchEntity {

	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false)
	    private String address;

	    private String city;

	    @JsonBackReference  // Prevents recursion during serialization
	    @ManyToOne
	    @JoinColumn(name = "bank_id", nullable = false)
	    private Bank bank;
}
