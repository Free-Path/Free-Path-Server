package com.freepath.support.interceptor;

import java.lang.annotation.Annotation;
import java.util.Optional;

import org.springframework.web.cors.CorsUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.freepath.auth.component.jwt.JwtProvider;
import com.freepath.auth.domain.Authenticated;
import com.freepath.error.ErrorException;
import com.freepath.error.ErrorType;
import com.freepath.support.AuthorizationExtractor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;

    public AuthInterceptor(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (CorsUtils.isPreFlightRequest(request)) {
            return true;
        }
        Optional<Authenticated> authenticated = parseAnnotation((HandlerMethod) handler, Authenticated.class);
        if (authenticated.isPresent()) {
            validateToken(request);
        }
        return true;
    }

    private <T extends Annotation> Optional<T> parseAnnotation(HandlerMethod handler, Class<T> clazz) {
        return Optional.ofNullable(handler.getMethodAnnotation(clazz));
    }

    private void validateToken(HttpServletRequest request) {
        String token = AuthorizationExtractor.extract(request);
        if (jwtProvider.validateTokenNotUsable(token)) {
            throw new ErrorException(ErrorType.INVALID_TOKEN);
        }
    }
}
