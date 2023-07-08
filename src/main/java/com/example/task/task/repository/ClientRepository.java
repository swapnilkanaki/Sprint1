package com.example.task.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.task.task.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer>{
    
}
