package com.laurabarauna.controleVR.modules.cards.domain.dto;

import java.math.BigDecimal;

public record CompleteCardOutputDto(
        Long id,
        String nickname,
        String colorHex,
        BigDecimal balance,
        Long userId
) {
}
