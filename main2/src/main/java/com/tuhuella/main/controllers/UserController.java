package com.tuhuella.main.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tuhuella.main.entities.Photo;
import com.tuhuella.main.entities.User;
import com.tuhuella.main.entities.Zone;
import com.tuhuella.main.services.UserService;
	

@Controller
@RequestMapping("/user")

public class UserController {
	@Autowired
	private UserService userService;


	@GetMapping("/register")
	public String form() {
		return "form-user";
	}

	@PostMapping("/register")
	public String saveUser(ModelMap modelo,@RequestParam Photo photo ,@RequestParam String name, @RequestParam String surname,@RequestParam Date birthDate,	@RequestParam String email, @RequestParam String password,@RequestParam String userName,@RequestParam String street,@RequestParam Integer streetNumber,@RequestParam Date date,
	@RequestParam Integer phoneNumber,@RequestParam Integer alternativeNumber, @RequestParam Zone zone) {

		try {
			userService.signUpUser(photo, name, surname, userName, password, date, street, streetNumber, zone, phoneNumber, alternativeNumber, email);

			modelo.put("exito", "registro exitoso");
			return "form-usuario";
		} catch (Exception e) {
			modelo.put("error", e.getMessage());
			return "form-usuario";
		}
	}
	
	@GetMapping("/showUserList")
	public String show (ModelMap modelo) {
		List<User> users = userService.findUsers();
		modelo.addAttribute("Users",users);
		return "show-users";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable String id, ModelMap modelo) {
		User user = userService.edit(id);
		modelo.addAttribute("User", user);
		return  "edit-user";		
	}

	


	
}




