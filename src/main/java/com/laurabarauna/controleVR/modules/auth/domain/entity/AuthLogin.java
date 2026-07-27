package com.laurabarauna.controleVR.modules.auth.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class AuthLogin {
    private Long id;
    private String password;
    private String role;
}
