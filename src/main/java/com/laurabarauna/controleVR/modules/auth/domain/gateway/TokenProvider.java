package com.laurabarauna.controleVR.modules.auth.domain.gateway;

import com.laurabarauna.controleVR.modules.auth.domain.entity.AuthLogin;

public interface TokenProvider {
    String generate(AuthLogin authLogin);
    Long validate(String token);
}
