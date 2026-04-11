package com.laurabarauna.controleVR.modules.users.application.usecase;

import com.laurabarauna.controleVR.modules.users.application.mapper.UserMapper;
import com.laurabarauna.controleVR.modules.users.domain.dto.CompleteUserOutputDto;
import com.laurabarauna.controleVR.modules.users.domain.entity.User;
import com.laurabarauna.controleVR.modules.users.domain.repository.UserRepository;
import com.laurabarauna.controleVR.shared.dto.WithId;
import com.laurabarauna.controleVR.shared.usecase.UseCase;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UcReadUser extends UseCase<WithId<Long, Void>, CompleteUserOutputDto> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public CompleteUserOutputDto execute(WithId<Long, Void> input) {
        User user = this.userRepository.findById(input.id());

        if (user == null) {
            throw new EntityNotFoundException("User with id " + input.id() + " not found.");
        }

        return this.userMapper.toCompleteUserOutputDto(user);
    }
}
