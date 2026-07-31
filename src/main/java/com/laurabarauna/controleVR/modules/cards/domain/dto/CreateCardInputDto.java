package com.laurabarauna.controleVR.modules.cards.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateCardInputDto(

        @NotBlank(message = "Nickname is required")
        @Size(max = 50, min = 3, message = "Nickname need's to have more than 3 characters and less than 50.")
        String nickname,

        @NotBlank(message = "Color hex is required")
        @Size(max = 4, min = 4, message = "Color hex need's to have more than 4 characters and less than 4.")
        String colorHex,

        @NotNull(message = "Balance is required")
        @PositiveOrZero(message = "Balance can't be negative")
        BigDecimal balance
) {
}
