package com.freepath.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.freepath.auth.component.jwt.JwtProvider;
import com.freepath.support.interceptor.AuthInterceptor;
import com.freepath.support.resolver.JwtResolver;

@Configuration
public class AuthConfig implements WebMvcConfigurer {

    private final JwtProvider jwtProvider;

    public AuthConfig(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(jwtProvider))
            .addPathPatterns("/v1/**");
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*")
            .addResourceLocations("classpath:/static/");
    }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new JwtResolver(jwtProvider));
    }
}
