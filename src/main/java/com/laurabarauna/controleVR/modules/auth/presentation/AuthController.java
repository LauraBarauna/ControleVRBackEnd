package com.laurabarauna.controleVR.modules.auth.presentation;

import com.laurabarauna.controleVR.modules.auth.application.usecase.UcLoginUser;
import com.laurabarauna.controleVR.modules.auth.domain.dto.CompleteLoginUserOutputDto;
import com.laurabarauna.controleVR.modules.auth.domain.dto.LoginUserInputDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UcLoginUser ucLoginUser;

    @PostMapping("/login")
    public ResponseEntity<CompleteLoginUserOutputDto> login(@Valid @RequestBody LoginUserInputDto input){
        return ResponseEntity.ok().body(this.ucLoginUser.execute(input));
    }

}
