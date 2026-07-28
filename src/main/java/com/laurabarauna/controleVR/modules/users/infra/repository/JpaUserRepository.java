package com.laurabarauna.controleVR.modules.users.infra.repository;

import com.laurabarauna.controleVR.modules.users.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
