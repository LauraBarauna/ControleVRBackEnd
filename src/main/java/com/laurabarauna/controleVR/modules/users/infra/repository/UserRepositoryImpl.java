package com.laurabarauna.controleVR.modules.users.infra.repository;

import com.laurabarauna.controleVR.modules.users.domain.entity.User;
import com.laurabarauna.controleVR.modules.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    @Override
    public User findById(Long id) {
        return this.jpaUserRepository.findById(id).orElse(null);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return this.jpaUserRepository.findAll(pageable);
    }

    @Override
    public User findByUsername(String username) {
        return this.jpaUserRepository.findByUsername(username).orElse(null);
    }


}
