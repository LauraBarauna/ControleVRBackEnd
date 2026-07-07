package com.laurabarauna.controleVR.modules.users.application.usecase;

import com.laurabarauna.controleVR.modules.users.application.mapper.UserMapper;
import com.laurabarauna.controleVR.modules.users.domain.dto.ShortUserOutputDto;
import com.laurabarauna.controleVR.modules.users.domain.repository.UserRepository;
import com.laurabarauna.controleVR.shared.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UcListUsers extends UseCase<Void, List<ShortUserOutputDto>> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<ShortUserOutputDto> execute(Void input) {
        return this.userMapper.toShortUserOutputDto(this.userRepository.findAll());
    }
}
