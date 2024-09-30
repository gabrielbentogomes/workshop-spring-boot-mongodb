package com.gabrielbento.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielbento.workshopmongo.domain.User;
import com.gabrielbento.workshopmongo.repository.UserRepository;
import com.gabrielbento.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		
		return user.orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado!"));
	}
}
