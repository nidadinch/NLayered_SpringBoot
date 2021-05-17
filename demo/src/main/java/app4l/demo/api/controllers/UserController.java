package app4l.demo.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app4l.demo.business.abstracts.UserService;
import app4l.demo.entities.concretes.User;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	@ApiOperation(value = "View a list of users")
	public List<User> getAll(){
		return this.userService.getAll();
	}
	
	@ApiOperation(value = "Get user by Id")
	@GetMapping(path="/{userId}", produces = "application/json")
	public Optional<User> getById(@PathVariable("userId") Long userId) {
		return userService.getById(userId);
	}

}
