package br.com.project.springboot.login.controllers;

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

import br.com.project.springboot.login.data.vo.UserVO;
import br.com.project.springboot.login.services.LoginService;

@RestController
@RequestMapping("/api/login/v1")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@PostMapping
	public ResponseEntity<UserVO> login(@RequestBody UserVO user) {
		
		UserVO userReturn = new UserVO();
		try {
			userReturn = service.findUserByEmailAndPassword(user);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<UserVO>(userReturn, HttpStatus.OK);
	}
	
	@GetMapping("/greetings")
	public String greetings() {				
		return "It's Working";
	}
}
