package com.tuhuella.main.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuhuella.main.repositories.PetRepository;
import com.tuhuella.main.webException.WebException;




@Service
public class PetService {

@Autowired
private PetRepository petRepository;

@Transactional
public void createPet ( String name) throws Exception{
	
	if (name.equals(null)||name.isEmpty()) {
		throw new Exception ("El nombre no puede estar vacio");
	}
	

	
}

}
