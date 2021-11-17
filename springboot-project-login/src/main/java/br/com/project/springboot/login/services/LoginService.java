package br.com.project.springboot.login.services;

import br.com.project.springboot.login.dto.UserRequestDTO;
import br.com.project.springboot.login.dto.UserResponseDTO;

public interface LoginService {
    UserResponseDTO findUserByEmailAndPasswordOrThrows(UserRequestDTO user) throws Exception;
}
