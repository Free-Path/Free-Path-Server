package com.freepath.auth.component.jwt;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import com.freepath.auth.config.AuthenticationProperties;
import com.freepath.auth.domain.Authentication;
import com.freepath.error.ErrorException;
import com.freepath.error.ErrorType;
import com.freepath.token.domain.Token;
import com.freepath.token.repository.TokenRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Component
public class JwtProvider implements TokenRepository {

    private static final String SECRET_KEY = "rnlcksgek";

    private final AuthenticationProperties authenticationProperties;

    private final SecretKey secretKey;

    public JwtProvider(AuthenticationProperties authenticationProperties) {
        this.authenticationProperties = authenticationProperties;
        this.secretKey = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8),
                Jwts.SIG.HS256.key().build().getAlgorithm());
    }

    public Token create(Authentication authentication) {
        String accessToken = issueAccessToken(authentication);
        return new Token(accessToken, null);
    }

    private String issueAccessToken(Authentication authentication) {
        Instant issuedAt = Instant.now();
        return generateToken(authentication.id().toString(), authentication.userId(),
                issuedAt.plusSeconds(authenticationProperties.accessTokenExpirationSeconds() * 60L), issuedAt);
    }

    private String generateToken(String jwtId, Long userId, Instant expiresAt, Instant issuedAt) {
        return Jwts.builder()
            .id(jwtId)
            .claim("userId", userId)
            .expiration(Date.from(expiresAt))
            .issuedAt(Date.from(issuedAt))
            .issuer("free-path-server")
            .signWith(secretKey)
            .compact();
    }

    public boolean validateTokenNotUsable(String token) {
        try {
            Claims claims = getClaims(token);
            return claims.getExpiration().before(new Date());
        }
        catch (ExpiredJwtException e) {
            throw new ErrorException(ErrorType.INVALID_TOKEN);
        }
        catch (JwtException | IllegalArgumentException e) {
            return true;
        }
    }

    public Long getUserId(String token) {
        return Long.valueOf(getClaims(token).getSubject());
    }

    private Claims getClaims(String token) {
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
    }

}
