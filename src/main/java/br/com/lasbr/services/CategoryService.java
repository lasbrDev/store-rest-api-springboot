package br.com.lasbr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.lasbr.entities.Category;
import br.com.lasbr.repositories.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository repository;
	
	public CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
