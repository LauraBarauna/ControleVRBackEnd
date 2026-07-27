package com.laurabarauna.controleVR.modules.users.domain.dto;

import jakarta.validation.constraints.Size;
import lombok.Setter;

public record UpdateUserInputDto(
        @Size(max = 50, min = 3, message = "First name need's to have more than 3 characters and less than 50.")
        String firstName,

        @Size(max = 100, min = 2, message = "Last name need's to have more than 2 characters and less than 100.")
        String lastName,

        @Size(max = 80, min = 4, message = "Username need's to have more than 4 characters and less than 80.")
        String username,

        @Size(max = 16, min = 8, message = "Password need's to have more than 8 characters and less than 16.")
        String password
) {
}
