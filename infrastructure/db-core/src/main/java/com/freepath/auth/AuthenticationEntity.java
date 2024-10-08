package com.freepath.auth;

import com.freepath.BaseEntity;
import com.freepath.auth.domain.Authentication;
import com.freepath.auth.domain.NewAuthentication;
import com.freepath.auth.domain.SocialType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "f_authentication")
public class AuthenticationEntity extends BaseEntity {

    private Long userId;

    private String socialId;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    protected AuthenticationEntity() {
    }

    public AuthenticationEntity(Long userId, NewAuthentication newAuthentication) {
        this.userId = userId;
        this.socialId = newAuthentication.socialId();
        this.socialType = newAuthentication.socialType();
    }

    public Authentication toAuthentication() {
        return new Authentication(
            this.getId(),
            this.userId,
            this.socialId,
            this.socialType
        );
    }
}
