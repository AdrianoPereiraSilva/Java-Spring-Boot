package br.com.project.springboot.login.services.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.com.project.springboot.login.exception.ConverterException;
import br.com.project.springboot.login.exception.UserNotFoundException;
import br.com.project.springboot.login.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.springboot.login.converters.DozerConverter;
import br.com.project.springboot.login.data.vo.UserVO;
import br.com.project.springboot.login.model.User;
import br.com.project.springboot.login.repositories.LoginRepository;
import br.com.project.springboot.login.util.Encrypt;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginServiceImpl implements LoginService {

	private final LoginRepository repository;

	@Override
	public UserVO findUserByEmailAndPasswordOrThrows(UserVO user) throws Exception {
		User entity;
		try {
			entity = DozerConverter.parseObject(user, User.class);
		} catch (Exception ex){
			throw new ConverterException("Erro ao Converter VO para Entity");
		}

		String passwordEncrypted = Encrypt.encrypt(entity.getPassword());
		
		User userReturned = repository.findUserByEmailAndPassword(entity.getEmail(), passwordEncrypted);

		if(userReturned == null) {
			throw new UserNotFoundException("Usuário não encontrado");
		}

		var vo = DozerConverter.parseObject(userReturned, UserVO.class);

		vo.setPassword(null);

		return vo;
	}

}
