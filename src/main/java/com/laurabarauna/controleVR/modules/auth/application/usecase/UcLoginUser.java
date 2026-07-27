package com.laurabarauna.controleVR.modules.auth.application.usecase;

import com.laurabarauna.controleVR.modules.auth.domain.dto.CompleteLoginUserOutputDto;
import com.laurabarauna.controleVR.modules.auth.domain.dto.LoginUserInputDto;
import com.laurabarauna.controleVR.modules.auth.domain.entity.AuthLogin;
import com.laurabarauna.controleVR.modules.auth.domain.repository.AuthRepository;
import com.laurabarauna.controleVR.modules.users.application.port.PasswordHasher;
import com.laurabarauna.controleVR.modules.users.domain.valueObject.Password;
import com.laurabarauna.controleVR.shared.usecase.UseCase;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.laurabarauna.controleVR.modules.users.domain.valueObject.Password.fromHashed;

@Component
@RequiredArgsConstructor
public class UcLoginUser extends UseCase<LoginUserInputDto, CompleteLoginUserOutputDto> {

    private final AuthRepository authRepository;
    private final PasswordHasher passwordHasher;

    @Override
    public CompleteLoginUserOutputDto execute(LoginUserInputDto input) {
        AuthLogin authLogin = this.authRepository.findPasswordAndRoleAndId(input.username());

        if (authLogin == null) throw new EntityNotFoundException();

        Password password = fromHashed(authLogin.getPassword());

        if (!password.matches(input.password(), this.passwordHasher)) throw new EntityNotFoundException();

        return new CompleteLoginUserOutputDto(authLogin.getId(), authLogin.getRole());
    }
}
