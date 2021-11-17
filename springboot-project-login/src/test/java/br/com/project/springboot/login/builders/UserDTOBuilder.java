package br.com.project.springboot.login.builders;


import br.com.project.springboot.login.dto.UserRequestDTO;
import br.com.project.springboot.login.dto.UserResponseDTO;
import lombok.Builder;

public class UserDTOBuilder {

    @Builder.Default
    private static final Long ID = 1L;

    @Builder.Default
    private static final String EMAIL = "teste@email1.com";

    @Builder.Default
    private static final String INVALID_EMAIL = "invalid@email1.com";

    @Builder.Default
    private static final String NAME = "Teste";

    @Builder.Default
    private static final String PASSWORD = "senha";

    @Builder.Default
    private static final String USER_NAME = "teste_teste";

    @Builder.Default
    private static final String TOKEN = "SAHSUAHSUHASUHAUHSUAHS";

    public static UserRequestDTO createMockVoRequest() {

        return UserRequestDTO.builder()
                .id(ID)
                .email(EMAIL)
                .name(NAME)
                .password(PASSWORD)
                .userName(USER_NAME)
                .token(TOKEN)
                .build();
    }

    public static UserRequestDTO createMockVoRequestInvalidEmail() {

        return UserRequestDTO.builder()
                .id(ID)
                .email(INVALID_EMAIL)
                .name(NAME)
                .password(PASSWORD)
                .userName(USER_NAME)
                .token(TOKEN)
                .build();
    }

    public static UserResponseDTO createMockVoResponse() {

        return UserResponseDTO.builder()
                .id(ID)
                .email(EMAIL)
                .name(NAME)
                .userName(USER_NAME)
                .token(TOKEN)
                .build();
    }
}
