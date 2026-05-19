package com.task.taskmanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.task.taskmanagement.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}