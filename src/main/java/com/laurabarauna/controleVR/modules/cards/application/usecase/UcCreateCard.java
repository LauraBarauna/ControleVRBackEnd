package com.laurabarauna.controleVR.modules.cards.application.usecase;

import com.laurabarauna.controleVR.modules.cards.application.mapper.CardMapper;
import com.laurabarauna.controleVR.modules.cards.domain.dto.CompleteCardOutputDto;
import com.laurabarauna.controleVR.modules.cards.domain.dto.CreateCardInputDto;
import com.laurabarauna.controleVR.modules.cards.domain.entity.Card;
import com.laurabarauna.controleVR.modules.cards.domain.repository.CardRepository;
import com.laurabarauna.controleVR.modules.users.domain.repository.UserRepository;
import com.laurabarauna.controleVR.shared.auth.LoggedUserProvider;
import com.laurabarauna.controleVR.shared.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UcCreateCard extends UseCase<CreateCardInputDto, CompleteCardOutputDto> {

    private final CardRepository cardRepository;
    private final UserRepository userRepository;
    private final CardMapper cardMapper;
    private final LoggedUserProvider loggedUserProvider;

    @Override
    public CompleteCardOutputDto execute(CreateCardInputDto input) {
        Card card = this.cardMapper.toCardDomain(input);
        this.cardRepository.save(card);

        card.setUser(this.userRepository.findById(this.loggedUserProvider.getUserId()));

        return this.cardMapper.toCompleteCardOutputDto(card);
    }
}
