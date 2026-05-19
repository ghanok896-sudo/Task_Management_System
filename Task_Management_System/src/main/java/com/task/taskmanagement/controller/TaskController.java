package com.task.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.task.taskmanagement.dto.TaskDTO;

import com.task.taskmanagement.entity.Task;

import com.task.taskmanagement.service.TaskService;

@RestController

@RequestMapping("/tasks")

public class TaskController {

    @Autowired

    private TaskService taskService;

    @PostMapping

    public Task createTask(@RequestBody TaskDTO taskDTO) {

        Task task = new Task();

        task.setTitle(taskDTO.getTitle());

        task.setDescription(taskDTO.getDescription());

        task.setStatus(taskDTO.getStatus());

        task.setPriority(taskDTO.getPriority());

        task.setAssignedTo(taskDTO.getAssignedTo());

        return taskService.createTask(task);

    }

    @GetMapping

    public List<Task> getAllTasks() {

        return taskService.getAllTasks();

    }

    @PutMapping("/{id}")

    public Task updateTask(@PathVariable Long id,

                           @RequestBody TaskDTO taskDTO) {

        Task task = new Task();

        task.setTitle(taskDTO.getTitle());

        task.setDescription(taskDTO.getDescription());

        task.setStatus(taskDTO.getStatus());

        task.setPriority(taskDTO.getPriority());

        task.setAssignedTo(taskDTO.getAssignedTo());

        return taskService.updateTask(id, task);

    }

    @DeleteMapping("/{id}")

    public String deleteTask(@PathVariable Long id) {

        return taskService.deleteTask(id);

    }

}
 