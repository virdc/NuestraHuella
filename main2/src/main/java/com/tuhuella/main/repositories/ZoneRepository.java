package com.tuhuella.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.tuhuella.main.entities.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, String> {
	
	@Query("SELECT a FROM Zone a WHERE a.active = true")
	public List<Zone> showActives();
	
}
