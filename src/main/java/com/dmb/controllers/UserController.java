package com.dmb.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmb.entities.User;
import com.dmb.sevices.UserService;

@RestController 
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserService serv;
	
//	@GetMapping("/users")
//	public ResponseEntity<List<User>> getAllUser() {
//		return ResponseEntity.ok(serv.getAllUser());
//	}
	
//	@GetMapping("/user/{id}")
//	public ResponseEntity<User> getOneUser(@PathVariable(name = "id") Long id) { 
//		Optional<User> entity = serv.getOneUser(id);
//
//		if (entity.isPresent()) {
//			return ResponseEntity.ok(entity.get());
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User entity) {
		return ResponseEntity.ok(serv.createUser(entity));
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(name = "id") Long id, @RequestBody User entity) {
		Optional<User> entityOld = serv.getOneUser(id);
		if (entityOld.isPresent()) {
			return ResponseEntity.ok(serv.updateUser(entity));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
//	@DeleteMapping("/user/{id}")
//	public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) { 
//		Optional<User> entity = serv.getOneUser(id);
//		if (entity.isPresent()) {
//			serv.deleteUser(id);
//			return ResponseEntity.noContent().build();
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
}
