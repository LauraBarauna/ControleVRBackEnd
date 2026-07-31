package com.laurabarauna.controleVR.modules.cards.infra.repository;

import com.laurabarauna.controleVR.modules.cards.domain.entity.Card;
import com.laurabarauna.controleVR.modules.cards.domain.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository {

    private final JpaCardRepository jpaCardRepository;

    @Override
    public Card save(Card card) {
        return this.jpaCardRepository.save(card);
    }
}
