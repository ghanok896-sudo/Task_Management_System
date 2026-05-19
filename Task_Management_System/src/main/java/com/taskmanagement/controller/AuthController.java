package com.taskmanagement.controller;

	import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.dto.AuthResponse;
import com.taskmanagement.dto.LoginRequest;
import com.taskmanagement.entity.User;
import com.taskmanagement.security.JwtUtil;
import com.taskmanagement.service.UserService;

	@RestController
	@RequestMapping("/api/auth")
	public class AuthController {

	    @Autowired
	    private UserService userService;

	    @Autowired
	    private JwtUtil jwtUtil;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    // Register
	    @PostMapping("/register")
	    public User register(@RequestBody User user) {

	        return userService.registerUser(user);
	    }

	    // Login
	    @PostMapping("/login")
	    public AuthResponse login(
	            @RequestBody LoginRequest request) {

	        Optional<User> optionalUser =
	                userService.findByEmail(request.getEmail());

	        if (optionalUser.isPresent()) {

	            User user = optionalUser.get();

	            boolean passwordMatch =
	                    passwordEncoder.matches(
	                            request.getPassword(),
	                            user.getPassword());

	            if (passwordMatch) {

	                String token =
	                        jwtUtil.generateToken(user.getEmail());

	                return new AuthResponse(token);
	            }
	        }

	        throw new RuntimeException("Invalid Email or Password");
	    }
	}
	


