package br.com.lasbr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lasbr.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
