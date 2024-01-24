package br.com.lasbr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.lasbr.entities.Product;
import br.com.lasbr.repositories.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository repository;
	
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
