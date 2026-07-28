package com.laurabarauna.controleVR.modules.auth.application.usecase;

import com.laurabarauna.controleVR.modules.auth.domain.dto.LoginUserOutputDto;
import com.laurabarauna.controleVR.modules.auth.domain.dto.LoginUserInputDto;
import com.laurabarauna.controleVR.modules.auth.domain.entity.AuthLogin;
import com.laurabarauna.controleVR.modules.auth.domain.gateway.TokenProvider;
import com.laurabarauna.controleVR.modules.auth.domain.repository.AuthRepository;
import com.laurabarauna.controleVR.modules.users.application.port.PasswordHasher;
import com.laurabarauna.controleVR.modules.users.domain.valueObject.Password;
import com.laurabarauna.controleVR.shared.exception.custom.IncorrectPasswordOrUsernameException;
import com.laurabarauna.controleVR.shared.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.laurabarauna.controleVR.modules.users.domain.valueObject.Password.fromHashed;

@Component
@RequiredArgsConstructor
public class UcLoginUser extends UseCase<LoginUserInputDto, LoginUserOutputDto> {

    private final AuthRepository authRepository;
    private final PasswordHasher passwordHasher;
    private final TokenProvider tokenProvider;

    @Override
    public LoginUserOutputDto execute(LoginUserInputDto input) {
        AuthLogin authLogin = this.authRepository.findByUsername(input.username());

        if (authLogin == null) throw new IncorrectPasswordOrUsernameException("Os dados da senha ou do usuário estão inválidos.");

        Password password = fromHashed(authLogin.getPassword());

        if (!password.matches(input.password(), this.passwordHasher)) throw new IncorrectPasswordOrUsernameException("Os dados da senha ou do usuário estão inválidos.");

        String token = tokenProvider.generate(authLogin);

        return new LoginUserOutputDto(token);
    }
}
