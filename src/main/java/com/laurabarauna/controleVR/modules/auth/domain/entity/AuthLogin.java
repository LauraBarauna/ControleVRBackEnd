package com.laurabarauna.controleVR.modules.auth.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthLogin {
    private Long id;
    private String password;
    private String role;
}
