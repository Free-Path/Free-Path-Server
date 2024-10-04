package com.freepath.oauth;

public record KakaoClientResult(
    String id,
    String name,
    String nickname,
    String ageRange,
    String gender
) {
}
