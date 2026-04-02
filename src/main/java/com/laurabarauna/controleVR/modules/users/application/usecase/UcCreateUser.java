package com.laurabarauna.controleVR.modules.users.application.usecase;

import com.laurabarauna.controleVR.modules.users.application.mapper.UserMapper;
import com.laurabarauna.controleVR.modules.users.application.port.PasswordHasher;
import com.laurabarauna.controleVR.modules.users.domain.dto.CompleteUserOutputDto;
import com.laurabarauna.controleVR.modules.users.domain.dto.CreateUserInputDto;
import com.laurabarauna.controleVR.modules.users.domain.entity.User;
import com.laurabarauna.controleVR.modules.users.domain.repository.UserRepository;
import com.laurabarauna.controleVR.shared.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.laurabarauna.controleVR.modules.users.domain.valueObject.Password.fromRaw;

@RequiredArgsConstructor
@Component
public class UcCreateUser extends UseCase<CreateUserInputDto, CompleteUserOutputDto> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordHasher passwordHasher;

    @Override
    public CompleteUserOutputDto execute(CreateUserInputDto input) {
        User user = this.userMapper.toDomain(input);
        user.setPassword(fromRaw(input.password(), this.passwordHasher).getHashedPassword());

        this.userRepository.save(user);

        return this.userMapper.toCompleteUserOutputDto(user);
    }
}
