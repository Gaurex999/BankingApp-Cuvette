package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
@Table(name = "services")
public class ServiceEntity {

	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @Column(columnDefinition = "TEXT")
	    private String description;

	    @JsonBackReference  // Prevents recursion during serialization
	    @ManyToOne
	    @JoinColumn(name = "bank_id", nullable = false)
	    private Bank bank;
	
}
