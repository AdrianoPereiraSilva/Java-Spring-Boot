package br.com.project.springboot.login.builders;


import br.com.project.springboot.login.data.vo.UserVO;
import br.com.project.springboot.login.util.Encrypt;
import lombok.Builder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Builder
public class UserVOBuilder {

    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private String email = "teste@email1.com";

    @Builder.Default
    private String name = "Teste";

    @Builder.Default
    private String password = "senha";

    @Builder.Default
    private String userName = "teste_teste";

    @Builder.Default
    private String token = "SAHSUAHSUHASUHAUHSUAHS";

    public UserVO createMockVoRequest() {

        return UserVO.builder()
                .id(id)
                .email(email)
                .name(name)
                .password(password)
                .userName(userName)
                .token(token)
                .build();
    }

    public UserVO createMockVoResponse() throws Exception {

        return UserVO.builder()
                .id(id)
                .email(email)
                .name(name)
                .password(Encrypt.encrypt(password))
                //.password(password)
                .userName(userName)
                .token(token)
                .build();
    }
}
