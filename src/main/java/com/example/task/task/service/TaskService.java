package com.example.task.task.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.task.task.entity.Task;
import com.example.task.task.exception.CustomException;
import com.example.task.task.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Get All Task data
    public ResponseEntity<List<Task>> getAllTask()
	{
		try
		{
            List<Task> list=(List<Task>)this.taskRepository.findAll();
            return ResponseEntity.ok(list) ;
		}
		catch (Exception e)
		{
            throw new CustomException(" Empty Dataset "+e.toString());
		}
	}

   // Get Task assigned Data Base On Id
    public List<Task> getAssignToById(int fromId) {
        List<Task> result = taskRepository.findByFromId(fromId);
        if (result.isEmpty()) {
            throw new EntityNotFoundException("No tasks found with id: " + fromId);
        } else {
            return result;
        }
    }

    // Get Task Assign Data Base On Id
   public List<Task> getAssignMeById(int toId) {
       List<Task> result = taskRepository.findByToId(toId);
       if (result.isEmpty()) {
            throw new EntityNotFoundException("No tasks found with id: " + toId);
        } else {
            return result;
        }
   }


   // Save Task Data 
    public ResponseEntity<Task> addTask(Task c)
	{
		try {
            if(taskRepository.existsById(c.getFromId()) && taskRepository.existsById(c.getToId())){
                Task task=this.taskRepository.save(c);
                return ResponseEntity.ok(task);
            }
            else
            {
                throw new EntityNotFoundException("No Client found with id: ");
            }
		}
        catch(Exception e)
		{
			throw new CustomException(" Something Wrong "+e.toString());
		}
	}


}
