package com.laurabarauna.controleVR.modules.users.application.usecase;

import com.laurabarauna.controleVR.modules.users.application.mapper.UserMapper;
import com.laurabarauna.controleVR.modules.users.domain.dto.ShortUserOutputDto;
import com.laurabarauna.controleVR.modules.users.domain.entity.User;
import com.laurabarauna.controleVR.modules.users.domain.repository.UserRepository;
import com.laurabarauna.controleVR.shared.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UcListUsers extends UseCase<Pageable, Page<ShortUserOutputDto>> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Page<ShortUserOutputDto> execute(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::toShortUserOutputDto);
    }
}
