package br.com.project.springboot.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.springboot.model.User;
import br.com.project.springboot.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@PostMapping
	public ResponseEntity<User> login(@RequestBody User user) {
		
		User userReturn = new User();
		try {
			userReturn = service.findUserByEmailAndPassword(user);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<User>(userReturn, HttpStatus.OK);
	}
	
	@GetMapping
	public void logout() {}
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		User userReturn = service.registerUser(user);
		
		return new ResponseEntity<User>(userReturn, HttpStatus.OK);
	}

}
