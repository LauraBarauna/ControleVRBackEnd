package com.laurabarauna.controleVR.modules.users.application.mapper;

import com.laurabarauna.controleVR.modules.users.domain.dto.CompleteUserOutputDto;
import com.laurabarauna.controleVR.modules.users.domain.dto.CreateUserInputDto;
import com.laurabarauna.controleVR.modules.users.domain.entity.User;

public interface UserMapper {
    User toDomain(CreateUserInputDto createUserInputDto);
    CompleteUserOutputDto toCompleteUserOutputDto(User user);
}
