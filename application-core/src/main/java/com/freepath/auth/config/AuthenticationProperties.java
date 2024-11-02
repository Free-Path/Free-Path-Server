package com.freepath.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt-token")
public record AuthenticationProperties(Long accessTokenExpirationSeconds, Long refreshTokenExpirationSeconds) {
}
