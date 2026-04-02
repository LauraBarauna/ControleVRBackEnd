package com.laurabarauna.controleVR.modules.users.infra.repository;

import com.laurabarauna.controleVR.modules.users.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface JpaUserRepository extends JpaRepository<User, Long> {
}
