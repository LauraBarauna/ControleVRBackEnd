package com.laurabarauna.controleVR.modules.auth.infra.repository;

import com.laurabarauna.controleVR.modules.auth.domain.entity.AuthLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JpaAuthRepository extends JpaRepository<AuthLogin, Long> {
    @Query(value = "SELECT password, role, id FROM users WHERE username = :username", nativeQuery = true)
    Optional<AuthLogin> findPasswordAndRoleAndId(String username);
}
