package com.laurabarauna.controleVR.modules.users.domain.repository;

import com.laurabarauna.controleVR.modules.users.domain.entity.User;

public interface UserRepository {
    User save(User user);

    boolean existsByUsername(String username);

    User findById(Long id);
}
