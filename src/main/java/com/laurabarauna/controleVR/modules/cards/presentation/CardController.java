package com.laurabarauna.controleVR.modules.cards.presentation;

import com.laurabarauna.controleVR.modules.cards.application.usecase.UcCreateCard;
import com.laurabarauna.controleVR.modules.cards.domain.dto.CompleteCardOutputDto;
import com.laurabarauna.controleVR.modules.cards.domain.dto.CreateCardInputDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final UcCreateCard ucCreateCard;

    @PostMapping()
    public ResponseEntity<CompleteCardOutputDto> createCard(@Valid @RequestBody CreateCardInputDto input) {
        CompleteCardOutputDto created = this.ucCreateCard.execute(input);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.id())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }

}
