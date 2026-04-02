package com.laurabarauna.controleVR.modules.users.infra.repository;

import com.laurabarauna.controleVR.modules.users.domain.entity.User;
import com.laurabarauna.controleVR.modules.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public User save(User user) {
        return this.jpaUserRepository.save(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return this.jpaUserRepository.existsByUsername(username);
    }
}
