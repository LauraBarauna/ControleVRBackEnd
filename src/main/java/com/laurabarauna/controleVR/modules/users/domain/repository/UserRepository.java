package com.laurabarauna.controleVR.modules.users.domain.repository;

import com.laurabarauna.controleVR.modules.users.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {
    User save(User user);

    boolean existsByUsername(String username);

    User findById(Long id);

    Page<User> findAll(Pageable pageable);

    User findByUsername(String username);
}
