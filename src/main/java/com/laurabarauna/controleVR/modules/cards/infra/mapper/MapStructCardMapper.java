package com.laurabarauna.controleVR.modules.cards.infra.mapper;

import com.laurabarauna.controleVR.modules.cards.application.mapper.CardMapper;
import com.laurabarauna.controleVR.modules.cards.domain.dto.CompleteCardOutputDto;
import com.laurabarauna.controleVR.modules.cards.domain.dto.CreateCardInputDto;
import com.laurabarauna.controleVR.modules.cards.domain.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructCardMapper extends CardMapper {
    @Override
    Card toCardDomain(CreateCardInputDto createCardInputDto);

    @Override
    CompleteCardOutputDto toCompleteCardOutputDto(Card card);
}
