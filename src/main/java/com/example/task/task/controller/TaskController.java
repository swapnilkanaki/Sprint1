package com.example.task.task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.task.entity.Task;
import com.example.task.task.service.TaskService;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping("/saveTask") 
	public ResponseEntity<Task> saveClient(@RequestBody Task task)
	{
	    return taskService.addTask(task);
	}

    @GetMapping(value="/task")
	public  ResponseEntity<List<Task>> getAllTask() {
	    return taskService.getAllTask();
	}

    @GetMapping("/taskTo/{id}") 
	public ResponseEntity<List<Task>> getTaskAssignToById(@PathVariable int id) 
	{ 
		List<Task> tasks = taskService.getAssignToById(id);
		return ResponseEntity.ok(tasks);
	}

    @GetMapping("/taskFrom/{id}")
	public ResponseEntity<List<Task>> getTaskAssignMeById(@PathVariable int id) 
	{ 
	    List<Task> tasks = taskService.getAssignMeById(id);
		return ResponseEntity.ok(tasks);
	}
    
    
}
