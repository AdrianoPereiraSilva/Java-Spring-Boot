package br.com.project.springboot.login.services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.com.project.springboot.login.repositories.LoginRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import br.com.project.springboot.login.converters.DozerConverter;
import br.com.project.springboot.login.data.vo.UserVO;

@Service
@Profile("fake_login")
public class FakeLoginService extends LoginService {

	public FakeLoginService(LoginRepository repository) {
		super(repository);
	}

	public UserVO findUserByEmailAndPassword(UserVO user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		var vo = DozerConverter.parseObject(user, UserVO.class);
		
		vo.setPassword(null);
		
		return vo;
	}

}
