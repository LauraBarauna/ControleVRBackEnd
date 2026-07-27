package com.laurabarauna.controleVR.modules.auth.infra.repository;

import com.laurabarauna.controleVR.modules.auth.domain.entity.AuthLogin;
import com.laurabarauna.controleVR.modules.auth.domain.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Component
public class AuthRepositoryImpl implements AuthRepository {

    private final JpaAuthRepository jpaAuthRepository;

    @Override
    public AuthLogin findPasswordAndRoleAndId(String username) {
        return this.jpaAuthRepository.findPasswordAndRoleAndId(username)
                .orElse(null);
    }
}
