package com.codingninjas.EVotingSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.services.UserService;

@RestController
//@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
//	  • POST "/add/user" (@RequestBody User user): It creates a new user into the database.
@PostMapping("/add/user")
public void saveUser(@RequestBody User user) {
	userService.saveUser(user);
	
}

	
	
	
//	    • GET "/get/users": It fetches the list of all users from the database.

@GetMapping("get/users")
public List<User> getAllUsers(){
	return userService.getAll();
}



}
