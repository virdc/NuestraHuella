package com.tuhuella.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuhuella.main.entities.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, String> {

}
