package com.freepath.oauth;

import org.springframework.stereotype.Component;

@Component
public class KakaoClient {

    private final KakaoApi kakaoApi;

    public KakaoClient(KakaoApi kakaoApi) {
        this.kakaoApi = kakaoApi;
    }

    public KakaoClientResult getUserInfo(String token) {
        return kakaoApi.getKaKaoUserInfo("Bearer " + token).toResult();
    }
}
