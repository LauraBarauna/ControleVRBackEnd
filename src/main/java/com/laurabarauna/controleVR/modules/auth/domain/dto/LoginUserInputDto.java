package com.laurabarauna.controleVR.modules.auth.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginUserInputDto(
        @NotBlank(message = "Username is required")
        @Size(max = 80, min = 4, message = "Username need's to have more than 4 characters and less than 80.")
        String username,

        @NotBlank(message = "Password is required")
        @Size(max = 16, min = 8, message = "Password need's to have more than 8 characters and less than 16.")
        String password
) {
}
