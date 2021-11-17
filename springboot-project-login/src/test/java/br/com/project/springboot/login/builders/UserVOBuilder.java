package br.com.project.springboot.login.builders;


import br.com.project.springboot.login.dto.UserRequestDTO;
import br.com.project.springboot.login.dto.UserResponseDTO;
import br.com.project.springboot.login.util.Encrypt;
import lombok.Builder;

@Builder
public class UserVOBuilder {

    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private String email = "teste@email1.com";

    @Builder.Default
    private String invalidEmail = "invalid@email1.com";

    @Builder.Default
    private String name = "Teste";

    @Builder.Default
    private String password = "senha";

    @Builder.Default
    private String userName = "teste_teste";

    @Builder.Default
    private String token = "SAHSUAHSUHASUHAUHSUAHS";

    public UserRequestDTO createMockVoRequest() {

        return UserRequestDTO.builder()
                .id(id)
                .email(email)
                .name(name)
                .password(password)
                .userName(userName)
                .token(token)
                .build();
    }

    public UserRequestDTO createMockVoRequestInvalidEmail() {

        return UserRequestDTO.builder()
                .id(id)
                .email(invalidEmail)
                .name(name)
                .password(password)
                .userName(userName)
                .token(token)
                .build();
    }

    public UserResponseDTO createMockVoResponse() throws Exception {

        return UserResponseDTO.builder()
                .id(id)
                .email(email)
                .name(name)
                .userName(userName)
                .token(token)
                .build();
    }
}
