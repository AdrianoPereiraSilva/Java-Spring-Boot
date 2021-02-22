package br.com.project.springboot.login.services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import br.com.project.springboot.login.converters.DozerConverter;
import br.com.project.springboot.login.data.vo.UserVO;
import br.com.project.springboot.login.model.User;
import br.com.project.springboot.login.repositories.LoginRepository;
import br.com.project.springboot.login.util.Encrypt;

@Service
@Profile("!fake_login")
public class LoginService {

	@Autowired
	LoginRepository repository;

	public UserVO findUserByEmailAndPassword(UserVO user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		var entity = DozerConverter.parseObject(user, User.class);
		
		String passwordEncrypted = Encrypt.encrypt(entity.getPassword());
		
		User userReturned = repository.findUserByEmailAndPassword(entity.getEmail(), passwordEncrypted);
		
		var vo = DozerConverter.parseObject(userReturned, UserVO.class);
		
		vo.setPassword(null);
		
		return vo;
	}
}
