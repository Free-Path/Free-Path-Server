package com.freepath.auth.component;

import org.springframework.stereotype.Service;

import com.freepath.error.ErrorException;
import com.freepath.error.ErrorType;
import com.freepath.oauth.KakaoClient;
import com.freepath.oauth.KakaoClientResult;

import feign.FeignException;

@Service
public class OAuthService {

    private final KakaoClient kakaoClient;

    public OAuthService(KakaoClient kakaoClient) {
        this.kakaoClient = kakaoClient;
    }

    public KakaoClientResult getKaKaoUserInfo(String token) {
        try {
            return kakaoClient.getUserInfo(token);
        }
        catch (FeignException e) {
            if (e.status() == 401) {
                throw new ErrorException(ErrorType.INVALID_KAKAO_TOKEN);
            }
            else {
                throw new ErrorException(ErrorType.DEFAULT);
            }
        }
    }

}
