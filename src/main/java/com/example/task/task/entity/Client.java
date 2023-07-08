package com.example.task.task.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "client")
public class Client {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

	@Column(length=30, unique = true, nullable = false)
	private String name;

	@Column(length=50, unique = true, nullable = false)
	private String email;

	@Column(length=10, unique = true, nullable = false)
	private String phone;

	@Column(length=20, nullable = false)
	private String designation;
    
}
