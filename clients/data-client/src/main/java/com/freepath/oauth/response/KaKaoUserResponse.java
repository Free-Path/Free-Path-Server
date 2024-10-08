package com.freepath.oauth.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freepath.oauth.KakaoClientResult;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KaKaoUserResponse(
    String id,
    KaKaoAccount kaKaoAccount
) {
    public KakaoClientResult toResult() {
        return new KakaoClientResult(
            id,
            kaKaoAccount.name(),
            kaKaoAccount.kaKaoProfile().nickname(),
            kaKaoAccount().ageRange(),
            kaKaoAccount.gender(),
            kaKaoAccount.kaKaoProfile().profileImageUrl()
        );
    }
}
