package com.example.task.task.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "task")
public class Task {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;

    @Column(nullable = false)
    private int fromId;

    @Column(nullable = false)
    private int toId;

	@Column(length=50, unique = true, nullable = false)
	private String title;

	@Column( nullable = false)
	private String description;
	
	@Column(length=10, nullable = false)
	private String status;

    @Column(nullable = false)
    private LocalDate date;

}
