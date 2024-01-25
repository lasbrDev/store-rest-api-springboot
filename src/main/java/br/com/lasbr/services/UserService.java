package br.com.lasbr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.lasbr.entities.User;
import br.com.lasbr.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}

