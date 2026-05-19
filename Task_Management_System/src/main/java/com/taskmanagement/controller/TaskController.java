package com.taskmanagement.controller;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.entity.Task;
import com.taskmanagement.service.TaskService;

	@RestController
	@RequestMapping("/api/tasks")
	public class TaskController {

	    @Autowired
	    private TaskService taskService;

	    // Create Task
	    @PostMapping
	    public Task createTask(@RequestBody Task task) {
	        return taskService.createTask(task);
	    }

	    // Get All Tasks
	    @GetMapping
	    public List<Task> getAllTasks() {
	        return taskService.getAllTasks();
	    }

	    // Get Task By Id
	    @GetMapping("/{id}")
	    public Task getTaskById(@PathVariable Long id) {
	        return taskService.getTaskById(id);
	    }

	    // Update Task
	    @PutMapping("/{id}")
	    public Task updateTask(@PathVariable Long id,
	                           @RequestBody Task task) {

	        return taskService.updateTask(id, task);
	    }

	    // Delete Task
	    @DeleteMapping("/{id}")
	    public String deleteTask(@PathVariable Long id) {

	        return taskService.deleteTask(id);
	    }
	}


