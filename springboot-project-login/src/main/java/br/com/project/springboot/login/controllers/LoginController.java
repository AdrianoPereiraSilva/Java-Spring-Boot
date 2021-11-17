package br.com.project.springboot.login.controllers;

import br.com.project.springboot.login.dto.UserResponseDTO;
import br.com.project.springboot.login.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.springboot.login.dto.UserRequestDTO;

@RestController
@RequestMapping("/api/login/v1")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO user) throws Exception {
		return ResponseEntity.ok(service.findUserByEmailAndPasswordOrThrows(user));
	}
	
	@GetMapping("/greetings")
	public String greetings() {				
		return "It's Working";
	}
}
