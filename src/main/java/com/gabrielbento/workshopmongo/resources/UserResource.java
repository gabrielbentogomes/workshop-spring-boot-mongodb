package com.gabrielbento.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielbento.workshopmongo.domain.User;
import com.gabrielbento.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
}
