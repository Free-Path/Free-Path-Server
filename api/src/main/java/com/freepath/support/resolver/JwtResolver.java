package com.freepath.support.resolver;

import java.util.Objects;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.freepath.auth.component.jwt.JwtProvider;
import com.freepath.auth.domain.AuthenticationPrincipal;
import com.freepath.support.AuthorizationExtractor;

import jakarta.servlet.http.HttpServletRequest;

public class JwtResolver implements HandlerMethodArgumentResolver {

    private final JwtProvider jwtProvider;

    public JwtResolver(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(AuthenticationPrincipal.class);
    }

    public Long resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String token = AuthorizationExtractor.extract(Objects.requireNonNull(request));
        return jwtProvider.getUserId(token);
    }

}
