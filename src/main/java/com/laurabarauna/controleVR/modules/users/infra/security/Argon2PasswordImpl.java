package com.laurabarauna.controleVR.modules.users.infra.security;

import com.laurabarauna.controleVR.modules.users.application.port.PasswordHasher;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class Argon2PasswordImpl implements PasswordHasher {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String hash(String rawPassword) {
        return this.passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String hashedPassword) {
        return this.passwordEncoder.matches(rawPassword, hashedPassword);
    }
}
