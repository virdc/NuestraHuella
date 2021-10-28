package com.tuhuella.main.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

		@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })
		public User save(Photo photo, String name, String surname, String userName, String password, Integer age, String street, Integer StreetNumber, Zone zone, Integer phoneNumber, Integer alternativeNumber String email) throws WebException {

		User entity = new User();
		entity.setActive(true);
		entity.setAge(age);
		entity.setName(name);
		entity.setSurname(surname);
		entity.setUserName(userName);
		entity.setPassword(password);
		entity.setStreet(street);
		entity.setStreetNumber(StreetNumber);
		entity.setZone(zone);
		entity.setPhoneNumber(phoneNumber);
		
			

			return userRepository.save(entidad);
		}

		public void validate(String name, String surname, String email, String password, String rol) throws Exception {

			if (name == null || name.isEmpty() || name.contains("  ")) {
				throw new Exception("Debe tener un name valido");
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
