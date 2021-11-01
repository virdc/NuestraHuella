package com.tuhuella.main.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.tuhuella.main.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT a from User a WHERE a.email = ?1 ")
	Optional <User> findMyUserByEmail(String email); 
	List<User> findByNameContain(String name);
	List<User> findAll();
	
}
