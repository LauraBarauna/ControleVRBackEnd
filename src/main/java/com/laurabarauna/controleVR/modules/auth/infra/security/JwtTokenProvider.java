package com.laurabarauna.controleVR.modules.auth.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.laurabarauna.controleVR.modules.auth.domain.entity.AuthLogin;
import com.laurabarauna.controleVR.modules.auth.domain.gateway.TokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenProvider implements TokenProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Override
    public String generate(AuthLogin authLogin) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(authLogin.getId().toString())
                .withClaim("role", authLogin.getRole())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                .sign(algorithm);
    }

    @Override
    public Long validate(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        String subject = JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();

        return Long.valueOf(subject);
    }
}
