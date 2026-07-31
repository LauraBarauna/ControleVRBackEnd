package com.laurabarauna.controleVR.shared.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LoggedUserProviderImpl implements LoggedUserProvider{
    @Override
    public Long getUserId() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return Long.valueOf(authentication.getName());
    }
}
