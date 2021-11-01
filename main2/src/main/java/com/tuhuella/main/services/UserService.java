package com.tuhuella.main.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tuhuella.main.entities.Photo;
import com.tuhuella.main.entities.User;
import com.tuhuella.main.entities.Zone;
import com.tuhuella.main.repositories.UserRepository;

@Service
public class UserService {

		@Autowired
		private UserRepository userRepository;

		@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
		public User signUpUser(Photo photo, String name, String surname, String userName, String password, Date birthDate, String street, Integer StreetNumber, Zone zone, Integer phoneNumber, Integer alternativeNumber, String email) throws Exception {
			
			validate(name,surname,userName,email,password);
		User entity = new User();
		entity.setName(name);
		entity.setSurname(surname);
		entity.setUsername(userName);
		entity.setPassword(password);
		
		entity.setActive(true);
		entity.setPhoto(photo);
		entity.setBirthDate(birthDate);
		entity.setStreet(street);
		entity.setStreetNumber(StreetNumber);
		entity.setZone(zone);
		entity.setPhoneNumber(phoneNumber);
		entity.setAlternativeNumber(alternativeNumber);
		entity.setEmail(email);
		entity.setActive(true);
		
		
			return userRepository.save(entity);
		}

		public List<User> showUserByEmail(String email) throws Exception{
			try {
				return userRepository.findByNameContain(email);
				
			} catch (Exception e) {
				return userRepository.findByNameContain(email);

			}
		
			
		}
		
		
		
		
		public void validate(String name, String surname, String username, String email, String password) throws Exception {

			if (name == null || name.isEmpty() || name.contains("  ")) {
				throw new Exception("Debe tener un name valido");
			}
			if (username == null || username.isEmpty() || username.contains("  ")) {
				throw new Exception("must have a valid username");
			}
			if (surname == null || surname.isEmpty() || surname.contains("  ")) {
				throw new Exception("Debe tener un surname valido");
			}
			if (email == null || email.isEmpty() || email.contains("  ")) {
				throw new Exception("must have a valid email");
			}
		
			if (password == null || password.isEmpty() || password.contains("  ") || password.length() < 8 || password.length() > 12) {
				throw new Exception("must have a  valid password");
			}

		}


}
