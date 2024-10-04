package com.freepath.oauth.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KaKaoAccount(
    @JsonProperty("profile")
    KaKaoProfile kaKaoProfile,
    String name,
    @JsonProperty("age_range")
    String ageRange,
    String gender
) {
}
