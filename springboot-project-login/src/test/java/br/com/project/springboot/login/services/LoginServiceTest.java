package br.com.project.springboot.login.services;

import br.com.project.springboot.login.dto.UserRequestDTO;
import br.com.project.springboot.login.dto.UserResponseDTO;
import br.com.project.springboot.login.exception.UserNotFoundException;
import br.com.project.springboot.login.model.User;
import br.com.project.springboot.login.repositories.LoginRepository;

import br.com.project.springboot.login.services.impl.LoginServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static br.com.project.springboot.login.builders.UserDTOBuilder.*;
import static br.com.project.springboot.login.converters.DozerConverter.parseObject;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ActiveProfiles({"test"})
@SpringBootTest()
public class LoginServiceTest {

    @Mock
    private LoginRepository repository;

    @Autowired
    private LoginServiceImpl loginService;

    @Test
    void whenUserInformedCorrectlyThenShouldBeReturnedUser() throws Exception {

        UserRequestDTO expectedUserUserVoRequest = createMockVoRequest();
        UserResponseDTO expectedUserUserVoResponse = createMockVoResponse();

        User expectedUserRequest = parseObject(expectedUserUserVoRequest, User.class);
        User expectedUserResponse = parseObject(expectedUserUserVoResponse, User.class);

        when(repository.findUserByEmailAndPassword(expectedUserRequest.getEmail(), expectedUserUserVoRequest.getPassword()))
                .thenReturn(expectedUserResponse);

        UserResponseDTO founderUserVO = loginService.findUserByEmailAndPasswordOrThrows(expectedUserUserVoRequest);

        assertEquals(founderUserVO, expectedUserUserVoResponse);

    }

    @Test
    void whenUserEmailInformedIsInvalidShouldBeReturnedUserNotFoundException() throws Exception {

        UserRequestDTO expectedUserUserVoRequest = createMockVoRequestInvalidEmail();
        User expectedUserRequest = parseObject(expectedUserUserVoRequest, User.class);

        when(repository.findUserByEmailAndPassword(expectedUserRequest.getEmail(), expectedUserUserVoRequest.getPassword()))
                .thenReturn(null);

        assertThrows(UserNotFoundException.class, () -> loginService.findUserByEmailAndPasswordOrThrows(expectedUserUserVoRequest));
    }

}
