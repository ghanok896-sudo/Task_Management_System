package com.task.taskmanagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.task.taskmanagement.config.JwtUtil;
import com.task.taskmanagement.dto.UserDTO;
import com.task.taskmanagement.entity.User;
import com.task.taskmanagement.repository.UserRepository;
import com.task.taskmanagement.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
   @Autowired
   private UserService userService;
   @Autowired
   private UserRepository userRepository;
   @PostMapping("/register")
   public User register(@RequestBody UserDTO userDTO) {
       User user = new User();
       user.setUsername(userDTO.getUsername());
       user.setPassword(userDTO.getPassword());
       user.setRole(userDTO.getRole());
       return userService.registerUser(user);
   }
   @PostMapping("/login")
   public String login(@RequestBody UserDTO userDTO) {
       User existingUser = userRepository
               .findByUsername(userDTO.getUsername())
               .orElseThrow(() -> new RuntimeException("User not found"));
       if(existingUser.getPassword()
               .equals(userDTO.getPassword())) {
           return JwtUtil.generateToken(userDTO.getUsername());
       }
       return "Invalid Password";
   }
}