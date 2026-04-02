package com.laurabarauna.controleVR.modules.users.domain.dto;

public record CompleteUserOutputDto(
        Long id,
        String firstName,
        String lastName,
        String username,
        String role
) {
}
