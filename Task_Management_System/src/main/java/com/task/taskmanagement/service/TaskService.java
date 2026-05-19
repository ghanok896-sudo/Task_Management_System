package com.task.taskmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.task.taskmanagement.entity.Task;

import com.task.taskmanagement.exception.ResourceNotFoundException;

import com.task.taskmanagement.repository.TaskRepository;

@Service

public class TaskService {

    @Autowired

    private TaskRepository taskRepository;

    public Task createTask(Task task) {

        return taskRepository.save(task);

    }

    public List<Task> getAllTasks() {

        return taskRepository.findAll();

    }

    public Task updateTask(Long id, Task updatedTask) {

        Task task = taskRepository.findById(id)

                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        task.setTitle(updatedTask.getTitle());

        task.setDescription(updatedTask.getDescription());

        task.setStatus(updatedTask.getStatus());

        task.setPriority(updatedTask.getPriority());

        task.setAssignedTo(updatedTask.getAssignedTo());

        return taskRepository.save(task);

    }

    public String deleteTask(Long id) {

        Task task = taskRepository.findById(id)

                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        taskRepository.delete(task);

        return "Task deleted successfully";

    }

}
 