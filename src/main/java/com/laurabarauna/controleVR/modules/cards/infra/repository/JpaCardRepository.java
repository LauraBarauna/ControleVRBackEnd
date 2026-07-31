package com.laurabarauna.controleVR.modules.cards.infra.repository;

import com.laurabarauna.controleVR.modules.cards.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCardRepository extends JpaRepository<Card, Long> {
}
