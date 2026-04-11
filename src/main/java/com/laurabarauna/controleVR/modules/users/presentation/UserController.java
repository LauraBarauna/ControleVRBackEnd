package com.laurabarauna.controleVR.modules.users.presentation;

import com.laurabarauna.controleVR.modules.users.application.usecase.UcCreateUser;
import com.laurabarauna.controleVR.modules.users.application.usecase.UcReadUser;
import com.laurabarauna.controleVR.modules.users.domain.dto.CompleteUserOutputDto;
import com.laurabarauna.controleVR.modules.users.domain.dto.CreateUserInputDto;
import com.laurabarauna.controleVR.shared.dto.WithId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UcCreateUser ucCreateUser;
    private final UcReadUser ucReadUser;

    @PostMapping()
    public ResponseEntity<CompleteUserOutputDto> createUser(@Valid @RequestBody CreateUserInputDto input) {
        CompleteUserOutputDto created = this.ucCreateUser.execute(input);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.id())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompleteUserOutputDto> readUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.ucReadUser.execute(new WithId<>(id, null)));
    }

}
