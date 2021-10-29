package com.tuhuella.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tuhuella.main.entities.Photo;
import com.tuhuella.main.repositories.PhotoRepository;
import com.tuhuella.main.webException.WebException;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepository photoRepo;
	
	public Photo savePhoto(MultipartFile file) throws WebException {
		try {
		if(file != null) {
			Photo photo = new Photo();
			photo.setMime(file.getContentType());
			photo.setName(file.getName());
			photo.setPicture(file.getBytes());
			
			return photoRepo.save(photo);
			} else { 
				return null;
			}
		} catch(WebException e) {
			e.getMessage();
		}
	}	
	
}
