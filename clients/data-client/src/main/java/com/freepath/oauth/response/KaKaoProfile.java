package com.freepath.oauth.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KaKaoProfile(String nickname, @JsonProperty("profile_image_url") String profileImageUrl) {
}
