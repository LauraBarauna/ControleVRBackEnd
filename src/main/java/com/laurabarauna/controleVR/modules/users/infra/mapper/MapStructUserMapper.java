package com.laurabarauna.controleVR.modules.users.infra.mapper;

import com.laurabarauna.controleVR.modules.users.application.mapper.UserMapper;
import com.laurabarauna.controleVR.modules.users.domain.dto.CompleteUserOutputDto;
import com.laurabarauna.controleVR.modules.users.domain.dto.CreateUserInputDto;
import com.laurabarauna.controleVR.modules.users.domain.dto.ShortUserOutputDto;
import com.laurabarauna.controleVR.modules.users.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructUserMapper extends UserMapper {
    @Override
    User toDomain(CreateUserInputDto createUserInputDto);

    @Override
    CompleteUserOutputDto toCompleteUserOutputDto(User user);

    @Override
    @Mapping(target = "name", source = ".", qualifiedByName = "fullName")
    ShortUserOutputDto toShortUserOutputDto(User user);

    @Named("fullName")
    default String fullName(User user) {
        return user.getFirstName() + " " + user.getLastName();
    }
}
