package com.laurabarauna.controleVR.modules.users.domain.valueObject;

import com.laurabarauna.controleVR.modules.users.application.port.PasswordHasher;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Password {

    private String hashedPassword;

    public static Password fromHashed(String hashedPassword) {
        return new Password(hashedPassword);
    }

    public static Password fromRaw(String rawPassword, PasswordHasher passwordHasher) {
        return new Password(passwordHasher.hash(rawPassword));
    }

    public boolean matches(String rawPassword, PasswordHasher passwordHasher) {
        return passwordHasher.matches(rawPassword, getHashedPassword());
    }
}
