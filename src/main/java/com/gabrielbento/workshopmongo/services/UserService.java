package com.gabrielbento.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielbento.workshopmongo.domain.User;
import com.gabrielbento.workshopmongo.dto.UserDTO;
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
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public User fromDto(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
		return repository.save(newObj);
	}
}
