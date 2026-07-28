package com.laurabarauna.controleVR.modules.auth.domain.repository;

import com.laurabarauna.controleVR.modules.auth.domain.entity.AuthLogin;


public interface AuthRepository {
    AuthLogin findByUsername(String username);
}
