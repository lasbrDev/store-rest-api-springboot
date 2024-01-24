package br.com.lasbr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lasbr.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
