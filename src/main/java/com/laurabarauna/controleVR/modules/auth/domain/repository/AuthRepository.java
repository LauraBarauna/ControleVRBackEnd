package com.laurabarauna.controleVR.modules.auth.domain.repository;

import com.laurabarauna.controleVR.modules.auth.domain.entity.AuthLogin;

import java.util.Optional;

public interface AuthRepository {
    AuthLogin findPasswordAndRoleAndId(String username);
}
