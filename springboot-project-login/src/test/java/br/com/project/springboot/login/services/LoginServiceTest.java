package br.com.project.springboot.login.services;

import br.com.project.springboot.login.builders.UserVOBuilder;
import br.com.project.springboot.login.converters.DozerConverter;
import br.com.project.springboot.login.data.vo.UserVO;
import br.com.project.springboot.login.exception.ConverterException;
import br.com.project.springboot.login.model.User;
import br.com.project.springboot.login.repositories.LoginRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

    @Mock
    private LoginRepository repository;

    @InjectMocks
    private LoginService loginService;

    @Test
    void whenUserInformedCorrectlyThenShouldBeReturnedUser() throws Exception {

        // given
        UserVO expectedUserUserVoRequest = UserVOBuilder.builder().build().createMockVoRequest();
        UserVO expectedUserUserVoResponse = UserVOBuilder.builder().build().createMockVoResponse();

        User expectedUserRequest = DozerConverter.parseObject(expectedUserUserVoRequest, User.class);
        User expectedUserResponse = DozerConverter.parseObject(expectedUserUserVoResponse, User.class);

        // when
        when(repository.findUserByEmailAndPassword(expectedUserRequest.getEmail(), expectedUserUserVoResponse.getPassword()))
                .thenReturn(expectedUserResponse);

        expectedUserUserVoResponse.setPassword(null);

        // then
        UserVO founderUserVO = loginService.findUserByEmailAndPassword(expectedUserUserVoRequest);

        assertEquals(founderUserVO, expectedUserUserVoResponse);

    }

    @Test
    void whenUserEmailInformedIsInvalidShouldBeReturnedConverterException() throws Exception {
        // given
        UserVO expectedUserUserVoRequest = UserVOBuilder.builder().build().createMockVoRequest();
        UserVO expectedUserUserVoResponse = UserVOBuilder.builder().build().createMockVoResponse();
        expectedUserUserVoRequest.setEmail("invalid@email.com");

        User expectedUserRequest = DozerConverter.parseObject(expectedUserUserVoRequest, User.class);

        // when
        when(repository.findUserByEmailAndPassword(expectedUserRequest.getEmail(), expectedUserUserVoResponse.getPassword()))
                .thenReturn(null);

        // then
        assertThrows(ConverterException.class, () -> loginService.findUserByEmailAndPassword(expectedUserUserVoRequest));

    }

}
