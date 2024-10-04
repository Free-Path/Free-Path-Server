package com.freepath.oauth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.freepath.oauth.response.KaKaoUserResponse;

@FeignClient(value = "kakao-auth-api", url = "https://kapi.kakao.com")
public interface KakaoApi {
    @GetMapping(
        value = "/v2/user/me",
        consumes = "application/x-www-form-urlencoded;charset=utf-8",
        produces = MediaType.APPLICATION_JSON_VALUE)
    KaKaoUserResponse getKaKaoUserInfo(
        @RequestHeader(name = "Authorization") String authorization
    );
}
