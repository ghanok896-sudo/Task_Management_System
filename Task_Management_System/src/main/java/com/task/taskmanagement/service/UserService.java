package com.task.taskmanagement.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.task.taskmanagement.entity.User;
import com.task.taskmanagement.repository.UserRepository;

@Service
public class UserService {
   @Autowired
   private UserRepository userRepository;
   public User registerUser(User user) {
       return userRepository.save(user);
   }
}



