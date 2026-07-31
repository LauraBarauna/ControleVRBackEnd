package com.laurabarauna.controleVR.modules.cards.application.mapper;

import com.laurabarauna.controleVR.modules.cards.domain.dto.CompleteCardOutputDto;
import com.laurabarauna.controleVR.modules.cards.domain.dto.CreateCardInputDto;
import com.laurabarauna.controleVR.modules.cards.domain.entity.Card;

public interface CardMapper {
    Card toCardDomain(CreateCardInputDto createCardInputDto);
    CompleteCardOutputDto toCompleteCardOutputDto(Card card);
}
