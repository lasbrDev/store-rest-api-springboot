package br.com.lasbr.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lasbr.entities.Product;
import br.com.lasbr.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResourse {

	private final ProductService service;
	
	public ProductResourse(ProductService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product product = service.findById(id);
		return ResponseEntity.ok().body(product);
	}
}
