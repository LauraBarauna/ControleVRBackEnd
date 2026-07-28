package com.laurabarauna.controleVR.modules.auth.infra.repository;

import com.laurabarauna.controleVR.modules.auth.domain.entity.AuthLogin;
import com.laurabarauna.controleVR.modules.auth.domain.repository.AuthRepository;
import com.laurabarauna.controleVR.modules.users.domain.entity.User;
import com.laurabarauna.controleVR.modules.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthRepositoryImpl implements AuthRepository {

    private final UserRepository userRepository;

    @Override
    public AuthLogin findByUsername(String username) {
        User user = this.userRepository.findByUsername(username);
        if(user == null) return null;

        return new AuthLogin(user.getId(), user.getPassword(), user.getRole());
    }
}
