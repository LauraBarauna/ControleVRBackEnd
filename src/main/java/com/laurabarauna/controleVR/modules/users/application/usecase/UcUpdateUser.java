package com.laurabarauna.controleVR.modules.users.application.usecase;

import com.laurabarauna.controleVR.modules.users.application.mapper.UserMapper;
import com.laurabarauna.controleVR.modules.users.application.port.PasswordHasher;
import com.laurabarauna.controleVR.modules.users.domain.dto.UpdateUserInputDto;
import com.laurabarauna.controleVR.modules.users.domain.entity.User;
import com.laurabarauna.controleVR.modules.users.domain.repository.UserRepository;
import com.laurabarauna.controleVR.shared.dto.WithId;
import com.laurabarauna.controleVR.shared.usecase.UseCase;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.laurabarauna.controleVR.modules.users.domain.valueObject.Password.fromHashed;
import static com.laurabarauna.controleVR.modules.users.domain.valueObject.Password.fromRaw;

@RequiredArgsConstructor
@Component
public class UcUpdateUser extends UseCase<WithId<Long, UpdateUserInputDto>, Void> {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordHasher passwordHasher;

    @Override
    public Void execute(WithId<Long, UpdateUserInputDto> input) {
        User userToUpdate = this.userRepository.findById(input.id());
        String password = input.data().password();
        String newPassword = null;

        if (userToUpdate == null) {
            throw new EntityNotFoundException("User with id " + input.id() + " not found.");
        }

        if (password != null) {
            if (!fromHashed(userToUpdate.getPassword()).matches(password, this.passwordHasher)) {
                newPassword = fromRaw(password, this.passwordHasher).getHashedPassword();
            }
        }

        UpdateUserInputDto inputToUpdate = new UpdateUserInputDto(
                input.data().firstName(),
                input.data().lastName(),
                input.data().username(),
                newPassword
                );

        this.userMapper.updateEntity(userToUpdate, inputToUpdate);
        System.out.println(userToUpdate.getPassword());

        this.userRepository.save(userToUpdate);
        return null;
    }
}
