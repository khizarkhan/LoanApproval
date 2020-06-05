package com.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.UserService;
import com.vo.User;



@RestController
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/save")
	public List<User> addNewUser(@RequestBody User user){
		List<User> userList =  userService.save(user);
		return userList;
	}
	
	@PostMapping("/validate/{username}/{password}")
	public String  loginUser(@PathVariable String username, @PathVariable String password){
		return userService.validatUser(username, password);
	}

}
