package com.tuhuella.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tuhuella.main.entities.Pet;



@Repository
public interface PetRepository {
	@Query("SELECT a FROM Pet a WHERE a.nombre LIKe :name")
	public List<Pet> searchPetName(@Param("name") String name);

	public List<Pet> findAll();
	
	
	//@Query("SELECT a FROM Pet a WHERE a.id LIKE :id")
		//public Pet consultId(@Param("id") String id);
		
		//@Query("SELECT a FROM Pet a WHERE a.high=true")
		//public List<Pet> consultHigh();
		
		//@Query("SELECT a FROM Pet a WHERE a.down=false")
		//public List<Pet> consultDown();
		
		//@Query("SELECT a FROM Pet a")
		//public List<Pet> listPet();


}
