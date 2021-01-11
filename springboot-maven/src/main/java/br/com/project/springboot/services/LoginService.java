package br.com.project.springboot.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.springboot.model.User;
import br.com.project.springboot.repositories.LoginRepository;
import br.com.project.springboot.util.Encrypt;

@Service
public class LoginService {

	@Autowired
	LoginRepository repository;

	public User findUserByEmailAndPassword(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		User userReturn = repository.findUserByEmailAndPassword(user.getEmail(), Encrypt.encrypt(user.getPassword()));
		userReturn.setPassword(null);
		return userReturn;
	}
	
	public User registerUser(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		User newUser = new User();
		
		newUser.setEmail(user.getEmail());
		newUser.setUserName(user.getUserName());
		newUser.setToken(user.getToken());
		newUser.setPassword(Encrypt.encrypt(user.getPassword()));
		
		return repository.save(newUser);
	}
	
}
