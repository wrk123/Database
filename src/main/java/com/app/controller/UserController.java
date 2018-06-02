package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.service.UserService;

import java.util.List;


@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Boolean> createUser(@RequestBody User userDetails) throws Exception{
		Boolean userSatus = Boolean.FALSE;
		userSatus= userService.createUser(userDetails);
		if(userSatus.booleanValue() == false){
			return new ResponseEntity<Boolean>(userSatus, HttpStatus.EXPECTATION_FAILED);
		}
		return  new ResponseEntity<Boolean>(userSatus, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Boolean> updateUser(@RequestBody User userDetails) throws Exception{
		Boolean userSatus = Boolean.FALSE;
		userSatus= userService.createUser(userDetails);
		if(userSatus.booleanValue() == false){
			return new ResponseEntity<Boolean>(userSatus, HttpStatus.EXPECTATION_FAILED);
		}
		return  new ResponseEntity<Boolean>(userSatus, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<User> findOneUserDetail(@RequestBody User userDetails) throws Exception{
		User user = null;
		user= userService.getUserDetails(userDetails);
		if(user == null){
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<User>> findAllUserDetails() throws Exception{
		List<User> users = null;
		users= userService.getAllDetails();
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(users, HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
