package br.com.project.springboot.login.services;

import br.com.project.springboot.login.data.vo.UserVO;

public interface LoginService {
    UserVO findUserByEmailAndPasswordOrThrows(UserVO user) throws Exception;
}
