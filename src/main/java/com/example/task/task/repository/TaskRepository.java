package com.example.task.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.task.task.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Integer>{
    List<Task> findByFromId(Integer fromId);    
    List<Task> findByToId(Integer toId);

    boolean existsById(Integer id);

}

