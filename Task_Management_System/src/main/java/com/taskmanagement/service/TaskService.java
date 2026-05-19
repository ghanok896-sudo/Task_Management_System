package com.taskmanagement.service;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.entity.Task;
import com.taskmanagement.repository.TaskRepository;

	@Service
	public class TaskService {

	    @Autowired
	    private TaskRepository taskRepository;

	    // Create Task
	    public Task createTask(Task task) {
	        return taskRepository.save(task);
	    }

	    // Get All Tasks
	    public List<Task> getAllTasks() {
	        return taskRepository.findAll();
	    }

	    // Get Task By Id
	    public Task getTaskById(Long id) {
	        return taskRepository.findById(id).orElse(null);
	    }

	    // Update Task
	    public Task updateTask(Long id, Task task) {

	        Task existingTask = taskRepository.findById(id).orElse(null);

	        existingTask.setTitle(task.getTitle());
	        existingTask.setDescription(task.getDescription());
	        existingTask.setStatus(task.getStatus());
	        existingTask.setPriority(task.getPriority());

	        return taskRepository.save(existingTask);
	    }

	    // Delete Task
	    public String deleteTask(Long id) {

	        taskRepository.deleteById(id);

	        return "Task Deleted Successfully";
	    }
	}


